package cn.chatsys.util.tips;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JTextArea;

import cn.chatsys.dao.LoginInfoDao;
import cn.chatsys.dao.impl.LoginInfoDaoImpl;

public class NewChatRequestMgr {

	// 新消息提示窗口集合
	private Map<Integer, FriendChatTipsWin> friendChatWinMap = new HashMap<Integer, FriendChatTipsWin>();
	// 聊天对象集合
	private Set<Integer> chatObjectSet= new HashSet<Integer>();
	
	/**
	 * 集中管理所有65432端口收到的数据报包
	 * @param friendIP
	 * @param uid 
	 */
	public void mgrNewChatContent(String friendIP, String text, int uid)
	{
		// 获取新消息的的ip
		String ip = friendIP;
		
		// 根据IP查询，是哪个好友
		LoginInfoDao lid = new LoginInfoDaoImpl();
		int fid = lid.findLoginInfoByIP(ip).getUser().getId();
		
		// 判断当前好友是否已经在集合中
		if(chatObjectSet.contains(fid))
		{
			// 如果当前好友在集合中   ---- 说明提示窗已经存在
			// 目的：找到对应的提示窗，并修改其中的内容
			for(Entry<Integer, FriendChatTipsWin> friendChatWin : friendChatWinMap.entrySet())
			{
				if(friendChatWin.getKey() == fid)
				{
					// 找到了，修改对应的friendChatWin中的文本内容
					JTextArea textArea = friendChatWin.getValue().getHisChat();
					textArea.setText(textArea.getText() + "\n" + text);
					break;
				}
			}
		}
		else
		{
			// 如果当前好友不在集合中  新建一个提示窗口
			FriendChatTipsWin friendChatTipsWin = new FriendChatTipsWin(uid, fid, this);
			// 并添加至提示管理集合中
			friendChatWinMap.put(fid, friendChatTipsWin);
			JTextArea textArea = friendChatTipsWin.getHisChat();
			textArea.setText(text);
			// 将好友添加至集合中
			chatObjectSet.add(fid);
		}
	}

	public Map<Integer, FriendChatTipsWin> getFriendChatWinMap() {
		return friendChatWinMap;
	}

	public void setFriendChatWinMap(Map<Integer, FriendChatTipsWin> friendChatWinMap) {
		this.friendChatWinMap = friendChatWinMap;
	}

	public Set<Integer> getChatObjectSet() {
		return chatObjectSet;
	}

	public void setChatObjectSet(Set<Integer> chatObjectSet) {
		this.chatObjectSet = chatObjectSet;
	}
	
}
