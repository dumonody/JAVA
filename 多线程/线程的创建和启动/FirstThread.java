/*
	通过继承Thread类来创建线程类

	Thread类是java.lang包下面的类，默认是会导入的


	步骤：
	1、定义Thread类的子类，并重写该类的方法
	2、创建Thread类子类的实例，即创建了线程类对象
	3、使用线程类对象调用start()方法类启动该线程
*/
public class FirstThread extends Thread
{
	// 创建实例成员i
	private int i;

	// 重写run方法
	public void run()
	{
		for(; i < 100; i++)
		{
			// 当线程类继承Thread类时，直接使用this即可获取当前线程,因为this就代表当前实例的引用
			// 当然也可以使用Thread.currentThread()这个类方法来获取当前线程
			// Thread对象的getName()方法可以返回当前线程的名字
			// 因此在这里可以直接调用getName()方法返回当前线程的名字(省略this.)

			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args)
	{
		for(int i = 0; i < 100; i++)
		{
			// 调用Thread类的类成员方法currentThread()来获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);

			if(i == 20)
			{
				// 创建并启动第一个线程
				new FirstThread().start();
				// 创建并启动第二个线程
				new FirstThread().start();
			}

		}
	}
}

/*
	运行结果：
		上述程序一共有三个线程：显式创建的两个子线程和一个主线程；
		两个子线程的循环变量不连续，表明他们没有共享数据(实例变量i)

	运行结果总结：
		1、一个Java程序默认至少有一个主线程，主线程的执行体就是main()方法；
		2、Thread.currentThread()是Thread类的静态(类)方法，返回当前正在执行的线程对象；
		3、getName()方法是Thread类的实例方法，返回调用该方法的线程对象的名字；
		4、默认情况下（也可以用setName(String name)方法给线程设置指定名字）：
			主线程的名字：main
			用户启动的多个线程的名字依次为：Thread-0, Thread-1, ..., Thread-n；	
		5、run()方法中的代码执行流就是该线程所需要完成的任务，即run()方法是该线程执行体；
		6、调用start()方法来启动该线程
		
*/