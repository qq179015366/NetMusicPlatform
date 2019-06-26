package com.xkm.nmp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xkm.nmp.core.utils.SqlSessionFactoryUtil;
import com.xkm.nmp.pojo.User;

public class UserDAOImpl implements IUserDAO{
	
	SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();
	SqlSession s = null;

	//查所有
	@Override
	public List<User> queryAll() {
		s = sf.openSession();
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		List<User> users=userDAO.queryAll();
		s.close();
		return users;
	}

	//检查账号密码
	@Override
	public User checkUser(String uname, String password) {
		s=sf.openSession();
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		User user=userDAO.checkUser(uname, password);
		s.close();
		return user;
	}

}
