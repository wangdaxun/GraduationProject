package com.wdx.manager.bean;

import java.util.Date;

public class Applicant {
	private Integer applicantId;
	private String applicantEmail;
	private Date applicantRegistDate;
	
	public Applicant() {
		super();
	}

	public Applicant(String applicantEmail, Date applicantRegistDate) {
		super();
		this.applicantEmail = applicantEmail;
		this.applicantRegistDate = applicantRegistDate;
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

	public Date getApplicantRegistDate() {
		return applicantRegistDate;
	}

	public void setApplicantRegistDate(Date applicantRegistDate) {
		this.applicantRegistDate = applicantRegistDate;
	}
	
}
