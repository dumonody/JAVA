package cn.chatsys.bean;

/**
 * 聊天窗口打开后的聊天端口记录信息实体类
 * @author Pro.Du
 *
 */
public class ChatPort {

	private int id;
	private int sendport;	// 当前用户与指定好友聊天的信息发送端口
	private int receiveport;	// 当前用户与指定好友聊天的信息接收端口
	private User user;	// 当前用户id
	private User friend;	// 当前用户正在聊天的指定用户

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSendport() {
		return sendport;
	}
	public void setSendport(int sendport) {
		this.sendport = sendport;
	}
	public int getReceiveport() {
		return receiveport;
	}
	public void setReceiveport(int receiveport) {
		this.receiveport = receiveport;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getFriend() {
		return friend;
	}
	public void setFriend(User friend) {
		this.friend = friend;
	}

	
	
}
