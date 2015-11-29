package com.alimuya.webclient.service;

import com.alimuya.webclient.IWebClientService;

public class WebClientService implements IWebClientService{
	@Override
	public void startup() throws Exception{
	 	new Thread(new Runnable() {
			
			@Override
			public void run() {
				Jetty8HttpService jetty=new Jetty8HttpService();
				try {
					jetty.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void shutdown() throws Exception{
		// TODO Auto-generated method stub
		
	}
}
