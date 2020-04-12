package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Applicant {
    private Integer applicant_id;
    private String applicant_email;
    private String applicant_pwd;
    private Date applicant_registdate;
}