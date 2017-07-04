package com.duyanhan.dao;

import java.util.List;

import com.duyanhan.bean.Pos;

/**
 * 职位信息类
 * @author czkct
 *
 */
public interface PosDao {

	/**
	 * 查询指定部门的所有职位
	 * @param depid
	 * @return
	 */
	public List<Pos> findPosByDepid(int depid);
	/**
	 * 查询指定编号的职位
	 * @param id
	 * @return
	 */
	public Pos findPosById(int id);
	/**
	 * 添加新部门
	 * @param name
	 * @param depid
	 * @return
	 */
	public boolean doPos(String name, int depid);
	/**
	 * 删除职位
	 * @param id
	 * @return
	 */
	public boolean delPos(int id);
	/**
	 * 修改部门信息
	 * @param pos
	 * @return
	 */
	public boolean updatePos(Pos pos);
}
