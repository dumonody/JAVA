package com.duyanhan.dbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取数据库链接类
 * @author Pro.Du
 *
 */
public class BaseDao {

	private String driverclass = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/bookdb?characterencoding=UTF-8";
	private String username = "root";
	private String password = "root";
	
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public Connection getConnection()
	{
		Connection conn = null;
		// 注册驱动
		try {
			Class.forName(driverclass);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param conn	数据库连接对象
	 * @param pstmt	预编译执行对象
	 * @param rs	结果集
	 */
	public void closeSource(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		// 关闭结果集
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		// 关闭执行对象
		if(pstmt != null)
		{
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		// 关闭连接对象
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	
	
	/**
	 * 更新操作（对增删改的整合）
	 * @param sql	更新的sql语句
	 * @param args	sql语句中的各参数组成的有序集合
	 * @return	返回true则成功， 反之失败
	 */
	public boolean update(String sql, List<Object> args){
		// 判断更新操作是否成功的变量
		boolean isSuccess = false;
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		try {
			// 获取执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置预编译sql参数
			if(args != null && args.size() > 0)
			{
				int len = args.size();
				for(int i = 0; i < len; i++)
				{
					// 为预编译sql语句中的每个？占位符赋确定值
					pstmt.setObject(i+1, args.get(i));
				}
			}
			// 执行更新操作，并获得返回值
			int line = pstmt.executeUpdate();
			// 判断执行后的返回值（影响行数）
			if(line > 0)
			{
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource(conn, pstmt, null);
		}
		return isSuccess;
	}
	
	
	/**
	 * 查询操作
	 * @param <T>	泛型
	 * @param sql	查询的sql语句
	 * @param args	sql语句中的各参数组成的有序集合
	 * @param clazz	类型类
	 * @return		返回查询结果对象集合
	 */
	public <T> List<T> query(String sql, List<Object> args, Class clazz)
	{
		// 查询内容
		List<T> list = new ArrayList<T>();
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 获取执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置预编译sql参数
			if(args != null && args.size() > 0)
			{
				int len = args.size();
				for(int i = 0; i < len; i++)
				{
					// 为预编译sql语句中的每个？占位符赋确定值
					pstmt.setObject(i+1, args.get(i));
				}
			}
			// 获取结果集
			rs = pstmt.executeQuery();
			// 获取结果集元数据对象
			ResultSetMetaData rsmd = rs.getMetaData();
			// 循环赋值每一个对象
			while(rs.next())
			{
				// cnt表示当前第几个属性
				int cnt = 1;
				// 创建一个新的对象
				Object obj = clazz.newInstance();
				// 获取这个类所有的成员变量
				Field[] fields = clazz.getDeclaredFields();
				// 给obj各个field对象赋值
				for(Field f : fields)
				{
					// 定义一个f成员变量的值
					Object fObj = null;
					// 获取f成员变量的名字
					String fName = f.getName().toLowerCase();
					// 获取表中对应的列名
					String colName = rsmd.getColumnName(cnt).toLowerCase();
					// 如果成员变量名与列名不一致
					if(!fName.equals(colName)){
						// 获取当前f成员的类
						Class fClazz = f.getType();
						// 待查询的表名
						String tableName = fClazz.toString().toLowerCase();
						tableName = tableName.substring(tableName.lastIndexOf(".")+1);
						// 查询当前f成员变量的sql语句
						String fSql = "select * from " + tableName + " where id=?";
						// 获取当前f成员变量的sql语句参数列表
						List<Object> fArgs = new ArrayList<Object>();
						fArgs.add(rs.getObject(cnt));
						// 通过查询获取当前f对象
						fObj = this.query(fSql, fArgs, fClazz).get(0);
					}
					else{
						fObj = rs.getObject(fName);
					}
					// 设置成员可访问
					f.setAccessible(true);
					// 为f成员变量赋值
					f.set(obj, fObj);
					// 准备判断下一个成员
					cnt++;
				}
				// 添加对象到待返回的list集合中
				list.add((T) obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource(conn, pstmt, rs);
		}
		return list;
	}
}
