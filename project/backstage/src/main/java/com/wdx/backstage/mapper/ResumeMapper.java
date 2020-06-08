package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Resume_Basicinfo;
import com.wdx.backstage.domain.Resume_Education;
import com.wdx.backstage.domain.Resume_Project_Experience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ResumeMapper {
    @Select("select * from tb_resume_basicinfo resume left join tb_resume_education edu on " +
            "resume.basicinfo_id=edu.basicinfo_id left join tb_resume_project_experience exp on " +
            "resume.basicinfo_id=exp.basicinfo_id where resume.user_id=#{userId}")
    Resume_Basicinfo getUserResume(@Param("userId") Integer id);

    @Update("update tb_resume_basicinfo set personal_profile=#{profile} where user_id=#{userId}")
    void updateResumeProfile(@Param("userId") Integer id, @Param("profile") String profile);

    @Update("update tb_resume_basicinfo set job_intension=#{intension}, resume_salary=#{salary}, current_loc=#{currentLoc} " +
            "where user_id=#{userId}")
    void updateResumeJob(@Param("userId")Integer id, @Param("intension") String intension, @Param("salary") String salary, @Param("currentLoc") String currentLoc);

    @Update("update tb_resume_project_experience set project_period = #{period} where basicinfo_id=#{basicId}")
    void updateResumePeriod(@Param("basicId")Integer id, @Param("period") String period);


    @Select("select basicinfo_id from tb_resume_basicinfo where user_id=#{userId}")
    Integer getResumeBasicId(@Param("userId")Integer userId);

    @Update("update tb_resume_education set graduate_school=#{school},education_degree=#{degree},profession=#{profession} where basicinfo_id=#{basicId}")
    void updateResumeEdu(@Param("basicId")Integer basicId, @Param("school")String school, @Param("degree")String degree, @Param("profession")String profession);

    @Update("update tb_resume_project_experience set project_name=#{name},project_period=#{period},job_title=#{title},job_desc=#{des},job_company=#{company} where basicinfo_id=#{basicId}")
    void updateResumeExp(@Param("basicId")Integer basicId,@Param("name") String name, @Param("period") String period, @Param("title")String title, @Param("des")String desc, @Param("company")String company);
    public List<Resume_Basicinfo> queryAllRusumeBasic();
    public Resume_Basicinfo queryResumeBasicById(Integer id);

    public List<Resume_Education> queryAllEducation();
    public Resume_Education queryResumeEducationById(Integer id);

    public List<Resume_Project_Experience> queryAllResumeProject();
    public Resume_Project_Experience queryResumeProjectById(Integer id);
}
