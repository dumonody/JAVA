package com.duyanhan.event_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.duyanhan.dotask.DoMyTask;
import com.duyanhan.gui.MyFrame;

/**
 * 关闭环境按钮的监听事件，实现ActionListener这个接口
 * @author czkct
 *
 */
public class MyStopButtonActionListener implements ActionListener {

	// 创建一个窗口的引用
	private MyFrame mf;
	
	// 创建一个索引
	private int index;
	
	// 有参构造，获取窗口的引用、以及当前环境的索引
	public MyStopButtonActionListener(MyFrame myFrame, int index) {
		this.mf = myFrame;
		this.index = index;
	}

	// 处理关闭环境事件的事件监听器
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("用户点击了关闭环境按钮！");
		// 创建一个执行任务的对象
		DoMyTask dmt = new DoMyTask(mf, index);
		// 执行打开环境方法
		dmt.doTasks(0);
	}

}
