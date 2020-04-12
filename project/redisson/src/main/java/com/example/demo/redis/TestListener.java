package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements RedisDelayedQueueListener<String>{
    @Override
    public void invoke(String s) {
        System.out.println("消费了："+s);
    }
}
