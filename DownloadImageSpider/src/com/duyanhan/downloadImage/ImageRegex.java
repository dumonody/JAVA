package com.duyanhan.downloadImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 工具类：获取图片集的基本信息
 * @author czkct
 *
 */
public class ImageRegex {
	/**
	 * 若成功匹配，则返回匹配到的内容，否则返回null
	 * @param urlString		链接
	 * @param regexString	正则表达式
	 * @param n				n个匹配项
	 * @return				返回匹配的内容数组
	 */
	public static String[] getCollectionInfo(String urlString, String regexString, int[] n) throws Exception	// 异常向上抛出
	{
		// 获取URL对象
		URL url = new URL(urlString);
		// 获取连接对象
		URLConnection conn = url.openConnection();
		// 获取内容字符串
		String contentStr = getContentStringByConn(conn);
		// 编译(正则表达式)模式串得到模式对象
		Pattern pattern = Pattern.compile(regexString,  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
				/**
				 * Pattern.CASE_INSENSITIVE|Pattern.DOTALL这两个参数很重要：
				 * Pattern.CASE_INSENSITIVE:匹配时忽略大小写
				 * Pattern.DOTALL：匹配时使'.'字符真正做到可以匹配任意字符，包括换行符，如果不加此参数，只能匹配除了换行符以外的所有字符
				 */
		// 由模式对象和内容字符串获得匹配对象
		Matcher matcher = pattern.matcher(contentStr);
		// 进行匹配
		while(matcher.find())	// 这里虽然用了while，但是只要有一个符合的，就直接return了
		{
			// 动态创建一个元素个数为n的String数组
			String[] strArr = new String[n.length];
			// 为数组中的每个项赋值匹配到的对应的内容
			for(int i = 0; i < n.length; i++){
				strArr[i] = matcher.group(n[i]);
			}
			return strArr;
		}
		return null;
	}
	
	/**
	 * 根据连接获取内容字符串
	 * @param conn
	 * @return
	 */
	public static String getContentStringByConn(URLConnection conn)
	{
		try{
			// 获取网页内容的字节输入流
			InputStream is = conn.getInputStream();
			// 包装字节输入流变成字符输入流
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			// 包装字符输入流变成缓冲流
			BufferedReader br = new BufferedReader(isr);
			// 定义一个临时字符串
			String tempStr = null;
			// 定义一个可变字符串,这个就是待返回的内容串
			StringBuilder sb = new StringBuilder();
			// 将缓冲流中的内容按行读取到可变字符串中
			while((tempStr = br.readLine())!=null)
			{
				sb.append(tempStr);
				sb.append("\n");
			}
			return sb.toString();
		}
		catch(Exception e)
		{
			System.out.println("根据连接获取字符串异常!");
			e.printStackTrace();
		}
		// 如果异常,则返回空字符串
		return "";
	}
}
