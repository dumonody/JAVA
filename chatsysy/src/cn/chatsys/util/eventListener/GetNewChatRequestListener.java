package cn.chatsys.util.eventListener;

import cn.chatsys.util.tips.NewChatRequestTips;

/**
 * 监听好友新会话请求任务
 * @author Pro.Du
 *
 */
public class GetNewChatRequestListener implements Runnable{

	private int uid;
	
	public GetNewChatRequestListener(int uid) {
		this.uid = uid;
	}

	@Override
	public void run() {
		NewChatRequestTips.getNewChatRequest(uid);
	}
}
