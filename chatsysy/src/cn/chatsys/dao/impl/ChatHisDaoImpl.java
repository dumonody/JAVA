package cn.chatsys.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import cn.chatsys.bean.ChatHis;
import cn.chatsys.dao.ChatHisDao;
import cn.chatsys.dbc.BaseDao;
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
		
		try 
		{ 
		    File file = new File(filepath);
			//调用write 方法，将字符串写入到流中 
		    FileWriter fw = new FileWriter(file, true);//避免覆盖之前的内容
			fw.write(content); //要写入的内容
			fw.write("\r\n");//换行
			//刷新流对象中的缓冲中的数据 
			fw.flush();  
		}
		catch (IOException e) 
		{  
			e.printStackTrace();  
		}
	
		return true;
	}

	@Override
	public String checkChatContentByFilepath(String filepath) {
		
		File file=new File(filepath);
		Reader reader = null;
		InputStream is=null;
		char[] tempchars = new char[50];
		try 
		{
            String tepstring=new String();
            int charread = 0;
            //由于要以字符来读取，所以需要套上字符流
            reader = new InputStreamReader(new FileInputStream(filepath));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) 
            {
            	
                //屏蔽掉\r不显示
                if ((charread == tempchars.length)	
                        && (tempchars[tempchars.length - 1] != '\r')) 
                {
                    tepstring=tepstring+ new String(tempchars);
                }
                else
                {
                    for (int i = 0; i < charread; i++)
                    {
                        if (tempchars[i] == '\r')
                        {
                          continue;
                        } 
                        else
                        {
                        	tepstring=tepstring+tempchars[i];
                        }
                    }
                }
                
            }
        }
		catch(Exception e1)
		{
            e1.printStackTrace();
        }
		finally 
		{
            if (reader != null)
            {
                try 
                {
                    reader.close();
                }
                catch (IOException e1) 
                {
                	
                }
            }
        }
		return new String(tempchars);
	}
}
