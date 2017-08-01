package com.duyanhan.test;

import java.util.Map;

import com.duyanhan.synchronizedpkg.MyNum;
import com.duyanhan.synchronizedpkg.PrintChar;
import com.duyanhan.synchronizedpkg.PrintNum;
import com.duyanhan.util.MyUtil;

public class Test {

	public static void main(String[] args) {

		// 第一题
		MyUtil myUtil = new MyUtil();
		// 假设输入为aaabbbccc
		Map<String, Integer> map = myUtil.Count("aaabbbccc");
		for (String string : map.keySet()) {
			System.out.println(string + " " + map.get(string));
		}
		
		
		// 第二题
		System.out.println(myUtil.compare("int arr={{5,6,1,16},{7,3,9}}"));
		
		
		// 第三题
		System.out.println(myUtil.myWord("abc,cc a title.1122dd"));
		
		// 第四题
		myUtil.myPrint();
		
		// 第五题
		MyNum myNum = new MyNum(6);	// 假设打印长度为6
		new Thread(new PrintNum(myNum)).start();
		new Thread(new PrintChar(myNum)).start();
		
		// 第六题在Test2中，附sql文件
	}

}
