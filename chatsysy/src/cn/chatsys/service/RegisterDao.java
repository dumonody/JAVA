package cn.chatsys.service;

public interface RegisterDao {
	public boolean register(String loginName,String password,String rePassword);
}
