package com.wdx.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Company;
import com.wdx.backstage.mapper.CompanyMapper;
import com.wdx.backstage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RequestMapping("/company")
@Controller
public class CompanyController {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyService companyService;
    @RequestMapping("/getCompanyList")
    @ResponseBody
    public String queryCompanyList(){
        return companyService.getAllCompany();
    }
    @RequestMapping("/getOneCompany")
    @ResponseBody
    public String getOneCompany(@RequestParam("companyId")Integer id){
        return companyService.getOneCompany(id);
    }
}
