package com.cen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cen.entity.Menu;
import com.cen.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	MenuService menuService;
	@RequestMapping("/getMenu")
	@ResponseBody
	public List<Menu> getMenu(){
		List<Menu> list = menuService.getMenu();
		return list;
	}
	@RequestMapping("/getSubMenu")
	@ResponseBody
	public List<Menu> getSubMenu(int mid){
		List<Menu> list = menuService.getSubMenu(mid);
		return list;
	}
}
