package com.xkm.nmp.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();;
	
	public static String getJsonString(Object obj) {
		return gson.toJson(obj);
	}

}

