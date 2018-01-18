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
 * ������ඨ��ɵ����࣬��ֻ�ܴ���һ��ʵ��
 * @author czkct
 *
 */
public class ReadXMLUtil {

	// ʹ��һ�����������������������ʵ��
	private static ReadXMLUtil instance;
	// �Թ�����ʹ��private���Σ����ع�����(�������ڴ�����ⲿ�Ͳ���ͨ��new ReadXMLUtil()����ʽ������ReadXMLUtil��ʵ����)
	private ReadXMLUtil(){}
	
	

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

	/**
	 * �ṩһ����̬���������ڷ���ReadXMLUtilʵ��
	 * �÷��������Զ�����ƣ���ֻ֤����һ��ReadXMLUtil����
	 * @return ReadXMLUtilʵ��
	 */
	public static ReadXMLUtil getInstance()
	{
		// ���instanceΪnull��˵������������ReadXMLUtilʵ��
		// ���instance��Ϊnull��˵���Ѿ�������ReadXMLUtilʵ�������������´����µ�ʵ��,����ֱ�ӷ��ش�ʵ��
		if (instance == null)
		{
			// ����һ��ReadXMLUtil���󣬲����仺������
			instance = new ReadXMLUtil();
			// ����Ҫע�⣺��������private���κ����������ֻ���ڴ�����ڲ�����ʹ��Ȩ�ޣ�������������ȷ�ģ���������ڴ�����ⲿʹ�����Ǵ���ģ�����
		}
		return instance;
	}
	
	/**
	 * ��ȡ���е�XML�ļ�
	 */
	public void readAllXML()
	{
		// ��ȡ�ܿ���XML�ļ��������£�����-xml���б�
		readRootXML();
		
		// �Ȼ�ȡxmlList�б��е�����xml���ƺͻ��������ɵ�map
		List<Map<String, String>> tempEnvXmlList = this.getEnvXmlList();
		
		// ����һ����ʱ�İ�����ÿ��������������б�����ÿ�����������ִ���б����ֹ�б������
		List<Map<List<Map<String, String>>, List<Map<String, String>>>> tempTotalTaskStartAndStopArrayList = new ArrayList<>();
		
		// ��ÿ��xml�ļ����ƶ�Ӧ��xml���ж�ȡ
		for (int i = 0; i < tempEnvXmlList.size(); i++)
		{
			// ��ȡ��ǰMap
			Map<String, String> currMap = tempEnvXmlList.get(i);
			// ��ȡMap��Ӧ��Set
			Set<Entry<String, String>> entrySet = currMap.entrySet();
			// ����Set���ϣ�ÿ��Set�����ж�ֻ��һ����ֵ��->{������=xml�ļ���}��
			for (Entry<String, String> entry : entrySet)
			{
				// ��ȡxml�ļ�����
				String fileName = entry.getValue();
				
				
				// ��ȡ��xml�ļ�,������õķ���ֵ��������л��������б�����
				Map<List<Map<String, String>>, List<Map<String, String>>> tempRelevanceMap = readSingleXML(fileName);
				tempTotalTaskStartAndStopArrayList.add(tempRelevanceMap);
				
			}
		}
		// �������л����������б�
		this.setTotalTaskStartAndStopArrayList(tempTotalTaskStartAndStopArrayList);
	}
	
