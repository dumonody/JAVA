package cn.chatsys.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.ChatHis;
import cn.chatsys.dao.ChatHisDao;
import cn.chatsys.dbc.BaseDao;
import cn.chatsys.util.io.ChatContentFileUtil;
/**
 * 
 * @author LH
 *
 */
public class ChatHisDaoImpl implements ChatHisDao {

	BaseDao bs=new BaseDao(); 

	@Override
	public int findChatHisByFuid(int uid, int fid) {

		String sql="select * from ChatHis where uid=? and fid=?";
		List<Object> list = new ArrayList<Object>();
		ChatHis ch = new ChatHis();
		list.add(uid);
		list.add(fid);
		ch=(ChatHis) bs.query(sql, list, ChatHis.class).get(0);
		int i=ch.getId();
		return i;
	}

	@Override
	public String findChatHisFilepathById(int id) {

		String sql="select * from ChatHis where id=?";
		ChatHis ch= new ChatHis();
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		ch=(ChatHis) bs.query(sql, list, ChatHis.class).get(0);
		String filePath= ch.getFile();
		return filePath;
	}

	@Override
	public boolean doChatContentByFilepath(String filepath,String content) {
		
		boolean flag = false;
	
		File file = new File(filepath);
		flag = ChatContentFileUtil.appendContentToFile(file, content);
		
		return flag;
	}

	@Override
	public String checkChatContentByFilepath(String filepath) {
		
		File file=new File(filepath);
		String ans = ChatContentFileUtil.getContentFromFile(file);
		return ans;
	}

	@Override
	public boolean doChatHisFileByFuid(int uid, int fid) {
		
		boolean flag = false;
		
		String filePath = "ChatHisFolder" + File.separator + uid + "_" + fid ;	// 新建路径
		File file = new File(filePath);
		if(!file.exists())
		{
			String sql = "insert into ChatHis (file, uid, fid) values (?, ?, ?)";
			List<Object> args = new ArrayList<Object>();
			args.add(filePath);
			args.add(uid);
			args.add(fid);
			flag = bs.update(sql, args);
			// 创建文件
			try {
				flag = flag && file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
}
