package com.sansan.service.impl;

import java.util.List;


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
	
	@Override
	public List<User> getUserInfo(int i) {
		return userMapper.getUserInfoByUserID(i);
	}
	
}
