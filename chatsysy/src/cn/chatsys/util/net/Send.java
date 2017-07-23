package cn.chatsys.util.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import cn.chatsys.bean.User;
import cn.chatsys.dao.ChatPortDao;
import cn.chatsys.dao.LoginInfoDao;
import cn.chatsys.dao.impl.ChatPortDaoImpl;
import cn.chatsys.dao.impl.LoginInfoDaoImpl;
import cn.chatsys.util.win.WindowUtil;
import cn.chatsys.view.ChatWin;

/**
 * 发送聊天内容任务类
 * @author Pro.Du
 *
 */
public class Send implements Runnable{
	
	// 用户对象
	private User user;

	// 好友对象
	private User friend;
	
	// 好友当前IP
	private InetAddress friendIP;
	
	// 好友当前接收聊天信息的端口
	private int friendRecePort;
	
	// 有一个用于发送的数据报包对象的引用
	private DatagramSocket ds = null;
	
	// 聊天窗口
	private ChatWin cw;
	
	// 有参构造
	public Send(DatagramSocket ds, ChatWin cw, User friend, User user)
	{
		this.ds = ds;
		this.cw = cw;
		this.friend = friend;
		this.user = user;
		
		// 初始化发送目标的IP和端口
		init(friend);
	}

	private void init(User friend) {
		LoginInfoDao lid = new LoginInfoDaoImpl();
		try {
			this.friendIP = InetAddress.getByName(lid.findLoginInfoByUid(friend.getId()).getIp());
		} catch (UnknownHostException e) {
			System.out.println("用户: " + friend.getLoginName() + " 不在线！");
			e.printStackTrace();
		}
		
		ChatPortDao cpd = new ChatPortDaoImpl();
		try {
			this.friendRecePort = cpd.findChatPortByUidAndFid(this.friend.getId(), this.user.getId()).getReceiveport();
		} catch (Exception e) {
			System.out.println("用户: " + friend.getLoginName() + " 没有打开与你对话的聊天窗口！");
			e.printStackTrace();
		}
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
					dp = new DatagramPacket(buf, buf.length, this.friendIP, this.friendRecePort);
					this.ds.send(dp);
					System.out.println("发送给："+ this.friendIP.toString() + "成功！");
					
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
	}

}
