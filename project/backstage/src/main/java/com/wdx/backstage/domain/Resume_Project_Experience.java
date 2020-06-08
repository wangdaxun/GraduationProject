package com.wdx.backstage.domain;

import lombok.Data;

@Data
public class Resume_Project_Experience {
    private Integer project_id;
    private Integer basicinfo_id;
    private String project_name;
    private String project_period;
    private String job_title;
    private String job_desc;
    private String job_company;
}
