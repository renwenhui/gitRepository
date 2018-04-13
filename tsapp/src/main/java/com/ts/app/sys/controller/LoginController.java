package com.ts.app.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.ts.app.sys.constants.Constants;
import com.ts.app.sys.service.UserService;
import com.ts.app.sys.shiro.CustomRealm;
import com.ts.app.sys.shiro.CustomUsernamePasswordToken;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;  
	
	@Autowired
	private CustomRealm customRealm;
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	
	/** 
     * 登录
     */
    @RequestMapping(value = "/loginSubmit")
    @ResponseBody
    public Map loginSubmit(HttpServletRequest request,String userName,String password) { 
        Map map = Maps.newHashMap();
    	boolean result = false;
        String errorMessage = "";
        if(!checkImgCode(request)){ //校验图片验证码
    		errorMessage = "验证码不正确";
    	}else{
	        // 获取当前实体信息
	        Subject subject = SecurityUtils.getSubject();  
	        
	        CustomUsernamePasswordToken token = new CustomUsernamePasswordToken(userName, password); 
	        token.setRememberMe(true);  
	        try {
	            subject.login(token);
	            result = true;
	        } catch (UnknownAccountException e) {  
	            errorMessage = "用户名或者密码不正确";  
	        } catch (IncorrectCredentialsException e) {  
	            errorMessage = "用户名或者密码不正确";  
	        } catch (LockedAccountException e) {  
	            errorMessage = "当前用户被停用,不能登录";  
	        }catch (AuthenticationException e) {  
	            errorMessage = "登录失败";  
	            logger.error("登录失败：" + e);
	            e.printStackTrace();
	            token.clear();
	        }
    	}
        map.put(Constants.SUCCESS, result);
        map.put(Constants.MSG, errorMessage);
        return map;
    }
    
    /**
	 * 校验验证码
	 */
	public boolean checkImgCode(HttpServletRequest request){
		boolean result = false;
		HttpSession session = request.getSession(false);
		String validCode = (String) session.getAttribute(Constants.IMG_CODE); // 获取session中正确的验证码
		String imgCode = request.getParameter("imgCode"); //取出输入的验证码,并与session中的验证进行对比 
		if(validCode!=null && imgCode!=null 
				&& validCode.equalsIgnoreCase(imgCode)){
			result = true; 
		}
		return result;
	}
   
}
