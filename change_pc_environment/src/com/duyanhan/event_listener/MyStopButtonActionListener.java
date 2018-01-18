package com.duyanhan.event_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.duyanhan.dotask.DoMyTask;
import com.duyanhan.gui.MyFrame;

/**
 * �رջ�����ť�ļ����¼���ʵ��ActionListener����ӿ�
 * @author czkct
 *
 */
public class MyStopButtonActionListener implements ActionListener {

	// ����һ�����ڵ�����
	private MyFrame mf;
	
	// ����һ������
	private int index;
	
	// �вι��죬��ȡ���ڵ����á��Լ���ǰ����������
	public MyStopButtonActionListener(MyFrame myFrame, int index) {
		this.mf = myFrame;
		this.index = index;
	}

	// ����رջ����¼����¼�������
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("�û�����˹رջ�����ť��");
		// ����һ��ִ������Ķ���
		DoMyTask dmt = new DoMyTask(mf, index);
		// ִ�д򿪻�������
		dmt.doTasks(0);
	}

}
