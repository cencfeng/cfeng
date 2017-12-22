package com.cen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cen.entity.User;
import com.cen.mapper.UserMapper;
import com.cen.service.UserService;

import redis.clients.jedis.Jedis;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUser(user);
	}
	@Override
	public List<User> getUsertest() {
		// TODO Auto-generated method stub
		
		return userMapper.getUsertest();
	}

}
