package com.duyanhan.shop;

/**
 * 顾客类
 * @author czkct
 *
 */
public class Customer {

	private String name;	// 姓名
	private String pswd;	// 密码
	private double fund;	// 资金
	
	
	public Customer(){}
	public Customer(String name, String pswd, double fund) {
		super();
		this.name = name;
		this.pswd = pswd;
		this.fund = fund;
	}
	public double getFund() {
		return fund;
	}
	public void setFund(double fund) {
		this.fund = fund;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	
}
