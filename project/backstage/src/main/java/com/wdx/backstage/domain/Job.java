package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Job {
    private Integer job_id;
    private Integer company_id;
    private Integer job_cid;
    private String job_name;
    private Integer job_hiringnum;
    private String job_salary;
    private String job_area;
    private String job_desc;
    private Date job_endtime;
    private Integer job_state;
    // 和公司名一对一
    private String company_name;
    // 和工作的类型一对一
    private String job_catname;
    // 和工作描述一对一
    private String job_exper;
    private String job_pic;
    private String job_edu;
    private String job_lianxiren;
    private String job_zhiwei;
    private String job_zhize;
}
