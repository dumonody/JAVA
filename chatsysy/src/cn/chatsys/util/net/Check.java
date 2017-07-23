package cn.chatsys.util.net;

import java.net.DatagramSocket;

import cn.chatsys.bean.ChatPort;
import cn.chatsys.dao.ChatPortDao;
import cn.chatsys.dao.impl.ChatPortDaoImpl;
import cn.chatsys.view.ChatWin;

/**
 * -----------通信监控线程类------------
 * 通信关闭检测类
 * @author Pro.Du
 *
 */
public class Check implements Runnable{

	private DatagramSocket ds;
	private ChatWin cw;
	private ChatPort cp;
	
	public Check(DatagramSocket ds, ChatWin cw, ChatPort cp)
	{
		this.ds = ds;
		this.cw = cw;
		this.cp = cp;
	}
	
	@Override
	public void run() {
		
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(cw.isEndChat())
			{
				this.ds.close();
				break;
			}
		}
		
		// 删除数据库聊天端口记录
		ChatPortDao cpd = new ChatPortDaoImpl();
		int uid = cp.getUser().getId();
		int fid = cp.getFriend().getId();
		ChatPort tmpCp = cpd.findChatPortByUidAndFid(uid, fid);
		if(tmpCp != null)
		{
			cpd.delChatPortByUidAndFid(uid, fid);
		}
	}
	

}
