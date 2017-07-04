package com.duyanhan.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 商城购物测试主类
 * @author czkct
 *
 */
public class ShoppingSystem {

	private static List<Goods> goodsStoke;	// 商品库存
	private static List<Customer> customersList;	// 已有用户
	
	/**
	 * 初始化商品库存
	 */
	static {
		goodsStoke = new ArrayList<Goods>();
		goodsStoke.add(new Goods( 1, "TCL彩电 ", 1688, 10, "CHINA", 1));
		goodsStoke.add(new Goods( 2, "海尔冰箱", 2488, 5, "CHINA", 1));
		goodsStoke.add(new Goods( 3, "格力空调", 3000, 8, "CHINA", 1));
		
		goodsStoke.add(new Goods( 4, "红富士苹果", 8, 100, "CHINA", 3));
		goodsStoke.add(new Goods( 5, "美国红蛇果", 16, 50, "USA", 3));
		goodsStoke.add(new Goods( 6, "妃子笑荔枝", 20, 20, "CHINA", 3));
		
		customersList = new ArrayList<Customer>();
		customersList.add(new Customer("都颜汗", "123456", 4500));
		customersList.add(new Customer("duyanhan", "123456", 4500));
	}
	
	/**
	 * 主方法
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 声明定义扫描对象
		Scanner sc = new Scanner(System.in);
		// 声明定义测试主类
		ShoppingSystem shoppingTest = new ShoppingSystem();
		// 声明一个顾客
		Customer customer = null;
		// 声明一个购物车
		Cart cart = new Cart(new ArrayList<Goods>(), customer);
		
		System.out.println("=======================贵美商城======================");
		System.out.println("欢迎光临贵美商城!");
		System.out.println("------------------------");
		
		
		
		System.out.println("商品类型：");
		System.out.println("\t\t\t1、电器");
		System.out.println("\t\t\t2、服饰");
		System.out.println("\t\t\t3、水果");
		
		// 下面根据选项显示对应信息
		shoppingTest.showGoodsStoke(sc);
		// 用户选择物品购买操作
		customer = shoppingTest.chooseOpt(sc, customer, cart).getCustomer();
		if(customer == null){
			System.out.println("对不起，三次登录都失败，系统强制退出！");
			return ;
		}
	
		
	}
	
	/**
	 * 跳转到登录注册界面方法
	 * @param sc	扫描器对象
	 * @param customer	当前游客对象
	 * @return	已登录用户对象
	 */
	public Customer goLoginReg(Scanner sc, Customer customer)
	{
		System.out.println("-----------------------------------------------------------");
		System.out.println("                1.登录(三次登录机会，均失败则结束!)");
		System.out.println("                2.注册");
		
		System.out.print("请选择：");
		int select = sc.nextInt();
		if(select == 1)
		{
			int loginFailedTime = 0;
			do
			{
				// 执行登录
				customer = login(sc, customer);
				if(customer == null)
				{
					loginFailedTime ++;
				}
			}while(customer == null && loginFailedTime != 3);
			if(loginFailedTime == 3) return null;	// 如果三次登录都失败
			if(customer != null)
			{
				System.out.println("登录成功， 欢迎用户 " + customer.getName());
			}
			
		}
		else if(select == 2)
		{
			// 执行注册
			customer = register(sc, customer);
			// 添加到用户列表
			customersList.add(customer);
			System.out.println("注册成功， 欢迎新用户 " + customer.getName());
		}
		
		return customer;
	}
	
	/**
	 * 用户登录
	 * @param sc	扫描器对象
	 * @param customer	当前用户对象
	 * @return	当前用户对象
	 */
	private Customer login(Scanner sc, Customer customer) {
		String loginName;	// 登录名
		String loginPswd;	// 登录密码
		
		
		System.out.print("请输入用户名：");
		loginName = sc.next();
		System.err.print("请输入密     码：");
		loginPswd = sc.next();
		
		if(customersList!= null && customersList.size() > 0)
			// 遍历查找是否存在
			for(Customer c : customersList)
			{
				if(c.getName().equals(loginName) && c.getPswd().equals(loginPswd))
					return c;
			}
		System.out.println("用户名或密码错误，请重新登录！！");
		return null;
	}


