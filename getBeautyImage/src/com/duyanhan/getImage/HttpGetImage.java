package com.duyanhan.getImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetImage {

	private static final String FOLDERNAME = "beautyImage";
	private static String categoryfoldername = "";
	private static final String REGEXSTRING = "<h2.*>(.*?)</h2>";
	private static String urlstring = "";
	
	public static void main(String[] args) {
		
		// 先创建一个文件夹，用来盛装图片
		// 先检测一下文件夹是否存在，如果不存在才创建
		File f = new File(FOLDERNAME);
		if(!f.exists())
		{
			// 如果不存在才创建
			f.mkdir();
		}
			
			
		// 这里不能写成GetImage.start()，因为start方法是非静态方法
		new GetImage().start();

	}
	
	static class GetImage extends Thread{
		
		@Override
		public void run() {
			int index1 = 1700;
			
			for(int i = 0; i < 3; i++)
			{
				// 开始爬下一个美女的图片了
				// 注意下一个美女的图集索引是index1 + i;
				
				// 更新包含美女名字的url地址
				urlstring = "http://mm.bmtec.cn/html/xinggan/" + (index1 + i) + ".html";
				
				// 先获取美女的名字
				String beautyName = RegexGetBeautyName.getBeautyName(urlstring, REGEXSTRING, 1);
				
				// 更新分类目录名称
				categoryfoldername = (index1 + i)+ "-" +beautyName;
				
				// 先创建一个文件夹，用来盛装图片
				// 先检测一下文件夹是否存在，如果不存在才创建
				File f = new File("./" + FOLDERNAME + "/" + categoryfoldername);
				if(!f.exists())
				{
					// 如果不存在才创建
					f.mkdir();
					// 创建成功
					System.out.println("创建成功");
				}
				
				getinfo(index1 + i);
			}
		}
		
		public void getinfo(int index1)
		{
			int index2 = 1;
			try {
				
				while(true)
				{
					URL url = new URL("http://img1.mm131.com/pic/" + index1 + "/" + index2 + ".jpg");
					HttpURLConnection  connection = (HttpURLConnection) url.openConnection();
					
					System.out.println("正在下载：" + url.toString());
					// 获取状态码
					if (connection.getResponseCode() == 200)
					{
						InputStream is = connection.getInputStream();
						// 根据输入流下载图片
						downloadImage(is, index1 + "" + index2 + ".jpg");
						// 关闭输入流
						is.close();
						// 索引2自增，为下一个url的判断做准备
						index2 ++;
						System.out.println("下载成功！");
					}
					else {
						System.out.println("下载失败！更新索引");
						break;
					}
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void downloadImage(InputStream inputStream, String imageName){
			FileOutputStream fos = null;
			try {
				// 实际读取到字节
				int b;
				// 图片文件输出字节流
				fos = new FileOutputStream(new File("./" + FOLDERNAME + "/" + categoryfoldername+ "/" + imageName));
				// 从输入流读取到字节数组b中，然后字节数组b写出到输出流中
				while((b = inputStream.read())!=-1)
				{
					fos.write(b);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				// 关闭文件流
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
