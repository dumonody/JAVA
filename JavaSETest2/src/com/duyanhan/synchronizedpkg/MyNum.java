package com.duyanhan.synchronizedpkg;

public class MyNum {

	public int i = 1;
	
	public boolean flag = true;	// 线程交替执行标志
	
	private int max;
	
	public MyNum(int max)
	{
		this.max = max;
	}

	public int getMax() {
		return max;
	}
}
