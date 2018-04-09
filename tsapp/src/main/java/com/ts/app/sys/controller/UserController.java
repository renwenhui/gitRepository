package com.ts.app.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.ts.app.sys.constants.Constants;
import com.ts.app.sys.domain.User;
import com.ts.app.sys.service.UserService;

@Controller
public class UserController{
	@Autowired
    private UserService userService;  
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	/**
	 * @Description: 用户注册
	 * @param: @param files
	 * @param: @param user
	 * @param: @throws IOException   
	 * @return: void   
	 * @throws
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
	
}