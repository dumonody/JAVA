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
		while(true)
		{
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			try {
				ds.receive(dp);
				String text = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
				WindowUtil.setJEditorPaneText(cw, text);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
