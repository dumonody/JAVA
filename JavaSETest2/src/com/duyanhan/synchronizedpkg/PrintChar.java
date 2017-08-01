package com.duyanhan.synchronizedpkg;

public class PrintChar implements Runnable{

	private MyNum num;
	
	public PrintChar(MyNum num){
		this.num = num;
	}

	private void printChar()
	{
		while(num.i <= num.getMax())
		{
			synchronized(num){
				if(num.flag)
				{
					System.out.print((char)('A' + num.i - 1));
					num.flag = false;
//					System.out.println("num.i=" + num.i + "  num.flag=" + num.flag);
//					System.out.println("\n字符线程通知其他阻塞线程");
					num.notify();
				}
				else
				{
					try {
//						System.out.println("字符线程挂起");
						num.wait();	// 线程挂起
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	@Override
	public void run() {
		this.printChar();
	}
}
