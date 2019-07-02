package com.xkm.test;

import java.util.List;

import com.xkm.nmp.pojo.User;
import com.xkm.nmp.service.UserService;

/**
 * ≤‚ ‘µ«¬º
 * 
 * @author Ò„ÁÊ√˙
 *
 */
public class TestLogin {
	public static void main(String[] args) {
		UserService us = new UserService();
		System.out.println(us.countBlockUser());
		
		//User user=us.getUserByUname("testAccount");
		//System.out.println(user.toString());

		// User user=new User();
		// user.setUname("Jacob");
		// user.setPassword("123456");
		// user.setSex(0);
		// user.setPhone("13674825566");
		// user.setEmail("jacobWorkEmail@gmail.com");
		// us.addUser(user);
		// ≤‚ ‘
		// User user = us.checkUser("xxx", "123456");
		// if (user != null)
		// System.out.println(user.toString());
		// else
		// System.out.println("«ÎºÏ≤È’À∫≈√‹¬Î");
		//
		List<User> users = us.queryAll();
		users.forEach(u -> System.out.println(u.toString()));
	}
}
