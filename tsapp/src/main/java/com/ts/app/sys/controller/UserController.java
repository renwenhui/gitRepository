package com.ts.app.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Maps;
import com.ts.app.sys.constants.Constants;
import com.ts.app.sys.domain.Article;
import com.ts.app.sys.domain.User;
import com.ts.app.sys.service.UserService;
import com.ts.app.sys.utils.CacheUtils;
import com.ts.app.sys.utils.MD5Util;
import com.ts.app.sys.utils.UploadUtils;

@Controller
@SuppressWarnings("all")
public class UserController{
	@Autowired
    private UserService userService;  
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	/**
	 *  用户注册
	 */
    @RequestMapping("/userReg")
    @ResponseBody
    public Map userReg(HttpServletRequest request,User user){
    	Map map = Maps.newHashMap();
    	try{
    		//获取页面传过来的手机号
    		if(StringUtils.isEmpty(user.getPhone())){
    	        map.put(Constants.SUCCESS, false);
    	        map.put(Constants.MSG, "手机号码不能为空");
    	        return map;
    		}
    		//获取页面传过来的密码
    		if(StringUtils.isEmpty(user.getPassword())){
    			map.put(Constants.SUCCESS, false);
    			map.put(Constants.MSG, "密码不能为空");
    			return map;
    		}
    		
	    	// 检查用户名是否已存在
	    	User u = new User();
	    	u.setUserName(user.getUserName());
	    	List<User> userList = userService.findUserList(u);
	    	if(userList.size() > 0){
		        map.put(Constants.SUCCESS, false);
		        map.put(Constants.MSG, "用户名已经被注册");
		        return map;
	    	}
	    	// 检查手机号是否已存在
	    	u.setUserName(null); // 清除实体类中的用户名数据
	    	u.setPhone(user.getPhone());
	    	userList = userService.findUserList(u);
	    	if(userList.size() > 0){
				map.put(Constants.SUCCESS, false);
		        map.put(Constants.MSG, "手机号已经被注册");
		        return map;
			}
	    	userService.insertUser(user);//添加到数据库
	        map.put(Constants.SUCCESS, true);
	        map.put(Constants.MSG, "注册成功");
		}catch (Exception e) {
	        map.put(Constants.SUCCESS, false);
	        map.put(Constants.MSG, "注册失败,请重试");
	        logger.error("用户注册失败：" + e);
	        e.printStackTrace();
		}
    	return map;
    }
    
    /**
	 *  查询基本信息
	 */
	@RequestMapping("/findUserDetail")
	@ResponseBody
	public Map findUserDetail(){
		Map map = Maps.newHashMap();
		try {
			Integer userId = CacheUtils.getUser().getUserId();
			User user = userService.findUserDetailById(userId);
			
			map.put(Constants.SUCCESS, true);
			map.put("user", user);
			map.put("MAP_USER_SEX", Constants.MAP_USER_SEX);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询留言反馈列表信息失败，错误信息为：" + e);
			map.put(Constants.SUCCESS, false);
			map.put(Constants.MSG, "系统异常，请重试");
		}
		
		return map;
	}
	
