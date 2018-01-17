package com.sansan.service;

import java.util.List;

import com.sansan.dao.User;

public interface UserService {
	String SERVICE_NAME = "userService";
	List<User> getUserInfo(int i);

}
