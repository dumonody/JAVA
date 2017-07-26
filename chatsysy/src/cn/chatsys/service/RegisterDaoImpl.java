package cn.chatsys.service;

import cn.chatsys.bean.User;
import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.GroupDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;

public class RegisterDaoImpl implements RegisterDao {
	@Override
	public boolean register(String loginName, String password, String rePassword)
	{
		boolean isFlag = false;
		User user = new User();
		UserDao userdao = new UserDaoImpl();
		UserInfoDao userInfo = new UserInfoDaoImpl();
		user=userdao.findUserbyLoginName(loginName);
		if(user==null)
		{	
			if(password.equals(rePassword))
			{
				isFlag=userdao.doLoginName(loginName, password);
				UserInfo u = new UserInfo();
				user=userdao.findUserbyLoginName(loginName);
				u.setUser(user);
				userInfo.doUserInfo(u);
				GroupDao groupDao= new GroupDaoImpl();
				groupDao.doGroup(userdao.findUserbyLoginName(loginName).getId(), "好友列表");
				
			}
		}
		return isFlag;
	}
}