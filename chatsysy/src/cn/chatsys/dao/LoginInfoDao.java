package cn.chatsys.dao;

import java.util.Date;

import cn.chatsys.bean.LoginInfo;

/**
 * 登录信息接口
 * @author moy
 *
 */
public interface LoginInfoDao {
	/**
	 * 添加登录信息
	 * @param loginInfo
	 * @return
	 */
	public boolean doLoginInfo(String address,String ip,Date time,boolean state, int uid);
	
	
	/**
	 * pro.du
	 * 根据用户id查找登录信息
	 */
	public LoginInfo findLoginInfoByUid(int uid);
	
	
	/**
	 * 根据ip查找登录信息
	 * @param ip
	 * @return
	 */
	public LoginInfo findLoginInfoByIP(String ip);
	
	/**
	 * 根据用户id更新登录信息
	 * @param address
	 * @param ip
	 * @param time
	 * @param uid
	 * @return
	 */
	public boolean updateLoginInfo(String address, String ip, Date time, boolean state, int uid);
}
