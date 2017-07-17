package com.duyanhan.io.a.file;

import java.io.File;

public class FileDemo {

	public static void main(String[] args)
	{
		
//		将demoTest封装成File对象
//		demoTest可以是[文件]，也可以是[文件夹]
//		demoTest可以[存在]，也可以[不存在]
//		都可以封装成一个File对象
//		[字符串路径]中的斜杠分隔符可以是单个正斜杠/,或者两个反斜杠\\（由于转义，所以反斜杠需要两个）
		 
		
		String pathName = "C:\\Users\\czkct\\Desktop\\demoTest";
		File f1 = new File(pathName);
		System.out.println(f1);	// 输出的是“C:\Users\czkct\Desktop\demoTest”
		

		String parent = "C:\\Users\\czkct\\Desktop";
		String child = "demoTest";
		File f2 = new File(parent, child);
		System.out.println(f2);	// 输出的是“C:\Users\czkct\Desktop\demoTest”
		
		
		File f3 = new File(parent);
		File f4 = new File(f3, child);
		System.out.println(f4);	// 输出的是“C:\Users\czkct\Desktop\demoTest”
		
		
//		路径的跨平台写法：使用默认名称分隔符File.separator
		String pathName2 = "czkct" + File.separator + "Desktop" + File.separator + "demoTest";
		System.out.println(pathName2);	// 输出的是“czkct\Desktop\demoTest”
	}
}
