package cn.chatsys.util.net;

import java.net.DatagramSocket;

import cn.chatsys.bean.LoginInfo;
import cn.chatsys.view.ChatWin;

/**
 * 聊天工具类
 * @author Pro.Du
 *
 */
public class Chat {

	// 这是我要聊天的好友的登录信息
	private LoginInfo myFriendLoginInfo;
	
	// 聊天窗口
	private ChatWin cw;
	
	/**
	 * 聊天有参构造
	 * @param mf
	 */
	public Chat(LoginInfo mf, ChatWin cw)
	{
		this.myFriendLoginInfo = mf;
		this.cw = cw;
	}
	
	/**
	 * 聊天方法
	 */
	public void goChat()
	{
		try {
			// 发送信息, 统一使用10001端口
			DatagramSocket sendSocket = new DatagramSocket();
			// 接收信息, 统一使用10002端口
			DatagramSocket receiveSocket = new DatagramSocket(10001);
			
			// 开启发送接收消息的两个任务
			Send send = new Send(sendSocket, this.cw, myFriendLoginInfo);
			Receive rece = new Receive(receiveSocket, this.cw);
			
			// 开启通信任务
			Thread sendT = new Thread(send);
			Thread receT = new Thread(rece);
			sendT.start();
			receT.start();
			
			// 开启检测任务
			Check checkSend = new Check(sendSocket, this.cw);
			Check checkRece = new Check(receiveSocket, this.cw);
			Thread cS = new Thread(checkSend);
			Thread cR = new Thread(checkRece);
			cS.start();
			cR.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
