package test;

import com.duyanhan.gui.MyFrame;
import com.duyanhan.util.ReadXMLUtil;

public class Test {

	public static void main(String[] args) {
	/*	// 获取一个读取xml文件工具类实例
		ReadXMLUtil readXMLUtil = ReadXMLUtil.getInstance();
		// 对此实例调用readAllXML方法
		readXMLUtil.readAllXML();
		// 获取此实例的EnvXmlList，并打印
		System.out.println(readXMLUtil.getEnvXmlList());
		// 获取任务列表
		System.out.println(readXMLUtil.getTotalTaskStartAndStopArrayList());*/
		
		// 获取一个读取xml文件工具类实例
		ReadXMLUtil readXMLUtil = ReadXMLUtil.getInstance();
		// 对此实例调用readAllXML方法:读取所有的XML文件
		readXMLUtil.readAllXML();
		// 使用此实例初始化窗口对象
		MyFrame mf = MyFrame.getInstance();
		mf.init(readXMLUtil);
	}
}
