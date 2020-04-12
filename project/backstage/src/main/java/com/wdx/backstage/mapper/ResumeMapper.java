package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Resume_Basicinfo;
import com.wdx.backstage.domain.Resume_Education;
import com.wdx.backstage.domain.Resume_Project_Experience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper {
    public List<Resume_Basicinfo> queryAllRusumeBasic();
    public Resume_Basicinfo queryResumeBasicById(Integer id);

    public List<Resume_Education> queryAllEducation();
    public Resume_Education queryResumeEducationById(Integer id);

    public List<Resume_Project_Experience> queryAllResumeProject();
    public Resume_Project_Experience queryResumeProjectById(Integer id);
}
