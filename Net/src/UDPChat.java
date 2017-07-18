import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPChat {

	public static void main(String[] args) throws Exception {

		
		// 同时拥有收发功能，则应该有两个Socket，一个用于发送，一个用于接收
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receiveSocket = new DatagramSocket(10002);
		
		// 创建任务对象
		Send send = new Send(sendSocket);
		Receive receive = new Receive(receiveSocket);
		
		// 创建线程并执行
		Thread sendT = new Thread(send);
		Thread receiveT = new Thread(receive);
		sendT.start();
		receiveT.start();
		
	}

}
/**
 * 发送任务类
 * @author Pro.Du
 *
 */
class Send implements Runnable{

	private DatagramSocket ds = null;
	
	public Send(DatagramSocket ds)
	{
		this.ds = ds;
	}
	
	@Override
	public void run() {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			String text = null;
			while((text = sc.nextLine()) != null)
			{
				byte[] buf = text.getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.255"), 10002);
				ds.send(dp);
				if(text.equals("over"))
				{
					break;
				}
			}
			
			ds.close();
			sc.close();
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 接收任务类
 * @author Pro.Du
 *
 */
class Receive implements Runnable{

private DatagramSocket ds = null;
	
	public Receive(DatagramSocket ds)
	{
		this.ds = ds;
	}
	@Override
	public void run() {
		try {
			while(true)
			{
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);
				
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());
				System.out.println("IP:" + ip + ":" + port + " -> " + text);
				if(text.equals("over"))
				{
					System.out.println("IP:" + ip + ":" + port + " ...... 离开聊天室" );
//					break;
				}
			}
			
//			ds.close();
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
