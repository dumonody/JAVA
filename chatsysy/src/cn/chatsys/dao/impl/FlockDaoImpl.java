package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.Flock;
import cn.chatsys.dao.FlockDao;
import cn.chatsys.dbc.BaseDao;
/**
 * 群实现类(测试通过)
 * @author yyl
 *
 */
public class FlockDaoImpl implements FlockDao {
	BaseDao bs=new BaseDao();
	@Override
	public List<Flock> findFlocksByUid(int uid) {
		List<Object> list=new ArrayList<Object>();
		List<Flock> fl=new ArrayList<Flock>();
		String sql="select * from flock where uid=?";
		list.add(uid);
		fl=bs.query(sql, list, Flock.class);
		return fl;
	}

	@Override
	public boolean doFlock(int uid, String flockName) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="insert into flock(uid,name) values(?,?)";
		list.add(uid);
		list.add(flockName);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

	@Override
	public boolean delFlock(int id) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="delete from flock where id=?";
		list.add(id);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

	@Override
	public List<Flock> findFlocksByFlockName(String flockName) {
		List<Object> list=new ArrayList<Object>();
		String sql="select * from flock where name like ?";
		list.add("%"+flockName+"%");
		return bs.query(sql, list, Flock.class);
	}


	@Override
	public Flock findFlockById(int id) {
		List<Object> list=new ArrayList<Object>();
		String sql="select * from flock where id=?";
		list.add(id);
		return (Flock) bs.query(sql, list, Flock.class).get(0);
	}

	@Override
	public boolean updateFlockNameByFlockId(int id, String flockName) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="update flock set name=? where id=?";
		list.add(flockName);
		list.add(id);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

}
