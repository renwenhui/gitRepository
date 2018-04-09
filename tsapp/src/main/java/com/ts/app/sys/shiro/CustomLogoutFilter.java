package com.ts.app.sys.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomLogoutFilter extends LogoutFilter {
	
	@Autowired
	private CustomRealm customRealm;
	
	@Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		customRealm.clearAllCachedAuthenticationInfo(); //退出清空认证信息缓存
    	Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);
        try {
            subject.logout();
        } catch (SessionException ise) {
           ise.printStackTrace();
        }
        issueRedirect(request, response, redirectUrl);
        //返回false表示不执行后续的过滤器，直接返回跳转到登录页面
        return false;
    }
}