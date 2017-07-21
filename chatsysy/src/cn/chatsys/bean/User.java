package cn.chatsys.bean;
/**
 * 
 * @author Administrator
 *这是用户表
 */
public class User
{
	private int id;//用户ID（唯一）
	private String loginName;//登录名可变
	private String password;//密码可变
	//第一个构造方法用于在ID不变的情况下，更改用户名和密码
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + "]";
	}
}
