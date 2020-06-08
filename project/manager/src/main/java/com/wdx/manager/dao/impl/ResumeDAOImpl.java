package com.wdx.manager.dao.impl;


import com.wdx.manager.bean.Resume;

import java.util.ArrayList;

public interface ResumeDAOImpl {
	public void save(Resume resume);
	public void update(Resume resume);
	public void delete(Resume resume);
	public Resume getOne(Integer id);
	public ArrayList<Resume> getAll();
	// 获取数据库某一页的数据
	public ArrayList<Resume> getPageList(Integer pageNo, Integer pageSize);
	// 获取数据库一共的条数
	public Integer getAllNum();
}
