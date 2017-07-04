
/**
 * 汽车抽象类
 * @author Administrator
 *
 */
public abstract class Car {
	// 汽车基本属性
	private int type;	// 轿车还是客车
	
	private String brand;	// 汽车品牌
	
	private String number;	// 车牌号
	
	private double dailyRent;	// 日租金
	
	private int days;	// 租赁天数
	
	
	public Car(){}
	
	public Car(int type, String brand, String number, int days) {
		super();
		this.type = type;
		this.brand = brand;
		this.number = number;
		this.days = days;
	}

	

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public abstract double calRent(int days);	// 计算租金的抽象方法

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(double dailyRent) {
		this.dailyRent = dailyRent;
	}
	
}
