package com.alimuya.webclient.broadcast;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BroadCaster implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void sendBroadcast(Object source,String action){
		this.sendBroadcast(source, action, null);
	}
	
	public void sendBroadcast(Object source,String action,Serializable args){
		applicationContext.publishEvent(new Event(source,action,args));
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext=applicationContext;
	}
}
