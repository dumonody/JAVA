package cn.chatsys.util.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 聊天记录文件工具类
 * @author Pro.Du
 *
 */
public class ChatContentFileUtil {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/**
	 * 向聊天文件中追加聊天记录
	 * @param file
	 * @param appendContent
	 * @return
	 */
	public static boolean appendContentToFile(File file, String appendContent)
	{
		boolean flag = false;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file, true);
			byte[] appendData = (LINE_SEPARATOR+appendContent).getBytes("GBK");
			fos.write(appendData);
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos!=null)
			{
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					fos = null;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 获取聊天记录文件中的内容
	 * @param file
	 * @return
	 */
	public static String getContentFromFile(File file)
	{
		String content = null;
		return content;
	}
}
