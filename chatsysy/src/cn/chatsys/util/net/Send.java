package cn.chatsys.util.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import cn.chatsys.bean.LoginInfo;
import cn.chatsys.util.win.WindowUtil;
import cn.chatsys.view.ChatWin;

/**
 * 发送聊天内容任务类
 * @author Pro.Du
 *
 */
public class Send implements Runnable{

	// 这是我要聊天的好友的登录信息
	private LoginInfo myFriendLoginInfo;
	
	// 有一个用于发送的数据报包对象的引用
	private DatagramSocket ds = null;
	
	// 聊天窗口
	private ChatWin cw;
	
	// 有参构造
	public Send(DatagramSocket ds, ChatWin cw, LoginInfo myFriendLoginInfo)
	{
		this.ds = ds;
		this.cw = cw;
		this.myFriendLoginInfo = myFriendLoginInfo;
	}
	
	@Override
	public void run() {

		String text = WindowUtil.getJEditorPaneText(this.cw);
		DatagramPacket dp = null;
		byte[] buf;
		try {
			buf = text.getBytes("UTF-8");
			dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(myFriendLoginInfo.getIp()), 10001);
			this.ds.send(dp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.ds.close();
		}
		
	}

}
