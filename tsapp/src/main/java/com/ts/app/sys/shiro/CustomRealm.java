package com.ts.app.sys.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.ts.app.sys.domain.User;
import com.ts.app.sys.service.UserService;
   
public class CustomRealm extends AuthorizingRealm {  
  
    @Autowired
    private UserService userService;  
    
    //认证
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {  
    	CustomUsernamePasswordToken customToken = (CustomUsernamePasswordToken)token;
    	String userName = customToken.getUsername(); //获取用户名
        
		if (!StringUtils.isEmpty(userName)) {
			User user = new User();
	    	user.setPhone(userName);
	        List<User> userList = userService.findUserList(user);
			 //查询数据库获取用户信息
	        if(userList.size() == 0){
	        	// 如果手机号没有查询到数据,再用用户名进行查询
	        	user.setPhone(null);  //清除user中phone数据
	        	user.setUserName(userName);
	        	userList = userService.findUserList(user);
	        	if(userList.size() == 0){
	        		throw new UnknownAccountException(); //没找到帐号
	        	}
	        }
	        user = userList.get(0); //得到用户信息
			
			//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
					user, user.getPassword(),ByteSource.Util.bytes(user.getSalt()), this.getName());        
	        return simpleAuthenticationInfo;
		}
		
		throw new UnknownAccountException();
    	
    }  
    
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	} 
    
    @Override  
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {  
        super.clearCachedAuthorizationInfo(principals);  
    }  
    
    @Override  
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {  
        super.clearCachedAuthenticationInfo(principals);  
    }
  
    @Override  
    public void clearCache(PrincipalCollection principals) {  
        super.clearCache(principals);  
    }  
  
    public void clearAllCachedAuthorizationInfo() {  
        getAuthorizationCache().clear();  
    }  
  
    public void clearAllCachedAuthenticationInfo() {  
        getAuthenticationCache().clear();  
    }  
  
    public void clearAllCache() {  
        clearAllCachedAuthenticationInfo();  
        clearAllCachedAuthorizationInfo();  
    }
} 