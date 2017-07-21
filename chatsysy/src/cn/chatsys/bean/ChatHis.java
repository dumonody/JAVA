package cn.chatsys.bean;
/**
 * 这是聊天记录表
 * @author Pro.Du
 *
 */
public class ChatHis {
	private int id;//聊天记录的ID
	private String file;//聊天记录的内容
	private User user;//用户ID
	private User friend;
	
	public User getFriend() {
		return friend;
	}
	public void setFriend(User friend) {
		this.friend = friend;
	}
	public ChatHis() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
