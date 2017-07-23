package cn.chatsys.util.net;

import java.net.DatagramSocket;

import cn.chatsys.bean.ChatPort;
import cn.chatsys.bean.User;
import cn.chatsys.dao.ChatPortDao;
import cn.chatsys.dao.impl.ChatPortDaoImpl;
import cn.chatsys.view.ChatWin;

/**
 * 聊天工具类
 * @author Pro.Du
 *
 */
public class Chat {

	// 好友对象
	private User friend;
	// 当前用户对象
	private User user;
	// 聊天窗口
	private ChatWin cw;
	
	/**
	 * 聊天有参构造
	 * @param friend
	 * @param user 
	 */
	public Chat(User friend, User user, ChatWin cw)
	{
		this.friend = friend;
		this.user = user;
		this.cw = cw;
	}
	
	/**
	 * 聊天方法
	 */
	public void goChat()
	{
		try {
			// 发送信息, 随机开启一个端口
			DatagramSocket sendSocket = new DatagramSocket();
			// 接收信息, 随机开启一个端口
			DatagramSocket receiveSocket = new DatagramSocket();
			
			// 记录这两个端口:注意使用getLocalPort()方法获取上面开启的两个一接一收的随机端口
			ChatPort cp = new ChatPort();
			// 获取发送端口，并记录
			cp.setSendport(sendSocket.getLocalPort());
			// 获取接收端口，并记录
			cp.setReceiveport(receiveSocket.getLocalPort());
			// 记录两个对象
			cp.setUser(user);
			cp.setFriend(friend);
			
			// 添加数据库聊天端口记录
			ChatPortDao cpd = new ChatPortDaoImpl();
			cpd.doChatPortByChatPort(cp);
			
			// 开启发送接收消息的两个任务
			Send send = new Send(sendSocket, this.cw, friend, user);
			Receive rece = new Receive(receiveSocket, this.cw);
			
			// 开启通信任务
			Thread sendT = new Thread(send);
			Thread receT = new Thread(rece);
			sendT.start();
			receT.start();
			
			// ===========通信监控线程==========
			Check checkSend = new Check(sendSocket, this.cw, cp);
			Check checkRece = new Check(receiveSocket, this.cw, cp);
			Thread cS = new Thread(checkSend);
			Thread cR = new Thread(checkRece);
			cS.start();
			cR.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
