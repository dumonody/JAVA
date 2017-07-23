package cn.chatsys.util.win;

import java.awt.Component;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WindowUtil {

	/**
	 * 获取编辑框中的文本内容
	 * @param frame
	 * @return
	 */
	public static String getJEditorPaneText(JFrame frame)
	{
		String ans = new String();
		JPanel p = (JPanel) frame.getContentPane();
		Component[] components = p.getComponents();
		for(Component cmpt : components)
		{
			if(cmpt instanceof JEditorPane)
			{
				ans = ((JEditorPane) cmpt).getText();
			}
		}
		return ans;
	}
	
	/**
	 * 设置文本发送区的内容
	 * @param frame
	 * @param content
	 */
	public static void setTextArea(JFrame frame, String content)
	{
		JPanel p = (JPanel) frame.getContentPane();
		Component[] components = p.getComponents();
		for(Component cmpt : components)
		{
			if(cmpt instanceof JTextArea)
			{
				JTextArea textArea = (JTextArea) cmpt;
				textArea.setText(textArea.getText() + content);
			}
		}
	}
	
	/**
	 * 设置文本发送区的内容
	 * @param frame
	 * @param content
	 */
	public static void setJEditorPaneText(JFrame frame, String content)
	{
		JPanel p = (JPanel) frame.getContentPane();
		Component[] components = p.getComponents();
		for(Component cmpt : components)
		{
			if(cmpt instanceof JEditorPane)
			{
				((JEditorPane) cmpt).setText(content);
			}
		}
	}
}
