package test;

import com.duyanhan.gui.MyFrame;
import com.duyanhan.util.ReadXMLUtil;

public class Test {

	public static void main(String[] args) {
	/*	// ��ȡһ����ȡxml�ļ�������ʵ��
		ReadXMLUtil readXMLUtil = ReadXMLUtil.getInstance();
		// �Դ�ʵ������readAllXML����
		readXMLUtil.readAllXML();
		// ��ȡ��ʵ����EnvXmlList������ӡ
		System.out.println(readXMLUtil.getEnvXmlList());
		// ��ȡ�����б�
		System.out.println(readXMLUtil.getTotalTaskStartAndStopArrayList());*/
		
		// ��ȡһ����ȡxml�ļ�������ʵ��
		ReadXMLUtil readXMLUtil = ReadXMLUtil.getInstance();
		// �Դ�ʵ������readAllXML����:��ȡ���е�XML�ļ�
		readXMLUtil.readAllXML();
		// ʹ�ô�ʵ����ʼ�����ڶ���
		MyFrame mf = MyFrame.getInstance();
		mf.init(readXMLUtil);
	}
}
