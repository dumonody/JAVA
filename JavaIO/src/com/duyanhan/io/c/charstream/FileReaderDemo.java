package com.duyanhan.io.c.charstream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {

		// 字符流和字节流的方法都很相似！！！构造方法也是
		FileReader fr = new FileReader("testDir\\testFile");	// FileReader这个字符流的底层就是FileInputStream字节流
		
		// 定义一个字符的值
		int ch = 0;
		// 使用字符流每读取一个字符，底层实现是：读取多个字节(具体读多少，是将字符集拿到码表中去查询然后再确定)，然后将这些字节转换成一个字符
		while((ch = fr.read()) != -1)
		{
			// 将每个字符值转换成字符
			System.out.print((char)ch);
		}
	}

}
