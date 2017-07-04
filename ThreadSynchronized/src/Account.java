/**
 * 银行账户类
 * @author czkct
 *
 */
public class Account {

	private String accountNo;
	private double balance;

	// 构造
	public Account(){}
	public Account(String accountNo, double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	// 提供一个线程安全的draw()方法来完成取钱操作
	public synchronized void draw(double drawAmount)
	{
		// 如果账户余额大于取钱数目
		if(this.balance >= drawAmount)
		{
			// 吐出钞票
			System.out.println(Thread.currentThread().getName()
					+ "取钱成功!吐出钞票:" + drawAmount);	// 当前线程取钱
			// 线程休息
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 修改余额
			balance -= drawAmount;
			System.out.println("\t 余额为: " + this.balance);
		}
		// 否则如果账户余额不足
		else
		{
			System.out.println(Thread.currentThread().getName()
					+ "取钱失败!余额不足!");
		}
	}
	
	
	// 重写hashCode()
	public int hashCode()
	{
		return accountNo.hashCode();
	}
	// 重写equals()方法
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;// 地址相同的两个对象   一定相等
		}
		if(obj != null && obj.getClass() == Account.class) // 后半句等价于   obj instanceof Account
		{
			Account target = (Account) obj;
			return target.getAccountNo().equals(this.accountNo);
		}
		return false;
	}
	
	// setter、getter方法
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
