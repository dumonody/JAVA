package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dbc.BaseDao;
/**
 * 用户信息实现类（测试通过）
 * @author moy
 *
 */
public class UserInfoDaoImpl implements UserInfoDao {
	BaseDao base = new BaseDao();
	@Override
	public boolean doUserInfo(UserInfo userInfo) {
		boolean isFlag=false;
		List<Object> list = new ArrayList<Object>();
		String sql = "insert into userinfo(nickname,avatarpath,sex,age,star,birthday,email,address,uid) values(?,?,?,?,?,?,?,?,?)";
		list.add(userInfo.getNickname());
		list.add(userInfo.getAvatarpath());
		list.add(userInfo.getSex());
		list.add(userInfo.getAge());
		list.add(userInfo.getStar());
		list.add(userInfo.getBirthday());
		list.add(userInfo.getEmail());
		list.add(userInfo.getAddress());
		list.add(userInfo.getUser().getId());
		isFlag=base.update(sql, list);
		return isFlag;
	}

	@Override
	public UserInfo findUserInfoById(int uid) {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from userinfo where id=?";
		list.add(uid);
		return (UserInfo) base.query(sql, list, UserInfo.class).get(0);
	}

	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		boolean isFlag=false;
		List<Object> list = new ArrayList<Object>();
		String sql = "update userinfo set nickname=?,avatarpath=?,sex=?,age=?,star=?,birthday=?,email=?,address=?  where id=?";
		list.add(userInfo.getNickname());
		list.add(userInfo.getAvatarpath());
		list.add(userInfo.getSex());
		list.add(userInfo.getAge());
		list.add(userInfo.getStar());
		list.add(userInfo.getBirthday());
		list.add(userInfo.getEmail());
		list.add(userInfo.getAddress());
		list.add(userInfo.getId());
		isFlag=base.update(sql, list);
		return isFlag;
	}

	@Override
	public UserInfo findUserInfoByUid(int uid) {
		UserInfo userInfo = new UserInfo();
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from userinfo where uid=?";
		list.add(uid);
		userInfo = (UserInfo) base.query(sql, list, UserInfo.class).get(0);
		return userInfo;
	}

}
