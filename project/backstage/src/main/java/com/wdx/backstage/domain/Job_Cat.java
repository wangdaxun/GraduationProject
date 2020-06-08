package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Job_Cat {
    private Integer cid;
    private Integer parent_cid;
    private String job_catname;
    private Integer status;
    private Integer is_parent;
    private Date created;
    private Date updated;

}
