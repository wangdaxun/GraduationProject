package com.wdx.manager.dao.impl;

import com.wdx.manager.bean.Job;

import java.util.ArrayList;



public interface JobDAOImpl {
	public ArrayList<Job> selectAll();
	public ArrayList<Job> query(int companyId, String jobName);
	public ArrayList<Job> selectJobNameByCompany(int companyId);
	public void save(Job job);
}
