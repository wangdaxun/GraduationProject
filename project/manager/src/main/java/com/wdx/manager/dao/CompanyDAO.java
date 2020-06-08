package com.wdx.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wdx.manager.bean.Company;
import com.wdx.manager.dao.impl.CompanyDAOImpl;
import com.wdx.manager.util.CRUDTemplate;
import com.wdx.manager.util.JbdcUtil;

public class CompanyDAO implements CompanyDAOImpl {

	@Override
	public void save(Company company) {
		// TODO Auto-generated method stub
		String theSql = "select max(company_id) as company_id from tb_company";
		Connection conn = null;
		PreparedStatement ps = null;
		Integer id = 0;
		conn = JbdcUtil.getConnection();
		try{
			ps = conn.prepareStatement(theSql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("company_id")+1;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		String sql = "insert into tb_company(COMPANY_ID,COMPANY_NAME,COMPANY_AREA,COMPANY_SIZE,COMPANY_TYPE,"
				+ "COMPANY_STATE,COMPANY_SORT,COMPANY_VIEWNUM) values (?,"
				+ "?,?,?,?,?,?,?)";
		CRUDTemplate.excuteUpdate(sql,id,company.getCompanyName(),company.getCompanyArea(),company.getCompanySize(),company.getCompanyType()
				,company.getCompanyState(),company.getCompanySort(),company.getCompanyViewnum());
		String sql2 = "insert into tb_company_desc(COMPANY_ID,COMPANY_DESC,COMPANY_IMG) values(?,?,?)";
		CRUDTemplate.excuteUpdate(sql2, id, company.getCompanyDesc(), company.getCompanyPic());
	}

	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub
		String sql = "update tb_company set COMPANY_NAME=?,COMPANY_AREA=?,COMPANY_SIZE=?,COMPANY_TYPE=?," +
				"COMPANY_STATE=?,COMPANY_SORT=?,COMPANY_VIEWNUM=? where COMPANY_ID=?";
		CRUDTemplate.excuteUpdate(sql,  company.getCompanyName(),company.getCompanyArea(),company.getCompanySize(),company.getCompanyType()
				,company.getCompanyState(),company.getCompanySort(),company.getCompanyViewnum(),company.getCompanyId());
		String sql2 = "update tb_company_desc set COMPANY_DESC=? where COMPANY_ID=?";
		CRUDTemplate.excuteUpdate(sql2, company.getCompanyDesc(), company.getCompanyId());
	}

	@Override
	public void delete(Company company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company getOne(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		Company company = new Company();
		conn = JbdcUtil.getConnection();
		String sql = "select * from tb_company company left join tb_company_desc des on company.company_id=des.company_id where company.COMPANY_ID=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				company.setCompanyId(rs.getInt("COMPANY_ID"));
				company.setCompanyName(rs.getString("COMPANY_NAME"));
				company.setCompanyArea(rs.getString("COMPANY_AREA"));
				company.setCompanySize(rs.getString("COMPANY_SIZE"));
				company.setCompanyType(rs.getString("COMPANY_TYPE"));
				company.setCompanyDesc(rs.getString("COMPANY_DESC"));
				company.setCompanyState(rs.getInt("COMPANY_STATE"));
				company.setCompanySort(rs.getInt("COMPANY_SORT"));
				company.setCompanyViewnum(rs.getInt("COMPANY_VIEWNUM"));
				company.setCompanyPic(rs.getString("COMPANY_IMG"));
				company.setCompanyEnvir(rs.getString("COMPANY_ENVIR"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public ArrayList<Company> getAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Company> companys = new ArrayList<Company>();
		conn = JbdcUtil.getConnection();
		String sql = "select * from tb_company";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Company company = new Company();
				company.setCompanyId(rs.getInt("COMPANY_ID"));
				company.setCompanyName(rs.getString("COMPANY_NAME"));
				company.setCompanyArea(rs.getString("COMPANY_AREA"));
				company.setCompanySize(rs.getString("COMPANY_SIZE"));
				company.setCompanyType(rs.getString("COMPANY_TYPE"));
				//company.setCompanyDesc(rs.getString("COMPANY_DESC"));
				company.setCompanyState(rs.getInt("COMPANY_STATE"));
				company.setCompanySort(rs.getInt("COMPANY_SORT"));
				company.setCompanyViewnum(rs.getInt("COMPANY_VIEWNUM"));
				//company.setCompanyPic(rs.getString("COMPANY_PIC"));
				companys.add(company);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companys;
	}

	@Override
	public ArrayList<Company> getAllCompanyName() {
		// TODO Auto-generated method stub
		ArrayList<Company> list = new ArrayList<Company>();
		Connection conn = JbdcUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select COMPANY_ID,COMPANY_NAME from tb_company ORDER BY COMPANY_ID DESC";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Company company = new Company();
				company.setCompanyId(rs.getInt("COMPANY_ID"));
				company.setCompanyName(rs.getString("COMPANY_NAME"));
				list.add(company);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
