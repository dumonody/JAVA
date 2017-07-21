package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.FriendList;
import cn.chatsys.bean.User;
import cn.chatsys.dao.FriendListDao;
import cn.chatsys.dbc.BaseDao;

public class FriendListDaoImpl implements FriendListDao {
	BaseDao bs=new BaseDao();

	@Override
	public boolean doFriendList(int uid,int fid,String remarks) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="insert into friendlist(uid,fid,remarks) values(?,?,?)";
		list.add(uid);
		list.add(fid);
		list.add(remarks);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

	@Override
	public boolean delFriendListById(int uid,int fid) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="delete from friendlist where uid=?,fid=?";
		list.add(uid);
		list.add(fid);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

	@Override
	public boolean updateFriendList(int uid,int fid,String remarks) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="update friendlist set remarks=? where uid=?,fid=?";
		list.add(remarks);
		list.add(uid);
		list.add(fid);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

	@Override
	public List<FriendList> findAllFriendList(int uid) {
		List<Object> list=new ArrayList<Object>();
		String sql="select * from friendlist where uid=?";
		list.add(uid);
		return bs.query(sql, list, FriendList.class);
	}

}
