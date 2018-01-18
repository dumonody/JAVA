package test;

import java.io.IOException;

/**
 * 调用启动外部程序
 * @author czkct
 *
 */
public class TestRuntimeExec {

	public static void main(String[] args)
	{
		// 获取运行时环境这个对象
		Runtime rt = Runtime.getRuntime();
		// 打开应用程序
		try {
			// 启动指定路径的应用程序
//			rt.exec("C:/Program Files (x86)/Tencent/QQ/Bin/QQScLauncher.exe");
			// 关闭指定路径的应用程序
			rt.exec("Taskkill /IM QQ.exe");
			// 启动cmd命令，并执行参数
//			rt.exec("cmd /c start net start mysql");
//			rt.exec("cmd /c start net stop mysql");
		} catch (IOException e) {
			throw new RuntimeException("指令无效！");
		}
	}
}
