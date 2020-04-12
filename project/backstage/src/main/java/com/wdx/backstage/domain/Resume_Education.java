package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Resume_Education {
    private Integer education_id;
    private Integer basicinfo_id;
    private String graduate_school;
    private Date time_duration;
    private String education_degree;
    private String profession;
}
