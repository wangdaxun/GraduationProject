package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Applicant;
import com.wdx.backstage.domain.Resume_Basicinfo;
import com.wdx.backstage.domain.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    List<Users> queryAllUsers();
    Users queryUsersById(Integer id);

    List<Applicant> queryAllApplicant();
    Applicant queryApplicantById(Integer id);

    @Select("select user_email from tb_users where user_email=#{email}")
    String getUserEmail(@Param("email")String email);

    @Select("select applicant_id from tb_applicant where applicant_email=#{email}")
    Integer getApplyId(@Param("email")String email);

    @Insert("insert into tb_users(apply_id,user_email, user_pwd, user_state) values(#{applyId},#{email}, #{password}, 2)")
    Integer addUser(@Param("applyId")Integer applyId,@Param("email")String email, @Param("password")String password);

    @Select("select max(user_id) as userId from tb_users")
    Integer getUserId();

    @Insert("insert into tb_resume_basicinfo(user_id,email,realname) values(#{userId},#{email},#{name})")
    void addInitResume(@Param("userId") Integer userId, @Param("email") String email, @Param("name") String name);

    @Select("select max(basicinfo_id) as basicId from tb_resume_basicinfo")
    Integer getResumeId();

    @Insert("insert into tb_resume_education(basicinfo_id) values(#{basicinfoId})")
    void addInitResumeEdu(@Param("basicinfoId") Integer basicinfoId);

    @Insert("insert into tb_resume_project_experience(basicinfo_id) values(#{basicinfoId})")
    void addInitResumePro(@Param("basicinfoId") Integer basicinfoId);

    @Insert("insert into tb_applicant(applicant_email,applicant_pwd,applicant_registdate) " +
            "values(#{email},#{pwd},#{time})")
    Integer addApply(@Param("email")String email, @Param("pwd")String password, @Param("time")String time);

    @Select("select user.*,apply.applicant_registdate from tb_users as user left join tb_applicant as apply " +
            "on user.apply_id = apply.applicant_id where user.user_email=#{email} and user.user_pwd=#{password}")
    Users getOneUser(@Param("email")String email, @Param("password")String password);

    @Select("select reu.*,users.user_logname  from tb_resume_basicinfo as reu left join tb_users as users " +
            "on reu.user_id=users.user_id where users.user_id = #{userId}")
    Resume_Basicinfo getUserBasicinfo(@Param("userId")Integer userId);

    @Update("update tb_resume_basicinfo set realname=#{realName}, telephone=#{telephone}," +
            "email=#{email},personal_profile=#{personalPro} where user_id=#{userId}")
    void updateUserBasicinfo(@Param("realName")String realName, @Param("telephone")String telephone
    ,@Param("email")String email,@Param("personalPro")String personalPro, @Param("userId") Integer userId);
    @Update("update tb_users set user_logname=#{logname} where user_id=#{userId}")
    void updateUserName(@Param("logname")String logname, @Param("userId")Integer userId);
}
