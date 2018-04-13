package com.ts.app.sys.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.Maps;

public class Constants {
	
	/**
	 * 用户SESSION KEY
	 */
	public static final String SESSION_USER_KEY="SESSION_USER_KEY";
	
	/**
	 * 图片验证码
	 */
	public static final String IMG_CODE="imgCode";
	
	/**
	 * 图片验证码创建时间
	 */
	public static final String IMG_BUILD_TIME="imgBuildTime";
	
	/**
	 * 返回结果（true成功，false失败）
	 */
	public static final String SUCCESS="success";
	
	/**
	 * json返回信息
	 */
	public static final String MSG="msg";
    
    /**
     * 删除标志
     */
    public static final String DEL_FLAG="1";
	
	/**
     * 性别-0男
     */
	public static final String USER_SEX_MALE = "0";
	/**
     * 性别-1女
     */
	public static final String USER_SEX_FEMALE = "1";
	public static final Map<String,String> MAP_USER_SEX=Maps.newHashMap(); 
    static{
    	MAP_USER_SEX.put(USER_SEX_MALE, "男");
    	MAP_USER_SEX.put(USER_SEX_FEMALE, "女");
    }
    
    /**
     * 留言反馈和用户评价 每页默认显示两条
     */
    public static final String PAGESIZE_2="2";
    
    /**
     * 消息中心 每页默认显示四条
     */
    public static final String PAGESIZE_4="4";
    
    



    


    

	
    
    
    
	
   
    
   
    
   
    
	
	
    
	
	
	
    
    
    
   
    

}
