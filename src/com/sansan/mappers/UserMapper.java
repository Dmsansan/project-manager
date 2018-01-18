package com.sansan.mappers;

import java.util.List;

import com.sansan.dao.User;

public interface UserMapper {

	List<User> getUserInfoByUserID(int i);
	
	/**
	 * 根据用户密码查找用户密码
	 * @param userName
	 * @return
	 */
	String getUserPassWord(String userName);

}
