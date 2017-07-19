package com.duyanhan.io.b.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo3 {

	public static void main(String[] args)
	{
		File testFile = new File("testDir\\testFile");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(testFile);
			
			// 如果数据源文件很大，字节数很多，会导致堆内存溢出
			byte[] buf = new byte[fis.available()];	
			fis.read(buf);
			// 读取内容到缓冲字节数组中
			System.out.println(new String(buf));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null)
			{
				try {
					fis.close();
				} catch (IOException e) {
					throw new RuntimeException();
				}
				fis = null;
			}
		}
	}
}