	/**
	 * ��ȡ����������XML�ļ�
	 */
	private Map<List<Map<String, String>>, List<Map<String, String>>> readSingleXML(String fileName)
	{
		// ����һ����ʱ��Map�����ڹ�����ʱ��ִ�������б�tempTaskStartArrayList����ʱ����ֹ�����б�tempTaskStopArrayList
		Map<List<Map<String, String>>, List<Map<String, String>>> tempRelevanceMap = new HashMap<>();
		try {
			// ����DOM�������Ĺ���
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// ���ù��������newDocumentBuilder()�����õ�DOM������
			DocumentBuilder builder = factory.newDocumentBuilder();
			// ��һ��ָ�����ļ�������DOM����
			Document dom = builder.parse(new File(fileName));
			// ��ȡ��ǰ�ĵ�Ԫ��(����Ԫ��)
			Element root = dom.getDocumentElement();
			// ��ȡ�Ӽ�Ԫ��   taskԪ��
			NodeList list = root.getElementsByTagName("task-item");
			
			// ����һ����ʱ��ִ�������б�tempTaskStartArrayList
			List<Map<String,String>> tempTaskStartArrayList = new ArrayList<>();
			// ����һ����ʱ����ֹ�����б�tempTaskStopArrayList
			List<Map<String,String>> tempTaskStopArrayList = new ArrayList<>();
			
			// ����task-itemԪ�ؼ��ϣ�ѭ������Ϊ�˱�ǩ���ֵĴ���
			for (int i = 0; i < list.getLength(); i ++)
			{
				// ��ȡÿ��task-itemԪ��
				Node ele = list.item(i);
				// �ٻ�ȡÿ��task-itemԪ�ص������Ӽ�Ԫ��
				NodeList taskChildList = ele.getChildNodes();
				for (int j = 0; j < taskChildList.getLength(); j ++)
				{
					// ��ȡ��ǰ�Ӽ�Ԫ�ض���
					Node tCEle = taskChildList.item(j);
					// ���task-itemԪ�صĵ�ǰ�Ӽ�Ԫ����task-start
					if ("task-start".equals(tCEle.getNodeName()))
					{
						// ��ȡif-execute�Ӽ�Ԫ��
						Node ifExecuteEle = ((Element) tCEle).getElementsByTagName("if-exec").item(0);
						// �ж�if-execute�ı�ǩ�����Ƿ�Ϊtrue
						if (Boolean.parseBoolean(ifExecuteEle.getTextContent()))
						{
							// �����true�����ȡ������command�ӱ�ǩ��delay�ӱ�ǩ�����ݣ�����Ϊ��ֵ�ԣ�put��map������,Ȼ�����ArrayList��
							Node commandEle = ((Element) tCEle).getElementsByTagName("command").item(0);
							String commandValue = commandEle.getTextContent();
							Node taskDiscEle = ((Element) tCEle).getElementsByTagName("task-disc").item(0);
							String taskDiscValue = taskDiscEle.getTextContent();
							// ����һ����ʱ����
							Map<String, String> tempMap = new HashMap<>();
							tempMap.put(commandValue, taskDiscValue);
//							System.out.println(tempMap);
							tempTaskStartArrayList.add(tempMap);
						}
						// ���if-execute�ı�ǩ������false����ִ���κβ���
					}
					// ���task-itemԪ�صĵ�ǰ�Ӽ�Ԫ����task-stop
					if ("task-stop".equals(tCEle.getNodeName()))
					{
						// ��ȡif-execute�Ӽ�Ԫ��
						Node ifExecuteEle = ((Element) tCEle).getElementsByTagName("if-exec").item(0);
						// �ж�if-execute�ı�ǩ�����Ƿ�Ϊtrue
						if (Boolean.parseBoolean(ifExecuteEle.getTextContent()))
						{
							// �����true�����ȡ������command�ӱ�ǩ��delay�ӱ�ǩ�����ݣ�����Ϊ��ֵ�ԣ�put��map������,Ȼ�����ArrayList��
							Node commandEle = ((Element) tCEle).getElementsByTagName("command").item(0);
							String commandValue = commandEle.getTextContent();
							Node taskDiscEle = ((Element) tCEle).getElementsByTagName("task-disc").item(0);
							String taskDiscValue = taskDiscEle.getTextContent();
							// ����һ����ʱ����
							Map<String, String> tempMap = new HashMap<>();
							tempMap.put(commandValue, taskDiscValue);
//							System.out.println(tempMap);
							tempTaskStopArrayList.add(tempMap);
						}
						// ���if-execute�ı�ǩ������false����ִ���κβ���
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
		
		
		// ����һ��Map<List<Map<String, String>>, List<Map<String, String>>>����
		return tempRelevanceMap;
	}
	
	/**
	 * ��ȡ�ܿ���XML�ļ�,�����£�����-xml���б�
	 */
	public void readRootXML()
	{
		try {
			// ��ȡDOM��������������
			DocumentBuilderFactory documentBuilderfactory = DocumentBuilderFactory.newInstance();
			// ��ȡDOM����������
			DocumentBuilder documentBuilder = documentBuilderfactory.newDocumentBuilder();
			// ��ȡ�ĵ�����DOM����
			Document document = documentBuilder.parse(new File("ROOT.xml"));
			// ��ȡ��Ԫ��
			Element allEnvEle = document.getDocumentElement();
			// ��ȡ��Ԫ���µ�����envԪ�ض�Ӧ�Ľڵ�
			NodeList evnList = allEnvEle.getElementsByTagName("env");
			// ����һ����ʱ�Ĵ���ȡ�� ������-xml���б�ÿ��xml�ж���Ӧһ�������б�
			List<Map<String, String>> tempEnvXmlList = new ArrayList<>();
			// �������е�evnԪ�أ���������Ӧ�Ĳ���
			for (int i = 0; i < evnList.getLength(); i++)
			{
				// ��ȡ��ǰ�ڵ��Ӧ��envԪ��
				Element envEle = (Element) evnList.item(i);
				// ��ȡ��Ԫ���µ�env-loadԪ��
				Element envLoadEle = (Element) envEle.getElementsByTagName("env-load").item(0);
				// �жϴ�Ԫ�ص�ֵ
				if (Boolean.parseBoolean(envLoadEle.getTextContent()))
				{
					// �����Ԫ�ص�ֵ��true����ȡ��envԪ���µ�env-discԪ�أ�������Ԫ�ص�ֵ����tempEnvXmlList��
					Element envDiscELe = (Element) envEle.getElementsByTagName("env-disc").item(0);
					String envDiscValue = envDiscELe.getTextContent();
					// ͬʱ����ȡ��envԪ���µ�env-nameԪ�أ�������Ԫ�ص�ֵ����tempEnvXmlList��
					Element envNameELe = (Element) envEle.getElementsByTagName("env-name").item(0);
					String envNameValue = envNameELe.getTextContent();
					// ����һ����ʱ����
					Map<String, String> tempMap = new HashMap<>();
					tempMap.put(envDiscValue, envNameValue);
					tempEnvXmlList.add(tempMap);
				}
				else
				{
					// �����Ԫ�ص�ֵ��false����ִ���κβ���������������һ��envԪ�ض�Ӧ�Ľڵ�
					continue;
				}
			}

			// ���£�����-xml���б�
			this.setEnvXmlList(tempEnvXmlList);
			
		} catch (ParserConfigurationException e) {
			System.out.println("��ȡDOM����������ʧ�ܣ�");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("��ȡ�ĵ�(DOM)����ʧ�ܣ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO���쳣����ȡROOT.xml�ļ�����ʧ�ܣ�");
			e.printStackTrace();
		}
		
	}
	
	
}
