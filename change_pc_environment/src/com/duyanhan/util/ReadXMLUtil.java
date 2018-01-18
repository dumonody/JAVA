package com.duyanhan.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 将这个类定义成单例类，即只能创建一个实例
 * @author czkct
 *
 */
public class ReadXMLUtil {

	// 使用一个类变量来缓存曾经创建的实例
	private static ReadXMLUtil instance;
	// 对构造器使用private修饰，隐藏构造器(这样，在此类的外部就不能通过new ReadXMLUtil()的形式来创建ReadXMLUtil的实例了)
	private ReadXMLUtil(){}
	
	

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

	/**
	 * 提供一个静态方法，用于返回ReadXMLUtil实例
	 * 该方法加入自定义控制，保证只产生一个ReadXMLUtil对象
	 * @return ReadXMLUtil实例
	 */
	public static ReadXMLUtil getInstance()
	{
		// 如果instance为null，说明还不曾创建ReadXMLUtil实例
		// 如果instance不为null，说明已经创建了ReadXMLUtil实例，将不会重新创建新的实例,而是直接返回此实例
		if (instance == null)
		{
			// 创建一个ReadXMLUtil对象，并将其缓存起来
			instance = new ReadXMLUtil();
			// 这里要注意：构造器被private修饰后，这个构造器只能在此类的内部才有使用权限，所以这里是正确的！！！如果在此类的外部使用则是错误的！！！
		}
		return instance;
	}
	
	/**
	 * 读取所有的XML文件
	 */
	public void readAllXML()
	{
		// 读取总控制XML文件，并更新（环境-xml）列表
		readRootXML();
		
		// 先获取xmlList列表中的所有xml名称和环境名构成的map
		List<Map<String, String>> tempEnvXmlList = this.getEnvXmlList();
		
		// 创建一个临时的包含了每个环境的任务的列表，其中每个环境任务的执行列表和终止列表相关联
		List<Map<List<Map<String, String>>, List<Map<String, String>>>> tempTotalTaskStartAndStopArrayList = new ArrayList<>();
		
		// 将每个xml文件名称对应的xml进行读取
		for (int i = 0; i < tempEnvXmlList.size(); i++)
		{
			// 获取当前Map
			Map<String, String> currMap = tempEnvXmlList.get(i);
			// 获取Map对应的Set
			Set<Entry<String, String>> entrySet = currMap.entrySet();
			// 遍历Set集合（每个Set集合中都只有一个键值对->{环境名=xml文件名}）
			for (Entry<String, String> entry : entrySet)
			{
				// 获取xml文件名称
				String fileName = entry.getValue();
				
				
				// 读取此xml文件,并将获得的返回值添加至所有环境任务列表集合中
				Map<List<Map<String, String>>, List<Map<String, String>>> tempRelevanceMap = readSingleXML(fileName);
				tempTotalTaskStartAndStopArrayList.add(tempRelevanceMap);
				
			}
		}
		// 更新所有环境任务总列表
		this.setTotalTaskStartAndStopArrayList(tempTotalTaskStartAndStopArrayList);
	}
	
