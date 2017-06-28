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
			
			for(int i = 0; i < 3; i++)
			{
				// ��ʼ����һ����Ů��ͼƬ��
				// ע����һ����Ů��ͼ��������index1 + i;
				
				// ���°�����Ů���ֵ�url��ַ
				urlstring = "http://mm.bmtec.cn/html/xinggan/" + (index1 + i) + ".html";
				
				// �Ȼ�ȡ��Ů������
				String beautyName = RegexGetBeautyName.getBeautyName(urlstring, REGEXSTRING, 1);
				
				// ���·���Ŀ¼����
				categoryfoldername = (index1 + i)+ "-" +beautyName;
				
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
					
					System.out.println("�������أ�" + url.toString());
					// ��ȡ״̬��
					if (connection.getResponseCode() == 200)
					{
						InputStream is = connection.getInputStream();
						// ��������������ͼƬ
						downloadImage(is, index1 + "" + index2 + ".jpg");
						// �ر�������
						is.close();
						// ����2������Ϊ��һ��url���ж���׼��
						index2 ++;
						System.out.println("���سɹ���");
					}
					else {
						System.out.println("����ʧ�ܣ���������");
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
