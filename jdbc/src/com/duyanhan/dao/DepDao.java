package com.duyanhan.dao;

import java.util.List;

import com.duyanhan.bean.Dep;

/**
 * 此接口中设计的都是和Dep表相关的操作
 * @author czkct
 *
 */
public interface DepDao {

	/**
	 * 查询所有的部门
	 * @return
	 */
	public List<Dep> findAllDep();
	/**
	 * 查询指定编号的部门
	 * @param id
	 * @return
	 */
	public Dep findDepById(int id);
	/**
	 * 添加新部门
	 * @param name
	 * @return
	 */
	public boolean doDep(String name);
	/**
	 * 删除指定编号的部门
	 * @param id
	 * @return
	 */
	public boolean delDep(int id);
	/**
	 * 修改部门信息
	 * @param dep
	 * @return
	 */
	public boolean updateDep(Dep dep);
}
