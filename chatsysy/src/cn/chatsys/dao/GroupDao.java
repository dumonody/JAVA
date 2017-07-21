package cn.chatsys.dao;

import java.util.List;

import cn.chatsys.bean.Group;
/**
 * 分组接口
 * @author moy
 *
 */

public interface GroupDao {
	/**
	 * 用户创建新的分组
	 * @param uid
	 * @param groupName
	 * @return
	 */
	public boolean doGroup(int uid,String groupName);
	/**
	 *通过组id查找组
	 * @param gid
	 * @return
	 */
	public Group findGroupById(int id);
	/**
	 * 查找指定用户的分组
	 * @param uid
	 * @return
	 */
	public List<Group> findGroupByUid(int uid);
	/**
	 * 修改组信息
	 * @param group
	 * @return
	 */
	public boolean updateGroup(Group group);
	/**
	 * 删除分组 
	 * @param id
	 * @return
	 */
	public boolean delGroup(int id );
	
}
