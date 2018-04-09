package com.ts.app.sys.dao;

import java.util.List;

import com.ts.app.sys.domain.User;
public interface UserMapper {
	public List<User> findUserList(User user);
	
	public void insertUser(User user);

}
