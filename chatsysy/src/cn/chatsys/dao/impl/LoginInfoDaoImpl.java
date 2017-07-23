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
	public boolean doLoginInfo(String address,String ip,Date time, boolean state, int uid) {
		boolean isFlag = false;
		
		List<Object> list = new ArrayList<Object>();
		String sql = "insert into logininfo(address, ip, time, state, uid) value(?,?,?,?,?)";//写入sql语句
		
		list.add(address);
		list.add(ip);
		list.add(time);
		list.add(state);
		list.add(uid);
		
		isFlag=base.update(sql, list);//获得修改提示
		return isFlag;
	}

	@Override
	public LoginInfo findLoginInfoByUid(int uid) {
		
		LoginInfo li = null;
		List<Object> args = new ArrayList<Object>();
		args.add(uid);
		String sql = "select * from logininfo where uid=?";
		List<LoginInfo> list = base.query(sql, args, LoginInfo.class);
		if(list != null && list.size() > 0)
		{
			li = list.get(0);
		}
		return li;
	}

	@Override
	public boolean updateLoginInfo(String address, String ip, Date time, boolean state, int uid) {
		boolean flag = false;
		String sql = "update logininfo set address=?, ip=?, time=?, state=? where uid=?";
		List<Object> args = new ArrayList<Object>();
		args.add(address);
		args.add(ip);
		args.add(time);
		args.add(state);
		args.add(uid);
		flag = base.update(sql, args);
		return flag;
	}

}
