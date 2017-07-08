import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 写出字节流
 * @author czkct
 *
 */
public class WriteByteStream {

	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("textw.txt");
			// 内存中的待写出到硬盘文件的字符串
			String tmp = "测试写出字节流";
			// 按指定字符集获取字节数组
			byte[] output = tmp.getBytes("UTF-8");
			// 将output数组中的内容写出到硬盘文件中
			fos.write(output);
			// 关闭输出流
			fos.close();
			
			System.out.println("写出完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
