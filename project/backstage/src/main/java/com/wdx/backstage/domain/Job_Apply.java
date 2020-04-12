package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Job_Apply {
    private Integer apply_id;
    private Integer job_id;
    private Integer applicant_id;
    private Date apply_date;
    private Integer apply_state;
}
