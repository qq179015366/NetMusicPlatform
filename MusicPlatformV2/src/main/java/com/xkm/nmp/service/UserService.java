package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.UserDAOImpl;
import com.xkm.nmp.pojo.User;

public class UserService {
	private UserDAOImpl dao = new UserDAOImpl();

	// ������
	public List<User> queryAll() {
		return dao.queryAll();
	}

	public List<User> queryAllByPager(Integer page, Integer pageSize) {
		int start = (page - 1) * pageSize;
		int size = pageSize;
		return dao.queryAllByPager(start, size);
	}

	// ����˺�����
	public User checkUser(String uname, String password) {
		return dao.checkUser(uname, password);
	}

	// ע��
	public void addUser(User user) {
		dao.addUser(user);
	}

	// ɾ��
	public void delUser(Long uid) {
		dao.delUser(uid);
	}

	// �����û�����ѯ
	public User getUserByUname(String uname) {
		return dao.getUserByUname(uname);
	}

	public Integer countUser() {
		return dao.countUser();
	}

	public Integer countBlockUser() {
		return dao.countBlockUser();
	}

	public List<User> queryBlockUser(Integer page, Integer pageSize) {
		int start = (page - 1) * pageSize;
		int size = pageSize;
		return dao.queryBlockUser(start, size);
	}
	
	public void renewUser(Long uid) {
		dao.renewUser(uid);
	}

}
