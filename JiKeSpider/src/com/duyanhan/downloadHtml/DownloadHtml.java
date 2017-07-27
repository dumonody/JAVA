package com.duyanhan.downloadHtml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloadHtml {

	/**
	 * 获取网页内容
	 * @param urlStr
	 * @param regex
	 * @return
	 * @throws Exception
	 */
	public String getHtmlString(String urlStr, String charset) throws Exception{
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, charset);
		BufferedReader bufR = new BufferedReader(isr);
		StringBuilder content = new StringBuilder();
		String line = null;
		while((line = bufR.readLine()) != null)
		{
			content.append(line);
			content.append(System.lineSeparator());
		}
		bufR.close();
		isr.close();
		is.close();
		return content.toString();
	}
	
	public List<String[]> getAimStringList(String urlStr, String charSet, String regexStr, int[] n) throws Exception
	{
		List<String[]> list = new ArrayList<String[]>();
		String htmlString = this.getHtmlString(urlStr, charSet);
// 		测试下载此网页
//		this.downloadHtml(htmlString, charSet, "download.html");
		/**
		 * Pattern.CASE_INSENSITIVE|Pattern.DOTALL这两个参数很重要：
		 * Pattern.CASE_INSENSITIVE:匹配时忽略大小写
		 * Pattern.DOTALL：匹配时使'.'字符真正做到可以匹配任意字符，包括换行符，如果不加此参数，只能匹配除了换行符以外的所有字符
		 */
		Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		Matcher matcher = pattern.matcher(htmlString);
		while(matcher.find())
		{
			String[] tmpAimStr = new String[n.length];
			for(int i = 0, len = n.length; i < len; i++)
			{
				tmpAimStr[i] = matcher.group(n[i]);
				// 测试匹配到的部分
//				System.out.println(tmpAimStr[i]);
			}
			list.add(tmpAimStr);
		}
		return list;
	}
	
	public boolean downloadHtml(String contentStr, String charSet, String filePath)
	{
		boolean flag = false;
		BufferedWriter bufW = null;
		try {
			bufW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), charSet));
			bufW.write(contentStr);
			bufW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
