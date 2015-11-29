package com.alimuya.webclient.broadcast;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BroadcastLoader implements ApplicationListener<ApplicationEvent> {
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof ContextRefreshedEvent) { 
			ApplicationContext context = (ApplicationContext)event.getSource();
			if(context.getParent()==null){
				System.out.println("jahahah");
			}
		}
	}
}

