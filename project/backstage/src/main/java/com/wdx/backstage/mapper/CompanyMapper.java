package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Company;
import com.wdx.backstage.domain.Company_Desc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Select("select company.*,comDesc.*  from tb_company company left join tb_company_desc comDesc " +
            "on company.company_id=comDesc.company_id")
    List<Company> queryAllCompany();
    @Select("select company.*,comDesc.*  from tb_company company left join tb_company_desc comDesc" +
            " on company.company_id=comDesc.company_id where company.company_id = #{companyId}")
    Company getOneCompany(@Param("companyId")Integer companyId);
    public Company queryCompanyById(Integer id);

    public List<Company_Desc> queryAllCompanyDesc();
    public Company_Desc queryCompanyDescById(Integer id);

}
