package com.wdx.controller;

import com.alibaba.fastjson.JSON;
import com.wdx.domain.Student;
import com.wdx.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {
    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping("/query")
    @ResponseBody
    public String queryUserList(){
        List<Student> students = studentMapper.queryStudentList();
        String jsonStudents = JSON.toJSONString(students);
        return jsonStudents;
    }
}
