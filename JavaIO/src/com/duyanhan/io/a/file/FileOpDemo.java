package com.duyanhan.io.a.file;

import java.io.File;
import java.io.IOException;

public class FileOpDemo {

	public static void main(String[] args) {
		
		try {
			File f = new File("C:\\test.abc");
			
//		创建文件
//			前提是：抽象路径名指向的文件(夹)不存在，才会返回true
			boolean b1 = f.createNewFile();
			System.out.println("创建"+(b1==true?"":"不")+"成功！");
			
		
//		判断文件是否存在
//			前提是：文件(夹)存在，才会返回true
			boolean b3 = f.exists();
			System.out.println("文件(夹)"+(b3==true?"":"不")+"存在！");
			
			
//		删除文件
//			前提是：文件存在，且不被占用，才会返回true
//			注意：删除的文件不会进入回收站，需要谨慎！！！
			boolean b2 = f.delete();
			System.out.println("删除"+(b2==true?"":"不")+"成功！");
		
//		对目录操作：创建、删除、判断是否存在
			File dir = new File("E:\\aa\\bb\\cc\\dd");
//		创建目录
			boolean b4 = dir.mkdirs();	// 代表在指定路径E:\\aa\\bb\\cc下创建dd目录
			boolean b5 = dir.mkdirs();	// 代表创建aa、bb、cc、dd多级目录，推荐使用这种
			System.out.println(b4);
			System.out.println(b5);
			
//		删除文件夹
//			前提是：待删除的目录中为空，没其它内容，才可以删除，返回true
			boolean b6 = dir.delete();
			System.out.println("删除"+(b6==true?"":"不")+"成功！");
			
//		判断是文件还是文件夹
//			前提是：文件(夹)已经存在，才可以判断
//			注意：这个很重要，不要认为有扩展名的就是文件，没有扩展名的就一定是目录
			File f2 = new File("E:\\java.txt");
			f2.mkdir();
			if(f2.exists())
			{
				System.out.println(f2.isFile());
				System.out.println(f2.isDirectory());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
