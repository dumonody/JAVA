package cn.chatsys.bean;
/**
 * 这是好友列表
 * @author Administrator
 *
 */
public class FriendList
{
	private int id;//列表ID
	private User friend;//用户好友
	private User user;//用户
	private String remarks;//好友备注
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getFriend() {
		return friend;
	}
	public void setFriend(User friend) {
		this.friend = friend;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
