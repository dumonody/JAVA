package com.duyanhan.bean;

/**
 * 职位信息类
 * @author czkct
 *
 */
public class Pos {

	private int id;	// 职位id
	private String name;	// 职位名称
	private Dep dep;	// 所属部门（在表中用部门id，在类中用部门对象）
	public Pos() {
		super();
	}
	public Pos(int id, String name, Dep dep) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
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
	public Dep getDep() {
		return dep;
	}
	public void setDep(Dep dep) {
		this.dep = dep;
	}
	
}
