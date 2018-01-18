/*
	通过String类使用正则表达式：
		String类常用以下方法直接使用正则表达式功能：
			1、boolean matches(String regex):判断该字符串是否匹配指定的正则表达式
			2、String replaceAll(String regex, String replacement):将该字符串中所有匹配regex的子串替换成replacement
			3、String replaceFirst(String regex, String replacement):将该字符串中第一个匹配regex的子串替换成replacement
			4、String[] split(String regex):以regex作为分隔符，把字符串分割成多个子串
	注意：
		Arrays类是java.util包中的类，即工具类中的数组类

	通过Pattern类和Matcher类使用正则表达式的步骤：
		1、使用Pattern类compile(模式字符串)这个静态方法将一个模式字符串编译得到Pattern对象
		2、使用这个Pattern对象调用matcher(目标字符串)方法来创建Matcher对象
		3、再调用Matcher的各种方法来使用正则表达式
				Matcher的常用方法：
					1.matches()方法：返回整个目标字符串与Pattern是否匹配
					2.find()方法：返回目标字串中是否包含与Pattern匹配的子串
					3.group()方法：返回上一次与Pattern匹配的子串
					4.start()方法：返回上一次与Pattern匹配的子串在目标字符串中的开始位置
					5.end()方法：返回上一次与Pattern匹配的子串在目标字符串中的结束位置加1
					6.lookingAt()方法：返回目标字符串前面部分与Pattern是否匹配
					7.reset()方法：将现有的Matcher对象应用于一个新的字符序列
	注意：
		Pattern类和Matcher类都是java.util.regex包中的类，因为它们都是正则工具类中的类。
*/
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UseRegexTest
{

	//使用String类提供的方法来直接使用正则表达式
	public void testStringReg()
	{
		String[] msgs = 
		{
			"Java has regular expressions in 1.4",
			"regular expressions now expressing in Java",
			"Java represses oracular expressions"
		};

		for(String msg : msgs)
		{
			//matches方法
			if(msg.matches("Java.*"))
			{
				System.out.println(msg);
			}
			//replaceAll方法
			System.out.println(msg.replaceAll("Ja\\w+", "嘿嘿"));
			//replaceFirst方法
			System.out.println(msg.replaceFirst("re\\w+", "嘻嘻"));
			//split方法
			System.out.println(Arrays.toString(msg.split("\\s+")));
		}
	}

	//测试find和group两个方法
	public void testFindGroup()
	{
		//使用字符串模拟从网上得到的网页源码
		String str = "我想求购一本《疯狂Java讲义》，尽快联系我13333333333"
			+ "交朋友，电话号码是13811111111"
			+ "出售二手电脑，联系方式1522222222";

		//创建一个Pattern对象，并用它创建一个Matcher对象
		//该正则表达式只抓取13X和15X段的手机号
		Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
		//将所有符合正则表达式的子串（电话号码）全部输出
		while(m.find())
		{
			System.out.println(m.group());
		}
	}

	//测试start和end方法
	public void testStartEnd()
	{
		//创建一个Pattern对象，并用它建立一个Matcher对象
		String regStr = "Java is very easy!";
		Matcher m = Pattern.compile("\\w+").matcher(regStr);
		while(m.find())
		{
			System.out.println(m.group() + "子串的起始位置：" + m.start() + ",其结束位置：" + m.end());
		}

	}

	//测试matches方法
	public void testMatches()
	{
		String[] mails = 
		{
			"dumonody@163.com",
			"dumonody@126.com",
			"ligang@crazyit.org",
			"wawa@abc.xx"
		};

		String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		Pattern mailPattern = Pattern.compile(mailRegEx);
		Matcher matcher = null;
		for(String mail : mails)
		{
			if(matcher == null)
			{
				matcher = mailPattern.matcher(mail);
			}
			else
			{
				//将现有的Matcher对象应用于一个新的目标字符串
				matcher.reset(mail);
			}
			String result = mail + (matcher.matches() ? "是" : "不是")
				+ "一个有效的邮件地址";
			System.out.println(result);
		}
	}

	//测试replaceAll方法
	public void testReplaceAll()
	{
		String[] msgs = 
		{
			"Java has regular expressions in 1.4",
			"regular expressions now expressing in Java",
			"Java represses oracular expressions"
		};
		Pattern p = Pattern.compile("re\\w+");
		Matcher matcher = null;
		for(int i = 0; i < msgs.length; i++)
		{
			if(matcher == null)
			{
				matcher = p.matcher(msgs[i]);
			}
			else
			{
				matcher.reset(msgs[i]);
			}
			System.out.println(matcher.replaceAll("哈哈:"));
		}
	}

	public static void main(String[] args)
	{
		UseRegexTest urt = new UseRegexTest();


		System.out.println("-----------------测试find和group两个方法-----------------");
		//测试find和group两个方法
		urt.testFindGroup();


		System.out.println("-----------------测试start和end两个方法-----------------");
		//测试start和end两个方法
		urt.testStartEnd();


		System.out.println("-----------------测试matches方法-----------------");
		//测试matches方法
		urt.testMatches();


		System.out.println("-----------------测试replaceAll方法-----------------");
		//测试replaceAll方法
		urt.testReplaceAll();


		System.out.println("-----------------测试testStringReg方法-----------------");
		//测试testStringReg方法
		urt.testStringReg();
	}
}