	/**
	 * 读取各个单独的XML文件
	 */
	private Map<List<Map<String, String>>, List<Map<String, String>>> readSingleXML(String fileName)
	{
		// 创建一个临时的Map，用于关联临时待执行任务列表tempTaskStartArrayList和临时待终止任务列表tempTaskStopArrayList
		Map<List<Map<String, String>>, List<Map<String, String>>> tempRelevanceMap = new HashMap<>();
		try {
			// 创建DOM解析器的工厂
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// 调用工厂对象的newDocumentBuilder()方法得到DOM解析器
			DocumentBuilder builder = factory.newDocumentBuilder();
			// 将一个指定的文件解析成DOM对象
			Document dom = builder.parse(new File(fileName));
			// 获取当前文档元素(即根元素)
			Element root = dom.getDocumentElement();
			// 获取子级元素   task元素
			NodeList list = root.getElementsByTagName("task-item");
			
			// 创建一个临时待执行任务列表tempTaskStartArrayList
			List<Map<String,String>> tempTaskStartArrayList = new ArrayList<>();
			// 创建一个临时待终止任务列表tempTaskStopArrayList
			List<Map<String,String>> tempTaskStopArrayList = new ArrayList<>();
			
			// 遍历task-item元素集合：循环次数为此标签出现的次数
			for (int i = 0; i < list.getLength(); i ++)
			{
				// 获取每个task-item元素
				Node ele = list.item(i);
				// 再获取每个task-item元素的所有子级元素
				NodeList taskChildList = ele.getChildNodes();
				for (int j = 0; j < taskChildList.getLength(); j ++)
				{
					// 获取当前子级元素对象
					Node tCEle = taskChildList.item(j);
					// 如果task-item元素的当前子级元素是task-start
					if ("task-start".equals(tCEle.getNodeName()))
					{
						// 获取if-execute子级元素
						Node ifExecuteEle = ((Element) tCEle).getElementsByTagName("if-exec").item(0);
						// 判断if-execute的标签内容是否为true
						if (Boolean.parseBoolean(ifExecuteEle.getTextContent()))
						{
							// 如果是true，则获取到它的command子标签和delay子标签的内容，并作为键值对，put到map集合中,然后插入ArrayList中
							Node commandEle = ((Element) tCEle).getElementsByTagName("command").item(0);
							String commandValue = commandEle.getTextContent();
							Node taskDiscEle = ((Element) tCEle).getElementsByTagName("task-disc").item(0);
							String taskDiscValue = taskDiscEle.getTextContent();
							// 创建一个临时集合
							Map<String, String> tempMap = new HashMap<>();
							tempMap.put(commandValue, taskDiscValue);
//							System.out.println(tempMap);
							tempTaskStartArrayList.add(tempMap);
						}
						// 如果if-execute的标签内容是false，则不执行任何操作
					}
					// 如果task-item元素的当前子级元素是task-stop
					if ("task-stop".equals(tCEle.getNodeName()))
					{
						// 获取if-execute子级元素
						Node ifExecuteEle = ((Element) tCEle).getElementsByTagName("if-exec").item(0);
						// 判断if-execute的标签内容是否为true
						if (Boolean.parseBoolean(ifExecuteEle.getTextContent()))
						{
							// 如果是true，则获取到它的command子标签和delay子标签的内容，并作为键值对，put到map集合中,然后插入ArrayList中
							Node commandEle = ((Element) tCEle).getElementsByTagName("command").item(0);
							String commandValue = commandEle.getTextContent();
							Node taskDiscEle = ((Element) tCEle).getElementsByTagName("task-disc").item(0);
							String taskDiscValue = taskDiscEle.getTextContent();
							// 创建一个临时集合
							Map<String, String> tempMap = new HashMap<>();
							tempMap.put(commandValue, taskDiscValue);
//							System.out.println(tempMap);
							tempTaskStopArrayList.add(tempMap);
						}
						// 如果if-execute的标签内容是false，则不执行任何操作
					}
				}
			}
			
			tempRelevanceMap.put(tempTaskStartArrayList, tempTaskStopArrayList);
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 返回一个Map<List<Map<String, String>>, List<Map<String, String>>>集合
		return tempRelevanceMap;
	}
	
	/**
	 * 读取总控制XML文件,并更新（环境-xml）列表
	 */
	public void readRootXML()
	{
		try {
			// 获取DOM解析器工厂对象
			DocumentBuilderFactory documentBuilderfactory = DocumentBuilderFactory.newInstance();
			// 获取DOM解析器对象
			DocumentBuilder documentBuilder = documentBuilderfactory.newDocumentBuilder();
			// 获取文档对象（DOM对象）
			Document document = documentBuilder.parse(new File("ROOT.xml"));
			// 获取根元素
			Element allEnvEle = document.getDocumentElement();
			// 获取根元素下的所有env元素对应的节点
			NodeList evnList = allEnvEle.getElementsByTagName("env");
			// 创建一个临时的待读取的 （环境-xml）列表，每个xml中都对应一个任务列表
			List<Map<String, String>> tempEnvXmlList = new ArrayList<>();
			// 遍历所有的evn元素，并进行相应的操作
			for (int i = 0; i < evnList.getLength(); i++)
			{
				// 获取当前节点对应的env元素
				Element envEle = (Element) evnList.item(i);
				// 获取此元素下的env-load元素
				Element envLoadEle = (Element) envEle.getElementsByTagName("env-load").item(0);
				// 判断此元素的值
				if (Boolean.parseBoolean(envLoadEle.getTextContent()))
				{
					// 如果此元素的值是true，读取此env元素下的env-disc元素，并将该元素的值放入tempEnvXmlList中
					Element envDiscELe = (Element) envEle.getElementsByTagName("env-disc").item(0);
					String envDiscValue = envDiscELe.getTextContent();
					// 同时，读取此env元素下的env-name元素，并将该元素的值放入tempEnvXmlList中
					Element envNameELe = (Element) envEle.getElementsByTagName("env-name").item(0);
					String envNameValue = envNameELe.getTextContent();
					// 创建一个临时集合
					Map<String, String> tempMap = new HashMap<>();
					tempMap.put(envDiscValue, envNameValue);
					tempEnvXmlList.add(tempMap);
				}
				else
				{
					// 如果此元素的值是false，则不执行任何操作，继续遍历下一个env元素对应的节点
					continue;
				}
			}

			// 更新（环境-xml）列表
			this.setEnvXmlList(tempEnvXmlList);
			
		} catch (ParserConfigurationException e) {
			System.out.println("获取DOM解析器对象失败！");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("获取文档(DOM)对象失败！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO流异常，获取ROOT.xml文件对象失败！");
			e.printStackTrace();
		}
		
	}
	
	
}
