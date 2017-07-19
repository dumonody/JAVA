package com.duyanhan.io.b.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo3 {

	public static void main(String[] args){

		File testFile = new File("testDir\\testFile");
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(testFile);
			byte[] data = "内容".getBytes();
			fos.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos!=null)
			{
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException();
				}
			}
		}
	}
}
