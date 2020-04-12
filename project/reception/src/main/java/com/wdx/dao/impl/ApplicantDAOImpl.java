package com.wdx.dao.impl;

public interface ApplicantDAOImpl {
	public boolean isExistEmail(String email);
	public void save(String email, String password);
	public int login(String email, String password);
	public int isExistResume(Integer applicantID);
}
