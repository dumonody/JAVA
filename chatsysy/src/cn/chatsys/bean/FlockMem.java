package cn.chatsys.bean;
/**
 * 群成员实体类
 * @author moy
 *
 */
public class FlockMem {
	private int id;
	private User user;
	private Flock flock;
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
	public Flock getFlock() {
		return flock;
	}
	public void setFlock(Flock flock) {
		this.flock = flock;
	}
}
