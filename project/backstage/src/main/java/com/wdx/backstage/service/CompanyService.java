package com.wdx.backstage.service;

import com.wdx.backstage.domain.Company;

import java.util.List;

public interface CompanyService {
    String getAllCompany();
    String getOneCompany(Integer companyId);
}
