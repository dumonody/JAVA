
public class DrawThread extends Thread {
	
	// 模拟用户账户
	private Account account;
	// 当前取钱线程所希望取的钱数
	private double drawAmount;
	
	// 有参构造
	public DrawThread(String name, Account account, double drawAmount)
	{
		super(name);// 给父类Thread类传一个name初始化参数      相当于  new Thread(name)
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	// 当多个线程修改同一个共享数据时， 将涉及数据安全问题
	public void run()
	{
		
		/**
		 * 修改部分, 使用同步代码块
		 */
		
		/*
		// 给账户对象this.account加锁, 然后再修改, 最后释放
		// 注意这里的this.account 就是同步监视器    因为通常推荐使用可能被并发访问的共享资源充当同步监视器
		synchronized(this.account)
		{
			// 账户余额大于取钱数目
			if(this.account.getBalance() >= this.drawAmount)
			{
				// 吐出钞票
				System.out.println(this.getName() + "取钱成功！吐出钞票：" + this.drawAmount);
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 修改余额
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("\t 余额为：" + account.getBalance());
			}
			else
			{
				System.out.println(this.getName() + "取钱失败！余额不足！");
			}
		}*/
		
		
		/**
		 *	直接调用account对象的draw()方法来执行取钱操作
		 *	同步方法的同步监视器就是this, this代表调用draw方法的对象
		 *	也就是说, 线程进入draw()方法之前, 必须先对account对象加锁
		 */
		
		account.draw(drawAmount);
	}
}
