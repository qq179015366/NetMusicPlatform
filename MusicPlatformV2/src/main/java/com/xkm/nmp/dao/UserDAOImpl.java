package com.xkm.nmp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xkm.nmp.core.utils.SqlSessionFactoryUtil;
import com.xkm.nmp.pojo.User;

public class UserDAOImpl implements IUserDAO {

	SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();
	SqlSession s = null;

	// 查所有
	@Override
	public List<User> queryAll() {
		s = sf.openSession();
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		List<User> users = userDAO.queryAll();
		s.close();
		return users;
	}

	// 检查账号密码
	@Override
	public User checkUser(String uname, String password) {
		s = sf.openSession();
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		User user = userDAO.checkUser(uname, password);
		s.close();
		return user;
	}

	// 注册
	@Override
	public void addUser(User user) {
		s = sf.openSession(true);
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		userDAO.addUser(user);
		s.close();
	}

	// 删除
	@Override
	public void delUser(Long uid) {
		s = sf.openSession(true);
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		userDAO.delUser(uid);
		s.close();
	}

	// 根据用户名查询
	@Override
	public User getUserByUname(String uname) {
		s = sf.openSession();
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		User user = userDAO.getUserByUname(uname);
		s.close();
		return user;
	}

	@Override
	public Integer countUser() {
		s = sf.openSession();
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		Integer count = userDAO.countUser();
		s.close();
		return count;
	}

	@Override
	public List<User> queryAllByPager(Integer start, Integer size) {
		s = sf.openSession();
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		List<User> users = userDAO.queryAllByPager(start, size);
		s.close();
		return users;
	}

	@Override
	public Integer countBlockUser() {
		s = sf.openSession();
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		Integer count = userDAO.countBlockUser();
		s.close();
		return count;
	}

	@Override
	public List<User> queryBlockUser(Integer start, Integer size) {
		s = sf.openSession();
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		List<User> users = userDAO.queryBlockUser(start, size);
		s.close();
		return users;
	}

	@Override
	public void renewUser(Long uid) {
		s = sf.openSession(true);
		IUserDAO userDAO = s.getMapper(IUserDAO.class);
		userDAO.renewUser(uid);
		s.close();
	}

}
