package com.wdx.dao.impl;

import java.util.ArrayList;

import com.wdx.domain.Company;

public interface CompanyDAOImpl {
	public ArrayList<Company> getCompanyList();
	public Company getCompanyById(int companyId);
	public ArrayList<Company> getCompanyPageList(int pageNo, int pageSize);
	public int getAllNum();
	public void updateCompanyViewCount(int id);
}
