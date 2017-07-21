package cn.chatsys.dao;

import java.util.List;

import cn.chatsys.bean.FriendList;

public interface FriendListDao {
	/**
	 * 添加好友，及其备注
	 * @param uid
	 * @param fid
	 * @param remarks
	 * @return
	 */
	public boolean doFriendList(int uid,int fid,String remarks);
	/**
	 * 根据好友列表ID删除好友
	 * @param id
	 * @return
	 */
	public boolean delFriendListById(int uid,int fid);
	/**
	 * 修改好友的备注remarks
	 * @param uid
	 * @param remarks
	 * @return
	 */  
	public boolean updateFriendList(int uid,int fid,String remarks);
	/**
	 * 查找所有好友
	 * @param uid
	 * @return
	 */
	public List<FriendList> findAllFriendList(int uid); 
}

