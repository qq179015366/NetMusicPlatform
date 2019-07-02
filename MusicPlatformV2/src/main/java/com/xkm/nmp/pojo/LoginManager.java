package com.xkm.nmp.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginManager {

	private static List<String> sessionIds = new ArrayList<>();
	private static Map<String, User> sessionUserMap = new HashMap<>();
	private static List<User> onlineUsers = new ArrayList<>();

	public void add(String sessionId) {
		sessionIds.add(sessionId);
	}

	public void addUser(String sessionId) {
		User user = sessionUserMap.get(sessionId);
		onlineUsers.add(user);
	}

	public void remove(String sessionId) {
		sessionIds.remove(sessionId);
	}

	public void removeUser(String sessionId) {
		try {
			User user = sessionUserMap.get(sessionId);
			onlineUsers.remove(user);
		} catch (Exception e) {
			System.out.println("´íÎóÀ´×Ô:com.xkm.nmp.pojo.LoginManager  line:32");
			e.printStackTrace();
		}
	}

	public static List<String> getSessionIds() {
		return sessionIds;
	}

	public static void setSessionIds(List<String> sessionIds) {
		LoginManager.sessionIds = sessionIds;
	}

	public static Map<String, User> getSessionUserMap() {
		return sessionUserMap;
	}

	public static void setSessionUserMap(Map<String, User> sessionUserMap) {
		LoginManager.sessionUserMap = sessionUserMap;
	}

	public static List<User> getOnlineUsers() {
		return onlineUsers;
	}

	public static void setOnlineUsers(List<User> onlineUsers) {
		LoginManager.onlineUsers = onlineUsers;
	}

}
