package cn.chatsys.dao;

import java.util.List;

import cn.chatsys.bean.GroupMem;
import cn.chatsys.bean.User;
/**
 * 这是分组成员的接口层
 * @author Administrator
 *
 */
public interface GroupMemDao {
	/**
	 * 添加分组成员,gid 为分组id
	 * @param gid
	 * @param user
	 * @return
	 */
	public boolean doGroupMem(int gid,int uid);
	/**
	 * 删除分组成员
	 * @param gid
	 * @param user
	 * @return
	 */
	public boolean delGroupMem(int gid,int uid);

	/**
	 * 查出指定分组id的所有成员
	 * @param gid
	 * @return
	 */
	public List<User> findAllGroupMemByGid(int gid);
	/**
	 * 查找分组成员列表通过分组id
	 * @param gid
	 * @return
	 */
	public List<GroupMem> findAllGroupMemListByGid(int gid);
}
