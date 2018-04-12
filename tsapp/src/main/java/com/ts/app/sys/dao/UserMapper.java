package com.ts.app.sys.dao;

import java.util.List;

import com.ts.app.sys.domain.User;
public interface UserMapper {
	/**
	 * 查询用户
	 * @return
	 */
	public List<User> findUserList(User user);
	/**
	 * 添加用户
	 * @return
	 */
	public void insertUser(User user);
	/**
	 * 修改用户
	 * @return
	 */
	public void updateUserById(User user) ;
	/**
	 * 查询用户详情
	 * @return
	 */
	public User findUserDetailById(Integer userId) ;

}
