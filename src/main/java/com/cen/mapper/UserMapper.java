package com.cen.mapper;

import java.util.List;

import com.cen.entity.User;

public interface UserMapper {

	User getUser(User user);
	
	List<User> getUsertest();
}
