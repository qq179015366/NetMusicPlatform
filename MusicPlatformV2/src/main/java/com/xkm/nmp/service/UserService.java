package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.UserDAOImpl;
import com.xkm.nmp.pojo.User;

public class UserService {
	private UserDAOImpl dao=new UserDAOImpl();

	//查所有
	public List<User> queryAll(){
		return dao.queryAll();
	}
	
	//检查账号密码
	public User checkUser(String uname,String password) {
		return dao.checkUser(uname, password);
	}
	
}
