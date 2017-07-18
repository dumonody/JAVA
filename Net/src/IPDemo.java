import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	public static void main(String[] args) {

		try {
			// 获取本地主机地址对象：
			InetAddress ip = InetAddress.getLocalHost();
			// 获取主机地址：
			System.out.println(ip.getHostAddress());	// 192.168.0.134
			// 获取主机名称：
			System.out.println(ip.getHostName());	// czkct-PC
			
			// 获取其它主机地址
			InetAddress ip2 = InetAddress.getByName("www.baidu.com");
			System.out.println(ip2.getHostAddress());	// 14.215.177.37
			System.out.println(ip2.getHostName());		// www.baidu.com
			
			// 有一种情况要注意：若getHostName()的返回值与geHostAddress()返回值都是IP地址
			// 原因是：主机名与主机地址之间有对应关系，想要获取主机名，就要先解析主机地址
			// 所以：当主机地址解析不成功时，getHostName()就直接返回主机地址，而不是主机名
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
