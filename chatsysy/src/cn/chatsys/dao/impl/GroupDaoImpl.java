package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.Group;
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dbc.BaseDao;

public class GroupDaoImpl implements GroupDao {
	BaseDao bs = new BaseDao();
	@Override
	public boolean doGroup(int uid,String groupName) {
		boolean isflag=false;
		
		String sql = "insert into chatsys.Group (uid,groupname) values (?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(uid);
		list.add(groupName);
		isflag=bs.update(sql, list);
		return isflag;
	}

	@Override
	public Group findGroupById(int gid) {
		
		String sql = "select * from chatsys.Group where gid=?";
		List<Object> list = new ArrayList<Object>();
		Group group = new Group();
		list.add(gid);
		group=(Group) bs.query(sql, list, Group.class).get(0);
		return group;
		
	}

	@Override
	public List<Group> findGroupByUid(int uid) {
		
		String sql="select * from chatsys.Group where uid=?";
		Group group= new Group();
		List<Object> list = new ArrayList<Object>();
		list.add(uid);
		return bs.query(sql, list, Group.class);
	}

	@Override
	public boolean updateGroup(Group group) {
		boolean isflag = false;
		String sql="update chatsys.Group set groupname=? where id=?";
		List<Object> list = new ArrayList<Object>();
		list.add(group.getGroupname());
		list.add(group.getId());
		isflag=bs.update(sql, list);
		return isflag;
	}

	@Override
	public boolean delGroup(int id) {
		boolean isflag = false;
		
		String sql="delete from chatsys.Group where id=?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		isflag=bs.update(sql, list);
		
		return isflag;
	}

	@Override
	public Group findGroupByGroupName(String name) {
		Group group = new Group();
		group = null;
		String sql = "select * from chatsys.Group where groupname=?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		if(bs.query(sql, list, Group.class).size()>0)
		{
			group=(Group) bs.query(sql, list, Group.class).get(0);
		}
		return group;
	}

}
