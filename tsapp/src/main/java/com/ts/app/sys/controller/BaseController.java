package com.ts.app.sys.controller;

import com.ts.app.sys.utils.CacheUtils;

/**
 * 
  * 基础Controller
 */
public class BaseController {

	public Integer getLoginUid(){
		return CacheUtils.getUser().getUserId();
	}
	
	public boolean isAdminLogin(){
		//FIXME:判断是否是管理人员
		return true;
	}
}
