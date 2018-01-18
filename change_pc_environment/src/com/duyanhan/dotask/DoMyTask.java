package com.duyanhan.dotask;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.duyanhan.gui.MyFrame;

/**
 * 执行环境任务：打开环境、或关闭环境
 * @author czkct
 *
 */
public class DoMyTask {

	// 创建一个打开任务命令列表
	List<Map<String,String>> commandList1;
	// 创建一个关闭任务命令列表
	List<Map<String,String>> commandList0;
	
	
	/**
	 * 有参构造，获取包含环境列表和任务列表的窗口引用、以及当前要处理的环境的索引
	 * @param mf	窗口引用
	 * @param index	待处理环境的索引
	 */
	public DoMyTask(MyFrame mf, int index) 
	{
		// 获取index索引对应的窗口对象中的环境任务列表
		List<Map<List<Map<String,String>>,List<Map<String,String>>>> totalTaskStartAndStopArrayList = mf.getTotalTaskStartAndStopArrayList();
		Map<List<Map<String,String>>,List<Map<String,String>>> map = totalTaskStartAndStopArrayList.get(index);
		// 分别获取key和value，key是打开任务命令列表，value是关闭任务命令列表
		// 先转化为Set
		Set<Entry<List<Map<String, String>>, List<Map<String, String>>>> entrySet = map.entrySet();
		// 遍历Set，获取其中唯一一个key,和value
		for (Entry<List<Map<String, String>>, List<Map<String, String>>> entry : entrySet) {
			// 更新打开任务命令列表
			this.commandList1 = entry.getKey();
			// 更新关闭任务命令列表
			this.commandList0 = entry.getValue();
		}
	}

	/**
	 * 执行任务的方法
	 * @param i  i为1，表示打开环境， i为0，表示关闭环境
	 */
	public void doTasks(int i) {
		
		// 如果 i为1，表示打开环境， i为0，表示关闭环境
		if (i == 1)
		{
			// 打开环境,执行commandList1列表
			this.executeTaskList(commandList1);
		}
		else 
		{
			// 关闭环境，执行commandList0列表
			this.executeTaskList(commandList0);
		}
	}

	/**
	 * 执行命令列表
	 * @param commandList12
	 */
	private void executeTaskList(List<Map<String, String>> commandList12) {
		
		// 获取运行时环境对象
		Runtime runtime = Runtime.getRuntime();
		
		// 这个List中每个Map元素中都只有一个键值对，这个键值对的key就是待执行的命令，键值对的value就是对执行命令的描述
		for (int i = 0; i < commandList12.size(); i++)
		{
			
			// 命令
			String command = "";
			// 命令描述
			String commandDisc = "";
			
			// 获取当前待执行命令及其描述所在的map集合
			Map<String, String> currCommandMap = commandList12.get(i);
			// 将其转换成Set集合
			Set<Entry<String,String>> entrySet = currCommandMap.entrySet();
			// 遍历-》获取Set集合中唯一的元素
			for (Entry<String, String> entry : entrySet) {
				// 获取命令
				command = entry.getKey();
				// 获取命令描述
				commandDisc = entry.getValue();
			}
			
			// 执行这条命令
			this.executeCommand(runtime, command, commandDisc);
			
		}
	}
	
	/**
	 * 执行单个命令，并打印其描述
	 * @param runtime 
	 */
	private void executeCommand(Runtime runtime, String cmd, String disc)
	{
		try {
			// 执行命令
			runtime.exec(cmd);
			// 打印执行命令后的描述
			System.out.println(disc + "命令执行成功！");
		} catch (IOException e) {
			// 命令执行失败
			System.out.println(disc + "命令执行失败！");
			e.printStackTrace();
		}
	}

}
