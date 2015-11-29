package com.alimuya.webclient.service;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class Jetty8HttpService {
	public void start() throws Exception {
		Server server = new Server(4949);
		WebAppContext context = new WebAppContext();
		ServletHolder holder = null;
		// ServletHolder holder=new ServletHolder(new ResourceServlet());
		// context.addServlet(holder, "/resources/*");
		holder = new ServletHolder(new DefaultServlet());
		context.addServlet(holder, "/resources/*");
		
		context.setContextPath("/redright");
		context.setDescriptor("WebRoot/WEB-INF/web.xml");
		context.setResourceBase("WebRoot");
		context.setWelcomeFiles(new String[] { "index.html" });
		context.setParentLoaderPriority(true);
		context.setConfigurationDiscovered(true);
		server.setHandler(context);
		server.start();
		server.join();
	}
}
