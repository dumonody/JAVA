package com.duyanhan.downloadImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadCollection extends Thread {

	private int collectionNumber = DownloadAll.COLLECTIONBEGINNUM;	// 当前图片集的编号
	private String urlString = ""; // 当前图片集首页链接地址

	private String collectionName = "";			// 当前图片集的名称
	private int collectionTotalPage = 0;	// 当前图片集总页数
	
	private boolean notExist = false;	// 是否遍历下载当前图片集
	
	/**
	 * 构造
	 */
	public DownloadCollection(){}
	public DownloadCollection(int i) {
		//　更新当前图片集的编号
		this.collectionNumber = this.collectionNumber + i;
		this.urlString = "http://mm.bmtec.cn/index.php?xinggan/" + this.collectionNumber + ".html";
		try{
			// 获取图片集名称和图片集的图片张数
			String[] CollectionNameAndTotalPage = ImageRegex.getCollectionInfo(urlString, DownloadAll.REGEXSTRING, new int[]{1, 2});
			this.collectionName = collectionNumber + "-" + CollectionNameAndTotalPage[0];
			this.collectionTotalPage = Integer.parseInt(CollectionNameAndTotalPage[1]);
		}
		catch(Exception e)
		{
			System.out.println("当前图片集信息获取或不存在！跳过当前图片集！");
			notExist = true;
			e.printStackTrace();
		}
	}
	
	/**
	 * 线程执行体
	 */
	public void run()
	{
		// 如果当前图片集存在
		if(!notExist){
			// 先创建当前图片集文件夹
			new FileControl("./" + DownloadAll.FOLDERNAME + "/" + collectionName).createFile();
			System.out.println("当前美女一共有" + collectionTotalPage + "张图片！");
			
			// 遍历下载所有图片
			downloadCollectionAllImage();
		}
	}

	public void downloadCollectionAllImage()
	{
		for(int i = 1; i <= collectionTotalPage; i++)
		{
			try{
				URL url = new URL("http://mm.bmtec.cn/index.php?/xinggan/" + collectionNumber + (i==1?"":"_" + i) + ".html");
				URLConnection connection = url.openConnection();
				
				System.out.println("正在下载：" + url.toString());
				
				InputStream is = connection.getInputStream();
				// 根据输入流下载图片
				downloadImage(is, collectionNumber + "_" + (i < 10?"0" + i:i) + ".jpg");
				// 关闭输入流
				is.close();
				System.out.println("下载成功！");
			} catch (Exception e) {
				System.out.println("下载失败！");
				e.printStackTrace();
			}
		}
	}
	
	
	public void downloadImage(InputStream inputStream, String imageName){
		FileOutputStream fos = null;
		try {
			// 实际读取到字节
			int b;
			// 图片文件输出字节流
			fos = new FileOutputStream(new File("./" + DownloadAll.FOLDERNAME + "/" + collectionName+ "/" + imageName));
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
