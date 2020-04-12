package com.wdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.wdx.dao.impl.ResumeDAOImpl;
import com.wdx.domain.ResumeBasicinfo;
import com.wdx.util.CRUDTemplate;
import com.wdx.util.JdbcUtil;

public class ResumeDAO implements ResumeDAOImpl {

	@Override
	public int add(ResumeBasicinfo basicinfo, int applicantID) {
		// TODO Auto-generated method stub
		int basicinfoID = 0;
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into RESUME_BASICINFO(BASICINFO_ID,BIRTHDAT,"
				+ "CURRENT_LOC,EMAIL,GENDER,HEADSHOT,JOBEXPERIENCE,JOBINTENSION,"
				+ "REALNAME,RESIDENTLOC,TELEPHONE,APPLICANT_ID)"
				+ "values(SEQ_ITOFFER_RESUME.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			CRUDTemplate.excuteUpdate(sql, basicinfo.getBirthday(), basicinfo.getCurrentLoc()
					, basicinfo.getEmail(), basicinfo.getGender(), basicinfo.getHeadShot(), basicinfo.getJobExpeience()
					,basicinfo.getJobIntension(),basicinfo.getRealName(), basicinfo.getResidentLoc(), basicinfo.getTelephone(), applicantID);
			// 获取当前生成的简历标识
			String sql2 = "select SEQ_ITOFFER_RESUME.CURRVAL from dual";
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()) {
				basicinfoID = rs.getInt(1);
			}
			// 事务提交
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		return basicinfoID;
	}
	public static void main(String[] args) {
		ResumeDAO resumeDao = new ResumeDAO();
		ResumeBasicinfo resume = resumeDao.selectBasicinfoById(3);
		resume.setJobExpeience("全栈大神");
		resumeDao.update(resume);
	}
	@Override
	public void updateHeadShot(int basicinfoId, String newFileName) {
		// TODO Auto-generated method stub
		String sql = "update RESUME_BASICINFO set HEADSHOT=?  where BASICINFO_ID=?";
		CRUDTemplate.excuteUpdate(sql, newFileName, basicinfoId);
	}
	@Override
	public ResumeBasicinfo selectBasicinfoById(int applicantId) {
		// TODO Auto-generated method stub
		ResumeBasicinfo resume = new ResumeBasicinfo();
		ResultSet rs = null;
		String sql = "select * from resume_basicinfo where applicant_id=?";
		try {
			rs = CRUDTemplate.excuteSelect(sql, applicantId);
			while(rs.next()) {
				resume.setBasicinfoId(rs.getInt("basicinfo_id"));
				resume.setBirthday(rs.getDate("birthdat"));
				resume.setCurrentLoc(rs.getString("current_loc"));
				resume.setEmail(rs.getString("email"));
				resume.setGender(rs.getString("gender"));
				resume.setHeadShot(rs.getString("headshot"));
				resume.setJobExpeience(rs.getString("jobexperience"));
				resume.setJobIntension(rs.getString("jobintension"));
				resume.setRealName(rs.getString("realname"));
				resume.setResidentLoc(rs.getString("residentloc"));
				resume.setTelephone(rs.getString("telephone"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resume;
	}
	@Override
	public int update(ResumeBasicinfo basicinfo) {
		// TODO Auto-generated method stub
		String sql = "update resume_basicinfo "
				+ "set birthdat=?,email=?,gender=?,jobexperience=?,"
				+ "jobintension=?,realname=?,"
				+ "telephone=? where basicinfo_id=?";
		int result = CRUDTemplate.excuteUpdate(sql, 
				basicinfo.getBirthday(), basicinfo.getEmail(),
				basicinfo.getGender(), basicinfo.getJobExpeience(),
				basicinfo.getJobIntension(), basicinfo.getRealName(),
			    basicinfo.getTelephone(), basicinfo.getBasicinfoId()
			);
		return result;
	}
}
