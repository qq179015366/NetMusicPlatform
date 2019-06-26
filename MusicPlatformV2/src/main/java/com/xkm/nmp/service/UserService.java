package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.UserDAOImpl;
import com.xkm.nmp.pojo.User;

public class UserService {
	private UserDAOImpl dao=new UserDAOImpl();

	public List<User> queryAll(){
		return dao.queryAll();
	}
	
}
