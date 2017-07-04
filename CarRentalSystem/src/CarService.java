import java.util.Scanner;


/**
 * 汽车业务类
 * @author Administrator
 *
 */
public class CarService {

	public void rent(Scanner sc) {
		String type = sc.next();
		if(type.equals("1"))
		{
			int carType = 1;
			System.out.print("请选择你要租赁的汽车品牌:1. 宝马	2.别克        ");
			int carBrand = sc.nextInt();
			int carModel = 0;
			if(carBrand == 1)
			{
				System.out.print("请选择你要租赁的汽车型号:1. X6	2.550i	");
				carModel = sc.nextInt();
			}
			else
			{
				System.out.println("请选择你要租赁的汽车型号:1. 林荫大道	2.GL8	");
				carModel = sc.nextInt();
			}
			System.out.print("请输入您要租赁的天数:");
			int days = sc.nextInt();
			// 使用小算法技巧:
			int x = ((carBrand&1)<<1)+(carModel&1);
			System.out.print("分配给您的汽车牌号是:");
			String number = "";
			String carModel2 = "";	// 型号
			switch(x)
			{
				case 0:number = "京NT96968"; carModel2 = "GL8"; break;
				case 1:number = "京NT37465"; carModel2 = "林荫大道"; break;
				case 2:number = "京CNY3284"; carModel2 = "550i"; break;
				case 3:number = "京NY28588"; carModel2 = "X6"; break;
				default: break;
			}
			System.out.println(number);
			Car lCar = new Limousine(carType, ((carBrand==1)?"宝马":"别克"), number, carModel2, days);
			double cost = lCar.calRent(lCar.getDays());
			System.out.println("您需要支付的费用是:" + cost + "元");
		}
		else if(type.equals("2"))
		{
			int carType = 2;
			System.out.print("请选择你要租赁的汽车品牌:1.金龙	2.金杯        ");
			int carBrand = sc.nextInt();
			System.out.print("请选择您要租赁的汽车座位数:1.16座		2.34座	");
			int carSeatNumber = sc.nextInt();
			System.out.print("请输入您要租赁的天数:");
			int days = sc.nextInt();
			// 使用小算法技巧:
			int x = ((carBrand&1)<<1)+(carSeatNumber&1);
			System.out.print("分配给您的汽车牌号是:");
			String number = "";
			switch(x)
			{
				case 0:number = "京9696996";break;
				case 1:number = "京6566754";break;
				case 2:number = "京8696998";break;
				case 3:number = "京8696997";break;
				default: break;
			}
			System.out.println(number);
			Car pCar = new PassengerCar(carType, ((carBrand==1)?"金龙":"金杯"), number, ((carSeatNumber==1)?16:34), days);
			double cost = pCar.calRent(pCar.getDays());
			System.out.println("您需要支付的费用是:" + cost + "元");
		}
	}
	
}
