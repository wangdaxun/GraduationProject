package com.wdx.mapper;

import com.wdx.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    public List<Student> queryStudentList();

}
