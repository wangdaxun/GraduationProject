package com.wdx.backstage.domain;

import lombok.Data;

@Data
public class Users {
    private Integer user_id;
    private Integer apply_id;
    private String user_logname;
    private  String user_pwd;
    private String user_email;
    private Integer user_role;
    private Integer user_state;

    // 一对一，一个User有一个applicant
    private String applicant_registdate;

}
