import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSend {

	public static void main(String[] args) {
		try {
			// 1. 需要先建立udp的socket。它具备发送或者接受功能
			DatagramSocket ds = new DatagramSocket();
			
			// 2. 将数据封装到数据包中。数据包对象是DatagramPacket
			String text = "发送的内容！";
			byte[] buf = text.getBytes();	// 将数据转换成字节数组
				// 将字节数组封装到数据包中
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.134"), 10000);
			
			// 3. 使用socket对象的send方法将数据包发送出去
			ds.send(dp);
			
			// 4. 关闭资源
			ds.close();
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