	/**
	 * 新用户注册方法
	 * @param sc	扫描器对象
	 * @param customer	新用户引用
	 * @return	新用户引用
	 */
	public Customer register(Scanner sc, Customer customer)
	{
		String regName;	// 新注册用户名
		String regPswd;	// 新注册密码
		String confirmPswd;	// 确认密码
		double regFund;	// 新注册资金
		
		boolean nameIsExist;	// 用户名判重标志
		do
		{
			nameIsExist = false;	// 初始化用户名判重标志
			System.out.print("请输入用户名：");
			// 获取用户名
			regName = sc.next();
			// 用户名判重
			if(customersList != null && customersList.size() > 0)
			{
				for(Customer c : customersList)
				{
					if(c.getName().equals(regName))
					{
						System.out.println("该用户名已被占用，请重新输入!");
						nameIsExist = true;
						break;
					}
				}
			}
		}while(nameIsExist);
		
		
		do
		{
			boolean shorterThanSix;	// 密码长度小于6的标志
			System.out.print("请输入密   码：");
			do
			{
				shorterThanSix = false;	// 初始化密码长度小于6的标志
				regPswd = sc.next();
				if(regPswd.length() < 6) 
				{
					shorterThanSix = true;
					System.out.print("密码长度少于六位,请重新输入:");
				}
			}while(shorterThanSix);
			
			
			System.out.print("请输入确认密码：");
			boolean samePswd;	// 密码相同标志
			int failedTime = 0;	// 确认密码时错误次数统计
			do
			{
				samePswd = false;	// 初始化密码相同标志
				confirmPswd = sc.next();
				if(regPswd.equals(confirmPswd))
				{
					samePswd = true;
					break;
				}
				else
				{
					failedTime ++;
					if(failedTime <= 2) System.out.print("确认密码和密码不一致，请重新输入:");
				}
				if(failedTime > 2) break;
			}while(!samePswd);
			
		}while(!regPswd.equals(confirmPswd));	// 只要两次密码不相同，就永远执行下去
		
		System.out.print("请输入注册金额：");
		boolean isNotCorrectFund;	// 金额是否正确标志
		do
		{
			isNotCorrectFund = false;	// 初始化金额标志
			regFund = sc.nextInt();
			if(regFund >= 1000)
			{
				isNotCorrectFund = true;
				break;
			}
			System.out.print("注册金额不能低于1000，请重新输入:");
		}while(!isNotCorrectFund);
		
		
		return new Customer(regName, regPswd, regFund);
		
	}
	
	/**
	 * 用户选择物品购买操作
	 * @param sc
	 * @param customer
	 */
	public Cart chooseOpt(Scanner sc, Customer customer, Cart cart)
	{
		System.out.print("请选择购买的商品编号：");
		// 先获取客户要购买的商品编号
		int goodsNo = sc.nextInt();
		// 先判断客户是否已经登录了
		if(customer == null)
		{
			// 登录提示
			System.out.println("你还没有登录， 请登录先！");
			// 返回登录注册界面
			customer = goLoginReg(sc, customer);
			if(customer == null) {
				cart.setCustomer(null);
				return cart;
			}
			// 如果没有返回，说明用户已经存在	更新当前的购物车
			cart.setCustomer(customer);
			// 再次显示指定类型商品库存信息
			showGoodsStoke(goodsNo);
			System.out.print("请选择购买的商品编号：");
			// 再次获取客户要购买的商品编号
			goodsNo = sc.nextInt();
		}
	
		String continueBuy = "";	// 是否继续购物标志变量
		
		do
		{
			// 否则直接进入物品购买界面
			cart = buyGoods(goodsNo, sc, customer, cart);	// 更新购物车
			System.out.print("请问您还要继续购物吗？");
			continueBuy = sc.next();
			if(continueBuy.equals("y"))
			{
				System.out.println("商品类型：");
				System.out.println("\t\t\t1、电器");
				System.out.println("\t\t\t2、服饰");
				System.out.println("\t\t\t3、水果");
				
				// 下面根据选项显示对应信息
				showGoodsStoke(sc);
				// 用户选择物品购买操作
				System.out.print("请选择购买的商品编号：");
				// 先获取客户要购买的商品编号
				goodsNo = sc.nextInt();
			}
			else if(continueBuy.equals("n"))
			{
				// 不购物了就显示购物清单
				cart.showCart();
				// 结账
				double sum = cart.checkout();
				System.out.println("您当前的消费一共是："+sum+"元");
				cart.changeBuy(sc, sum);
				break;	// 退出当前循环
			}
		}while(continueBuy.equals("y"));
		return cart;
	}
	
