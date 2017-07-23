package cn.chatsys.service;

import java.net.InetAddress;
import java.util.Date;

import cn.chatsys.bean.User;
import cn.chatsys.dao.LoginInfoDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.LoginInfoDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.util.location.AddressUtils;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean Login(String loginName, String password) {
		boolean isFlag = false;
		User user = new User();
		UserDao ud = new UserDaoImpl();
		user=ud.findUserbyLoginName(loginName);
		if(user!=null)
		{
			if(password.equals(user.getPassword())) {
				isFlag=true;
				updateLoginInfo(user);
			}
		}
		return isFlag;
	}

	/**
	 * 更新登录信息
	 * @param user
	 */
	private void updateLoginInfo(User user) {
		try {
			// 记录登录信息
			String ip = InetAddress.getLocalHost().getHostAddress();
			String loc = new AddressUtils().getAddress("ip="+ip, "UTF-8");
			if(loc.trim().equals("")) loc = "广东省广州市番禺区";
			Date time = new Date();
			int uid = user.getId();
			LoginInfoDao lid = new LoginInfoDaoImpl();
			if (lid.findLoginInfoByUid(uid) != null) {
				// 如果已经存在，则修改
				lid.updateLoginInfo(loc, ip, time, uid);
			}
			else
			{
				// 否则添加
				lid.doLoginInfo(loc, ip, time, uid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
