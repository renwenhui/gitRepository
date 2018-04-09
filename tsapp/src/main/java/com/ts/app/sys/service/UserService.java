package com.ts.app.sys.service;

import java.util.List;

import com.ts.app.sys.domain.User;
import com.ts.app.sys.exception.CustomException;

public interface UserService{
    
	public List<User> findUserList(User user);
	
	public void insertUser(User user);

}