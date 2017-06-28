package com.duyanhan.gui;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingComponent {
	// 定义一个界面
	JFrame jf = new JFrame("测试");
	
	// 定义一个带图标的按钮
	Icon okIcon = new ImageIcon("ico/ok.jpg");
	JButton ok = new JButton("确认", okIcon);
	
	// 定义一个单选按钮，初始处于选中状态
	JRadioButton male = new JRadioButton("男", true);
	// 定义一个单选按钮，初始处于没有选中状态
	JRadioButton female = new JRadioButton("女", false);
	
	// 定义一个ButtonGroup， 用于将上面两个JRadioButton组合在一起
	ButtonGroup bg = new ButtonGroup();
	
	// 定义一个复选框， 初始处于没有选中状态。
	JCheckBox married = new JCheckBox("是否已婚?", false);
	
	String[] colors = new  String[]{"红色", "绿色", "蓝色"};
	
	// 定义一个下拉选择框
	JComboBox<String> colorChooser = new JComboBox<>(colors);
	
	// 定义一个列表选择框
	JList<String> colorList = new JList<>(colors);
	
	// 定义一个8行、20列的多行文本域
	JTextArea ta = new JTextArea(8, 20);
	
	// 定义一个40列的单行文本域
	JTextField name = new JTextField(40);
	
	// 定义一个菜单条
	JMenuBar mb = new JMenuBar();
	
	// 定义一个文件菜单项
	JMenu file = new JMenu("文件");
	
	// 定义一个编辑菜单项
	JMenu edit = new JMenu("编辑");
			//=================上面的两个都没有指定图标========注意：上面两个是菜单，而不是菜单项！=======
	// 创建"新建"菜单项，并为之指定图标
	Icon newIcon = new ImageIcon("ico/new.png");
	JMenuItem newItem = new JMenuItem("新建", newIcon);
	// 创建"保存"菜单项，并为之指定图标
	Icon saveIcon = new ImageIcon("ico/save.png");
	JMenuItem saveItem = new JMenuItem("保存", saveIcon);
	// 创建"退出"菜单项，并为之指定图标
	Icon exitIcon = new ImageIcon("ico/exit.png");
	JMenuItem exitItem = new JMenuItem("退出", exitIcon);
	// 创建"复制"菜单项，并为之指定图标
	Icon copyIcon = new ImageIcon("ico/copy.png");
	JMenuItem copyItem = new JMenuItem("复制", copyIcon);
	// 创建"粘贴"菜单项，并为之指定图标
	Icon pasteIcon = new ImageIcon("ico/paste.png");
	JMenuItem pasteItem = new JMenuItem("粘贴", pasteIcon);
	
	JMenu format = new JMenu("格式");
	// 定义两个不带图标的注释
	JMenuItem commentItem = new JMenuItem("注释");
	JMenuItem cancelItem = new JMenuItem("取消注释");
	
	
	// 定义一个右键菜单用于设置程序风格
	JPopupMenu pop = new JPopupMenu();
	// 用于组合3个风格菜单项的ButtonGroup
	ButtonGroup flavorGroup = new ButtonGroup();
	
	// 创建5个单选按钮， 用于设定程序的外观风格
	JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal风格", true);
	JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus风格");
	JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows风格");
	JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows经典风格");
	JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif风格");
	
	//====================================用于执行界面初始化的init方法==========================================
	
	public void init()
	{
		// 创建一个装载了文本框、按钮的JPanel
		JPanel bottom = new JPanel();
		bottom.add(name);
		bottom.add(ok);
		jf.add(bottom, BorderLayout.SOUTH);
		
		// 创建一个装载了下拉选择框、三个JCheckBox的JPanel
		JPanel checkPanel = new JPanel();
		checkPanel.add(colorChooser);	// 添加下拉选择框
		bg.add(male);
		bg.add(female);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		
		
		// 最后设置部分   设置jf自适应大小且可见
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SwingComponent().init();
	}
}
