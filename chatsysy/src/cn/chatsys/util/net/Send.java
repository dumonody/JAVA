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

		while(!cw.isEndChat())
		{
			// 如果发送了消息
			if(cw.isHasSend() == true)
			{
				String text = WindowUtil.getJEditorPaneText(this.cw);
System.out.println("发送的消息：" + text);
				DatagramPacket dp = null;
				byte[] buf;
				try {
					buf = text.getBytes("UTF-8");
					dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(myFriendLoginInfo.getIp()), 10001);
					this.ds.send(dp);
System.out.println("发送给："+ myFriendLoginInfo.getIp()+ "成功！");
					// 下面是我现在聊天界面中的内容
					WindowUtil.setTextArea(this.cw, "\n" + text);
					WindowUtil.setJEditorPaneText(this.cw, "");
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 恢复消息发送状态
				cw.setHasSend(false);
			}
			
			try {
				// 休息50ms
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("关闭聊天,停止发送数据！");
		this.ds.close();
		this.ds = null;
	}

}
