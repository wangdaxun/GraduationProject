package com.wdx.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Company;
import com.wdx.backstage.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CompanyDto {
    @Autowired
    private CompanyMapper companyMapper;
    @RequestMapping("queryCompany")
    @ResponseBody
    public String queryCompanyList(){
        List<Company> companies = companyMapper.queryAllCompany();
        String jsonCompanies = JSON.toJSONString(companies);
        return jsonCompanies;
    }
}
