package cn.chatsys.dao;

import java.util.Date;
import java.util.List;

import cn.chatsys.bean.LastChat;

/**
 * 最近联系人接口
 * @author moy
 *
 */
public interface LastChatDao {
	/**
	 * 添加最近联系人
	 * @param lastChat
	 * @return
	 */
	public boolean doLastChat(int uid,int fid,Date time);
	/**
	 * 查询某人的最近联系人
	 * @param uid
	 * @return
	 */
	public List<LastChat> findLastChatByUid(int uid);
	/**
	 * 删除某条最近联系人信息
	 * @param id
	 * @return
	 */
	public boolean delLastChatById(int id);
	/**
	 * 删除某人的最近联系人列表
	 * @param uid
	 * @return
	 */
	public boolean delAllLastChatByUid(int uid);
	
	/**
	 * 根据uid和fuid查找最近会话
	 * @param uid
	 * @param fuid
	 * @return
	 */
	public LastChat findLastChatByUidAndFuid(int uid, int fuid);
	
}
