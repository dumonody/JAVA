package cn.chatsys.dao;

/**
 * 聊天记录接口
 * @author Pro.Du
 *
 */
public interface ChatHisDao{

	/**
	 * 根据当前用户id和好友id查询该好友与自己的聊天记录文件的id
	 * @param uid
	 * @param fid
	 * @return
	 */
	public int findChatHisByFuid(int uid, int fid);
	
	
	/**
	 * 根据id找到聊天记录文件路径file
	 * @param uid
	 * @param fuid
	 * @return
	 */
	public String findChatHisFilepathById(int id);
	
	/**
	 * 根据文件路径添加聊天内容
	 * @param filepath	文件路径
	 * @param content	聊天内容
	 * @return
	 */
	public boolean doChatContentByFilepath(String filepath, String content);
	
	/**
	 * 根据文件路径查看聊天内容
	 * @param filepath
	 * @return
	 */
	public String checkChatContentByFilepath(String filepath);
}
