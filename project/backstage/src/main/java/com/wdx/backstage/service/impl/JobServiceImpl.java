package com.wdx.backstage.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Company;
import com.wdx.backstage.domain.Job;
import com.wdx.backstage.mapper.JobMapper;
import com.wdx.backstage.service.JobService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;
    @Override
    public String getJobList() {
        List<Job> jobList = jobMapper.getJobList();
        return JSON.toJSONString(jobList);
    }

    @Override
    public String getOneJob(Integer jobId) {
        Job job = jobMapper.getOneJob(jobId);
        return JSON.toJSONString(job);
    }

    @Override
    public String getCompanyByJob(Integer jobId) {
        Company company = jobMapper.getCompanyByJob(jobId);
        return JSON.toJSONString(company);
    }

    @Override
    public String addJobApply(Integer userId, Integer jobId) {
        Integer applyId = jobMapper.getApplyId(userId, jobId);
        Map result = new HashMap<String, Object>();
        if(applyId == null){
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格
            String hehe = dateFormat.format(now);
            jobMapper.addJobApply(jobId, userId, hehe,1);
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        return JSON.toJSONString(result);
    }


}
