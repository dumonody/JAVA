package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.GroupMem;
import cn.chatsys.bean.User;
import cn.chatsys.dao.GroupMemDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dbc.BaseDao;

public class GroupMemDaoImpl implements GroupMemDao {
	BaseDao bs= new BaseDao();
	UserDao ud = new UserDaoImpl();

	@Override
	public boolean doGroupMem(int gid,int uid) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="insert into groupmem (gid,uid) values(?,?)";
		list.add(gid);
		list.add(uid);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

	@Override
	public boolean delGroupMem(int gid, int uid) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="delete from groupmem where gid=? and uid=?";
		list.add(gid);
		list.add(uid);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

	@Override
	public List<User> findAllGroupMemByGid(int gid) {
		List<Object> list=new ArrayList<Object>();
		String sql="select * from groupmem where gid=?";
		list.add(gid);
		List<GroupMem> gmList = bs.query(sql, list, GroupMem.class);
		List<User> ansList = new ArrayList<User>();
		for(GroupMem gm : gmList)
		{
			ansList.add(ud.findUserById(gm.getUser().getId()));
		}
		return ansList;
	}

	@Override
	public List<GroupMem> findAllGroupMemListByGid(int gid) {
		List<GroupMem> groupMemList = new ArrayList<GroupMem>();
		groupMemList=null;
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from groupmem where gid=?";
		list.add(gid);
		if(bs.query(sql, list, GroupMem.class).size()>0)
		{
			groupMemList = bs.query(sql, list, GroupMem.class);
		}
		return groupMemList;
	}

}
