package com.wdx.manager.dao.impl;

import com.wdx.manager.bean.JobApply;

import java.util.ArrayList;



public interface JobApplyDAOImpl {
	public ArrayList<JobApply> query(String companyId, String jobId,
									 String startDate, String endDate);

	public ArrayList<JobApply> getJobApply();
}
