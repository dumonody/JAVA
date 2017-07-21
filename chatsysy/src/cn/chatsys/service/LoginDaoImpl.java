package cn.chatsys.service;

import cn.chatsys.bean.User;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.UserDaoImpl;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean Login(String loginName, String password) {
		boolean isFlag = false;
		User user = new User();
		UserDao ud = new UserDaoImpl();
		user=ud.findUserbyLoginName(loginName);
		if(user!=null)
		{
			if(password.equals(user.getPassword())) isFlag=true;
		}
		return isFlag;
	}
}
