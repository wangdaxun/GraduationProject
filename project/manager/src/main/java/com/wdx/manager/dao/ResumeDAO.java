package com.wdx.manager.dao;

import com.wdx.manager.bean.Resume;
import com.wdx.manager.dao.impl.ResumeDAOImpl;
import com.wdx.manager.util.JbdcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ResumeDAO implements ResumeDAOImpl {

    @Override
    public void save(Resume resume) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Resume resume) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Resume resume) {
        // TODO Auto-generated method stub

    }

    @Override
    public Resume getOne(Integer id) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement ps = null;
        Resume resume = new Resume();
        conn = JbdcUtil.getConnection();
        try {
            String sql = "select * from tb_resume_basicinfo where BASICINFO_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                resume.setBasicinfoId(rs.getInt("BASICINFO_ID"));
                resume.setBirthday(rs.getDate("BIRTHDAY"));
                resume.setCurrentLoc(rs.getString("CURRENT_LOC"));
                resume.setEmail(rs.getString("EMAIL"));
                resume.setGender(rs.getString("GENDER"));
                resume.setHeadShot(rs.getString("HEAD_SHOT"));
                resume.setJobExpeience(rs.getString("JOB_EXPERIENCE"));
                resume.setJobIntension(rs.getString("JOB_INTENSION"));
                resume.setRealName(rs.getString("REALNAME"));
                resume.setResidentLoc(rs.getString("RESIDENT_LOC"));
                resume.setTelephone(rs.getString("TELEPHONE"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return resume;
    }

    @Override
    public ArrayList<Resume> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Resume> getPageList(Integer pageNo, Integer pageSize) {
        // TODO Auto-generated method stub

        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        conn = JbdcUtil.getConnection();
        // 定义本页记录索引值
        int firstIndex = pageSize * (pageNo-1);

        try {
            String sql = "select * from tb_resume_basicinfo limit ?,?";
            String sql2 = "select * from (select a.*, ROWNUM rn from "
                    + "(select * from TB_RESUME) a where ROWNUM<=?) where rn>?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, firstIndex);
            ps.setInt(2, pageSize);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Resume resume = new Resume();
                resume.setBasicinfoId(rs.getInt("BASICINFO_ID"));
                resume.setBirthday(rs.getDate("BIRTHDAY"));
                resume.setCurrentLoc(rs.getString("CURRENT_LOC"));
                resume.setEmail(rs.getString("EMAIL"));
                resume.setGender(rs.getString("GENDER"));
                resume.setHeadShot(rs.getString("HEAD_SHOT"));
                resume.setJobExpeience(rs.getString("JOB_EXPERIENCE"));
                resume.setJobIntension(rs.getString("JOB_INTENSION"));
                resume.setRealName(rs.getString("REALNAME"));
                resume.setResidentLoc(rs.getString("RESIDENT_LOC"));
                resume.setTelephone(rs.getString("TELEPHONE"));
                resumes.add(resume);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        return resumes;
    }

    @Override
    public Integer getAllNum() {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement ps = null;
        conn = JbdcUtil.getConnection();
        Integer allNum = 0;
        try {
            String sql = "select count(*) as allnum from tb_resume_basicinfo";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                allNum = rs.getInt("allnum");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return allNum;
    }

}

