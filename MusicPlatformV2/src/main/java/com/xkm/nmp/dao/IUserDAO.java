package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.User;

public interface IUserDAO {

	//查所有
	public List<User> queryAll();
	
	//检查账号
	public User checkUser(String uname,String password);
	
	//注册
	public void addUser(User user);
	
	//删除
	public void delUser(Long uid);
	
	//根据用户名查询
	public User getUserByUname(String uname);
	
}
