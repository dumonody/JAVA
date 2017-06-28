package com.duyanhan.shop;


/**
 * 电器类
 * @author Administrator
 *
 */
public class Electric {
	private String name = "";
	private int price = 0;
	private int amount = 0;
	private String origin = "";
	
	/**
	 * 默认构造
	 */
	public Electric(){}
	
	/**
	 * 自定义构造
	 * @param name		名称
	 * @param price		价格
	 * @param amount	数量
	 * @param origin	原产地
	 */
	public Electric(String name, int price, int amount, String origin)
	{
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.origin = origin;
	}

	
	//=======================get/set方法
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
}
