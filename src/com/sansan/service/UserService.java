package com.sansan.service;

import java.util.List;
import java.util.Map;

import com.sansan.dao.User;

public interface UserService {
	String SERVICE_NAME = "userService";
	/**
	 * 根据用户ID获取用户信息
	 * @param i
	 * @return
	 */
	List<User> getUserInfo(int i);
	
	/**
	 * 查找用户密码
	 * @param userName
	 * @return
	 */
	String getUserPassWord(String userName);
	
	/**
	 * 根据用户名查找用户ID
	 * @param userName
	 * @return
	 */
	User getUserID(String userName);
		
	/**
	 * 添加用户
	 * @param map
	 * @return
	 */
	int insertUser(Map<String, String> map);
	
	/**
	 * select框用户获取
	 * @return
	 */
	List<User> getAllUser();
	
	/**
	 * 获取用户列表信息
	 * @return
	 */
	List<User> getListAdmins();
	
	/**
	 * 获取用户总的数量
	 * @return
	 */
	int getCountAdmins();

}
