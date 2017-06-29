package com.duyanhan.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 购物车类
 * @author czkct
 *
 */
public class Cart {

	private List<Goods> good = new ArrayList<Goods>();	// 购物车商品
	private Customer customer = new Customer();	// 该购物车的拥有者
	
	public Cart(){}
	public Cart(ArrayList<Goods> goodsList, Customer customer) {
		this.good = goodsList;
		this.customer = customer;
	}
	
	/**
	 * 结账
	 * @return
	 */
	public double checkout()
	{
		double sum = 0;
		if(this.good != null && this.good.size() > 0)
		{
			for(int i = 0; i < this.good.size(); i++)
			{
				sum += this.good.get(i).getAmount() * this.good.get(i).getPrice();
			}
		}
		return sum;
	}
	
	/**
	 * 打印购物车
	 */
	public void showCart()
	{
		System.out.println("编号\t名称\t价格\t数量");
		for(Goods good : this.good)
		{
			System.out.println(good.getNo() + "\t" + good.getName() + "\t" + good.getPrice() + "\t" + good.getAmount());
		}
	}
	
	/**
	 * 购物车添加商品
	 * @param gd	添加的商品类型
	 * @param amount	添加的数量
	 */
	public void add(Goods gd, int amount)
	{
		boolean isHave = false;	// 商品已经存在购物车的标志变量
		
		// 添加商品时   自动归类   同种商品   自动增加计数
		if(this.good != null && this.good.size() > 0)
		{
			for(int i = 0; i < this.good.size(); i++)
			{
				// 找当前要添加的商品类型   可以直接根据编号   毕竟编号唯一
				if(this.good.get(i).getNo() == gd.getNo())
				{
					isHave = true;	// 已经存在此商品
					// 如果找到了   直接修改数量即可
					this.good.get(i).setAmount(this.good.get(i).getAmount() + amount);
					// 跳出循环
					break;
				}
			}
		}
		if(!isHave)	// 如果不存在
		{
			this.good.add(new Goods(gd.getNo(), gd.getName(), gd.getPrice(), amount, gd.getOrigin(), gd.getType()));
		}
	}

	/**
	 * 换购
	 * @param sc
	 * @param money
	 */
	public void changeBuy(Scanner sc, double money)
	{
		if(money >= 3000)
		{
			System.out.print("您的消费已满3000，请问您要参加换购吗?  ");
			String needChangeBuy = sc.next();
			if(needChangeBuy.equals("y"))
			{
				do{
					System.out.println("1.满3000加2块换购500ml可口可乐一瓶");
					System.out.println("2.满3000加10块换购5斤牛肉");
					System.out.println("3.满3000加100块换购电磁炉一台");
					
					switch(sc.nextInt())
					{
					case 1: money += 2; break;
					case 2: money += 10; break;
					case 3: money += 100; break;
					}
					System.out.println("请问您要付款吗?");
				}while(!sc.next().equals("y"));
			}
		}
		System.out.print("本次消费共" + money+ "元");
		if(money > this.customer.getFund())
		{
			System.out.println("，您的余额不足，请充值！");
		}
	}
	
	
	public List<Goods> getGood() {
		return good;
	}

	public void setGood(List<Goods> good) {
		this.good = good;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
