package cn.chatsys.bean;

/**
 * 分组成员表
 * @author Pro.Du
 *
 */
public class GroupMem {

	private int id;	// 分组成员的流水id
	private Group group; // 分组-》分组id变对象
	private User user;	// 分组成员-》id变对象
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
