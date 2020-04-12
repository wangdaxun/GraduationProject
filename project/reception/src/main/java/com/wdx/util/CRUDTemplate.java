package com.wdx.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CRUDTemplate {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	// 增，删，改模版的方法
		public static int excuteUpdate(String sql,Object ...params) {
			int result = 0;
			conn = JdbcUtil.getConnection();
			try {
				ps = conn.prepareStatement(sql);
				for(int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	// 查的模版方法
		public static ResultSet  excuteSelect(String sql, Object ...params) {
			Connection conn = null;
			PreparedStatement ps = null;
			conn = JdbcUtil.getConnection();
			try {
				ps = conn.prepareStatement(sql);
				for(int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
}
