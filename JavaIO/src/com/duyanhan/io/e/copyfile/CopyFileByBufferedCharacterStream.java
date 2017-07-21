package com.duyanhan.io.e.copyfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFileByBufferedCharacterStream {

	public static void main(String[] args) throws Exception {

		BufferedReader bufr = new BufferedReader(new FileReader("testDir\\testFile5"));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("testDir\\testFile5_copy"));
		
		// 循环读写一行数据
		String line = null;
		while((line = bufr.readLine()) != null)
		{
			bufw.write(line);
			// 写入换行(跨平台的换行)
			bufw.newLine();
			// 写多行，一定要用flush刷新
			bufw.flush();
		}
		
		// 关闭流
		bufw.close();
		bufr.close();
	}
}
