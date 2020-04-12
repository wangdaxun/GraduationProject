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
}
