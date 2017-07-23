package cn.chatsys.util.net;

import java.net.DatagramSocket;

import cn.chatsys.view.ChatWin;

/**
 * 通信关闭检测类
 * @author Pro.Du
 *
 */
public class Check implements Runnable{

	private DatagramSocket ds;
	private ChatWin cw;
	
	public Check(DatagramSocket ds, ChatWin cw)
	{
		this.ds = ds;
		this.cw = cw;
	}
	
	@Override
	public void run() {
		
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(cw.isEndChat())
			{
				this.ds.close();
				this.ds = null;
				break;
			}
		}
	}
	

}
