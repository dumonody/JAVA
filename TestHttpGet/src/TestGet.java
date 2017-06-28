import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestGet {

	public static void main(String[] args) {
		new ReadByGet().start();
	}

	/**
	 * 静态内部类
	 * 
	 * @author czkct
	 *
	 */
	static class ReadByGet extends Thread {

		@Override
		public void run() {
			try {

				// 获取URL
				URL url = new URL("http://mm.bmtec.cn/html//xinggan/2801_18.html");
				// 获取连接
				URLConnection connection = url.openConnection();
				// 获取网络连接输入字节流
				InputStream is = connection.getInputStream();
				// 使用输入字符流包装上面的输入字节流
				InputStreamReader isr = new InputStreamReader(is, "GBK");
				// 使用缓冲字符流包装上面的输入字符流，这样可以将输入流中的内容按行写入写出
				BufferedReader br = new BufferedReader(isr);

				// 按行从输入流中读取出数据
				String line;
				// 可变字符串
				StringBuilder builder = new StringBuilder();
				while ((line = br.readLine()) != null) {
					builder.append(line);
					// 注意这里，虽然说是按行读取内容到line中，但是不包括换行符, 因此我们需要自行添加换行符
					builder.append("\n");
				}
				// 后打开，先关闭
				br.close();
				isr.close();
				is.close();

				// 输出读取到的所有内容
				System.out.println(builder);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
