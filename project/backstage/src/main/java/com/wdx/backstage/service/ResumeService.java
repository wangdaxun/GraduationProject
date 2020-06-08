package com.wdx.backstage.service;

import com.wdx.backstage.domain.Resume_Basicinfo;

public interface ResumeService {
    String getUserResume(Integer userId);
    String updateResumeProfile(Integer userId, String profile);
    String updateResumeJob(Integer userId, String intension, String salary, String currentLoc);
    String updateResumeEdu(Integer userId, String school,String period, String degree, String profession, String profile);
    String updateResumeExp(Integer userId, String name, String period, String title, String desc, String company);
}
