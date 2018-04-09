package com.ts.app.sys.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.ts.app.sys.domain.User;

/**
 * @ClassName: UserUtils
 * @Description: 用户工具类
 * @author: chunyu.xia
 * @date: 2017-11-17 下午2:54:03
 */
public class CacheUtils {

	/**
	 * 用户KEY
	 */
	public static final String USER_CACHE = "userCache";
	
	/**
	 * 用户-菜单KEY
	 */
	public static final String USER_MENU_CACHE = "userMenuCache";

	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		User user = getPrincipal();
		if (user!=null){
			return user;
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}
	
	/**
	 * 从SecurityManager中获取主体信息，即当前用户信息
	 */
	public static User getPrincipal(){
		try{
			Subject subject = getSubject();
			User user = (User) subject.getPrincipal();
			if (user != null){
				return user;
			}
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取shiro-seesion
	 */
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	/**
	 * 根据key值 从shiro-session中获取对应的value
	 */
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	/**
	 * 将数据缓存到shiro-session中
	 */
	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}
	
	/**
	 * 根据key值清除shiro-session中对应的value
	 */
	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}
	
}
