package com.wdx.backstage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Company_Desc {
    private Integer company_id;
    private String company_desc;
    private String company_img;
    private String company_envir;
    private String companu_shangshi;
    private Date created;
    private Date updated;

}
