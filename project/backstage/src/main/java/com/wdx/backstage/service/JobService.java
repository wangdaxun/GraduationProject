package com.wdx.backstage.service;

import com.alibaba.fastjson.JSON;

public interface JobService {
    String getJobList();
    String getOneJob(Integer jobId);
    String getCompanyByJob(Integer jobId);
    String addJobApply(Integer userId, Integer jobId);
}
