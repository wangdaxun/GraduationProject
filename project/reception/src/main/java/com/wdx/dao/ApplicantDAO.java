package com.wdx.dao;

import com.wdx.dao.impl.ApplicantDAOImpl;
import com.wdx.util.CRUDTemplate;
import com.wdx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;


public class ApplicantDAO implements ApplicantDAOImpl {

	@Override
	public void save(String email, String password) {
		// TODO Auto-generated method stub
		String sql = "insert into APPLICANT(APPLICANT_ID,APPLICANT_EMAIL,APPLICANT_PWD,APPLICANT_REGISTDATE)"
				+ "values (SEQ_ITOFFER_APPLICANT.nextval,?,?,?)";
		CRUDTemplate.excuteUpdate(sql, email,password,new Timestamp(new Date().getTime()));
	}

	@Override
	public boolean isExistEmail(String email) {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pr = null;
		ResultSet rs = null;
		String sql = "select * from TB_APPLICANT where APPLICANT_EMAIL=?";
		try {
			pr = conn.prepareStatement(sql);
			pr.setString(1, email);
			rs = pr.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int login(String email, String password) {
		// TODO Auto-generated method stub
		int applicantID = 0;
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select APPLICANT_ID from TB_APPLICANT where APPLICANT_EMAIL=? and APPLICANT_PWD=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				applicantID = rs.getInt("applicant_id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return applicantID;
	}

	@Override
	public int isExistResume(Integer applicantID) {
		// TODO Auto-generated method stub
		int resumeID = 0;
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select BASICINFO_ID from TB_RESUME_BASICINFO where APPLICANT_ID=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, applicantID);
			rs = ps.executeQuery();
			if(rs.next()) {
				resumeID = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resumeID;
	}
	
}
