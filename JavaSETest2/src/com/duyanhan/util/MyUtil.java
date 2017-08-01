package com.duyanhan.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtil{

	public Map<String, Integer> Count(String str)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0, len = str.length(); i < len; i++)
		{
			String key = str.substring(i, i+1);
			if(map.get(key) == null)
			{
				map.put(key, 1);
			}
			else
			{
				map.put(key, map.get(key)+1);
			}
			
		}
		return map;
	}
	
	public String compare(String str)
	{
		int pos = str.indexOf("=");
		String ans = str.substring(0, pos+1);
		str = str.substring(pos+1, str.length());
		str = str.replace("{{", "");
		str = str.replace("}}", "");
		str = str.replace("},{", "-");	// 为什么不能用"|"
//		System.out.println(str);
		String[] stringArray = str.split("-");	// 为什么不能用split("},{")
//		for(String x : stringArray)
//		{
//			System.out.println(x);
//		}
		String[] numStr1 = stringArray[0].split(",");
		String[] numStr2 = stringArray[1].split(",");
//		System.out.println(numStr1);
//		System.out.println(numStr2);
		Integer max1 = Integer.MAX_VALUE;
		Integer max2 = Integer.MAX_VALUE;
		for(int i = 0, len = numStr1.length; i < len; i++)
		{	
			String tmpStr = numStr1[i];
			if(!tmpStr.trim().equals(""))
			{
				int tmp = Integer.parseInt(numStr1[i]);
				if(tmp < max1) max1 = tmp;
			}
		}
		for(int i = 0, len = numStr2.length; i < len; i++)
		{
			String tmpStr = numStr2[i];
			if(!tmpStr.trim().equals(""))
			{
				int tmp = Integer.parseInt(numStr2[i]);
				if(tmp < max2) max2 = tmp;
			}
		}
		ans = ans + "{" + max1 + "," + max2 + "}";
		return ans;
	}
	
	public String myWord(String str)
	{
		List<String> list = new ArrayList<String>();
		String ans = null;
		String regexStr = "[A-Za-z]*";
		Pattern pattern = Pattern.compile(regexStr,  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		Matcher matcher = pattern.matcher(str);
		int index = 0; 
		int len = 0;
		while(matcher.find())
		{
			String tmp = matcher.group();
			list.add(tmp);
			if(len < tmp.length())
			{
				len = tmp.length();
				index = list.size()-1;
			}
		}
		ans = list.get(index);
		return ans;
	}
	
	public void myPrint()
	{
		for(int i = 1; i <= 7; i++)	// 共七行
		{
			// 左右对称，每一行有  |4-i|*2个空格， 7-|4-i|*2个星号
			// 空格
			for(int j = 0, len = Math.abs(4-i); j < len; j++)
			{
				System.out.print(" ");
			}
			// 星号
			for(int j = 0, len = 7 - Math.abs(4-i)*2; j < len; j++)
			{
				System.out.print("*");
			}
		/*	// 空格   右边的空格可以省略
			for(int j = 0, len = Math.abs(4-i); j < len; j++)
			{
				System.out.print(" ");
			}*/
			System.out.println();
		}
	}
}
