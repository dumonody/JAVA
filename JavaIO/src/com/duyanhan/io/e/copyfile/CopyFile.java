package com.duyanhan.io.e.copyfile;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {

	public static void main(String[] args) throws Exception {

		/*
		 * 练习：复制文本文件
		 * 思路：
		 * 1、既然是文本文件，涉及到编码表，要使用字符流（用字节流也可以复制，但是想要拿到指定文字内容则不方便）
		 * 2、操作的是文本文件，涉及到硬盘
		 * 3、有指定码表吗？没有，所以使用默认
		 * 依上可知：操作的是文件，使用默认码表：那么使用字符流操作文件的便捷类（FileReader和FileWriter）最合适
		 */
		// 输入流绑定数据源，输出流绑定目标文件
		FileReader fr = new FileReader("testDir\\testFile4");
		FileWriter fw = new FileWriter("testDir\\testFile4_copy");
		
		// 为了提高效率，定义一个字符数组
		int len = 0; // 获取的字符个数
		char[] buf = new char[1024];
		
		// 开始拷贝
		while((len = fr.read(buf)) != -1)
		{
			fw.write(new String(buf, 0, len));
		}
		
		// 关闭资源
		fw.close();
		fr.close();
	}

}
