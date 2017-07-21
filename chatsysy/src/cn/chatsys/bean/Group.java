package cn.chatsys.bean;

/**
 * 分组实体类
 * @author moy
 *
 */
public class Group {
	private int id;
	private User user;
	private String groupname;

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
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", user=" + user + ", groupname=" + groupname + "]";
	}
	
}
