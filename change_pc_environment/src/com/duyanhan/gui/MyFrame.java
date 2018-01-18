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
 * ����������óɵ�����
 * @author czkct
 *
 */
public class MyFrame extends Frame{

	// ��������
	final private static String MYFRAMENMAE = "һ�����û���";
	// ��Ϣ����/��������
	final private static String FOOTNAME = "���ߣ����ſ�������  QQ��2504621508";
	
	
	// �����������ʢװ����Ψһ��ʵ��
	private static MyFrame instance;
	
	// ����һ������ȡ�� ������-xml���б�ÿ��xml�ж���Ӧһ�������б�
	private List<Map<String, String>> envXmlList;
	// ����һ�����������л�������������б�����ÿ�����������ִ���б����ֹ�б������
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

	// �����캯��˽�л���ʹ��粻����new�ķ�ʽ��������ʵ��
	private MyFrame(){}
	
	// ����ʵ��
	public static MyFrame getInstance()
	{
		// ���ʵ�������ھʹ���ʵ����������
		if (instance == null)
		{
			instance = new MyFrame();
		}
		// ����ʵ��
		return instance;
	}
	
	// ��ʼ������
	public void init(ReadXMLUtil readXMLUtil)
	{
		// ���ô���ͼ��
		this.setWindowIcon();
		// ���ô�������
		this.setTitle(MYFRAMENMAE);
		// �����ô��ڵĲ��ַ�ʽ:���ú�ʽ���֣��������еķ�ʽ
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// ��ȡ������-xml���б�
		this.setEnvXmlList(readXMLUtil.getEnvXmlList());
		// ��ȡ���л�������������б�
		this.setTotalTaskStartAndStopArrayList(readXMLUtil.getTotalTaskStartAndStopArrayList());
		// �򴰿�����Ӹ��ֿؼ�
		addEnvCategory();
		// ���������ú��ʵĴ�С
		this.pack();
		// ���ô��ڿ���ʾ
		this.setVisible(true);
		// ���ô�������Ļ���м���ʾ
		this.setViewAtWindowCenter();
		// ���ô��ڴ�С�����Ա仯��
		this.setResizable(false);
		// ���ⲿ�����ʽ��Ϊ������ӹرմ��ڵļ����¼�
		this.addWindowListener(new MyWindowListener());
	}
	
	// ���ô���ͼ��
	private void setWindowIcon()
	{
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		this.setIconImage(imageIcon.getImage());
	}
	
	// ����pack���������������ú��ʵĴ�С
	public void pack()
	{
		// ���������ú��ʵĴ�С
		super.pack();
		// ��ȡ���ڵĳ���
		int tempWidth = this.getWidth();
		// ��������ַ�����
		int titleCharNum = MyFrame.MYFRAMENMAE.length();
		// ����ܽ�������ȫ��ʾ�Ŀ�ȣ�������һ���ַ�ռ��13���ء�Ȼ�󴰿ڵ�ͼ�ꡢ��С������󻯡��رհ�ť�ܹ�ռ��Լ140���ҵ�����
		int newWidth = titleCharNum*13 + 140;
		// �������Ӧ�Ŀ�ȱ�����¿��С������´��ڵĴ�С
		if(tempWidth < newWidth)
		{
			this.setSize(newWidth, this.getHeight());
		}
	}
	
	// ���ô����ڵ�����Ļ���м���ʾ(Dimension�ǳߴ����˼)
	private void setViewAtWindowCenter()
	{
		// ʹ��Toolkit���awt�������getDefaultToolkit������ȡһ����ƽ̨��Toolkit�����ϵľ����Ȼ��ʹ�ô˾����ȡ��Ļ�ߴ����
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		// ��ȡ��Ļ�Ŀ������
		double screenWidth = screenSize.getWidth();
		// ��ȡ��Ļ�ĸ߶�����
		double screenHeight = screenSize.getHeight();
		// ��ȡ���ڵĿ������
		int width = this.getWidth();
		// ��ȡ���ڵĸ߶�����
		int height = this.getHeight();
		/*ע�⣺ȷ������λ�ã����λ��������ָ�������ϽǶ������꣬
		����Ϊ�˱��ִ�������Ļ���м䣬Ӧ��ʹ�������ϽǶ�������Ϊ(x, y);
		x = ��Ļ�Ŀ������/2-���ڵĿ������/2;
		y = ��Ļ�ĸ߶�����/2-���ڵĸ߶�����/2;*/
		// ȷ���������ϽǶ�������(x,y)
		int x = (int) (screenWidth/2 - width/2);
		int y = (int) (screenHeight/2 - height/2);
		
		// ���ƴ���
		this.setLocation(x, y);
	}
	
	
	// ���������б�����ӿؼ�����������
	private void addEnvCategory()
	{
		// �ȴ���һ����ֱ���������Box����
		Box leftBox = Box.createVerticalBox();
		Box rightBox = Box.createVerticalBox();
					
		// �Ȼ�ȡ������Ŀ��
		int Category = this.getEnvXmlList().size();
		// ÿ��һ����������������²�����
		for (int i = 0; i < Category; i++)
		{
			
			// ���һ����ǩ����ǩ�������ǻ���������
			Label env = new Label(this.getEnv(i));
			// �����box��������ӻ������Ʊ�ǩ
			leftBox.add(env);
			
			// �ȴ���һ��ˮƽ���������Box����,����ʢװ�򿪻����͹رջ���������ť
			Box hBox = Box.createHorizontalBox();
			
			// �������������ؼ�
			// 1.���һ���򿪻�����ť����ǩ�����ƾ��ǡ�һ���򿪡�
			Button bt1 = new Button("һ����");
			// ���ⲿ�����ʽΪ��һ���򿪡���ť��Ӽ����¼�
			bt1.addActionListener(new MyStartButtonActionListener(this, i));
			// 2.���һ���رջ�����ť����ǩ�����ƾ��ǡ�һ���رա�
			Button bt2 = new Button("һ���ر�");
			// ���ⲿ�����ʽΪ��һ���رա���ť��Ӽ����¼�
			bt2.addActionListener(new MyStopButtonActionListener(this, i));
			
			// �����Box������������ؼ�
			hBox.add(bt1);
			hBox.add(bt2);
			
			// ���ұ�box������hBox
			rightBox.add(hBox);
			
		}
		
		// �ȴ���һ��ˮƽ���������Box����������ʢװleft��rightbox
		Box leftAndRightBox = Box.createHorizontalBox();
		leftAndRightBox.add(leftBox);
		leftAndRightBox.add(rightBox);
		
		// �������Box�����ŵ�������
		this.add(leftAndRightBox);
		
		// ���һ��������ť
		Button helpButton = new Button(FOOTNAME);
		// ���ⲿ�����ʽΪ����Ϣ/��������ť��Ӽ����¼�
		helpButton.addActionListener(new MyHelpInfoButtonActionListener());
		this.add(helpButton);
	}
	
	// ����������ȡ��Ӧ�Ļ���������
	private String getEnv(int index)
	{
		// �Ȼ�ȡ������Ӧ��Map���ϣ�Ȼ����ת����Set����
		Set<Entry<String, String>> entrySet = this.getEnvXmlList().get(index).entrySet();
		// ���������е�ÿ��Ԫ�أ�ʵ����ֻ��һ��entryԪ�أ����Ԫ�ص�key���ǻ�������
		String envName = "";
		for (Entry<String, String> entry : entrySet) {
			envName =  entry.getKey();
		}
		return envName;
	}
}
