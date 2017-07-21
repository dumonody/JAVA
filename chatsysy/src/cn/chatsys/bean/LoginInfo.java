package cn.chatsys.bean;

import java.util.Date;
import cn.chatsys.bean.User;
/**
 * 登录信息类
 * @author moy
 *
 */
public class LoginInfo {
	private int id;//流水id
	private String address;//登录地址
	private String ip;//登录ip
	private Date time;//登录时间
	private User user;//登录用户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
