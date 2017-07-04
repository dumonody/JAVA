package com.duyanhan.bean;
/**
 * 部门信息类
 * @author czkct
 *
 */
public class Dep {

	private int id;	// 部门id
	private String name;	// 部门名称
	
	public Dep() {
		super();
	}
	public Dep(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
