package com.duyanhan.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import com.duyanhan.event_listener.MyHelpInfoButtonActionListener;
import com.duyanhan.event_listener.MyStartButtonActionListener;
import com.duyanhan.event_listener.MyStopButtonActionListener;
import com.duyanhan.event_listener.MyWindowListener;
import com.duyanhan.util.ReadXMLUtil;

/**
 * 将这个类设置成单例类
 * @author czkct
 *
 */
public class MyFrame extends Frame{

	// 窗口名称
	final private static String MYFRAMENMAE = "一键配置环境";
	// 信息标题/帮助标题
	final private static String FOOTNAME = "作者：穿着裤衩跳、  QQ：2504621508";
	
	
	// 这个引用用于盛装此类唯一的实例
	private static MyFrame instance;
	
	// 定义一个待读取的 （环境-xml）列表，每个xml中都对应一个任务列表
	private List<Map<String, String>> envXmlList;
	// 定义一个包含了所有环境的任务的总列表，其中每个环境任务的执行列表和终止列表相关联
	private List<Map<List<Map<String, String>>, List<Map<String, String>>>> totalTaskStartAndStopArrayList;
	
	public List<Map<String, String>> getEnvXmlList() {
		return envXmlList;
	}

	public void setEnvXmlList(List<Map<String, String>> envXmlList) {
		this.envXmlList = envXmlList;
	}

	public List<Map<List<Map<String, String>>, List<Map<String, String>>>> getTotalTaskStartAndStopArrayList() {
		return totalTaskStartAndStopArrayList;
	}

	public void setTotalTaskStartAndStopArrayList(
			List<Map<List<Map<String, String>>, List<Map<String, String>>>> totalTaskStartAndStopArrayList) {
		this.totalTaskStartAndStopArrayList = totalTaskStartAndStopArrayList;
	}

	// 将构造函数私有化，使外界不能以new的方式创建此类实例
	private MyFrame(){}
	
	// 返回实例
	public static MyFrame getInstance()
	{
		// 如果实例不存在就创建实例，并保存
		if (instance == null)
		{
			instance = new MyFrame();
		}
		// 返回实例
		return instance;
	}
	
	// 初始化窗口
	public void init(ReadXMLUtil readXMLUtil)
	{
		// 设置窗口图标
		this.setWindowIcon();
		// 设置窗口名称
		this.setTitle(MYFRAMENMAE);
		// 先设置窗口的布局方式:采用盒式布局，向下排列的方式
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// 获取（环境-xml）列表
		this.setEnvXmlList(readXMLUtil.getEnvXmlList());
		// 获取所有环境的任务的总列表
		this.setTotalTaskStartAndStopArrayList(readXMLUtil.getTotalTaskStartAndStopArrayList());
		// 向窗口中添加各种控件
		addEnvCategory();
		// 给窗口设置合适的大小
		this.pack();
		// 设置窗口可显示
		this.setVisible(true);
		// 设置窗口在屏幕正中间显示
		this.setViewAtWindowCenter();
		// 设置窗口大小不可以变化：
		this.setResizable(false);
		// 以外部类的形式来为窗口添加关闭窗口的监听事件
		this.addWindowListener(new MyWindowListener());
	}
	
	// 设置窗口图标
	private void setWindowIcon()
	{
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		this.setIconImage(imageIcon.getImage());
	}
	
	// 重载pack方法：给窗口设置合适的大小
	public void pack()
	{
		// 给窗口设置合适的大小
		super.pack();
		// 获取窗口的长度
		int tempWidth = this.getWidth();
		// 计算标题字符个数
		int titleCharNum = MyFrame.MYFRAMENMAE.length();
		// 最低能将标题完全显示的宽度：基本上一个字符占用13像素、然后窗口的图标、最小化、最大化、关闭按钮总共占用约140左右的像素
		int newWidth = titleCharNum*13 + 140;
		// 如果自适应的宽度比这个新宽度小，则更新窗口的大小
		if(tempWidth < newWidth)
		{
			this.setSize(newWidth, this.getHeight());
		}
	}
	
