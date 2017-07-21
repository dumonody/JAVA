package cn.chatsys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.User;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dbc.BaseDao;
/**
 * 测试通过
 * @author Pro.Du
 *
 */
public class UserDaoImpl implements UserDao {
	BaseDao bs=new BaseDao();
	
	@Override
	public User findUserbyLoginName(String loginName) {
		User user=null;
		List<Object> list=new ArrayList<Object>();
		String sql="select * from user where loginname=?";
		list.add(loginName);
		List<User> lu=bs.query(sql, list, User.class);
		if(lu.size()>0)
		{
			user=lu.get(0);
		}
		return user;
	}
	
	@Override
	public User findUserById(int id) 
	{
		BaseDao bs=new BaseDao();
		List<Object> list=new ArrayList<Object>();
		String sql="select * from user where id=?";
		list.add(id);
		return (User) bs.query(sql, list, User.class).get(0);
	}

	@Override
	public boolean doLoginName(String loginname, String password) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="insert into user(loginname,password) values (?,?)";
		list.add(loginname);
		list.add(password);
		isFlag=bs.update(sql, list);
		
		return isFlag;
	}

	@Override
	public boolean updatePasswordByLoginName(String loginname,String password) {
		boolean isFlag=false;
		List<Object> list=new ArrayList<Object>();
		String sql="update user set password=? where loginname=?";
		list.add(password);
		list.add(loginname);
		isFlag=bs.update(sql, list);
		return isFlag;
	}

}
