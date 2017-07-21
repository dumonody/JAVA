package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.Flock;
import cn.chatsys.bean.FlockMem;
import cn.chatsys.bean.User;
import cn.chatsys.dao.FlockMemDao;
import cn.chatsys.dbc.BaseDao;
/**
 * 群成员实现类(测试通过)
 * @author moy
 *
 */
public class FlockMemDaoImpl implements FlockMemDao {
	
	BaseDao base = new BaseDao();
	
	@Override
	public List<FlockMem> findFlockMemByFlockId(int flockId) {
		List<FlockMem> li = new ArrayList<FlockMem>();
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from flockmem where qid=?";
		list.add(flockId);
		li=base.query(sql, list, FlockMem.class);
		return li;
	}

	@Override
	public boolean doFlockMemByUserAndFlock(int uid, int flockId) {
		boolean isFlag=false;
		List<Object> list = new ArrayList<Object>();
		String sql = "insert into flockmem(uid,qid) values(?,?) ";
		list.add(uid);
		list.add(flockId);
		isFlag=base.update(sql, list);
		return isFlag;
	}

	@Override
	public boolean delFlockMemByUserAndFlock(int uid, int flockId) {
		boolean isFlag = false;
		List<Object> list = new ArrayList<Object>();
		String sql="delete from flockmem where uid=? and qid=?";
		list.add(uid);
		list.add(flockId);
		isFlag=base.update(sql, list);
		return isFlag;
	}

	@Override
	public boolean delAllMemByFlockId(int flockId) {
		boolean isFlag=false;
		List<Object> list = new ArrayList<Object>();
		String sql="delete from flockmem where qid=?";
		list.add(flockId);
		isFlag=base.update(sql, list);
		return isFlag;
	}

}
