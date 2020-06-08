package com.wdx.backstage.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Resume_Basicinfo;
import com.wdx.backstage.mapper.ResumeMapper;
import com.wdx.backstage.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;
    @Override
    public String getUserResume(Integer userId) {
        Resume_Basicinfo userResume = resumeMapper.getUserResume(userId);
        return JSON.toJSONString(userResume);
    }

    @Override
    public String updateResumeProfile(Integer userId, String profile) {
        resumeMapper.updateResumeProfile(userId, profile);
        return "200";
    }

    @Override
    public String updateResumeJob(Integer userId, String intension, String salary, String currentLoc) {
        resumeMapper.updateResumeJob(userId, intension, salary, currentLoc);
        return "200";
    }

    @Override
    public String updateResumeEdu(Integer userId, String school, String period, String degree, String profession, String profile) {
        Integer basicId = resumeMapper.getResumeBasicId(userId);
        resumeMapper.updateResumeEdu(basicId, school, degree, profession);
        resumeMapper.updateResumePeriod(basicId, period);
        resumeMapper.updateResumeProfile(userId, profile);
        return "200";
    }

    @Override
    public String updateResumeExp(Integer userId,String name, String period, String title, String desc, String company) {
        Integer basicId = resumeMapper.getResumeBasicId(userId);
        resumeMapper.updateResumeExp(basicId, name, period, title, desc, company);
        return "200";
    }
}
