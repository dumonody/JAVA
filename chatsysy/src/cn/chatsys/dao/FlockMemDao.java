package cn.chatsys.dao;

import java.util.List;

import cn.chatsys.bean.FlockMem;

/**
 * 群成员接口
 * @author Pro.Du
 *
 */
public interface FlockMemDao {

	/**
	 * 根据群号查找此群所有的群成员
	 * @return
	 */
	public List<FlockMem> findFlockMemByFlockId(int flockId);
	
	/**
	 * 根据用户对象和群对象添加新的群成员
	 * @param fm
	 * @return
	 */
	public boolean doFlockMemByUserAndFlock(int uid,int flockId);
	
	/**
	 * 根据用户对象id和群对象id删除指定群成员
	 * @param uid
	 * @param flockId
	 * @return
	 */
	public boolean delFlockMemByUserAndFlock(int uid, int flockId);
	
	/**
	 * 根据群id删除此群所有的群成员
	 * @param flockId
	 * @return
	 */
	public boolean delAllMemByFlockId(int flockId);
	
	public List<FlockMem> findFlockMemByUid(int uid);
}
