import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceive {

	public static void main(String[] args) {

		try {
			// 1. 需要先建立udp的socket。它具备发送或者接受功能
				// 注意：一定要明确端口，否则无法接受到发送端向指定端口发送的数据
			DatagramSocket ds = new DatagramSocket(10000);
			
			// 2.定义数据包, 接收数据
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);	// 此方法会导致当前线程阻塞
			
			// 3.通过数据包对象获取数据包的内容，发送端的ip。发送端的端口，发送端发送来的数据
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String text = new String(dp.getData(), 0, dp.getLength());
			// 打印获取的数据
			System.out.println(text);
			
			// 4.关闭资源
			ds.close();
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
