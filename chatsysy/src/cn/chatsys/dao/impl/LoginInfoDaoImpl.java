package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.chatsys.bean.LoginInfo;
import cn.chatsys.dao.LoginInfoDao;
import cn.chatsys.dbc.BaseDao;

/**
 * 登录记录实现类
 * @author moy
 *
 */
public class LoginInfoDaoImpl implements LoginInfoDao {
	BaseDao base = new BaseDao();
	
	@Override
	public boolean doLoginInfo(String address,String ip,Date time,int uid) {
		boolean isFlag = false;
		
		List<Object> list = new ArrayList<Object>();
		String sql = "insert into logininfo(address, ip, time, uid) value(?,?,?,?)";//写入sql语句
		
		list.add(address);
		list.add(ip);
		list.add(time);
		list.add(uid);
		
		isFlag=base.update(sql, list);//获得修改提示
		return isFlag;
	}

	@Override
	public LoginInfo findLoginInfoByUid(int uid) {
		
		List<Object> args = new ArrayList<Object>();
		args.add(uid);
		String sql = "select * from logininfo where uid=?";
		LoginInfo li = (LoginInfo) base.query(sql, args, LoginInfo.class).get(0);
		return li;
	}

}
