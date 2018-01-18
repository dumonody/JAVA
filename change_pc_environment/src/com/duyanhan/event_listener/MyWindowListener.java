package com.duyanhan.event_listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 这个是我的窗口监听器类，继承于窗口监听器的适配器
 * @author czkct
 *
 */
public class MyWindowListener extends WindowAdapter {

	// 实现处理事件的方法
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("用户试图关闭窗口！");
		// 退出程序
		System.exit(0);
	}
}
