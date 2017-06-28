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
