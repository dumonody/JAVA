package com.duyanhan.synchronizedpkg;

public class PrintNum implements Runnable{

	private MyNum num;
	
	public PrintNum(MyNum num){
		this.num = num;
	}

	private void printNum()
	{
		while(num.i <= num.getMax())
		{
			synchronized(num){
				if(!num.flag)
				{
					System.out.print(num.i);
					num.i++;
					num.flag = true;
//					System.out.println("num.i=" + num.i + "  num.flag=" + num.flag);
//					System.out.println("\n数字线程通知其他阻塞线程");
					num.notify();
				}
				else
				{
					try {
//						System.out.println("数字线程挂起");
						num.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
	public void run() {
		this.printNum();
	}
}
