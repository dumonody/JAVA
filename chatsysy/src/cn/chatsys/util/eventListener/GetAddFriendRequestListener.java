package cn.chatsys.util.eventListener;

import cn.chatsys.util.tips.AddFriendRequest;

public class GetAddFriendRequestListener implements Runnable{

	private int uid;
	
	public GetAddFriendRequestListener(int uid) {
		this.uid = uid;
	}
	
	@Override
	public void run() {
		new AddFriendRequest().getAddFriendRequest(uid);
		
	}

}
