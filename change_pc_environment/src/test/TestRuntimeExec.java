package test;

import java.io.IOException;

/**
 * ���������ⲿ����
 * @author czkct
 *
 */
public class TestRuntimeExec {

	public static void main(String[] args)
	{
		// ��ȡ����ʱ�����������
		Runtime rt = Runtime.getRuntime();
		// ��Ӧ�ó���
		try {
			// ����ָ��·����Ӧ�ó���
//			rt.exec("C:/Program Files (x86)/Tencent/QQ/Bin/QQScLauncher.exe");
			// �ر�ָ��·����Ӧ�ó���
			rt.exec("Taskkill /IM QQ.exe");
			// ����cmd�����ִ�в���
//			rt.exec("cmd /c start net start mysql");
//			rt.exec("cmd /c start net stop mysql");
		} catch (IOException e) {
			throw new RuntimeException("ָ����Ч��");
		}
	}
}
