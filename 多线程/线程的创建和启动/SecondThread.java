/*
	实现Runnable接口创建线程类

	步骤：1、定义Runnable接口的实现类（这个类是线程类的target类），并重写该接口的run()方法，
				该run()方法同样是该线程的线程执行体；
		  2、创建Runnable实现类的实例，并以此实例作为Thread类的
		  		target来创建Thread对象，这个创建出来的Thread对象
		  		才是真正的线程对象；
*/

public class SecondThread implements Runnable
{
	// 创建Runnable接口实现类的实例变量
	private int i;

	// run()方法同样是线程执行体，重写run()方法
	public void run()
	{
		for( ; i < 100; i++)
		{
			// 当线程类(的target类)实现Runnable接口时
			// 如果想获取当前线程，只能通过Thread.currentThread()方法
			// 因为如果用this，this只能代表当前实例，而这个实例只是线程类的target实例，
			// 所以Runnable接口的实现类(即线程类的target类)不能用this类获取当前线程

			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args)
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);

			if(i == 20)
			{
				// 创建线程类的target实例st
				SecondThread st = new SecondThread();
				// 通过new Thread(target, name)方法创建新线程
				new Thread(st, "新线程1").start();
				new Thread(st, "新线程2").start();
			}
		}
	}
}

/*
	运行结果：
		两个子线程的i变量是连续的，即，两个子线程的i变量总共是0到99共100个

	运行结果总结：
		1、Runnable接口是函数式接口可以用Lambda表达式创建Runnable对象；
		2、Runnable对象只是线程类的target对象，并不是线程对象；
		3、多个线程可以共享同一个target
		4、由3可知，多个线程可以共享同一个target类的实例变量(由运行结果可以看出来)；
*/