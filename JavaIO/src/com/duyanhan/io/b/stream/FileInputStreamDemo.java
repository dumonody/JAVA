package com.duyanhan.io.b.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args)
	{
		File testFile = new File("testDir\\testFile");
		
		FileInputStream fis = null;
		try {
			// 将 字节读取流 与 数据源 关联起来
			fis = new FileInputStream(testFile);
			
			// 每次读取一个字节并且输出
			int b = 0;
			while((b = fis.read())!=-1)
			{
				System.out.println(b);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
