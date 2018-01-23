package com.sansan.mappers;

import java.util.List;
import java.util.Map;

import com.sansan.dao.User;

public interface UserMapper {

	List<User> getUserInfoByUserID(int i);
	
	/**
	 * 根据用户密码查找用户密码
	 * @param userName
	 * @return
	 */
	String getUserPassWord(String userName);
	
	/**
	 * 查找用户ID
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
	 * 获取select框用户
	 * @return
	 */
	List<User> getAllUser();

}
