package com.xkm.nmp.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xkm.nmp.pojo.LoginManager;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
public class LoginListener implements HttpSessionListener {

	public static LoginManager loginM = new LoginManager();

	/**
	 * Default constructor.
	 */
	public LoginListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
		loginM.add(sessionId);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId=se.getSession().getId();
		loginM.remove(sessionId);
		loginM.removeUser(sessionId);
	}

}
