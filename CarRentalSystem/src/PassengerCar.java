
/**
 * 客车类
 * @author Administrator
 *
 */
public class PassengerCar extends Car {
	
	private int seatNumber;	// 座位数量

	/**
	 * 构造
	 */
	public PassengerCar() {}
	public PassengerCar(int type, String brand, String number, int seatNumber, int days) {
		super(type, brand, number, days);
		this.seatNumber = seatNumber;
		this.setDailyRent();
	}
	
	/**
	 * 根据指定方法,更新日租金	定义一个新的setDailyRent()方法   客车的日租金和座位数有关
	 */
	public void setDailyRent() {
		if(this.seatNumber <= 16)
		{
			// 如果租的座位为16及以下,日租金为800
			this.setDailyRent(800);
			// 注意这里没必要写成super.setDailyRent(800), 因为它自动继承了来自父类Car的setDailyRent方法
		}
		else if(this.seatNumber <= 34)
		{
			// 如果租的座位为34及以下,日租金为1500
			this.setDailyRent(1500);
		}
		else
		{
			System.out.println("无此类选择, 抱歉!");
		}
		
	}
	


	@Override
	public double calRent(int days) {
		// 先获取日租金
		double price = this.getDailyRent();
		if(days >= 150) return days*price*0.6;
		else if(days >= 30) return days*price*0.7;
		else if(days >= 7) return days*price*0.8;
		else if(days >= 3) return days*price*0.9;
		else return days*price;
	}
	
	
}
