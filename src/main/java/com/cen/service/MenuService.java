package com.cen.service;

import java.util.List;

import com.cen.entity.Menu;

public interface MenuService {

	List<Menu> getMenu();
	List<Menu> getSubMenu(int mid);
}
