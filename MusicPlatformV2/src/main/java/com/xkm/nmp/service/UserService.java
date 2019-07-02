package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.UserDAOImpl;
import com.xkm.nmp.pojo.User;

public class UserService {
	private UserDAOImpl dao = new UserDAOImpl();

	// 查所有
	public List<User> queryAll() {
		return dao.queryAll();
	}

	public List<User> queryAllByPager(Integer page, Integer pageSize) {
		int start = (page - 1) * pageSize;
		int size = pageSize;
		return dao.queryAllByPager(start, size);
	}

	// 检查账号密码
	public User checkUser(String uname, String password) {
		return dao.checkUser(uname, password);
	}

	// 注册
	public void addUser(User user) {
		dao.addUser(user);
	}

	// 删除
	public void delUser(Long uid) {
		dao.delUser(uid);
	}

	// 根据用户名查询
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
