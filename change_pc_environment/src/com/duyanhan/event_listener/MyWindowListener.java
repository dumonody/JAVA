package com.duyanhan.event_listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ������ҵĴ��ڼ������࣬�̳��ڴ��ڼ�������������
 * @author czkct
 *
 */
public class MyWindowListener extends WindowAdapter {

	// ʵ�ִ����¼��ķ���
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("�û���ͼ�رմ��ڣ�");
		// �˳�����
		System.exit(0);
	}
}
