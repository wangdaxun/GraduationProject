package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Company;
import com.wdx.backstage.domain.Job;
import com.wdx.backstage.domain.Job_Apply;
import com.wdx.backstage.domain.Job_Cat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobMapper {

//    public List<Job> queryAllJob();
//    public Job queryJobById(Integer id);
//
//    public List<Job_Apply> queryAllJobApply();
//    public Job_Apply queryJobApplyById(Integer id);
//
//    public List<Job_Cat> queryAllJobCat();
//    public Job_Cat queryJobCatById();
    @Select("select job.*,des.job_pic,des.job_exper,des.job_edu,des.job_lianxiren,des.job_zhiwei,des.job_zhize" +
            ",cat.job_catname from tb_job job left join tb_job_desc as des on " +
            "job.job_id=des.job_id left join tb_job_cat as cat on " +
            "job.job_cid=cat.cid")
    List<Job> getJobList();

    @Select("select job.*,des.job_pic,des.job_exper,des.job_edu,des.job_lianxiren,des.job_zhiwei,des.job_zhize" +
            ",cat.job_catname from tb_job job left join tb_job_desc as des on " +
            "job.job_id=des.job_id left join tb_job_cat as cat on " +
            "job.job_cid=cat.cid where job.job_id=#{jobId}")
    Job getOneJob(@Param("jobId")Integer id);

    @Select("select company.*,des.company_img,des.company_desc,des.company_shangshi from tb_company company " +
            "left join tb_job job on company.company_id=job.company_id " +
            "left join tb_company_desc des on company.company_id=des.company_id " +
            "where job.job_id=#{jobId}")
    Company getCompanyByJob(@Param("jobId")Integer id);

    @Insert("insert into tb_job_apply(job_id,user_id,apply_date,apply_state) values(#{jobId},#{userId},#{applyDate},#{applyState})")
    void addJobApply(@Param("jobId")Integer jobId, @Param("userId")Integer userId, @Param("applyDate")String applyDate, @Param("applyState")Integer applyState);

    @Select("select apply_id from tb_job_apply where user_id=#{userId} and job_id=#{jobId}")
    Integer getApplyId(@Param("userId")Integer userId, @Param("jobId")Integer jobId);
}
