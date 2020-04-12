package com.wdx.dao;

import com.wdx.dao.impl.JobApplyDAOImpl;
import com.wdx.domain.Company;
import com.wdx.domain.Job;
import com.wdx.domain.JobApply;
import com.wdx.util.CRUDTemplate;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class JobApplyDAO implements JobApplyDAOImpl {

	@Override
	public void save(int jobid, int applicantId) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_jobapply("
				+ "apply_id,job_id,applicant_id,apply_date,apply_state"
				+ ") values(seq_itoffer_jobapply.nextval,?,?,?,?)";
		CRUDTemplate.excuteUpdate(sql, jobid, applicantId, new Timestamp(new Date().getTime()), 1);
	}

	@Override
	public ArrayList<JobApply> getJobApplyList(int applicantId) {
		// TODO Auto-generated method stub
		ArrayList<JobApply> list = new ArrayList<JobApply>();
		ResultSet rs = null;
		String sql = "select a.apply_id,a.apply_state,a.apply_date,j.job_id,"
				+ "j.job_name,c.company_id,c.company_name "
				+ "from job_apply a, job j,company c "
				+ "where a.job_id=j.job_id and j.company_id=c.company_id "
				+ "and a.applicant_id=?";
		rs = CRUDTemplate.excuteSelect(sql,applicantId);
		try {
			while(rs.next()) {
				JobApply ja = new JobApply();
				ja.setApplyId(rs.getInt("apply_id"));
				ja.setApplyState(rs.getInt("apply_state"));
				ja.setApplicantId(applicantId);
				ja.setApplyDate(rs.getTimestamp("apply_date"));
				Job job = new Job();
				job.setJobId(rs.getInt("job_id"));
				job.setJobName(rs.getString("job_name"));
				Company company = new Company();
				company.setCompanyId(rs.getInt("company_id"));
				company.setCompanyName(rs.getString("company_name"));
				job.setCompany(company);
				ja.setJob(job);
				list.add(ja);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		JobApplyDAO jobApplyDao = new JobApplyDAO();
		//jobApplyDao.save(6, 1);
		ArrayList<JobApply> jobApplyList = jobApplyDao.getJobApplyList(1);
		System.out.println(jobApplyList);
	}

}
