package com.wdx.backstage.domain;

import lombok.Data;

@Data
public class Users {
    private Integer user_id;
    private Integer apply_id;
    private String user_logName;
    private  String user_pwd;
    private String user_email;
    private Integer user_role;
    private Integer user_state;
}
