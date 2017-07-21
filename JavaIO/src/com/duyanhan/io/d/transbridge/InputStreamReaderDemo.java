package com.duyanhan.io.d.transbridge;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) throws Exception {

		// 我们要从文件中按指定解码格式UTF-8读出字符内容，必须有个底层的字节流;
		// 因为是文件，所以用FileInputStream最合适
		FileInputStream fis = new FileInputStream("testDir\\testFile4");
		
		// 再指定要求的编码格式UTF-8，构造出这个输入字符流
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		
		// 定义读取字符个数
		int len = 0;
		char[] buf  = new char[1024];
		
		// 循环读取字符：底层实现是：
		// 先通过FileInputStream读取文件中的字节到内部字节缓冲数组中
		// 然后将字节缓冲数组中的字节根据UTF-8码表查找出对应的文字
		// 再将这些文字放到buf字符数组中
		while((len = isr.read(buf)) != -1)
		{
			// 输出字符内容
			System.out.println(new String(buf, 0, len));
		}
		
		// 关闭资源：注意：输入流不像输出流，不需要flush，自然也没有这个方法
		isr.close();
	}

}
