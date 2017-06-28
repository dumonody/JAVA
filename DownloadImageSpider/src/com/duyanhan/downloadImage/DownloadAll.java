package com.duyanhan.downloadImage;

public class DownloadAll {

	public static final String FOLDERNAME = "beautyImage";	// 所有图片的总文件夹
	public static final String REGEXSTRING = "<h2.*>(.*?)</h2>.*1/(.*?)\\u9875</span>";	// 匹配昵称和图片张数的正则表达式
	public static final int COLLECTIONBEGINNUM = 1700;	// 图片集起始编号
	public static final int RANGE = 0;	// 图片集编号自增范围
	
	public static void main(String[] args) {
		
		// 先创建包含所有图片的文件夹
		new FileControl(FOLDERNAME).createFile();
		
		for(int i = 0; i <= RANGE; i++)
		{
			// 单独启动一个线程下载当前这个编号对应的图片集
			new DownloadCollection(i).start();
		}
		
	}

}
