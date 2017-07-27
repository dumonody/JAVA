package com.duyanhan.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.duyanhan.downloadHtml.DownloadHtml;
import com.duyanhan.util.MakeList;

public class Test {

	public static void main(String[] args) {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("regex.properties"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		DownloadHtml dh = new DownloadHtml();
		String urlStr = properties.getProperty("urlStr");
		String charSet = properties.getProperty("charSet");
		String regexStr = properties.getProperty("regex");
		// 获取正则表达式
//		System.out.println(regexStr);
		int[] n = {1, 3};
		List<String[]> aimStringList = null;
		try {
			aimStringList = dh.getAimStringList(urlStr, charSet, regexStr, n);
			new MakeList().makeListByAimStringList(aimStringList, "HTML5.txt", charSet);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
