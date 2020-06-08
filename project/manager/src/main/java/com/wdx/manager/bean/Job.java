package com.wdx.manager.bean;

import java.util.Date;

public class Job {
	private Integer jobId;
	private Integer companyId;
	private String companyName;
	private Company company;
	private String jobName;
	private Integer jobHiringnum;
	private String jobSalary;
	private String jobArea;
	private String jobDesc;
	private Date jobEnddate;
	private String jobPic;
	private int jobState;
	private int applyNum;

	private String jobLianxiren;
	private String jobZhiwei;
	private String jobZhize;

	public Job() {
		super();
	}



	public Job(Company company, String jobName, Integer jobHiringnum, String jobSalary, String jobArea, String jobDesc,
			Date jobEnddate, String jobPic, int jobState, int applyNum) {
		super();
		this.company = company;
		this.jobName = jobName;
		this.jobHiringnum = jobHiringnum;
		this.jobSalary = jobSalary;
		this.jobArea = jobArea;
		this.jobDesc = jobDesc;
		this.jobEnddate = jobEnddate;
		this.jobPic = jobPic;
		this.jobState = jobState;
		this.applyNum = applyNum;
	}



	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getJobHiringnum() {
		return jobHiringnum;
	}

	public void setJobHiringnum(Integer jobHiringnum) {
		this.jobHiringnum = jobHiringnum;
	}

	public String getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}

	public String getJobArea() {
		return jobArea;
	}

	public void setJobArea(String jobArea) {
		this.jobArea = jobArea;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public Date getJobEnddate() {
		return jobEnddate;
	}

	public void setJobEnddate(Date jobEnddate) {
		this.jobEnddate = jobEnddate;
	}

	public int getJobState() {
		return jobState;
	}

	public void setJobState(int jobState) {
		this.jobState = jobState;
	}

	public int getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getJobLianxiren() {
		return jobLianxiren;
	}

	public void setJobLianxiren(String jobLianxiren) {
		this.jobLianxiren = jobLianxiren;
	}

	public String getJobZhiwei() {
		return jobZhiwei;
	}

	public void setJobZhiwei(String jobZhiwei) {
		this.jobZhiwei = jobZhiwei;
	}

	public String getJobZhize() {
		return jobZhize;
	}

	public void setJobZhize(String jobZhize) {
		this.jobZhize = jobZhize;
	}

	public String getJobPic() {
		return jobPic;
	}

	public void setJobPic(String jobPic) {
		this.jobPic = jobPic;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
