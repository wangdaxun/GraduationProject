package com.wdx.backstage.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Company;
import com.wdx.backstage.mapper.CompanyMapper;
import com.wdx.backstage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public String getAllCompany() {
        List<Company> companyList = companyMapper.queryAllCompany();
        return JSON.toJSONString(companyList);
    }

    @Override
    public String getOneCompany(Integer companyId) {
        Company company = companyMapper.getOneCompany(companyId);
        return JSON.toJSONString(company);
    }

}
