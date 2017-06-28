package com.duyanhan.getImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGetBeautyName {

	/**
	 * 返回匹配的美女的名字
	 * @param urlString  目标网页的url
	 * @param regexString  正则表达式字符串
	 * @param n   要获取的第n个括号中的内容
	 * @return  匹配的美女的名字
	 */
	public static String getBeautyName(String urlString, String regexString, int n)
	{
		try {
			
			// 获取url对象
			URL url = new URL(urlString);
			// 获取连接对象
			URLConnection conn = url.openConnection();
			// 获取网页内容的字节输入流
			InputStream is = conn.getInputStream();
			// 包装字节输入流变成字符输入流
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			// 包装字符输入流变成缓冲字符流
			BufferedReader br = new BufferedReader(isr);
			
			
			// 临时字符串
			String tmpStr = null;
			// 将字符流中的内容读出来，放到一个可变字符串中
			StringBuilder sb = new StringBuilder();
			// 按行读取到sb中
			while((tmpStr = br.readLine()) != null)
			{
				sb.append(tmpStr);
				// 换行
				sb.append("\n");
			}
			// 得到待进行正则处理的目标母串
			String dealStr = sb.toString();
			
			
			String regexStr = regexString;
			// 编译模式串得到模式对象
			Pattern pattern = Pattern.compile(regexStr);
			// 获得匹配对象
			Matcher matcher = pattern.matcher(dealStr);
			// 进行匹配
			while(matcher.find())
			{
				// 获取第n个括号中的匹配内容
				String aimStr = matcher.group(n);
				// 返回目标结果字串
				return aimStr;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 如果找不到匹配内容，就返回一个空的字符串
		return "";
	}
	
	
	public static String[] getBeautyName2(String urlString, String regexString, int[] n)
	{
		try {
			
			
			
			// 获取url对象
			URL url = new URL(urlString);
			// 获取连接对象
			URLConnection conn = url.openConnection();
			// 获取网页内容的字节输入流
			InputStream is = conn.getInputStream();
			// 包装字节输入流变成字符输入流
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			// 包装字符输入流变成缓冲字符流
			BufferedReader br = new BufferedReader(isr);
			
			
			// 临时字符串
			String tmpStr = null;
			// 将字符流中的内容读出来，放到一个可变字符串中
			StringBuilder sb = new StringBuilder();
			// 按行读取到sb中
			while((tmpStr = br.readLine()) != null)
			{
				sb.append(tmpStr);
				// 换行
				sb.append("\n");
			}
			// 得到待进行正则处理的目标母串
			String dealStr = sb.toString();
			
			
			String regexStr = regexString;
			// 编译模式串得到模式对象
			Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
			/**
			 * Pattern.CASE_INSENSITIVE|Pattern.DOTALL这两个参数很重要：
			 * Pattern.CASE_INSENSITIVE:匹配时忽略大小写
			 * Pattern.DOTALL：匹配时使'.'字符真正做到可以匹配任意字符，包括换行符，如果不加此参数，只能匹配除了换行符以外的所有字符
			 */
			// 获得匹配对象
			Matcher matcher = pattern.matcher(dealStr);
			// 进行匹配
			while(matcher.find())
			{
				String[] strArr = new String[n.length];
				// 获取第n个括号中的匹配内容
				for(int i = 0; i < n.length; i++)
				{
					strArr[i] = matcher.group(n[i]);
				}
				// 返回目标结果字串
				return strArr;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 如果找不到匹配内容，就返回一个空的字符串
		return null;
	}
	
}
