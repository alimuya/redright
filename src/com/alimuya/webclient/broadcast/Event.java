package com.alimuya.webclient.broadcast;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String action;
	public Serializable args;

	public Event(Object source,String action,Serializable args) {
		super(source);
		this.action=action;
		this.args=args;
	}
	
	public String getAction() {
		return action;
	}
	public Serializable getArgs() {
		return args;
	}
}
