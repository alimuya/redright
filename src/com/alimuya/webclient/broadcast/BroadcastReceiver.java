package com.alimuya.webclient.broadcast;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public abstract class BroadcastReceiver  implements ApplicationListener<Event> {

	private  Set<String> actions;
	
	@PostConstruct
	public void onInit(){
		this.actions=this.regListenActions();
	}
	
	@PreDestroy
	public void onDestroy(){
		this.actions=null;
	}
	
	public abstract Set<String> regListenActions();
	
	public abstract void onReceive(Object source,String action,Object args);

	@Override
	public void onApplicationEvent(Event event) {
		String action=event.getAction();
		if(this.actions!=null && action!=null && this.actions.contains(action)){
			this.onReceive(event.getSource(), action, event.getArgs());
		}
	}

	public Set<String> getActions() {
		return actions;
	}

	public void setActions(Set<String> actions) {
		this.actions = actions;
	}
}
