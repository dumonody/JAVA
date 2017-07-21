package cn.chatsys.dao;

import cn.chatsys.bean.User;
public interface UserDao {
	
	/**
	 * 根据用户登录名查找用户
	 * @param loginName
	 * @return
	 */
	public User findUserbyLoginName(String loginName);
	
	/**
	 * 根据用户ID查询用户
	 * @author Administrator
	 *
	 */
	public User findUserById(int id);
	
	/**
	 * 添加用户根据登录名和密码
	 * @param id
	 * @param loginname
	 * @param password
	 * @return
	 */
	public boolean doLoginName(String loginname,String password);
	
	/**
	 * //根据用户登录名修改密码,登录名不可更改
	 * @param id
	 * @return
	 */
	public boolean updatePasswordByLoginName(String loginname,String password);
	
	
}
