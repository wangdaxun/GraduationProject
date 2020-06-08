package com.wdx.manager.bean;

public class JobApply {
	private Integer applyId;
	private Job job;
	private Resume resume;
	private Applicant applicant;
	private String name;
	private String companyName;
	private String jobName;
	private String applyDate;
	
	public JobApply() {
		super();
	}

	public JobApply(String name, String companyName, String jobName, String applyDate) {
		this.name = name;
		this.companyName = companyName;
		this.jobName = jobName;
		this.applyDate = applyDate;
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
}
