package cn.chatsys.bean;

import java.util.Date;
/**
 * 用户信息表
 * @author moy
 *
 */

public class UserInfo {
	private int id;
	private String nickname="admin";
	private String avatarpath="avatar/2.png";	// 头像路径
	public String getAvatarpath() {
		return avatarpath;
	}
	public void setAvatarpath(String avatarpath) {
		this.avatarpath = avatarpath;
	}
	private String sex="男";
	private int age=0;
	private String star="摩羯座";//星座
	private Date birthday=new Date();
	private String email="空";
	private String address="空";
	private User user;

	public int getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", nickname=" + nickname + ", avatarpath=" + avatarpath + ", sex=" + sex
				+ ", age=" + age + ", star=" + star + ", birthday=" + birthday + ", email=" + email + ", address="
				+ address + "]";
	}
	
}
