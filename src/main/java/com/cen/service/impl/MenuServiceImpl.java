package com.cen.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cen.entity.Menu;
import com.cen.mapper.MenuMapper;
import com.cen.service.IRedisTakes;
import com.cen.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuMapper menuMapper;
	@Autowired
	IRedisTakes redisTakes;
	@Override
	public List<Menu> getMenu() {
		// TODO Auto-generated method stub
		List<Menu> list = redisTakes.selectList("menu");
		if(list.isEmpty()) {
			list = menuMapper.getMenu();
			redisTakes.setList("menu", list);
		}
		return list;
	}
	@Override
	public List<Menu> getSubMenu(int mid) {
		// TODO Auto-generated method stub
		List<Menu> list = redisTakes.selectList("submenu"+mid);
		if(list.isEmpty()) {
			list = menuMapper.getSubMenu(mid);
			if(!list.isEmpty()) {
			redisTakes.setList("submenu"+mid, list);
			}
		}
		return list;
	}

}
