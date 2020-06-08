package com.wdx.backstage.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Message;
import com.wdx.backstage.domain.Users;
import com.wdx.backstage.mapper.UsersMapper;
import com.wdx.backstage.service.UserService;
import com.wdx.backstage.util.CommonUtil;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public String sendYanzheng(String email) {
        String yanzheng;
        yanzheng = usersMapper.getUserEmail(email);
        if(yanzheng == null){
            String myEmail = "835321694@qq.com";
            String myName = "nnn";
            yanzheng = CommonUtil.getYanzheng(); // 生成验证码
            HtmlEmail htmlEmail = new HtmlEmail();
            htmlEmail.setHostName("smtp.qq.com");
            htmlEmail.setCharset("utf-8");
            htmlEmail.setAuthentication(myEmail, "ceuqmfmlviwjbbif");
            htmlEmail.setSubject("用户：");
            try {
                htmlEmail.setFrom(myEmail, myName);
                htmlEmail.setMsg("您本次的验证码为："+yanzheng+"\n");
                htmlEmail.addTo(email);
                htmlEmail.send();
            }catch (Exception e){
                System.out.println(e);
            }
            //syctowadhpdhbcdg
            return yanzheng;
        }else{
            return "111111";
        }
    }

    @Override
    public String JsonUserSign(String email, String name, String password, String userYanzheng, String sysYanzheng) {
        Message msgSuccess = new Message();
        msgSuccess.setMessage("注册成功");
        msgSuccess.setStatus(200);
        Message msgFail = new Message();
        if(sysYanzheng != null){
            if(sysYanzheng.equals(userYanzheng)){
                // 判断邮箱是否唯一
                String isEmailIn = usersMapper.getUserEmail(email);
                if(isEmailIn == null){
                    // 全部都符合，可以注册
                    Date now = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格
                    String time = dateFormat.format(now);
                    usersMapper.addApply(email, password, time);
                    Integer applyId = usersMapper.getApplyId(email);
                    usersMapper.addUser(applyId,email,password);
                    Integer userId = usersMapper.getUserId();
                    usersMapper.addInitResume(userId,email,name);
                    Integer basicId = usersMapper.getResumeId();
                    usersMapper.addInitResumeEdu(basicId);
                    usersMapper.addInitResumePro(basicId);
                    return JSON.toJSONString(msgSuccess);
                }else{
                    msgFail.setStatus(500);
                    msgFail.setMessage("该邮箱已经被注册过了");
                    return JSON.toJSONString(msgFail);
                }
            } else{
                msgFail.setStatus(500);
                msgFail.setMessage("输入的验证码与发送的不一致");
                return  JSON.toJSONString(msgFail);
            }
        }else{
            msgFail.setStatus(500);
            msgFail.setMessage("您还没有发送验证码，请向邮箱发送验证码");
            return JSON.toJSONString(msgFail);
        }
    }

    @Override
    public String JsonUserLogin(String email, String password) {
        Users oneUser = usersMapper.getOneUser(email, password);
        HashMap<String, Object> result = new HashMap<>();
        Message message = new Message();
        System.out.println("111"+oneUser);
        if(oneUser == null){
            message.setStatus(500);
            message.setMessage("用户名或密码输入错误");
            result.put("msg", message);
            return JSON.toJSONString(result);
        }else{
            message.setStatus(200);
            message.setMessage("登录成功");
            result.put("msg", message);
            result.put("user", oneUser);
            return JSON.toJSONString(result);
        }
    }
}
