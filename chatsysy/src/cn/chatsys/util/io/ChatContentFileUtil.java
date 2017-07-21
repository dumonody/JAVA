package cn.chatsys.util.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

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
		FileWriter fw = null;
		BufferedWriter bufw = null;
		try {
			fw = new FileWriter(file, true);
			bufw = new BufferedWriter(fw);
			bufw.write(appendContent);
			bufw.newLine();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bufw!=null)
			{
				try {
					bufw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					bufw = null;
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
		String content = new String();
		InputStreamReader isr = null;
		BufferedReader bufr = null;
		try {
			isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bufr = new BufferedReader(isr);
			String tmp = null;
			while((tmp = bufr.readLine()) != null)
			{
				content += (tmp + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
