package com.duyanhan.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库的连接以及关闭类
 * @author czkct
 *
 */
public class BaseDao {

	/**
	 * 获取数据库的连接对象
	 * @return
	 */
	public Connection getConnection()
	{
		/**
		 * 所谓的加载驱动就是加载类，加载连接指定数据库服务器的类
		 */
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf-8", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void closeConn(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		/*
		 * 注意关闭资源的顺序
		 */
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		
		if(pstmt != null)
		{
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pstmt = null;
		}
		
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
