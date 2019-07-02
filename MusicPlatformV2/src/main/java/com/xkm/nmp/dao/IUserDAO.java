package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.User;

public interface IUserDAO {

	// 查所有
	public List<User> queryAll();

	// 检查账号
	public User checkUser(String uname, String password);

	// 注册
	public void addUser(User user);

	// 删除
	public void delUser(Long uid);

	// 根据用户名查询
	public User getUserByUname(String uname);

	// 统计启用账号数量
	public Integer countUser();

	// 分页查所有启用账号
	public List<User> queryAllByPager(Integer start, Integer size);

	// 统计封禁账号数量
	public Integer countBlockUser();

	// 查询封禁用户
	public List<User> queryBlockUser(Integer start, Integer size);

	public void renewUser(Long uid);

}
