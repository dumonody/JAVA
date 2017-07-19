package com.duyanhan.io.b.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {

	public static void main(String[] args)
	{
		File testFile = new File("testDir\\testFile");
		
		FileInputStream fis = null;
		try {
			// 将 字节读取流 与 数据源 关联起来
			fis = new FileInputStream(testFile);
			
			// 创建一个缓冲字节数组
			byte[] buf = new byte[1024];
			
			// 读取内容到缓冲字节数组中
			int len = 0; 
			while((len = fis.read(buf))!=-1)
			{
				System.out.println(new String(buf, 0, len));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
