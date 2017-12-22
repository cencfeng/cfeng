package com.cen.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMsgHandler implements MessageListener {


	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
	}  
}
