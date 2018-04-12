package com.ts.app.sys.service;

import java.util.List;

import com.ts.app.sys.domain.User;

public interface UserService{
    /**
     * 查询用户列表
     * @return
     */
	public List<User> findUserList(User user);
	/**
     * 添加用户
     * @return
     */
	public void insertUser(User user);
	/**
     * 修改用户信息
     * @return
     */
	public void updateUserById(User user) ;
	/**
     * 查询用户信息
     * @return
     */
	public User findUserDetailById(Integer userId) ;

}