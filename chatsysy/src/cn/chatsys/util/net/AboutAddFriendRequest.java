package cn.chatsys.util.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 关于好友添加请求
 * @author Pro.Du
 *
 */
public class AboutAddFriendRequest {

	public void SendRequest()
	{
		// 使用UDP通信,发送请求的端口可以随意
		DatagramSocket ds;
		byte[] buf;
		DatagramPacket dp;
		try {
			ds = new DatagramSocket();
			buf = "发送的备注信息".getBytes();
			dp = new DatagramPacket(buf, buf.length, IP地址, 65432);	// 好友请求接收端口统一使用65432
			ds.send(dp);
		} catch (SocketException e) {
			e.printStackTrace();
		} finally{
			// 发送完请求就关闭Socket对象
			ds.close();
		}
		
		// 等待反馈消息
		DatagramSocket ds2;
		ds2 = new DatagramSocket(23456);	// 好友对请求的反馈消息一律发送到23456端口
		byte[] buf2 = new byte[1024];
		DatagramPacket dp2 = new DatagramPacket(buf2, buf2.length);
		ds2.receive(dp2);
	}
}
