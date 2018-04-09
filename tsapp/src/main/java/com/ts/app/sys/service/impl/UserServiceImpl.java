package com.ts.app.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.app.sys.dao.UserMapper;
import com.ts.app.sys.domain.User;
import com.ts.app.sys.service.UserService;
import com.ts.app.sys.utils.MD5Util;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> findUserList(User user) {
		return userMapper.findUserList(user);
	}

	@Override
	public void insertUser(User user) {
		String salt = (int)((Math.random()*9+1)*100000) + ""; //获取6位随机数;
		user.setSalt(salt);
		String password = MD5Util.saltMd5(user.getPassword(), salt);
		user.setPassword(password);
		userMapper.insertUser(user);
		
	}
	
}
