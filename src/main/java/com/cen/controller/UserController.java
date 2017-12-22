package com.cen.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cen.entity.User;
import com.cen.service.IMqProducer;
import com.cen.service.IRedisTakes;
import com.cen.service.UserService;
import com.cen.service.impl.ReceiveMsgHandler;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	IMqProducer mqProducer;
	//MessageListener  receiveMsgHandler;//打印接收的消息
	@RequestMapping("/login")
	public String login(User user,Model mv) {
		if(userService.getUser(user) != null) {
			//redisTakes.setKeyValue("username", user.getUsername());
			//String value = redisTakes.getReidsbyKey("username");
			//mv.addAttribute("result",value);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		    String strdate = sdf.format(date);		   
			mqProducer.sendMq("test_queue_key", user.getUsername()+" login  at "+strdate);
			return "menu";
		}
		return "failed";
	}
}
