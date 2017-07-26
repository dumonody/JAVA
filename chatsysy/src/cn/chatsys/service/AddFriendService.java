package cn.chatsys.service;

import cn.chatsys.dao.FriendListDao;
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dao.GroupMemDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.FriendListDaoImpl;
import cn.chatsys.dao.impl.GroupDaoImpl;
import cn.chatsys.dao.impl.GroupMemDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;

public class AddFriendService {

	// 双向添加好友更新数据库
	public boolean doFriend(int uid, int fid)
	{
		boolean flag = false;
		FriendListDao fld = new FriendListDaoImpl();
		// 先获取两个人的账号，作为默认备注
		UserDao userDao = new UserDaoImpl();
		GroupDao groupDao = new GroupDaoImpl();
		GroupMemDao groupMemDao = new GroupMemDaoImpl();
		String userLoginName = userDao.findUserById(uid).getLoginName();
		String friendLoginName = userDao.findUserById(fid).getLoginName();
		
		fld.doFriendList(uid, fid, friendLoginName);
		fld.doFriendList(fid, uid, userLoginName);
		int gid=groupDao.findGroupByUid(uid).get(0).getId();
		int fgid=groupDao.findGroupByUid(fid).get(0).getId();
		groupMemDao.doGroupMem(gid, fid);
		groupMemDao.doGroupMem(fgid, uid);
		// 没写完   flag没更新
		return flag;
	}
}
