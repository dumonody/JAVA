package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.ChatPort;
import cn.chatsys.dao.ChatPortDao;
import cn.chatsys.dbc.BaseDao;

public class ChatPortDaoImpl implements ChatPortDao {

	BaseDao bd = new BaseDao();
	
	@Override
	public ChatPort findChatPortByUidAndFid(int uid, int fid) {
		ChatPort cp = null;
		String sql = "select * from chatport where uid=? and fid=?";
		List<Object> args = new ArrayList<Object>();
		args.add(uid);
		args.add(fid);
		List<ChatPort> cplist = bd.query(sql, args, ChatPort.class);
		if(cplist != null && cplist.size() > 0)
		{
			cp = cplist.get(0);
		}
		return cp;
	}

	@Override
	public boolean doChatPortByChatPort(ChatPort cp) {
		boolean flag = false;
		String sql = "insert into chatport (sendport, receiveport, uid, fid) values (?, ?, ?, ?)";
		List<Object> args = new ArrayList<Object>();
		args.add(cp.getSendport());
		args.add(cp.getReceiveport());
		args.add(cp.getUser().getId());
		args.add(cp.getFriend().getId());
		flag = bd.update(sql, args);
		return flag ;
	}

	@Override
	public boolean delChatPortByUidAndFid(int uid, int fid) {
		boolean flag = false;
		String sql = "delete from chatport where uid=? and fid=?";
		List<Object> args = new ArrayList<Object>();
		args.add(uid);
		args.add(fid);
		flag = bd.update(sql, args);
		return flag ;
	}

}
