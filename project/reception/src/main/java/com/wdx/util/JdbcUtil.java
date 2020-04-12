package com.wdx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcUtil {
	private static String name = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql:///recruit?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static Connection conn = null;
	static {
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static Connection getConnection() {
		return conn;
	}
	
	public static void Close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Connection conn = JdbcUtil.getConnection();
		if(conn == null) {
			System.out.println("连接失败");
		}else {
			System.out.println("连接成功");
		}
	}
}
