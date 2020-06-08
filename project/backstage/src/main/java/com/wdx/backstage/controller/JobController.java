package com.wdx.backstage.controller;

import com.wdx.backstage.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping("/getJobList")
    @ResponseBody
    public String getJobList(){
        return jobService.getJobList();
    }

    @RequestMapping("/getOneJob")
    @ResponseBody
    public String getOneJob(@RequestParam("jobId")Integer jobId){
        return jobService.getOneJob(jobId);
    }

    @RequestMapping("/getCompanyByJob")
    @ResponseBody
    public String getCompanyByJob(@RequestParam("jobId")Integer jobId){
        return jobService.getCompanyByJob(jobId);
    }

    @RequestMapping("/addJobApply")
    @ResponseBody
    public String addJobApply(@RequestParam("userId")Integer userId, @RequestParam("jobId")Integer jobId){
        return jobService.addJobApply(userId, jobId);
    }
}
