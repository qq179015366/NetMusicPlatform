package com.xkm.nmp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xkm.nmp.core.utils.SqlSessionFactoryUtil;
import com.xkm.nmp.pojo.User;

public class UserDAOImpl implements IUserDAO{
	
	SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();
	SqlSession s = null;

	//²éËùÓÐ
	@Override
	public List<User> queryAll() {
		s = sf.openSession();
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		List<User> users=userDAO.queryAll();
		s.close();
		return users;
	}

	//¼ì²éÕËºÅÃÜÂë
	@Override
	public User checkUser(String uname, String password) {
		s=sf.openSession();
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		User user=userDAO.checkUser(uname, password);
		s.close();
		return user;
	}
	
     //×¢²á
	@Override
	public void addUser(User user) {
		s=sf.openSession(true);
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		userDAO.addUser(user);
		s.close();
	}
	
   //É¾³ý
	@Override
	public void delUser(Integer uid) {
		s=sf.openSession(true);
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		userDAO.delUser(uid);
		s.close();
	}

}
