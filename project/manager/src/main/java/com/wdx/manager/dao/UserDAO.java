package com.wdx.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.wdx.manager.bean.User;
import com.wdx.manager.dao.impl.UserDAOImpl;
import com.wdx.manager.util.CRUDTemplate;
import com.wdx.manager.util.JbdcUtil;

public class UserDAO implements UserDAOImpl {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String theSql = "select max(user_id) as user_id from tb_users";
		Connection conn = null;
		PreparedStatement ps = null;
		Integer id = 0;
		conn = JbdcUtil.getConnection();
		try{
			ps = conn.prepareStatement(theSql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("user_id")+1;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		String sql = "insert into tb_users(USER_ID,USER_LOGNAME,USER_PWD,USER_EMAIL,USER_ROLE,USER_STATE)"
				+ "values (?,?,?,?,?,?)";
		CRUDTemplate.excuteUpdate(sql, id, user.getUser_logname(),user.getUser_pwd(),user.getUser_email()
				,user.getUser_role(),user.getUser_state());
		String sql2 = "insert into tb_resume_basicinfo(user_id,realname) values(?,?)";
		CRUDTemplate.excuteUpdate(sql2, id, user.getUser_realname());
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "update tb_users set "
				+ "USER_LOGNAME=?,USER_PWD=?,USER_EMAIL=?,USER_ROLE=?,USER_STATE=? "
				+ "where USER_ID=?";
		CRUDTemplate.excuteUpdate(sql, user.getUser_logname(), user.getUser_pwd(), user.getUser_email(), user.getUser_role(), user.getUser_state(), user.getUser_id());
		String sql2 = "update tb_resume_basicinfo set realname=? where USER_ID=?";
		CRUDTemplate.excuteUpdate(sql2, user.getUser_realname(), user.getUser_id());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public User getOne(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		User user = new User();
		conn = JbdcUtil.getConnection();
		try {
			String sql = "select tb_users.*,tb_resume_basicinfo.realname from tb_users left join tb_resume_basicinfo on " +
					"tb_users.user_id=tb_resume_basicinfo.user_id where tb_users.user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setUser_id(rs.getInt("USER_ID"));
				user.setUser_logname(rs.getString("USER_LOGNAME"));
				user.setUser_pwd(rs.getString("USER_PWD"));
				user.setUser_realname(rs.getString("REALNAME"));
				user.setUser_email(rs.getString("USER_EMAIL"));
				user.setUser_role(rs.getInt("USER_ROLE"));
				user.setUser_state(rs.getInt("USER_STATE"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User getOne(String name, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		User user = new User();
		conn = JbdcUtil.getConnection();
		try {
			String sql = "select * from tb_users where USER_LOGNAME=? and USER_PWD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_logname(name);
				user.setUser_pwd(password);
				//user.setUser_realname(rs.getString("user_realname"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_role(rs.getInt("user_role"));
				user.setUser_state(rs.getInt("user_state"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getPageList(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<User> users = new ArrayList<User>();
		conn = JbdcUtil.getConnection();
		// 定义本页记录索引值
		int firstIndex = pageSize * (pageNo-1);
		
		try {
			String sql = "select tb_users.*,tb_resume_basicinfo.realname from tb_users left join tb_resume_basicinfo on " +
					"tb_users.user_id=tb_resume_basicinfo.user_id limit ?, ? ";
			String sql2 = "select * from (select a.* , ROWNUM rn from"
					+ "(select * from TB_USERS) a where ROWNUM<=?) where rn>?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, firstIndex);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("USER_ID"));
				user.setUser_logname(rs.getString("USER_LOGNAME"));
				user.setUser_pwd(rs.getString("USER_PWD"));
				user.setUser_realname(rs.getString("REALNAME"));
				user.setUser_email(rs.getString("USER_EMAIL"));
				user.setUser_role(rs.getInt("USER_ROLE"));
				user.setUser_state(rs.getInt("USER_STATE"));
				users.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public Integer getAllNum() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		conn = JbdcUtil.getConnection();
		Integer allNum = 0;
		try {
			String sql = "select count(*) as allnum from tb_users";
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
	
	public static void main(String[] args) {
		int pageNo = 1;
		int pageSize = 2;
		ArrayList<User> users = new ArrayList<User>();
		UserDAO userDao = new UserDAO();
		System.out.println(userDao.getAllNum());
		users = userDao.getPageList(pageNo, pageSize);
		for(User user : users) {
			System.out.println(user);
		}
	}
	
	
}
