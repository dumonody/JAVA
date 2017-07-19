package com.duyanhan.io.b.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {

	// 定义一个换行用的常量
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {

		File dir = new File("testDir");
		if(!dir.exists())
		{
			dir.mkdirs();	// 如果目录不存在，则临时创建
		}
		
		File testFile = new File(dir, "testFile");
		
		
		// 注意此处的构造多了一个是否允许追加内容的参数
		FileOutputStream fos = new FileOutputStream(testFile, true);
		
		
		byte[] data = "追加的内容".getBytes();
		
		fos.write(data);
		
		// 注意此处：向已有文件中追加换行的写法
		// 这里不用\r\n或者\n，因为前者是windows下的换行，后者是unix下的换行，为了跨平台使用如下写法
		byte[] data2 = (LINE_SEPARATOR + "换行后追加的内容").getBytes();
		
		fos.write(data2);
		
		fos.close();
	}
}
