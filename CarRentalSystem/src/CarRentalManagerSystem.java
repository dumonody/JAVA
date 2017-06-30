import java.util.Scanner;


public class CarRentalManagerSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("*************欢迎光临腾飞汽车租赁公司*************");
		System.out.println("1. 轿车	2. 客车");
		System.out.print("请选择你要租赁的汽车类型:");
		new CarService().rent(sc);
	}

	

}
