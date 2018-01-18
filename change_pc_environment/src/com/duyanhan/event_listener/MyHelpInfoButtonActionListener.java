package com.duyanhan.event_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 信息/帮助按钮的监听事件，实现ActionListener这个接口
 * @author czkct
 *
 */
public class MyHelpInfoButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("用户点击了帮助信息按钮！");
	}

}
