package com.duyanhan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.duyanhan.bean.Dep;
import com.duyanhan.dao.DepDao;
import com.duyanhan.dbc.BaseDao;

public class DepDaoImpl implements DepDao{

	BaseDao bd = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	@Override
	public List<Dep> findAllDep() {
		List<Dep> ld = new ArrayList<Dep>();
		conn = bd.getConnection();
		String sql = "select * from dep";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Dep dep = new Dep();
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("name"));
				ld.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, rs);
		}
		
		return ld;
	}

	@Override
	public Dep findDepById(int id) {
		Dep dep = new Dep();
		conn = bd.getConnection();
		String sql = "select * from dep where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, rs);
		}
		
		return dep;
	}

	@Override
	public boolean doDep(String name) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "insert into dep (name) values (?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int line = pstmt.executeUpdate();
			if(line > 0)
			{
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, null);
		}
		return flag;
	}

	@Override
	public boolean delDep(int id) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "delete from dep where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int line = pstmt.executeUpdate();
			if(line > 0)
			{
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, null);
		}
		return flag;
	}

	@Override
	public boolean updateDep(Dep dep) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "update dep set name=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dep.getName());
			pstmt.setInt(2, dep.getId());
			int line = pstmt.executeUpdate();
			if(line > 0)
			{
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, null);
		}
		return flag;
	}
	

}
