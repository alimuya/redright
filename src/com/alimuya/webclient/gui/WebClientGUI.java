package com.alimuya.webclient.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import com.alimuya.webclient.IWebClientService;
import com.alimuya.webclient.service.WebClientService;
import com.tiandy.demo.chats.EagleBrowser;

public class WebClientGUI implements IWebClientService{
	public static final String ACTION_GUI_SHUTDOWN="action_gui_shutdown";
	public static final String ACTION_GUI_SHUTDOWN_BY_EXCEPTION="action_gui_shutdown_by_exception";
	
	private JFrame frame;
	private JWebBrowser webBrowser;
	public WebClientGUI(String title){
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationByPlatform(true);
//		frame.setUndecorated(true);
		frame.setSize(800, 600);
		initBrowser();
		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();
		JPanel webBrowserPanel = new JPanel(new BorderLayout());
		webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		frame.getContentPane().add(webBrowserPanel,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public void show(final String url){
		
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("lalalllla");
//				webBrowser.updateUI();
//				webBrowser.clearSessionCookies();
				webBrowser.navigate(url);
//				webBrowser.reloadPage();
			}
		};
		SwingUtilities.invokeLater(runnable);
		NativeInterface.runEventPump();
	}
	
	private void initBrowser(){
		webBrowser = new JWebBrowser();
		webBrowser.setButtonBarVisible(false);
		webBrowser.setMenuBarVisible(false);
		webBrowser.setBarsVisible(false);
		webBrowser.setStatusBarVisible(false);
	}
	
	public static void main(String[] args) throws Exception {
		WebClientService server =new WebClientService();
		server.startup();
		final String url = "http://127.0.0.1:4949/redright/resources/index.html";
		final String title = "test";
		WebClientGUI client=new WebClientGUI(title);
		client.show(url);
	}

	@Override
	public void startup() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
