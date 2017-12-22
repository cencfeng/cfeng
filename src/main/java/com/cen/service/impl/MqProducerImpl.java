package com.cen.service.impl;

import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cen.service.IMqProducer;
@Service
public class MqProducerImpl implements IMqProducer {

	@Autowired
	AmqpTemplate amqpTemplate;
	@Override
	public void sendMq(String queueKey, Object object) {
		// TODO Auto-generated method stub
		
		amqpTemplate.convertAndSend(queueKey, object);
	  
	}

}
