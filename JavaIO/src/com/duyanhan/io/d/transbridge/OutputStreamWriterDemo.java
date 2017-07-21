package com.duyanhan.io.d.transbridge;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {

	public static void main(String[] args) throws Exception {

		// 我们要向文件中按指定编码格式UTF-8输出字符内容，必须有个底层的字节流;
		// 因为是文件，所以用FileOutputStream最合适
		FileOutputStream fos = new FileOutputStream("testDir\\testFile4");
		
		// 再指定要求的编码格式UTF-8，构造出这个输出字符流
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		
		// 输出内容:底层实现是：write方法将这一句话写到字节缓冲区中，
		// 这些字节是按照指定的编码格式UTF-8编码然后保存进去的，暂时还没有写到文件中
		osw.write("你好，谢谢，再见！");
		
		// 这里可以不用调用flush()方法，因为只输出一次，直接利用close()方法的刷新即可。
		
		// 关闭资源：先刷新，将字节缓冲区(字节数组)中的内容刷到文件中，然后关闭流
		osw.close();
	}

}