	/**
	 * 购买物品
	 * @param goodsNo 第一个想买的商品编号
	 * @param sc	扫描器对象
	 * @param customer	顾客对象
	 * @param cart 
	 * @return	返回购物车对象
	 */
	private Cart buyGoods(int goodsNo, Scanner sc, Customer customer, Cart cart) {
		
		String ifBuySameType = "";	// 是否还买同类型商品的标志变量
		
		do{
			// 商品编号对应的类型
			int type = 0;
			
			if(goodsStoke != null && goodsStoke.size() > 0)
			{
				for(int i = 0; i < goodsStoke.size(); i++)
				{
					// 找到了
					if(goodsStoke.get(i).getNo() == goodsNo)
					{
						System.out.print("请输入购买的数量：");
						boolean isNotEnough;
						int buyAmount;
						do
						{
							isNotEnough = false;
							buyAmount = sc.nextInt();
							// 判断库存是否足够
							if(goodsStoke.get(i).getAmount() < buyAmount)	// 如果库存不足
							{
								isNotEnough = true;
								System.out.print("存货不足，请重新输入:");
							}
							else // 如果库存足够
							{
								// 先更新库存数量
								goodsStoke.get(i).setAmount(goodsStoke.get(i).getAmount() - buyAmount);
								// 添加商品到购物车
								cart.add(goodsStoke.get(i), buyAmount);
								// 确定商品类型
								type = goodsStoke.get(i).getType();
							}
						}while(isNotEnough);
						
						break;	// 跳出查找商品的循环
					}
				}
			}
			// 判断编号对应的商品的类型
			
			System.out.print("请问要继续购买");
			if(type == 1)
			{
				System.out.print("电器");
			}
			else if(type == 3)
			{
				System.out.print("水果");
			}
			System.out.print("吗？");
			
			ifBuySameType = sc.next();
			if(ifBuySameType.equals("y"))
			{
				showGoodsStoke(type);
				System.out.print("请选择购买的商品编号：");
				// 再次获取客户要购买的商品编号
				goodsNo = sc.nextInt();
			}
			else if(ifBuySameType.equals("n"))
			{
				break;	// 退出循环
			}
			
		}while(ifBuySameType.equals("y"));	// 继续购买同类型的商品
		
		
		
		return cart;
	}

	/**
	 * 显示商品库存
	 * @param sc  扫描对象
	 */
	public void showGoodsStoke(Scanner sc)
	{
		System.out.print("请选择：");
		int type = sc.nextInt();
		System.out.println("编号\t名称\t价格\t数量\t原产地");
		for(Goods good : goodsStoke)
		{
			// 商品库存量大于0才有显示的意义
			if(good.getAmount() > 0 && good.getType() == type)
			{
				System.out.println(good.toString());
			}
		}
	}
	
	/**
	 * 重载 显示商品库存方法
	 * @param type	显示商品类型
	 */
	public void showGoodsStoke(int type)
	{
		System.out.println("编号\t名称\t价格\t数量\t原产地");
		for(Goods good : goodsStoke)
		{
			// 商品库存量大于0才有显示的意义
			if(good.getAmount() > 0 && good.getType() == type)
			{
				System.out.println(good.toString());
			}
		}
	}
	
}
