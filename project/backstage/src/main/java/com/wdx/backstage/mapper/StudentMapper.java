package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    public List<Student> queryStudentList();
}
