package com.cen.service;

import java.util.List;

import com.cen.entity.Menu;

public interface IRedisTakes {

	public String getReidsbyKey(String key);
	
	public void setKeyValue(String key,String value);
	
	public void setList(String key,List<Menu> list);
	
	public List<Menu> selectList(String key);
	 
}
