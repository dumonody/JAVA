package com.duyanhan.event_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.duyanhan.dotask.DoMyTask;
import com.duyanhan.gui.MyFrame;

/**
 * �򿪻�����ť�ļ����¼���ʵ��ActionListener����ӿ�
 * @author czkct
 *
 */
public class MyStartButtonActionListener implements ActionListener {
	
	// ����һ�����ڵ�����
	private MyFrame mf;
	
	// ����һ������
	private int index;
	
	// �вι��죬��ȡ���ڵ����á��Լ���ǰ����������
	public MyStartButtonActionListener(MyFrame myFrame, int index) {
		this.mf = myFrame;
		this.index = index;
	}

	// ����򿪻����¼����¼�������
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("�û�����˴򿪻�����ť��");
		// ����һ��ִ������Ķ���
		DoMyTask dmt = new DoMyTask(mf, index);
		// ִ�д򿪻�������
		dmt.doTasks(1);
	}

}
