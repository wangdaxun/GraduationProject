package com.wdx.backstage.domain;

import lombok.Data;

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
}
