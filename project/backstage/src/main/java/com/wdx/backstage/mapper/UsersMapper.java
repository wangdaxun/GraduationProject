package com.wdx.backstage.mapper;

import com.wdx.backstage.domain.Applicant;
import com.wdx.backstage.domain.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    public List<Users> queryAllUsers();
    public Users queryUsersById(Integer id);

    public List<Applicant> queryAllApplicant();
    public Applicant queryApplicantById(Integer id);
}
