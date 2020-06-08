package com.wdx.manager.dao.impl;

import com.wdx.manager.bean.Company;

import java.util.ArrayList;



public interface CompanyDAOImpl {
	public void save(Company company);
	public void update(Company company);
	public void delete(Company company);
	public Company getOne(Integer id);
	public ArrayList<Company> getAll();
	public ArrayList<Company> getAllCompanyName();
}
