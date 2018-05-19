package com.sansan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansan.mappers.UserMapper;
import com.sansan.dao.User;
import com.sansan.service.UserService;

@Transactional
@Service(UserService.SERVICE_NAME)
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 测试SMM框架接口
	 */
	@Override
	public List<User> getUserInfo(int i) {
		return userMapper.getUserInfoByUserID(i);
	}
	/**
	 * 根据用户名查找用户密码
	 */
	@Override
	public String getUserPassWord(String userName) {
		return userMapper.getUserPassWord(userName);
	}
	/**
	 * 查找用户ID
	 */
	@Override
	public User getUserID(String userName) {
		return userMapper.getUserID(userName);
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public int insertUser(Map<String, String> map) {
		return userMapper.insertUser(map);
	}
	
	/**
	 * select 框用户获取
	 */
	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}
	
	/**
	 * 获取用户列表信息
	 */
	@Override
	public List<User> getListAdmins(Map<String,Object> map) {
		return userMapper.getListAdmins(map);
	}
	
	/**
	 * 获取用户数量
	 */
	@Override
	public int getCountAdmins() {
		return userMapper.getCountAdmins();
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public int insertAdmin(User user) {
		return userMapper.insertAdmin(user);
	}

	/**
	 * 编辑用户信息
	 * @param user
	 * @return
	 */
	@Override
	public int updateUserInfo(User user){
		return userMapper.updateUserInfo(user);
	}

	/**
	 * delUserInfo
	 * @param userID
	 * @return
	 */
	@Override
	public int delUserInfo(int userID){
		return userMapper.delUserInfo(userID);
	}
}
