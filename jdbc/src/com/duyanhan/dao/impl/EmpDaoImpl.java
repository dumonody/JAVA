package com.duyanhan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.duyanhan.bean.Dep;
import com.duyanhan.bean.Emp;
import com.duyanhan.bean.Pos;
import com.duyanhan.dao.EmpDao;
import com.duyanhan.dbc.BaseDao;

public class EmpDaoImpl implements EmpDao {

	// 想想看：emp表中有个外键是pos表的主键，即emp对象引用了pos对象
	PosDaoImpl pdi = new PosDaoImpl();
	
	BaseDao bd = new BaseDao();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public List<Emp> findEmpByDepid(int depid) {
		List<Emp> le = new ArrayList<Emp>();
		List<Pos> lp = new ArrayList<Pos>();
		lp = pdi.findPosByDepid(depid);
		for(Pos p : lp)
		{
			List<Emp> tempEmpList = this.findEmpByPosid(p.getId());
			for(Emp e : tempEmpList)
			{
				le.add(e);
			}
		}
		return le;
	}

	@Override
	public List<Emp> findEmpByPosid(int posid) {
		List<Emp> le = new ArrayList<Emp>();
		conn = bd.getConnection();
		String sql = "select * from emp where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAddress(rs.getString("address"));
				emp.setPhone(rs.getString("phone"));
				emp.setBirth(rs.getString("birth"));
				emp.setPos(pdi.findPosById(rs.getInt("posid")));
				le.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, rs);
		}
		
		return le;
	}

	@Override
	public Emp findEmpById(int id) {
		Emp emp = new Emp();
		conn = bd.getConnection();
		String sql = "select * from emp where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAddress(rs.getString("address"));
				emp.setPhone(rs.getString("phone"));
				emp.setBirth(rs.getString("birth"));
				emp.setPos(pdi.findPosById(rs.getInt("posid")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeConn(conn, pstmt, rs);
		}
		return emp;
	}

	@Override
	public boolean doEmp(Emp emp) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "insert into emp (name, sex, address, phone, birth, posid) values(?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getSex());
			pstmt.setString(3, emp.getAddress());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getBirth());
			pstmt.setInt(6, emp.getPos().getId());
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
	public boolean delEmp(int id) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "delete from emp where id=?";
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
	public boolean updateEmp(Emp emp) {
		boolean flag = false;
		conn = bd.getConnection();
		String sql = "update emp set name=?, sex=?, address=?, phone=?, birth=?, posid=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getSex());
			pstmt.setString(3, emp.getAddress());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getBirth());
			pstmt.setInt(6, emp.getPos().getId());
			pstmt.setInt(7, emp.getId());
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
