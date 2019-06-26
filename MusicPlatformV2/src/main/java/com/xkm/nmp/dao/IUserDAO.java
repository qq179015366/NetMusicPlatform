package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.User;

public interface IUserDAO {

	//查所有
	public List<User> queryAll();
	
	//检查账号
	public User checkUser(String uname,String password);
	
}
