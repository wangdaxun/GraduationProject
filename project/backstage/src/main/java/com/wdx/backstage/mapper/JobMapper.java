package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Job;
import com.wdx.backstage.domain.Job_Apply;
import com.wdx.backstage.domain.Job_Cat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {
    public List<Job> queryAllJob();
    public Job queryJobById(Integer id);

    public List<Job_Apply> queryAllJobApply();
    public Job_Apply queryJobApplyById(Integer id);

    public List<Job_Cat> queryAllJobCat();
    public Job_Cat queryJobCatById();
}
