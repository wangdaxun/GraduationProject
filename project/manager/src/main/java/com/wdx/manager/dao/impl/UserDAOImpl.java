package com.wdx.manager.dao.impl;

import com.wdx.manager.bean.User;

import java.util.ArrayList;


public interface UserDAOImpl {
	public void save(User user);
	public void update(User user);
	public void delete(Integer id);
	public User getOne(String name, String password);
	public ArrayList<User> getAll();
	// 获取数据库某一页的数据
	public ArrayList<User> getPageList(Integer pageNo, Integer pageSize);
	// 获取数据库一共的条数
	public Integer getAllNum();
}
