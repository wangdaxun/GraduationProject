package com.wdx.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.wdx.manager.bean.Company;
import com.wdx.manager.bean.Job;
import com.wdx.manager.dao.impl.JobDAOImpl;
import com.wdx.manager.util.CRUDTemplate;
import com.wdx.manager.util.JbdcUtil;

public class JobDAO implements JobDAOImpl {

	@Override
	public ArrayList<Job> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Job> list = new ArrayList<Job>();
		Connection conn = JbdcUtil.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			String sql = "select tb_job.*, COMPANY_NAME "
					+ "from tb_job "
					+ "inner join tb_company on "
					+ "tb_job.COMPANY_ID=tb_company.COMPANY_ID";
			// String sql = "select * from TB_COMPANY";
			ps1 = conn.prepareStatement(sql);
			rs1 = ps1.executeQuery();
			while(rs1.next()) {
				Job job = new Job();
				job.setJobId(rs1.getInt("JOB_ID"));
				job.setJobName(rs1.getString("JOB_NAME"));
				job.setJobSalary(rs1.getString("JOB_SALARY"));
				job.setJobArea(rs1.getString("JOB_AREA"));
				job.setJobDesc(rs1.getString("JOB_DESC"));
				job.setJobEnddate(rs1.getDate("JOB_ENDTIME"));
				job.setJobHiringnum(rs1.getInt("JOB_HIRINGNUM"));
				job.setJobState(rs1.getInt("JOB_STATE"));
				String sql2 = "select count(*) as num from tb_job_apply where job_id=?";
				ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, rs1.getInt("JOB_ID"));
				rs2 = ps2.executeQuery();
				if(rs2.next()) {
					job.setApplyNum(rs2.getInt("num"));
				}else {
					job.setApplyNum(0);
				}
				Company company = new Company();
				company.setCompanyId(rs1.getInt("COMPANY_ID"));
				company.setCompanyName(rs1.getString("COMPANY_NAME"));
				job.setCompany(company);
				list.add(job);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Job> query(int companyId, String jobName) {
		ArrayList<Job> list = new ArrayList<Job>();
		Connection conn = JbdcUtil.getConnection();
		Statement stmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT tb_job.*,company_name FROM tb_job INNER JOIN" 
				+"tb_company on tb_job.company_id =  tb_company.company_id" 
				+"WHERE 1=1 ");
			if(companyId != 0 )
				sql.append("AND tb_job.company_id = " + companyId);
			if(!"".equals(jobName))
				sql.append("AND job_name like '%" + jobName +"%'");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				Job job = new Job();
				// 查询某个职位的申请人数
				String sql2 = "SELECT COUNT(*) FROM tb_jobapply WHERE job_id = ?";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, rs.getInt("job_id"));
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
					job.setApplyNum(rs2.getInt(1));
				else
					job.setApplyNum(0);
				job.setJobId(rs.getInt("job_id"));
				job.setJobName(rs.getString("job_name"));
				job.setJobHiringnum(rs.getInt("job_hiringnum"));
				job.setJobEnddate(rs.getTimestamp("job_endtime"));
				job.setJobState(rs.getInt("job_state"));
				Company company = new Company();
				company.setCompanyId(rs.getInt("company_id"));
				company.setCompanyName(rs.getString("company_name"));
				job.setCompany(company);
				list.add(job);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Job> selectJobNameByCompany(int companyID) {
		// TODO Auto-generated method stub
		ArrayList<Job> list = new ArrayList<Job>();
		Connection conn = JbdcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT job_id,job_name FROM tb_job WHERE company_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,companyID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Job job = new Job();
				job.setJobId(rs.getInt("job_id"));
				job.setJobName(rs.getString("job_name"));
				list.add(job);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void save(Job job) {
		String theSql = "select max(job_id) as job_id from tb_job";
		Connection conn = null;
		PreparedStatement ps = null;
		Integer id = 0;
		Integer comId = 0;
		conn = JbdcUtil.getConnection();
		try{
			ps = conn.prepareStatement(theSql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("job_id")+1;
			}
			String comSql = "select company_id from tb_company where company_name=?";
			ps = conn.prepareStatement(comSql);
			ps.setString(1, job.getCompanyName());
			ResultSet rs2 = ps.executeQuery();
		}catch (Exception e){
			e.printStackTrace();
		}
		String sql = "insert into tb_job(job_id, company_id, job_name, job_hiringnum, job_salary, job_area) " +
				"values(?,?,?,?,?,?)";
		CRUDTemplate.excuteUpdate(sql, id, comId, job.getJobName(), job.getJobHiringnum(), job.getJobSalary(), job.getJobArea());
		String sql2 = "insert into tb_job_desc(job_id,job_pic,job_lianxiren,job_zhiwei,job_zhize) values(?,?,?,?,?)";
		CRUDTemplate.excuteUpdate(sql2, id, job.getJobPic(),job.getJobLianxiren(), job.getJobZhiwei(), job.getJobZhize());

	}
}
