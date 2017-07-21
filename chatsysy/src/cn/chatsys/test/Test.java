package cn.chatsys.test;

import java.util.List;

import cn.chatsys.bean.Group;
import cn.chatsys.bean.User;
import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.ChatHisDao;
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dao.GroupMemDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.ChatHisDaoImpl;
import cn.chatsys.dao.impl.GroupDaoImpl;
import cn.chatsys.dao.impl.GroupMemDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;

/**
 * 
 * @author Pro.Du
 *
 */
public class Test {

	/**
	 * 测试UserDao
	 */
	public static void main(String[] args)
	{
		Test t = new Test();
//==================UserDaoImpl测试
//		testUserDaoImpl(t);
//==================UserInfoDaoImpl测试
//		testUserInfoDaoImpl(t);
//==================GroupDaoImpl测试
//		testGroupDaoImpl(t);
//==================GroupMemDaoImpl测试
//		testGroupMemDaoImpl(t);
//==================ChatHisDaoImpl测试
//		testChatHisDaoImpl(t);
	}

	
//==================ChatHisDaoImpl测试===============
	private static void testChatHisDaoImpl(Test t) {
		t.findChatHisByFuid();
		t.findChatHisFilepathById();
		t.checkChatContentByFilepath();
		t.doChatContentByFilepath();
	}
	public void findChatHisByFuid()
	{
		ChatHisDao chdl = new ChatHisDaoImpl();
		int id = chdl.findChatHisByFuid(1, 3);
		System.out.println("好友1和好友2的聊天记录文件id为："+ id);
	}
	public void findChatHisFilepathById()
	{
		ChatHisDao chdl = new ChatHisDaoImpl();
		String filePath = chdl.findChatHisFilepathById(5);
		System.out.println("好友1和好友2的聊天记录文件路径为："+ filePath);
	}
	public void checkChatContentByFilepath()
	{
		ChatHisDao chdl = new ChatHisDaoImpl();
		String content = chdl.checkChatContentByFilepath("C:/Users/czkct/Desktop/test.txt");
		System.out.println("好友1和好友2的聊天记录为："+ content);
	}
	public void doChatContentByFilepath()
	{
		ChatHisDao chdl = new ChatHisDaoImpl();
		boolean flag = chdl.doChatContentByFilepath("C:/Users/czkct/Desktop/test.txt","有趣的事情");
		System.out.println(flag);
	}
//==================GroupMemDaoImpl测试===============
	private static void testGroupMemDaoImpl(Test t) {
		t.doGroupMem();
		t.delGroupMem();
		t.findAllGroupMemByGid();
	}
	public void doGroupMem()
	{
		GroupMemDao gmd = new GroupMemDaoImpl();
		boolean flag = gmd.doGroupMem(1, 1);
		System.out.println(flag);
	}
	public void delGroupMem()
	{
		GroupMemDao gmd = new GroupMemDaoImpl();
		boolean flag = gmd.delGroupMem(1, 1);
		System.out.println(flag);
	}
	public void findAllGroupMemByGid()
	{
		GroupMemDao gmd = new GroupMemDaoImpl();
		List<User> list = gmd.findAllGroupMemByGid(1);
		System.out.println(list);
	}
//==================GroupDaoImpl测试===============
	private static void testGroupDaoImpl(Test t) {
		t.doGroup();
		t.findGroupById();
		t.findGroupByUid();
		t.updateGroup();
		t.delGroup();
	}
	public void doGroup()
	{
		GroupDao gdi = new GroupDaoImpl();
		boolean flag = gdi.doGroup(2, "jxust");
		System.out.println(flag);
	}
	
	public void findGroupById()
	{
		GroupDao gdi = new GroupDaoImpl();
		Group g = gdi.findGroupById(2);
		System.out.println(g.toString());
	}
	
	public void findGroupByUid()
	{
		GroupDao gdi = new GroupDaoImpl();
		List<Group> list = gdi.findGroupByUid(1);
		System.out.println(list);
	}
	public void updateGroup()
	{
		GroupDao gdi = new GroupDaoImpl();
		Group g = gdi.findGroupById(2);
		boolean flag = gdi.updateGroup(g);
		System.out.println(flag);
	}
	public void delGroup()
	{
		GroupDao gdi = new GroupDaoImpl();
		boolean flag = gdi.delGroup(2);
		System.out.println(flag);
	}
//==================UserInfoDaoImpl测试===============
	private static void testUserInfoDaoImpl(Test t) {
		UserInfo ui = t.findUserInfoByUid();
		t.doUserInfo(ui);
		t.updateUserInfo(ui);
	}
	public boolean doUserInfo(UserInfo ui) {
		UserInfoDao uidl = new UserInfoDaoImpl();
		boolean flag = uidl.doUserInfo(ui);
		return flag;
	}
	public UserInfo findUserInfoByUid() {
		UserInfoDao uidl = new UserInfoDaoImpl();
		UserInfo ui = uidl.findUserInfoById(1);
		System.out.println(ui.toString());
		return ui;
	}
	public boolean updateUserInfo(UserInfo ui) {
		UserInfoDao uidl = new UserInfoDaoImpl();
		boolean flag = uidl.updateUserInfo(ui);
		return flag;
	}
//==================UserDaoImpl测试===============
	private static void testUserDaoImpl(Test t) {
		t.findUserbyLoginName();
		t.findUserById();
		t.doLoginName();
		t.updatePasswordByLoginName();
	}
	public void findUserbyLoginName()
	{
		UserDao udl = new UserDaoImpl();
		User u = udl.findUserbyLoginName("haha1");
		System.out.println(u.toString());
	}
	public void findUserById()
	{
		UserDao udl = new UserDaoImpl();
		User u = udl.findUserById(3);
		System.out.println(u.toString());
	}
	public void doLoginName()
	{
		UserDao udl = new UserDaoImpl();
		boolean flag = udl.doLoginName("duyanhan", "mima");
		System.out.println(flag);
	}
	public void updatePasswordByLoginName()
	{
		UserDao udl = new UserDaoImpl();
		boolean flag = udl.updatePasswordByLoginName("duyanhan", "xiaoxiaoxiao");
		System.out.println(flag);
	}
}
