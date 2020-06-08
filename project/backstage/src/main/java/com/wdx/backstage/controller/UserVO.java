package com.wdx.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Message;
import com.wdx.backstage.mapper.UsersMapper;
import com.wdx.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@Controller
@RequestMapping("/user")
public class UserVO {
    @Autowired
    private UserService userService;
    @Autowired
    private UsersMapper usersMapper;

    String yanzheng;
    @ResponseBody
    @RequestMapping(value = "sendYanzheng", method = RequestMethod.POST)
    public String sendEmail(@RequestParam("email")String email){
        Message message = new Message();
        String theYan = userService.sendYanzheng(email);
        if("111111".equals(theYan)){
            message.setMessage("该邮箱已经被注册过了，请重新尝试");
            message.setStatus(500);
            return JSON.toJSONString(message);
        }else{
            yanzheng = theYan;
            message.setMessage("可以发送");
            message.setStatus(200);
            return JSON.toJSONString(message);
        }
    }
    @ResponseBody
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public String userSign(@RequestParam("email")String email,@RequestParam("name")String name, @RequestParam("password")String password,
                           @RequestParam("yanz")String yanz){
        return userService.JsonUserSign(email, name, password, yanz, yanzheng);
    }
    @ResponseBody
    @RequestMapping("/login")
    public String userLogin(@RequestParam("email")String email, @RequestParam("password")String password){
        System.out.println(email);
        return userService.JsonUserLogin(email, password);
    }
    @ResponseBody
    @RequestMapping("/getUser")
    public String getUser(@RequestParam("userId")String userId){
        return JSON.toJSONString(usersMapper.getUserBasicinfo(Integer.parseInt(userId)));
    }

    @ResponseBody
    @RequestMapping("/saveUser")
    public String saveUser(@RequestParam("logName")String logName, @RequestParam("email")String email,
                           @RequestParam("realName")String realName, @RequestParam("telephone")String telephone,
                           @RequestParam("personalPro")String personalPro, @RequestParam("userId")Integer userId){
        usersMapper.updateUserBasicinfo(realName, telephone, email, personalPro, userId);
        usersMapper.updateUserName(logName, userId);
        return JSON.toJSONString("success: 200");
    }

}
