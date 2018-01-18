package test;

import java.awt.Frame;
import java.awt.Label;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.BoxLayout;

import com.duyanhan.util.ReadXMLUtil;

public class FrameTest {

	public static void main(String[] args) {
		Frame f = new Frame("一键自动配置环境");
		
		// 设置布局
		f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
		
		// 获取ReadXMLUtil实例
		ReadXMLUtil readXMLUtil = ReadXMLUtil.getInstance();
		
		// 读取XML文件
		readXMLUtil.readAllXML();
		
		// 获取envXmlList
		List<Map<String, String>> envXmlList = readXMLUtil.getEnvXmlList();
		
		// 获取totalTaskStartAndStopArrayList
		List<Map<List<Map<String,String>>,List<Map<String,String>>>> totalTaskStartAndStopArrayList = readXMLUtil.getTotalTaskStartAndStopArrayList();
		
		int size = envXmlList.size();
		
		for (int i = 0; i < size; i++)
		{
			String name = null;
			Set<Entry<String, String>> set = envXmlList.get(i).entrySet();
			for (Entry<String, String> entry : set) {
				name = entry.getKey();
				
			}
			Label lb = new Label(name);
			f.add(lb);
		}
		

		f.pack();
		f.setVisible(true);
	}

}
