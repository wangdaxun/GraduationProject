package com.example.demo.controller;

import com.example.demo.redis.RedisDelayedQueue;
import com.example.demo.redis.RedisDelayedQueueListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    RedisDelayedQueue redisDelayedQueue;


    @RequestMapping("test")
    public String test(){
        Date now = new Date();
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        redisDelayedQueue.addQueue(smf.format(now),1, TimeUnit.MINUTES, "queue");
        return "success";
    }
}
