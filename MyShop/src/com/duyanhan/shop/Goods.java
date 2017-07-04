package com.duyanhan.shop;

/**
 * 商品类
 * @author czkct
 *
 */
public class Goods {
	private int no;	// 编号
	private String name;	// 名称
	private double price;	// 价格
	private int amount;	// 数量
	private String origin;	// 原产地
	private int type;	// 商品类型
	
	public Goods(){}
	
	public Goods(int no, String name, double price, int amount, String origin, int type) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.origin = origin;
		this.type = type;
	}
	
	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		String rtnStr = this.no + "\t"
				+ this.name + "\t"
				+ this.price + "\t"
				+ this.amount + "\t"
				+ this.origin + "\t";
		return rtnStr;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
