package com.sansan.mappers;

import java.util.List;

import com.sansan.dao.User;

public interface UserMapper {

	List<User> getUserInfoByUserID(int i);

}
