package com.wdx.backstage.service;

public interface UserService {
    String sendYanzheng(String email);
    String JsonUserSign(String email,String name, String password, String userYanzheng, String sysYanzheng);
    String JsonUserLogin(String email, String password);
}
