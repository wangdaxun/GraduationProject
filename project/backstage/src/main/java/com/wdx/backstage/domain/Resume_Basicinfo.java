package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Resume_Basicinfo {
    private Integer basicinfo_id;
    private Integer applicant_id;
    private String realName;
    private String gender;
    private Date birthday;
    private String current_loc;
    private String resident_loc;
    private String telephone;
    private String email;
    private String job_intension;
    private String job_experience;
    private String head_shot;
}
