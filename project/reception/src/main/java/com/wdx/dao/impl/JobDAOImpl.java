package com.wdx.dao.impl;

import com.wdx.domain.Job;

import java.util.ArrayList;

public interface JobDAOImpl {
	public ArrayList<Job> getJobListByCompanyId(Integer companyId);
	public Job getJobById(int jobid);
}
