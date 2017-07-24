package cn.chatsys.service;

import cn.chatsys.dao.FriendListDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.FriendListDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;

public class AddFriendService {

	// 双向添加好友更新数据库
	public boolean doFriend(int uid, int fid)
	{
		boolean flag = false;
		FriendListDao fld = new FriendListDaoImpl();
		// 先获取两个人的账号，作为默认备注
		UserDao userDao = new UserDaoImpl();
		String userLoginName = userDao.findUserById(uid).getLoginName();
		String friendLoginName = userDao.findUserById(fid).getLoginName();
		
		fld.doFriendList(uid, fid, friendLoginName);
		fld.doFriendList(fid, uid, userLoginName);
		return flag;
	}
	
	public static void main(String[] args)
	{
		new AddFriendService().doFriend(3, 5);
	}
}
