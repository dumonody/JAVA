import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 读取字节流
 * @author czkct
 *
 */
public class ReadByteStream {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("text.txt");
			byte[] input = new byte[21];
			// 输入流将文档中的部分内容读入到字节数组input中
			fis.read(input);
			// 将字节数组按照指定的字符集变成字符串
			String tmp = new String(input, "UTF-8");
			System.out.println(tmp);
			// 关闭输入流
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
