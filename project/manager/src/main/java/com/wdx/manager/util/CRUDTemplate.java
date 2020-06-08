package com.wdx.manager.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CRUDTemplate {
	// 增，删，改模版的方法
	public static int excuteUpdate(String sql,Object ...params) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		conn = JbdcUtil.getConnection();
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
}
