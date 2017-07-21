package cn.chatsys.bean;

import java.util.Date;

/**
 * 最近联系人表
 * @author Pro.Du
 *
 */
public class LastChat {

	private int id;	// 最近联系人流水id
	private User user;	// 用户id变对象
	private User fuser;	// 最近联系人id
	private Date time;	// 最近联系时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getFuser() {
		return fuser;
	}
	public void setFuser(User fuser) {
		this.fuser = fuser;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
