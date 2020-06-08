package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Resume_Basicinfo {
    private Integer basicinfo_id;
    private Integer user_id;
    private Integer applicant_id;
    private String realName;
    private String resume_sf;
    private String gender;
    private Date birthday;
    private String current_loc;
    private String resident_loc;
    private String telephone;
    private String email;
    private String job_intension;
    private String job_experience;
    private String head_shot;
    private String personal_profile;
    private String resume_salary;

    // 一对一
    private String user_logname;

    // 一对一
    private Integer education_id;
    private String graduate_school;
    private Date time_duration;
    private String education_degree;
    private String profession;

    // 一对一
    private Integer project_id;
    private String project_name;
    private String project_period;
    private String job_title;
    private String job_desc;
    private String job_company;
}
