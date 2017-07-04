package com.duyanhan.dao;

import java.util.List;

import com.duyanhan.bean.Emp;

public interface EmpDao {

	/**
	 * 查询某个部门的所有员工
	 * @param depid
	 * @return
	 */
	public List<Emp> findEmpByDepid(int depid);
	/**
	 * 查询某个职位的所有员工
	 * @param posid
	 * @return
	 */
	public List<Emp> findEmpByPosid(int posid);
	/**
	 * 查询指定编号的员工
	 * @param id
	 * @return
	 */
	public Emp findEmpById(int id);
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	public boolean doEmp(Emp emp);
	/**
	 * 删除员工
	 * @param id
	 * @return
	 */
	public boolean delEmp(int id);
	/**
	 * 更新员工
	 * @param emp
	 * @return
	 */
	public boolean updateEmp(Emp emp);
	
}
