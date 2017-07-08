import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 通过字节流拷贝文件内容
 * @author czkct
 *
 */
public class CopyByByteStream {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("头像.jpg");
			FileOutputStream fos = new FileOutputStream("头像new.jpg");
			
			byte[] input = new byte[50];
			// 只要输入流能读取到内容，并赋给input字节数组
			// 就将input字节数组中的内容通过输出流写出
			while(fis.read(input) != -1)
			{
				fos.write(input);
			}
			
			fis.close();
			fos.close();
			
			System.out.println("文件拷贝完毕！！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
