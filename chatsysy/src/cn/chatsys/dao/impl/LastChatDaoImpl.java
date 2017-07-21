package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.chatsys.bean.LastChat;
import cn.chatsys.dao.LastChatDao;
import cn.chatsys.dbc.BaseDao;
/**
 * 最近联系人实现类
 * @author moy
 *
 */
public class LastChatDaoImpl implements LastChatDao {
	BaseDao base = new BaseDao();
	@Override
	public boolean doLastChat(int uid,int fid,Date time) {
		boolean isFlag=false;
		List<Object> list = new ArrayList<Object>();
		String sql = "insert into lastchat(uid,fid,time) values(?,?,?)";
		list.add(uid);
		list.add(fid);
		list.add(time);
		isFlag=base.update(sql, list);
		return isFlag;
	}

	@Override
	public List<LastChat> findLastChatByUid(int uid) {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from lastchat where uid=?";
		list.add(uid);
		return base.query(sql, list, LastChat.class);
	}

	@Override
	public boolean delLastChatById(int id) {
		boolean isFlag=false;
		List<Object> list = new ArrayList<Object>();
		String sql = "delete from lastchat where id=?";
		list.add(id);
		isFlag=base.update(sql, list);
		return isFlag;
	}

	@Override
	public boolean delAllLastChatByUid(int uid) {
		boolean isFlag=false;
		List<Object> list = new ArrayList<Object>();
		String sql = "delete from lastchat where uid=?";
		list.add(uid);
		isFlag=base.update(sql, list);
		return isFlag;
	}

	@Override
	public LastChat findLastChatByUidAndFuid(int uid, int fuid) {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from lastchat where uid=? and fid=?";
		list.add(uid);
		list.add(fuid);
		return (LastChat) base.query(sql, list, LastChat.class).get(0);
	}

}
