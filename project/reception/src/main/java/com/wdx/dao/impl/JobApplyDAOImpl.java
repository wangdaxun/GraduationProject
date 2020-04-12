package com.wdx.dao.impl;

import com.wdx.domain.JobApply;

import java.util.ArrayList;


public interface JobApplyDAOImpl {
	public void save(int jobid, int applicantId);
	public ArrayList<JobApply> getJobApplyList(int applicantId);
}
