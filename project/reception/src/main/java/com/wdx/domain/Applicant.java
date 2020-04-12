package com.wdx.domain;

import java.util.Date;

public class Applicant {
	private Integer applicantId;
	private String applicantEmail;
	private String applicantPwd;
	private Date applicantRegistDate;
	public Applicant() {
		super();
	}
	public Applicant(Integer applicantId, String applicantEmail, String applicantPwd) {
		super();
		this.applicantId = applicantId;
		this.applicantEmail = applicantEmail;
		this.applicantPwd = applicantPwd;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantEmail() {
		return applicantEmail;
	}
	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}
	public String getApplicantPwd() {
		return applicantPwd;
	}
	public void setApplicantPwd(String applicantPwd) {
		this.applicantPwd = applicantPwd;
	}
	public Date getApplicantRegistDate() {
		return applicantRegistDate;
	}
	public void setApplicantRegistDate(Date applicantRegistDate) {
		this.applicantRegistDate = applicantRegistDate;
	}
	
}
