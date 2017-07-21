package cn.chatsys.bean;
/**
 * 这是群的实体类
 * @author Administrator
 *
 */
public class Flock {
	/*
	 * 这是群的实体类
	 */
	private int id;//这是群号  （唯一）
	private User user;//这是用户对象，只抽取其ID
	private String name;//这是群的名字（可变）
	
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
