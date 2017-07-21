package cn.chatsys.dao;

import cn.chatsys.bean.UserInfo;
/**
 * 用户信息接口
 * @author moy
 *
 */
public interface UserInfoDao {
	/**
	 * 新建用户信息
	 * @param userInfo
	 * @return
	 */
	public boolean doUserInfo(UserInfo userInfo);
	/**
	 * 查找用户信息通过id
	 * @param id
	 * @return
	 */
	public UserInfo findUserInfoById(int id);
	/**
	 * 修改用户信息(若删除某项，属性值直接为空)
	 * @param userInfo
	 * @return
	 */
	public boolean updateUserInfo(UserInfo userInfo);
	/**
	 * 查找用户信息通过用户ID
	 * @param uid
	 * @return
	 */
	public UserInfo findUserInfoByUid(int uid);
}
