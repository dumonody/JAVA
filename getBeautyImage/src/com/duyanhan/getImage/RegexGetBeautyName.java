package com.duyanhan.getImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGetBeautyName {

	/**
	 * ����ƥ�����Ů������
	 * @param urlString  Ŀ����ҳ��url
	 * @param regexString  ������ʽ�ַ���
	 * @param n   Ҫ��ȡ�ĵ�n�������е�����
	 * @return  ƥ�����Ů������
	 */
	public static String getBeautyName(String urlString, String regexString, int n)
	{
		try {
			
			// ��ȡurl����
			URL url = new URL(urlString);
			// ��ȡ���Ӷ���
			URLConnection conn = url.openConnection();
			// ��ȡ��ҳ���ݵ��ֽ�������
			InputStream is = conn.getInputStream();
			// ��װ�ֽ�����������ַ�������
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			// ��װ�ַ���������ɻ����ַ���
			BufferedReader br = new BufferedReader(isr);
			
			
			// ��ʱ�ַ���
			String tmpStr = null;
			// ���ַ����е����ݶ��������ŵ�һ���ɱ��ַ�����
			StringBuilder sb = new StringBuilder();
			// ���ж�ȡ��sb��
			while((tmpStr = br.readLine()) != null)
			{
				sb.append(tmpStr);
				// ����
				sb.append("\n");
			}
			// �õ��������������Ŀ��ĸ��
			String dealStr = sb.toString();
			
			
			String regexStr = regexString;
			// ����ģʽ���õ�ģʽ����
			Pattern pattern = Pattern.compile(regexStr);
			// ���ƥ�����
			Matcher matcher = pattern.matcher(dealStr);
			// ����ƥ��
			while(matcher.find())
			{
				// ��ȡ��n�������е�ƥ������
				String aimStr = matcher.group(n);
				// ����Ŀ�����ִ�
				return aimStr;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ����Ҳ���ƥ�����ݣ��ͷ���һ���յ��ַ���
		return "";
	}
	
	
	public static String[] getBeautyName2(String urlString, String regexString, int[] n)
	{
		try {
			
			
			
			// ��ȡurl����
			URL url = new URL(urlString);
			// ��ȡ���Ӷ���
			URLConnection conn = url.openConnection();
			// ��ȡ��ҳ���ݵ��ֽ�������
			InputStream is = conn.getInputStream();
			// ��װ�ֽ�����������ַ�������
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			// ��װ�ַ���������ɻ����ַ���
			BufferedReader br = new BufferedReader(isr);
			
			
			// ��ʱ�ַ���
			String tmpStr = null;
			// ���ַ����е����ݶ��������ŵ�һ���ɱ��ַ�����
			StringBuilder sb = new StringBuilder();
			// ���ж�ȡ��sb��
			while((tmpStr = br.readLine()) != null)
			{
				sb.append(tmpStr);
				// ����
				sb.append("\n");
			}
			// �õ��������������Ŀ��ĸ��
			String dealStr = sb.toString();
			
			
			String regexStr = regexString;
			// ����ģʽ���õ�ģʽ����
			Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
			/**
			 * Pattern.CASE_INSENSITIVE|Pattern.DOTALL��������������Ҫ��
			 * Pattern.CASE_INSENSITIVE:ƥ��ʱ���Դ�Сд
			 * Pattern.DOTALL��ƥ��ʱʹ'.'�ַ�������������ƥ�������ַ����������з���������Ӵ˲�����ֻ��ƥ����˻��з�����������ַ�
			 */
			// ���ƥ�����
			Matcher matcher = pattern.matcher(dealStr);
			// ����ƥ��
			while(matcher.find())
			{
				String[] strArr = new String[n.length];
				// ��ȡ��n�������е�ƥ������
				for(int i = 0; i < n.length; i++)
				{
					strArr[i] = matcher.group(n[i]);
				}
				// ����Ŀ�����ִ�
				return strArr;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ����Ҳ���ƥ�����ݣ��ͷ���һ���յ��ַ���
		return null;
	}
	
}
