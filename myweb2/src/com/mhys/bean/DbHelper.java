package com.mhys.bean;

import java.sql.*;

public class DbHelper {
	// 封装了连接数据的方法和操作数据库的代码
	// 根据这个类的代码,再通过Dao类来实现操作数据库

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/moot?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// 获得数据库连接
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 根据传进来的sql和数据查询
	public ResultSet executeQuery(String sql, Object... params) {
		this.conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询的结果集
		return rs;
	}

	// 根据传进来的sql和数据增删改
	public int executeUpdate(String sql, Object... params) {
		this.conn = getConnection();
		int updateNum = 0;
		try {
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			updateNum = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		//返回操作成功的数据的条数
		return updateNum;
	}

	// 关闭连接
	public void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试
	public static void main(String[] args) throws Exception {
		DbHelper dbHelper = new DbHelper();
		Connection connection = dbHelper.getConnection();
		System.out.println(connection);

	}
}

