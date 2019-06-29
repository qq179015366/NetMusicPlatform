package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.UserDAOImpl;
import com.xkm.nmp.pojo.User;

public class UserService {
	private UserDAOImpl dao=new UserDAOImpl();

	//������
	public List<User> queryAll(){
		return dao.queryAll();
	}
	
	//����˺�����
	public User checkUser(String uname,String password) {
		return dao.checkUser(uname, password);
	}
	
	//ע��
	public void addUser(User user) {
		dao.addUser(user);
	}
	
	//ɾ��
	public void delUser(Long uid) {
		dao.delUser(uid);
	}
	
	//�����û�����ѯ
	public User getUserByUname(String uname) {
		return dao.getUserByUname(uname);
	}
	
}
