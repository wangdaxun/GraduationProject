package com.wdx.manager.dao;

import com.wdx.manager.bean.*;
import com.wdx.manager.dao.impl.JobApplyDAOImpl;
import com.wdx.manager.util.JbdcUtil;

import java.sql.*;
import java.util.ArrayList;


public class JobApplyDao implements JobApplyDAOImpl {

	@Override
	public ArrayList<JobApply> query(String companyId, String jobId, String startDate, String endDate) {
		// TODO Auto-generated method stub
		ArrayList<JobApply> list = new ArrayList<JobApply>();
		Connection conn = JbdcUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("SELECT a.apply_id,a.apply_state,a.apply_date,"
			+ "j.job_id,j.job_name,c.applicant_id,d.basicinfo_id,d.realname "
			+ "FROM tb_jobapply a , tb_job j ,tb_applicant c ,tb_resume_basicinfo d "
			+ "WHERE a.job_id=j.job_id and a.applicant_id=c.applicant_id and c.applicant_id=d.applicant_id ");
		try {
			stmt = conn.createStatement();
			int cid = Integer.parseInt(companyId==null ? "0" :companyId);
			int jid = Integer.parseInt(jobId==null ? "0" :jobId);
			if(cid != 0)
				sql.append(" and j.company_id = " + cid);
			if(jid != 0)
				sql.append(" and a.job_id = "+jid);
			if(!"".equals(startDate))
				sql.append(" and a.apply_date >= to_timestamp('"+startDate+"','yyyy-MM-dd HH24:mi:ss')");
			if(!"".equals(endDate))
				sql.equals(" and a.apply_date <= to_timestamp('"+endDate+"','yyyy-MM-dd HH24:mi:ss')");
			rs = stmt.executeQuery(sql.toString());
			System.out.println(sql.toString());
			while (rs.next()) {
				//姓名、申请职位、申请状态、申请日期
				JobApply ja = new JobApply();
				ja.setApplyId(rs.getInt(1));
				//ja.setApplyState(rs.getInt(2));
				//ja.setApplyDate(rs.getTimestamp(3));
				Job job = new Job();
				job.setJobId(rs.getInt(4));
				job.setJobName(rs.getString(5));
				Applicant applicant = new Applicant();
				applicant.setApplicantId(rs.getInt(6));
				Resume resume = new Resume();
				resume.setBasicinfoId(rs.getInt(7));
				resume.setRealName(rs.getString(8));
				//applicant.setResume(resume);
				ja.setJob(job);
				ja.setApplicant(applicant);
				list.add(ja);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<JobApply> getJobApply() {
		ArrayList<JobApply> list = new ArrayList<JobApply>();
		Connection conn = JbdcUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select apply.apply_date,job.job_name,company.company_name,users.user_logname from tb_job_apply apply left join tb_job job on apply.job_id=job.job_id " +
				"left join tb_company company on job.company_id=company.company_id left join tb_users users on " +
				"apply.user_id=users.user_id";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				JobApply jobApply = new JobApply();
				jobApply.setJobName(rs.getString("job_name"));
				jobApply.setCompanyName(rs.getString("company_name"));
				jobApply.setApplyDate(rs.getString("apply_date"));
				jobApply.setName(rs.getString("user_logname"));
				list.add(jobApply);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
