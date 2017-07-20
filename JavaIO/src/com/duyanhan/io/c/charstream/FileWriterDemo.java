package com.duyanhan.io.c.charstream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("testDir\\testFile3");
		
		// 写出这行文字的底层实现为：将这行文字先根据字符集查找码表，
		// 然后编码成字节，并且保存到缓冲字节数组中,并不是直接写到目标文件中
		fw.write("你好，谢谢，再见！");
		
		// 这里只写一次，可以省略此行代码
		fw.flush();
		
		// 关闭资源
		fw.close();
	}

}
