package cn.chatsys.util.tips;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import cn.chatsys.bean.LoginInfo;
import cn.chatsys.bean.User;
import cn.chatsys.dao.LoginInfoDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.LoginInfoDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;

/**
 * 关于好友添加请求
 * @author Pro.Du
 *
 */
public class AddFriendRequest {

	
	/**
	 * 发送添加好友请求
	 * @param uid
	 * @param fid
	 */
	public void SendAddFriendRequest(int uid, int fid)
	{
		// 获取好友的IP地址
		LoginInfoDao lid = new LoginInfoDaoImpl();
		LoginInfo li = lid.findLoginInfoByUid(fid);
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName(li.getIp());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		// 获取当前用户账户名
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findUserById(uid);
		String accountName = user.getLoginName();
		
		
		
		// 使用UDP通信,发送请求的端口可以随意
		DatagramSocket ds = null;
		byte[] buf;
		DatagramPacket dp;
		try {
			ds = new DatagramSocket();
			buf = ("我是" + accountName + "，请求添加您为好友！").getBytes();
			dp = new DatagramPacket(buf, buf.length, ip, 54321);	// 好友请求接收端口统一使用54321
			ds.send(dp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 发送完请求就关闭Socket对象
			if(ds != null)
			{
				ds.close();
				ds = null;
			}
		}

	}
	
	
	/**
	 * 接收添加好友请求，并且做出反馈
	 */
	public void getAddFriendRequest(int uid){
		// 实例化接收用的Socket
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(54321);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		
		while(true)
		{
			DatagramPacket dp = null;
			byte[] buf = new byte[1024];
			try {
				// 接收添加好友请求的专用端口：54321
				
				dp = new DatagramPacket(buf, buf.length);
				// 阻塞等待接收数据报
				ds.receive(dp);
				String text = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
				String userIP = dp.getAddress().toString().substring(1);
				// 根据用户IP获取用户ID
				LoginInfoDao lid = new LoginInfoDaoImpl();
				int fid = lid.findLoginInfoByIP(userIP).getUser().getId();
				new AddFriendTipsWin(uid, fid, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
