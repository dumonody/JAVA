package com.duyanhan.dotask;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.duyanhan.gui.MyFrame;

/**
 * ִ�л������񣺴򿪻�������رջ���
 * @author czkct
 *
 */
public class DoMyTask {

	// ����һ�������������б�
	List<Map<String,String>> commandList1;
	// ����һ���ر����������б�
	List<Map<String,String>> commandList0;
	
	
	/**
	 * �вι��죬��ȡ���������б�������б�Ĵ������á��Լ���ǰҪ����Ļ���������
	 * @param mf	��������
	 * @param index	��������������
	 */
	public DoMyTask(MyFrame mf, int index) 
	{
		// ��ȡindex������Ӧ�Ĵ��ڶ����еĻ��������б�
		List<Map<List<Map<String,String>>,List<Map<String,String>>>> totalTaskStartAndStopArrayList = mf.getTotalTaskStartAndStopArrayList();
		Map<List<Map<String,String>>,List<Map<String,String>>> map = totalTaskStartAndStopArrayList.get(index);
		// �ֱ��ȡkey��value��key�Ǵ����������б�value�ǹر����������б�
		// ��ת��ΪSet
		Set<Entry<List<Map<String, String>>, List<Map<String, String>>>> entrySet = map.entrySet();
		// ����Set����ȡ����Ψһһ��key,��value
		for (Entry<List<Map<String, String>>, List<Map<String, String>>> entry : entrySet) {
			// ���´����������б�
			this.commandList1 = entry.getKey();
			// ���¹ر����������б�
			this.commandList0 = entry.getValue();
		}
	}

	/**
	 * ִ������ķ���
	 * @param i  iΪ1����ʾ�򿪻����� iΪ0����ʾ�رջ���
	 */
	public void doTasks(int i) {
		
		// ��� iΪ1����ʾ�򿪻����� iΪ0����ʾ�رջ���
		if (i == 1)
		{
			// �򿪻���,ִ��commandList1�б�
			this.executeTaskList(commandList1);
		}
		else 
		{
			// �رջ�����ִ��commandList0�б�
			this.executeTaskList(commandList0);
		}
	}

	/**
	 * ִ�������б�
	 * @param commandList12
	 */
	private void executeTaskList(List<Map<String, String>> commandList12) {
		
		// ��ȡ����ʱ��������
		Runtime runtime = Runtime.getRuntime();
		
		// ���List��ÿ��MapԪ���ж�ֻ��һ����ֵ�ԣ������ֵ�Ե�key���Ǵ�ִ�е������ֵ�Ե�value���Ƕ�ִ�����������
		for (int i = 0; i < commandList12.size(); i++)
		{
			
			// ����
			String command = "";
			// ��������
			String commandDisc = "";
			
			// ��ȡ��ǰ��ִ��������������ڵ�map����
			Map<String, String> currCommandMap = commandList12.get(i);
			// ����ת����Set����
			Set<Entry<String,String>> entrySet = currCommandMap.entrySet();
			// ����-����ȡSet������Ψһ��Ԫ��
			for (Entry<String, String> entry : entrySet) {
				// ��ȡ����
				command = entry.getKey();
				// ��ȡ��������
				commandDisc = entry.getValue();
			}
			
			// ִ����������
			this.executeCommand(runtime, command, commandDisc);
			
		}
	}
	
	/**
	 * ִ�е����������ӡ������
	 * @param runtime 
	 */
	private void executeCommand(Runtime runtime, String cmd, String disc)
	{
		try {
			// ִ������
			runtime.exec(cmd);
			// ��ӡִ������������
			System.out.println(disc + "����ִ�гɹ���");
		} catch (IOException e) {
			// ����ִ��ʧ��
			System.out.println(disc + "����ִ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}

}
