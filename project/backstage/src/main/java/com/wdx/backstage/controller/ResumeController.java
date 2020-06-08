package com.wdx.backstage.controller;

import com.wdx.backstage.service.ResumeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @RequestMapping("/getUserResume")
    @ResponseBody
    public String getUserResume(@RequestParam("userId")Integer userId){
       return resumeService.getUserResume(userId);
    }

    @RequestMapping("/updateResumeProfile")
    @ResponseBody
    public String updateResumeProfile(@RequestParam("userId")Integer userId, @RequestParam("profile")String profile){
        return resumeService.updateResumeProfile(userId, profile);
    }

    @RequestMapping("/updateResumeJob")
    @ResponseBody
    public String updateResumeJob(@RequestParam("userId")Integer userId, @RequestParam("intension")String intension, @RequestParam("salary")String salary, @RequestParam("currentLoc")String currentLoc){
        return resumeService.updateResumeJob(userId, intension, salary, currentLoc);
    }

    @RequestMapping("/updateResumeEdu")
    @ResponseBody
    public String updateResumeEdu(@RequestParam("userId")Integer userId, @RequestParam("school") String school, @RequestParam("period") String period, @RequestParam("profession") String profession,
              @RequestParam("degree")String degree, @RequestParam("profile")String profile){
        return resumeService.updateResumeEdu(userId, school, period, degree, profession, profile);
    }

    @RequestMapping("/updateResumeExp")
    @ResponseBody
    public String updateResumeExp(@RequestParam("userId")Integer userId, @Param("company") String company, @Param("period") String period, @Param("name") String name,
                                  @RequestParam("title")String title, @Param("desc") String desc){
        return resumeService.updateResumeExp(userId, name, period, title, desc, company);
    }
}
