package com.wdx.manager.bean;

public class Company {
	private Integer companyId;	// 企业标识
	private String companyName;	// 企业名称
	private String companyArea;	// 企业所在地区
	private String companySize; // 企业规模
	private String companyType;	// 企业性质
	private String companyDesc;	// 企业简介
	private Integer companyState;	// 招聘状态：1 招聘中 2 已暂停 3 已结束
	private Integer companySort;	// 排序序号
	private Integer companyViewnum;	// 浏览数
	private String companyPic;	// 宣传图片
	private String companyEnvir;	// 公司环境
	
	public Company() {
		super();
	}

	public Company(String companyName, String companyArea, String companySize, String companyType,
			String companyDesc, Integer companyState, Integer companySort, Integer companyViewnum, String companyPic) {
		super();
		this.companyName = companyName;
		this.companyArea = companyArea;
		this.companySize = companySize;
		this.companyType = companyType;
		this.companyDesc = companyDesc;
		this.companyState = companyState;
		this.companySort = companySort;
		this.companyViewnum = companyViewnum;
		this.companyPic = companyPic;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyArea() {
		return companyArea;
	}

	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public Integer getCompanyState() {
		return companyState;
	}

	public void setCompanyState(Integer companyState) {
		this.companyState = companyState;
	}

	public Integer getCompanySort() {
		return companySort;
	}

	public void setCompanySort(Integer companySort) {
		this.companySort = companySort;
	}

	public Integer getCompanyViewnum() {
		return companyViewnum;
	}

	public void setCompanyViewnum(Integer companyViewnum) {
		this.companyViewnum = companyViewnum;
	}

	public String getCompanyPic() {
		return companyPic;
	}

	public void setCompanyPic(String companyPic) {
		this.companyPic = companyPic;
	}

	public String getCompanyEnvir() {
		return companyEnvir;
	}

	public void setCompanyEnvir(String companyEnvir) {
		this.companyEnvir = companyEnvir;
	}
}
