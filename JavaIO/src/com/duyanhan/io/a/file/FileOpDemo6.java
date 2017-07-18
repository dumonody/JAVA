package com.duyanhan.io.a.file;

import java.io.File;

public class FileOpDemo6 {

	public static void main(String[] args) {

		File dir = new File("D:\\MySoft\\MyBlog\\myhexo\\source");
		
		if(dir.exists() && dir.isDirectory())
		{
			listAllFilesByCurrentDir(dir);
		}
		
	}
	
	public static void listAllFilesByCurrentDir(File dir)
	{
		// 打印文件夹名称
		System.out.println(dir);
		File[] files = dir.listFiles();
		for(File file : files)
		{
			if(file.isDirectory())
			{
				listAllFilesByCurrentDir(file);
			}
			else 
			{
				System.out.println(file);
			}
		}
	}
}
