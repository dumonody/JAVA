package cn.chatsys.dao;

import java.util.List;

import cn.chatsys.bean.Flock;

/**
 * 群接口
 * @author Pro.Du
 *
 */
public interface FlockDao {

	/**
	 * 根据用户id查找用户拥有的群
	 * @param uid
	 * @return
	 */
	public List<Flock> findFlocksByUid(int uid);
	/**
	 * 根据当前用户id和新群名称创建群
	 * @param uid
	 * @param flockName
	 * @return
	 */
	public boolean doFlock(int uid, String flockName);
	/**
	 * 根据群id来删除群
	 * @param id
	 * @return
	 */
	public boolean delFlock(int id);
	/**
	 * 根据群名模糊搜索想加入的群
	 * @param flockName
	 * @return
	 */
	public List<Flock> findFlocksByFlockName(String flockName);
	/**
	 * 根据群号来搜索群
	 * @param id
	 * @return
	 */
	public Flock findFlockById(int id);
	
	/**
	 * 根据群id来修改群名
	 * @param id
	 * @return
	 */
	public boolean updateFlockNameByFlockId(int id, String flockName);
}
