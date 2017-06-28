package com.duyanhan.shop;

import java.util.Scanner;

/**
 * 顾客类
 * 顾客:两种行为
 * 1:登录 
 * 2:注册
 * 两种行为都有成功和失败两种情况
 * @author Administrator
 *
 */
public class Customer {
	
	// 用户池
	private static Customer[] cPool = new Customer[100];
	// 用户数量
	private static int customerNum = 0;
	// 用户登录次数
	private static int loginCnt = 0;
	
	
	/**
	 * 顾客拥有的信息
	 */
	// 用户名
	private String name = "";
	// 用户密码
	private String pswd = ""; 
	// 用户注册资金
	private int fund = 0; 
	
	/**
	 * 用当前的用户账号密码和给出的账号密码进行匹配
	 * @param name
	 * @param pswd
	 * @return
	 */
	public boolean login(String name, String pswd)
	{
		// 遍历一遍用户池
		for(Customer c : cPool)
		{
			if(c.getName().equals(name) && c.getPswd().equals(pswd))
			{
				return true;
			}
		}
		loginCnt++;
		return false;
	}
	
	
	public void register()
	{
		System.out.print("请输入用户名:");
		Customer c = new Customer();
		// 填写用户名并且判断是否占用
		writeName(c);
		// 填写密码并且判断
		writePswd(c);
		// 填写注册资金并判断
		writeFund(c);
		
		// 将注册成功的用户添加到用户池中   并使用户统计数+1
		cPool[customerNum] = c;
		customerNum++;
		
		// 提醒
		System.out.println("注册成功欢迎新用户");
	}
	
	/**
	 * 输入用户名并判重
	 * @return
	 */
	private void writeName(Customer c)
	{
		Scanner sc = new Scanner(System.in);
		boolean isOccupy;
		String cName;
		do
		{
			System.out.print("请输入用户名:");
			cName = sc.next();	// 获取用户名
			// 根据用户数量遍历查看是否占用
			isOccupy = false;
			for(Customer tempC : cPool)
			{
				if(tempC.getName().equals(cName))
				{
					// 如果找到了   说明重复
					isOccupy = true;
					break;
				}
			}
			if(isOccupy)
			{
				System.out.println("该用户名已经被占用, 请重新输入!");
			}
		}while(isOccupy);
		
		// 用户名有效,设置用户名!
		c.setName(cName);
	}

	/**
	 * 输入密码并判断
	 * @param c
	 * @return
	 */
	private void writePswd(Customer c)
	{
		Scanner sc = new Scanner(System.in);
		String pswd1;
		String pswd2;
		System.out.print("请输入密码:");
		do{
			pswd1 = sc.next();
			// 判断密码长度是否小于6位
			if(pswd1.length()<6){
				System.out.print("密码长度小于6位,请重新输入:");
			}
		}while(pswd1.length()<6);
		System.out.print("请输入确认密码:");
		do{
			pswd2 = sc.next();
			// 判断若密码不一致
			if(!pswd2.equals(pswd1))
			{
				System.out.print("确认密码和密码不一致, 请重新输入确认密码:");
			}
		}while(!pswd2.equals(pswd1));
		
		// 密码有效, 设置密码!
		c.setPswd(pswd1);
	}
	
	/**
	 * 输入注册金额并判断
	 * @param c
	 */
	private void writeFund(Customer c)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入注册金额");
		int fund;
		do
		{
			fund = sc.nextInt();
			// 判断金额是否低于1000
			if(fund <= 1000)
			{
				System.out.print("注册金额不能低于1000，请重新输入:");
			}
		}while(fund <= 1000);
		
		// 金额有效,设置资金
		c.setFund(fund);
	}
	

	public int getLoginCnt()
	{
		return this.loginCnt;
	}
	
	
	
	
	
	
	
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
	 * @return the pswd
	 */
	public String getPswd() {
		return pswd;
	}


	/**
	 * @param pswd the pswd to set
	 */
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}


	/**
	 * @return the fund
	 */
	public int getFund() {
		return fund;
	}


	/**
	 * @param fund the fund to set
	 */
	public void setFund(int fund) {
		this.fund = fund;
	}
	
}
