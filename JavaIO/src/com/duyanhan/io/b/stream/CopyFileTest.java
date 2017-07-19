package com.duyanhan.io.b.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileTest {

	public static void main(String[] args) throws IOException {

		// 拷贝文件
		// 原理：读取一个文件中的数据，并将这些读入到的数据写入另一个文件中
		
		// 1、明确源文件和目的文件
		File srcFile = new File("testDir\\testFile");
		File destFile = new File("testDir\\testFile2");
		
		// 2、明确字节流输入流和源文件关联，字节输出流和目的文件关联
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		
		// 3、定义一个缓冲数组
		byte[] buf = new byte[2048];
		int len = 0;
		// 每次从源文件读取一个字节数组，并将字节数组写入到目的文件中
		while((len = fis.read(buf)) != -1)
		{
			fos.write(buf, 0, len);
		}
		
		// 4、关闭资源
		fos.close();
		fis.close();
	}

}
