package com.duyanhan.io.a.file;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;

public class FileMethodDemo {

	public static void main(String[] args) {

		File f = new File("src/com/duyanhan/io/a/file/FileMethodDemo.java");
		// 获取文件对象的绝对路径
		System.out.println(f.getAbsolutePath());	// D:\MyCode\Workspace_JavaSE_Project\JavaIO\src\com\duyanhan\io\a\file\FileMethodDemo.java
		
		// 获取File对象中封装的路径，封装进去的是什么路径，获取的就是什么路径
		System.out.println(f.getPath());
		
		// 获取文件名
		System.out.println(f.getName());	// FileMethodDemo.java
		
		// 获取文件最后的修改时间   先获取毫秒数
		long time = f.lastModified();
		// 再将毫秒数转换成Date类型，然后格式化成日期字符串
		String str_date = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(new Date(time));
		System.out.println(str_date);
		
		// 判断文件是否存在
		System.out.println(f.exists());
		
		// 获取文件字节数
		System.out.println(f.length());
		
	}

}
