package com.duyanhan.io.a.file;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileOpDemo2 {

	public static void main(String[] args) {

	// 获取一个目录下的所有内容的两种方式：
		// 注意：必须已经存在，且必须是目录，否则会有空指针异常！！！
		File dir = new File("C:\\Program Files");
		
	// 健壮性判断！！
		if(dir.exists() && dir.isDirectory())
		{
			// 如果只要此目录下的所有内容的名称：
			String[] names = dir.list();
			for(String name : names)
			{
				System.out.println(name);
			}
			
			
			// 如果要此目录下的所有内容的对象：
			// （更推荐这种，因为有了对象，可以对每个对象进行更多操作）
			File[] files = dir.listFiles();
			for(File file : files)
			{
				System.out.print(file + "   ");
				System.out.println(DateFormat.getDateTimeInstance().format(new Date(file.lastModified())));
			}
		}
	}

}
