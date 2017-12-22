package com.cen.service;

public interface IMqProducer {

	public void sendMq(String queueKey,Object object);
}
