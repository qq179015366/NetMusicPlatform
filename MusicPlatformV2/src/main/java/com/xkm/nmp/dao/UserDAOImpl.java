package com.xkm.nmp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xkm.nmp.core.utils.SqlSessionFactoryUtil;
import com.xkm.nmp.pojo.User;

public class UserDAOImpl implements IUserDAO{
	
	SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();
	SqlSession s = null;

	//������
	@Override
	public List<User> queryAll() {
		s = sf.openSession();
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		List<User> users=userDAO.queryAll();
		s.close();
		return users;
	}

	//����˺�����
	@Override
	public User checkUser(String uname, String password) {
		s=sf.openSession();
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		User user=userDAO.checkUser(uname, password);
		s.close();
		return user;
	}
	
     //ע��
	@Override
	public void addUser(User user) {
		s=sf.openSession(true);
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		userDAO.addUser(user);
		s.close();
	}
	
   //ɾ��
	@Override
	public void delUser(Long uid) {
		s=sf.openSession(true);
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		userDAO.delUser(uid);
		s.close();
	}

	//�����û�����ѯ
	@Override
	public User getUserByUname(String uname) {
		s=sf.openSession();
		IUserDAO userDAO=s.getMapper(IUserDAO.class);
		User user=userDAO.getUserByUname(uname);
		s.close();
		return user;
	}

}
