package cn.chatsys.util.win;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowUtil {

	public static String getJEditorPaneText(JFrame frame)
	{
		String ans = null;
		JPanel p = (JPanel) frame.getContentPane();
		JEditorPane editor = (JEditorPane) p.getComponentAt(14, 328);
		ans = editor.getText();
		return ans;
	}
	
	public static void setJEditorPaneText(JFrame frame, String content)
	{
		JPanel p = (JPanel) frame.getContentPane();
		JEditorPane editor = (JEditorPane) p.getComponentAt(14, 328);
		editor.setText(editor.getText() + content);
	}
}
