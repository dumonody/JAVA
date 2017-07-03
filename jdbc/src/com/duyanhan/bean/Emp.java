package com.duyanhan.bean;

/**
 * 员工信息类
 * @author czkct
 *
 */
public class Emp {

	private int id;	// 员工id
	private String name;	// 员工姓名
	private String sex;	// 员工性别
	private String address;	// 员工籍贯
	private String phone;	// 员工电话
	private String birth;	// 员工生日
	private Pos	pos;	// 员工职位  （在表中用Pos的id表示，在类中用Pos对象表示）
	public Emp() {
		super();
	}
	public Emp(int id, String name, String sex, String address, String phone, String birth, Pos pos) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
		this.pos = pos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Pos getPos() {
		return pos;
	}
	public void setPos(Pos pos) {
		this.pos = pos;
	}
	
	
}
