
/**
 * 轿车类
 * @author Administrator
 *
 */
public class Limousine extends Car {
	
	private String model;	// 型号

	/**
	 * 构造
	 */
	public Limousine() {}
	public Limousine(int type, String brand, String number, String model, int days) {
		super(type, brand, number, days);
		this.model = model;
		setDailyRent(brand);
		
	}

	/**
	 * 根据指定方法更新日租金	定义一个新的setDailyRent()方法	轿车的日租金和品牌、型号有关
	 */
	public void setDailyRent(String brand) {
		if(brand.equals("宝马"))
		{
			if(this.model.equals("X6"))
			{
				this.setDailyRent(800);
			}
			else if(this.model.equals("550i"))
			{
				this.setDailyRent(600);
			}
		}
		else if(brand.equals("别克"))
		{
			if(this.model.equals("林荫大道"))
			{
				this.setDailyRent(300);
			}
			else if(this.model.equals("GL8"))
			{
				this.setDailyRent(600);
			}
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
		if(days > 150) return days*price*0.7;
		else if(days > 30) return days*price*0.8;
		else if(days > 7) return days*price*0.9;
		else return days*price;
	}

	
}
