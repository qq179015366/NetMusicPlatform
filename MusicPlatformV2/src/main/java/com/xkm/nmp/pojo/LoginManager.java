package com.xkm.nmp.pojo;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {
	
	private static List<String> sessionIds=new ArrayList<>();
	
	public void add(String sessionId) {
		sessionIds.add(sessionId);
	}

	public void remove(String sessionId) {
		sessionIds.remove(sessionId);
	}

}
