package cn.chatsys.service;
/**
 * 业务登录接口
 * @author moy
 *
 */
public interface LoginDao {
	/**
	 * 登录功能，判断是否登录成功
	 * @param loginName
	 * @param password
	 * @return
	 */
	public boolean Login(String loginName,String password);
}
