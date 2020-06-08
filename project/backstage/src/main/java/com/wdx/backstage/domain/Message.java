package com.wdx.backstage.domain;

import lombok.Data;

@Data
// 返回的状态
public class Message {
    private String message;
    private Integer status;
}
