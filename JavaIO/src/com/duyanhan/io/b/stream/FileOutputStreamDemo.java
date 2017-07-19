package com.duyanhan.io.b.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {

		// 创建一个临时目录对象
		File dir = new File("testDir");
		if(!dir.exists())
		{
			dir.mkdirs();	// 如果目录不存在，则临时创建
		}
		
		// 在上面的临时目录下创建一个测试文件
		File testFile = new File(dir, "testFile");
		
		// 为testFile文件创建文件输出流（注意：从内存流向文件）
		FileOutputStream fos = new FileOutputStream(testFile);
		// 获取内存中的数据
		byte[] data = "内存中的数据".getBytes();
		// 将内存中的数据借助testFile文件的文件输出流写入到testFile文件中
		fos.write(data);
		
		// 关闭资源
		fos.close();
	}
}
