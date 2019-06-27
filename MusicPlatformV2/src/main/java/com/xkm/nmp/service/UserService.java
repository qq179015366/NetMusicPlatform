package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.UserDAOImpl;
import com.xkm.nmp.pojo.User;

public class UserService {
	private UserDAOImpl dao=new UserDAOImpl();

	//²éËùÓĞ
	public List<User> queryAll(){
		return dao.queryAll();
	}
	
	//¼ì²éÕËºÅÃÜÂë
	public User checkUser(String uname,String password) {
		return dao.checkUser(uname, password);
	}
	
	//×¢²á
	public void addUser(User user) {
		dao.addUser(user);
	}
	
	//É¾³ı
	public void delUser(Integer uid) {
		dao.delUser(uid);
	}
	
}
