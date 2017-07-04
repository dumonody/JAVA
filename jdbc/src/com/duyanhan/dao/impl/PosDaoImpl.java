package com.duyanhan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.duyanhan.bean.Pos;
import com.duyanhan.dao.PosDao;
import com.duyanhan.dbc.BaseDao;

public class PosDaoImpl implements PosDao {

	// 想想看：pos表中有个外键是dep表的主键，即pos对象引用了dep对象
	DepDaoImpl ddi = new DepDaoImpl();
	
	BaseDao bd = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public List<Pos> findPosByDepid(int depid) {
		List<Pos> lp = new ArrayList<Pos>();
		conn = bd.getConnection();
		String sql = "select * from dep where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, depid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Pos pos = new Pos();
				pos.setId(rs.getInt("id"));
				pos.setName(rs.getString("name"));
				pos.setDep(ddi.findDepById(rs.getInt("depid")));
				lp.add(pos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			bd.closeConn(conn, pstmt, rs);
		}
		return lp;
	}

	@Override
	public Pos findPosById(int id) {
		Pos pos = new Pos();
		conn = bd.getConnection();
		String sql = "select * from pos where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				pos.setId(rs.getInt("id"));
				pos.setName(rs.getString("name"));
				pos.setDep(ddi.findDepById(rs.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, rs);
		}
		return pos;
	}

	@Override
	public boolean doPos(String name, int depid) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "intsert into pos (name, depid) values (?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, depid);
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
	public boolean delPos(int id) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "delete from pos where id=?";
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
	public boolean updatePos(Pos pos) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "update pos set name=?, depid=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pos.getName());
			pstmt.setInt(2, pos.getDep().getId());
			pstmt.setInt(3, pos.getId());
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
