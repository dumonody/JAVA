package cn.chatsys.util.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import cn.chatsys.util.win.WindowUtil;
import cn.chatsys.view.ChatWin;

/**
 * 接收聊天内容任务类
 * @author Pro.Du
 *
 */
public class Receive implements Runnable{

	// 有一个用于发送的数据报包对象的引用
	private DatagramSocket ds = null;
	
	// 聊天窗口
	private ChatWin cw;
	
	public Receive(DatagramSocket ds, ChatWin cw)
	{
		this.ds = ds;
		this.cw = cw;
	}
	
	@Override
	public void run() {
		// 接收的数据不止一条
		while(!cw.isEndChat())
		{
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			try {
				ds.receive(dp);
				String text = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
				WindowUtil.setTextArea(cw, "\n" + text);
			} catch (IOException e) {
				if(ds.isClosed())
				{
					System.out.println("-----调试：接收用的通信Socket对象已经关闭了！");
				}
			}
		}
		System.out.println("关闭聊天,停止接收数据！");
		this.ds.close();
		this.ds = null;
	}

}
