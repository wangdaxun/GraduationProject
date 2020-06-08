package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Company {
    private Integer company_id;
    private String company_name;
    private String company_area;
    private String company_size;
    private String company_type;
    private Integer company_state;
    private Integer company_sort;
    private Integer company_viewnum;

    // 和desc一对一
    //private Company_Desc company_desc;
    private String company_desc;
    private String company_img;
    private String company_envir;
    private String company_shangshi;
    private Date created;
    private Date updated;
}
