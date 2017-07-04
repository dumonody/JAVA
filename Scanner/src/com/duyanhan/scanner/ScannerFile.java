package com.duyanhan.scanner;
import java.io.File;
import java.util.Scanner;
/**
 * Scanner读取键盘内容
 * @author czkct
 *
 */
public class ScannerFile {

	public static void main(String[] args) throws Exception
	{
		// 将一个File对象作为Scanner的构造参数，Scanner读取文件内容
		Scanner sc = new Scanner(new File("D:\\MyCode\\Workspace_JavaSE_Project\\Scanner\\src\\test.txt"));
		
		// 判断是否还有下一行
		while(sc.hasNextLine())
		{
			// 输出文件中的下一行   注意：这里必须主动换行，因为sc.nextLine获取的是一行的内容，并不包括换行符
			System.out.println(sc.nextLine());
		}
	}
}
