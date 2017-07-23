package cn.chatsys.dao;

import cn.chatsys.bean.ChatPort;

public interface ChatPortDao {

	/**
	 * 获取聊天端口对象
	 * @param uid
	 * @param fid
	 * @return
	 */
	public ChatPort findChatPortByUidAndFid(int uid, int fid);
	
	/**
	 * 插入当前用户与他指定的好友聊天时使用的聊天端口对象
	 * @param cp
	 * @return
	 */
	public boolean doChatPortByChatPort(ChatPort cp);
	
	
	/**
	 * 删除当前聊天端口对象，根据用户id和他正在聊天的用户的对象id
	 * @param uid
	 * @param fid
	 * @return
	 */
	public boolean delChatPortByUidAndFid(int uid, int fid);
}