	// 设置窗口在电脑屏幕正中间显示(Dimension是尺寸的意思)
	private void setViewAtWindowCenter()
	{
		// 使用Toolkit这个awt工具类的getDefaultToolkit方法获取一个此平台在Toolkit对象上的句柄，然后使用此句柄获取屏幕尺寸对象
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		// 获取屏幕的宽度像素
		double screenWidth = screenSize.getWidth();
		// 获取屏幕的高度像素
		double screenHeight = screenSize.getHeight();
		// 获取窗口的宽度像素
		int width = this.getWidth();
		// 获取窗口的高度像素
		int height = this.getHeight();
		/*注意：确定窗口位置，这个位置坐标是指窗口左上角顶点坐标，
		所以为了保持窗口在屏幕正中间，应该使窗口左上角顶点坐标为(x, y);
		x = 屏幕的宽度像素/2-窗口的宽度像素/2;
		y = 屏幕的高度像素/2-窗口的高度像素/2;*/
		// 确定窗口左上角顶点坐标(x,y)
		int x = (int) (screenWidth/2 - width/2);
		int y = (int) (screenHeight/2 - height/2);
		
		// 绘制窗口
		this.setLocation(x, y);
	}
	
	
	// 根据两个列表来添加控件、环境分类
	private void addEnvCategory()
	{
		// 先创建一个垂直排列组件的Box容器
		Box leftBox = Box.createVerticalBox();
		Box rightBox = Box.createVerticalBox();
					
		// 先获取环境数目：
		int Category = this.getEnvXmlList().size();
		// 每有一个环境，便进行如下操作：
		for (int i = 0; i < Category; i++)
		{
			
			// 添加一个标签：标签的名称是环境的名称
			Label env = new Label(this.getEnv(i));
			// 向左边box容器中添加环境名称标签
			leftBox.add(env);
			
			// 先创建一个水平排列组件的Box容器,用来盛装打开环境和关闭环境两个按钮
			Box hBox = Box.createHorizontalBox();
			
			// 创建如下两个控件
			// 1.添加一个打开环境按钮：标签的名称就是“一键打开”
			Button bt1 = new Button("一键打开");
			// 以外部类的形式为“一键打开”按钮添加监听事件
			bt1.addActionListener(new MyStartButtonActionListener(this, i));
			// 2.添加一个关闭环境按钮：标签的名称就是“一键关闭”
			Button bt2 = new Button("一键关闭");
			// 以外部类的形式为“一键关闭”按钮添加监听事件
			bt2.addActionListener(new MyStopButtonActionListener(this, i));
			
			// 向这个Box中添加这两个控件
			hBox.add(bt1);
			hBox.add(bt2);
			
			// 向右边box添加这个hBox
			rightBox.add(hBox);
			
		}
		
		// 先创建一个水平排列组件的Box容器，用来盛装left和rightbox
		Box leftAndRightBox = Box.createHorizontalBox();
		leftAndRightBox.add(leftBox);
		leftAndRightBox.add(rightBox);
		
		// 将这个大Box容器放到窗口中
		this.add(leftAndRightBox);
		
		// 添加一个帮助按钮
		Button helpButton = new Button(FOOTNAME);
		// 以外部类的形式为“信息/帮助”按钮添加监听事件
		helpButton.addActionListener(new MyHelpInfoButtonActionListener());
		this.add(helpButton);
	}
	
	// 根据索引获取对应的环境的名称
	private String getEnv(int index)
	{
		// 先获取索引对应的Map集合，然后将它转换成Set集合
		Set<Entry<String, String>> entrySet = this.getEnvXmlList().get(index).entrySet();
		// 遍历集合中的每个元素，实际上只有一个entry元素，这个元素的key就是环境名称
		String envName = "";
		for (Entry<String, String> entry : entrySet) {
			envName =  entry.getKey();
		}
		return envName;
	}
}