	/**
	 * 更改用户信息
	 */
	@RequestMapping("/updateUser")
    @ResponseBody
    public Map updateUser(HttpServletRequest request,User user){
    	Map map = Maps.newHashMap();
    	try{
    		Integer userId = CacheUtils.getUser().getUserId();
    		user.setUserId(userId);
    		userService.updateUserById(user);//更新用户信息
	        map.put(Constants.SUCCESS, true);
	        map.put(Constants.MSG, "修改成功");
		}catch (Exception e) {
	        map.put(Constants.SUCCESS, false);
	        map.put(Constants.MSG, "修改失败,请重试");
	        logger.error("修改失败：" + e);
	        e.printStackTrace();
		}
    	return map;
    }
	
	
	/**
	 * 上传头像
	 */
	@RequestMapping("/changeHead")
    @ResponseBody
    public Map changeHead(HttpServletRequest request,@RequestParam(value="file",required = false)MultipartFile file[]){
    	Map map = Maps.newHashMap();
    	try{
    		//获取用户id
    		Integer userId = CacheUtils.getUser().getUserId();
    		//本地测试路径
    		String path="F:/work/upload/";
    		User user= new User();
    		user.setUserId(userId);
    		
    		//验证地址是否存在
    		File targetFile=new File(path); 
    		if(!targetFile.exists()){
    			targetFile.mkdirs();
    		}
    		
    		//遍历
    			for(int i=0; i<file.length;i++){
    				
    				if(!file[i].isEmpty()){
    					try {		
    						//获取照片原始名称
    						String photoName=file[i].getOriginalFilename();
    						//扩展名
    						String extName = photoName.substring(photoName.lastIndexOf("."));
    						//防止图片名称冲突，中文乱码等问题重命名
    						photoName = System.nanoTime() + extName; 
    						user.setHeadUrl(photoName);
    						
    						//创建实际路径	
    						file[i].transferTo(new File(path+photoName));
    						
    					} catch (IllegalStateException e) {
    						e.printStackTrace();
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
    				}
    				
    			}
    		
    		userService.updateUserById(user);
	        map.put(Constants.SUCCESS, true);
	        map.put(Constants.MSG, "上传成功");
		}catch (Exception e) {
	        map.put(Constants.SUCCESS, false);
	        map.put(Constants.MSG, "上传失败,请重试");
	        logger.error("头像上传失败：" + e);
	        e.printStackTrace();
		}
    	return map;
    }
	
	/**
	 *  检查原密码
	 */
	@RequestMapping("/checkPassword")
    @ResponseBody
    public Map checkPassword(User user){
    	Map map = Maps.newHashMap();
    	try{
	    	//获取用户id
			Integer userId = CacheUtils.getUser().getUserId();
	    	User u = userService.findUserDetailById(userId);
	    	//获取密码盐
			String salt = u.getSalt(); //获取6位随机数
			//对密码进行加密
			String cipherPw = MD5Util.saltMd5(user.getPassword(), salt); // 获取加密后密码
	    	if (cipherPw.equals(u.getPassword())) {
	    		map.put(Constants.SUCCESS, true);
			}else{
				map.put(Constants.SUCCESS, false);
		        map.put(Constants.MSG, "原密码输入有误，请确认");
			}
    	} catch (Exception e) {
    		map.put(Constants.SUCCESS, false);
 	        map.put(Constants.MSG, "原密码输入有误,请重试");
 	        logger.error("原密码输入有误：" + e);
 	        e.printStackTrace();
    	}
		return map;
    }
	
	
	/**
	 * @Description: 修改登录密码
	 * @version: v1.0.0
	 * @author: ren
	 * @date: 2018-1-2 下午5:29:15
	 */
	@RequestMapping(value="changeLoginPwd")
	@ResponseBody
	public Map changeLoginPwd(User user){
		Map map = Maps.newHashMap();
		try {
			Integer userId=CacheUtils.getUser().getUserId();
			user.setUpdateUserId(userId);
			user.setUserId(userId);
			//获取随机数密码盐
			String salt = (int)((Math.random()*9+1)*100000) + ""; //获取6位随机数
			//对新密码进行加密
			String cipherPw = MD5Util.saltMd5(user.getPassword(), salt); // 获取加密后密码
			user.setSalt(salt);
			user.setPassword(cipherPw);
			userService.updateUserById(user);
			map.put(Constants.SUCCESS, true);
			map.put(Constants.MSG, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("密码修改错误，错误信息为：" + e);
			map.put(Constants.SUCCESS, false);
			map.put(Constants.MSG, "修改失败,请重试");
		}
		return map;  
	}
	
	/** 
	 * 用户登出 
	 */  
	/*@RequestMapping(value="/logout",method=RequestMethod.GET)  
	public String logout(HttpServletRequest request){  
	     SecurityUtils.getSubject().logout();  
	     return "redirect:/login";  
	} */
	
}