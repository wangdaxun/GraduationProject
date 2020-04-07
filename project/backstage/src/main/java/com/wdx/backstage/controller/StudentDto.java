package com.wdx.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.wdx.backstage.domain.Student;
import com.wdx.backstage.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentDto {
    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping("queryStudent")
    @ResponseBody
    public String queryStudentList() {
        Student s = new Student();
        s.setAge(9);
        System.out.println("鞠卫儿的年纪是："+s.getAge());
        List<Student> students = studentMapper.queryStudentList();
        String jsonStudent = JSON.toJSONString(students);
        return jsonStudent;
    }
}
