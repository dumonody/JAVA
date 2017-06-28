package com.duyanhan.downloadImage;
import java.io.File;


public class FileControl {

	// 文件名或文件夹名称
	private String name = "";
	
	public FileControl(){}
	
	public FileControl(String name){
		this.name = name;
	}

	// 判断文件夹是否存在,若不存在则创建
	public void createFile()
	{
		// 根据(路径)名称,创建一个文件/文件夹对象
		File f = new File(name);
		
		// 如果不存在此文件/文件夹, 则创建
		if(!f.exists())
		{
			f.mkdir();
		}
	}
}
