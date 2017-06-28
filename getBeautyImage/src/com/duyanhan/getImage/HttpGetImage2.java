package com.duyanhan.getImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpGetImage2{

	private static final String FOLDERNAME = "beautyImage";
	private static String categoryfoldername = "";
	private static final String REGEXSTRING = "<h2.*>(.*?)</h2>.*1/(.*?)\\u9875</span>";
	private static String urlstring = "";
	
	public static void main(String[] args) {
		
		// �ȴ���һ���ļ��У�����ʢװͼƬ
		// �ȼ��һ���ļ����Ƿ���ڣ���������ڲŴ���
		File f = new File(FOLDERNAME);
		if(!f.exists())
		{
			// ��������ڲŴ���
			f.mkdir();
		}
			
			
		// ���ﲻ��д��GetImage.start()����Ϊstart�����ǷǾ�̬����
		new GetImage().start();

	}
	
	static class GetImage extends Thread{
		
		@Override
		public void run() {
			int index1 = 1700;
			
			for(int i = 0; i < 1210; i++)
			{
				// ��ʼ����һ����Ů��ͼƬ��
				// ע����һ����Ů��ͼ��������index1 + i;
				
				// ���°�����Ů���ֵ�url��ַ
				urlstring = "http://mm.bmtec.cn/html/xinggan/" + (index1 + i) + ".html";
				
				// �Ȼ�ȡ��Ů������
				String[] beautyNameAndPageNumber = RegexGetBeautyName.getBeautyName2(urlstring, REGEXSTRING, new int[]{1, 2});
				
				// ���·���Ŀ¼����
				categoryfoldername = (index1 + i)+ "-" +beautyNameAndPageNumber[0];
				
				// �ȴ���һ���ļ��У�����ʢװͼƬ
				// �ȼ��һ���ļ����Ƿ���ڣ���������ڲŴ���
				File f = new File("./" + FOLDERNAME + "/" + categoryfoldername);
				if(!f.exists())
				{
					// ��������ڲŴ���
					f.mkdir();
					// �����ɹ�
					System.out.println("�����ɹ�");
				}
				
				// ��ȡ��һ����Ů��ͼ����
				getinfo(index1 + i, Integer.parseInt(beautyNameAndPageNumber[1]));
			}
		}
		
		public void getinfo(int index1, int pageNumber)
		{
			System.out.println("��ǰ��Ůһ���� " + pageNumber + " ����ͼ");
			
			for (int index2 = 1; index2 <= pageNumber; index2 ++)
			{
				try {
					
					URL url = new URL("http://img1.mm131.com/pic/" + index1 + "/" + index2 + ".jpg");
					URLConnection  connection = url.openConnection();
					
					System.out.println("�������أ�" + url.toString());
					
					InputStream is = connection.getInputStream();
					// ��������������ͼƬ
					downloadImage(is, index1 + "" + index2 + ".jpg");
					// �ر�������
					is.close();
					System.out.println("���سɹ���");
					
				} catch (Exception e) {
					System.out.println("����ʧ�ܣ�");
					e.printStackTrace();
				}
			}
		}
		
		public void downloadImage(InputStream inputStream, String imageName){
			FileOutputStream fos = null;
			try {
				// ʵ�ʶ�ȡ���ֽ�
				int b;
				// ͼƬ�ļ�����ֽ���
				fos = new FileOutputStream(new File("./" + FOLDERNAME + "/" + categoryfoldername+ "/" + imageName));
				// ����������ȡ���ֽ�����b�У�Ȼ���ֽ�����bд�����������
				while((b = inputStream.read())!=-1)
				{
					fos.write(b);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				// �ر��ļ���
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
