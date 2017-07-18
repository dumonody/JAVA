package com.duyanhan.io.a.file;

import java.io.File;

public class FileOpDemo3 {

	public static void main(String[] args) {

		File dir = new File("C:\\Program Files");
		
		if(dir.exists() && dir.isDirectory())
		{
			File[] files = dir.listFiles(new JavaFileFileter());
			for(File f : files)
			{
				System.out.println(f);
			}
		}
		
	}
}
