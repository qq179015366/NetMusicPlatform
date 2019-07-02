package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.User;

public interface IUserDAO {

	// ������
	public List<User> queryAll();

	// ����˺�
	public User checkUser(String uname, String password);

	// ע��
	public void addUser(User user);

	// ɾ��
	public void delUser(Long uid);

	// �����û�����ѯ
	public User getUserByUname(String uname);

	// ͳ�������˺�����
	public Integer countUser();

	// ��ҳ�����������˺�
	public List<User> queryAllByPager(Integer start, Integer size);

	// ͳ�Ʒ���˺�����
	public Integer countBlockUser();

	// ��ѯ����û�
	public List<User> queryBlockUser(Integer start, Integer size);

	public void renewUser(Long uid);

}
