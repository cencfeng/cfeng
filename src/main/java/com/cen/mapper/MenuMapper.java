package com.cen.mapper;

import java.util.List;

import com.cen.entity.Menu;

public interface MenuMapper {

	List<Menu> getMenu();
	List<Menu> getSubMenu(int mid);
}
