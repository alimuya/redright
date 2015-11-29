package com.alimuya.webclient.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Browser extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel webBrowserPanel;

	private JWebBrowser webBrowser;


	public Browser(String url) {
		super(new BorderLayout());
		webBrowserPanel = new JPanel(new BorderLayout());
//		webBrowser = new JWebBrowser();
//		
//		webBrowser.navigate(url);
//		webBrowser.setButtonBarVisible(false);
//		webBrowser.setMenuBarVisible(false);
//		webBrowser.setBarsVisible(false);
//		webBrowser.setStatusBarVisible(false);
		webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		add(webBrowserPanel, BorderLayout.CENTER);
	}

	public void startup (Runnable runnable){
		if(runnable!=null){
			UIUtils.setPreferredLookAndFeel();
			NativeInterface.open();
			SwingUtilities.invokeLater(runnable);
			NativeInterface.runEventPump();
		}
	}
}
