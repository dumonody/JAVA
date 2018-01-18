/*
	Java提供了InetAddress类来代表IP地址

	InetAddress类下面有两个子类：
			1、Inet4Address：代表IPv4地址
			2、Inet6Address：代表IPv6地址

	InetAddress类没有构造器，获取其实例的两个静态方法为：
		1、getByName(String host)：根据主机获取对应的InetAddress对象
		2、getByAddress(byte[] addr)：根据原始IP地址来获取对应的IP地址和主机名

	InetAddress类用来获取InetAddress实例对应的IP地址和主机名的方法：
			1、String getCanonicalHostName()：获取此IP地址的全限定域名
			2、String getHostName()：获取此IP地址的主机名
			3、String getHostAddress()：获取此InetAddress实例对应的IP地址字符串(以字符串形式)

	InetAddress类还提供了一个isReachable()方法，用于测试是否可以到达该地址

	注意：
		InetAddress类是java.net包下面的类
*/



import java.net.InetAddress;

public class InetAddressTest
{
	public static void main(String[] args) throws Exception
	{
		//根据主机名获取对应的InetAddress实例
		InetAddress ip = InetAddress.getByName("www.baidu.com");

		//判断是否可达
		System.out.println("duyanhan是否可达：" + ip.isReachable(2000));

		//获取该InetAddress实例的IP字符串
		System.out.println(ip.getHostAddress());

		//根据原始IP地址来获取对应的InetAddress实例
		InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});

		//判断是否可达
		System.out.println("本机是否可达：" + local.isReachable(5000));

		//获取该InetAddress实例对应的全限定域名
		System.out.println(local.getCanonicalHostName());


		//获取上面ip实例的主机名
		System.out.println(ip.getHostName());
		//获取上面local实例的主机名
		System.out.println(local.getHostName());
		//获取上面local实例的全限定域名
		System.out.println(ip.getCanonicalHostName());



	}
}