package com.duyanhan.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.duyanhan.downloadHtml.DownloadHtml;

public class Test {

	public static void main(String[] args) {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("regex.properties"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		DownloadHtml dh = new DownloadHtml();
		String urlStr = "https://www.baidu.com/baidu.html?from=noscript";
		String charSet = "UTF-8";
		String regexStr = properties.getProperty("regex");
		// 获取正则表达式
//		System.out.println(regexStr);
		int[] n = {1, 3};
		List<String[]> aimStringList = null;
		try {
			aimStringList = dh.getAimStringList(urlStr, charSet, regexStr, n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(String[] strArray : aimStringList)
		{
			String aimString = "";
			for(String item : strArray)
			{
				aimString += item;
			}
			System.out.println(aimString);
		}
	}

}
