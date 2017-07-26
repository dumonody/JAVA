package cn.chatsys.util.eventListener;

import cn.chatsys.view.List;

/**
 * 定时刷新
 * @author Pro.Du
 *
 */
public class ReFreshOnTime extends Thread{

	private List list;
	
	public ReFreshOnTime(List list)
	{
		this.list = list;
	}
	
	@Override
	public void run() {
		while(true)
		{
			this.list.repaint();
			try {
				Thread.sleep(5000);	// 每2秒刷新一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
