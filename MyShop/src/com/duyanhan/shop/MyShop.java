package com.duyanhan.shop;

public class MyShop {
	
	// 商城拥有以下商品
	private static Electric[] dianQi;	// 电器
	private static Fruit[] shuiGuo;		// 水果
	

	
	// 初始化方法
	public static void init()
	{
		// 初始化所有电器
		dianQi = new Electric[]{
				new Electric("TCL彩电", 1688, 10, "CHINA"), 
				new Electric("海尔冰箱", 2488, 5, "CHINA"), 
				new Electric("格力空调", 3000, 8, "CHINA")
		};
		
		// 初始化所有水果
		shuiGuo = new Fruit[]{
				new Fruit("红富士苹果", 8, 100, "CHINA"),
				new Fruit("美国红蛇果", 16, 50, "USA"),
				new Fruit("妃子笑荔枝", 20, 20, "CHINA")
		};
	}
	
	
	public static void main(String[] args)
	{
		
		
		
		
	}
	
	
	public static void menu()
	{
		
	}
	
	
	
}
