package cn.chatsys.util.tips;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class NewChatRequestTips {

	/**
	 * 向未打开与自己对话的聊天窗口的好友发送消息
	 * 发送新的会话请求
	 */
	public static void sendNewChatRequest(InetAddress ip, String content)
	{
		// 使用UDP通信,发送请求的端口可以随意
		DatagramSocket ds = null;
		byte[] buf;
		DatagramPacket dp = null;
		try {
			ds = new DatagramSocket();
			buf = content.getBytes("UTF-8");
			dp = new DatagramPacket(buf, buf.length, ip, 65432);	// 好友请求接收端口统一使用65432
			ds.send(dp);
			System.out.println("IP为：" + ip.toString() + "   消息发送成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 发送完请求就关闭Socket对象
			ds.close();
		}
	}
	
	// 获取会话请求
	public static void getNewChatRequest(int uid)
	{
		System.out.println("正在新会话监听中：");
		// 创建一个新会话的管理类
		NewChatRequestMgr newChatMgr = new NewChatRequestMgr();
		DatagramSocket receNewChatRequestDS = null;
		try {
			receNewChatRequestDS = new DatagramSocket(65432);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		
		while(true)
		{
			try {
				
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
	System.out.println("这里已经运行了！"); 
				// 接收数据报
				receNewChatRequestDS.receive(dp);
				// 获取ds的IP
				String friendIP = dp.getAddress().toString().substring(1);
	System.out.println("新消息来源：" + friendIP);
				// 获取数据报中的内容
				String text = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
				// 管理接收到的数据报
				newChatMgr.mgrNewChatContent(friendIP, text, uid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
