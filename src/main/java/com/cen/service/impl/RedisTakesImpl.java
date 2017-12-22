package com.cen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cen.entity.Menu;
import com.cen.entity.SeeUser;
import com.cen.service.IRedisTakes;
@Service
public class RedisTakesImpl implements IRedisTakes {

	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public String getReidsbyKey(String key) {
		// TODO Auto-generated method stub
		String value = (String)redisTemplate.opsForValue().get(key);
		return value;
	}


	@Override
	public void setKeyValue(String key, String value) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set(key,value);
		
	}


	@Override
	public void setList(String key, List<Menu> list) {
		// TODO Auto-generated method stub
		redisTemplate.opsForList().rightPushAll(key, list);
		
	}


	@Override
	public List<Menu> selectList(String key) {
		// TODO Auto-generated method stub
		
		return redisTemplate.opsForList().range(key, 0, -1);
	}
	

}
