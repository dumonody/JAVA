/*
	URLDecoder和URLEncoder作用：
		完成普通字符串和application/x-www-form-urlencoded MIME字符串之间的相互转换

	URLDecoder类包含一个decode(String s, String enc)静态方法：
		将application/x-www-form-urlencoded MIME字符串转换成普通字符串

	URLEncoder类包含一个encode(String s, String enc)静态方法：
		将普通字符串转换成application/x-www-form-urlencoded MIME字符串

	application/x-www-form-urlencoded MIME字符串：
		当URL地址中包含非西欧的字符串(比如中文)时，
		系统会将这些非西欧字符串转换成这种特殊字符串

	注意：
		URLDecoder和URLEncoder两个类都是java.net包下面的类


	注意2：
		将一个application/x-www-form-urlencoded字符串解码成普通字符串时
		使用的字符集应当与
		将该普通字符串编码成此的application/x-www-form-urlencoded字符串时
		使用的字符集一致
		才能保证字符串解码正确！！！！
*/


import java.net.URLEncoder;
import java.net.URLDecoder;

public class URLDecoderTest
{
	public static void main(String[] args) throws Exception
	{
		//将application/x-www-form-urlencoded字符串转换成普通字符串
		String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82java", "utf-8");
		System.out.println(keyWord);

		//将普通字符串转换成application/x-www-form-urlencoded字符串
		String urlStr = URLEncoder.encode("疯狂Android讲义", "GBK");
		System.out.println(urlStr);
		/*
			上面的“疯狂Android讲义”在编码之后，
			注意： 每个中文字符将会转换成"%XX%XX"的形式，
			因为每个中文字符占两个字节，每个字节可以转换成两个十六进制的数字,
			当采用不同的字符集时，每个中文字符对应的字节数并不完全相同，
			上面的例子中：采用GBK字符集编码"疯狂"，得到"%B7%E8%BF%F1"
					如果采用utf-8字符集编码"疯狂", 得到"%E7%96%AF%E7%8B%82"
		*/
	}
}