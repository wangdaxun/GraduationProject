package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Company;
import com.wdx.backstage.domain.Company_Desc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    public List<Company> queryAllCompany();
    public Company queryCompanyById(Integer id);

    public List<Company_Desc> queryAllCompanyDesc();
    public Company_Desc queryCompanyDescById(Integer id);

}
