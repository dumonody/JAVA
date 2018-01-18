/*
	使用@SuppressWarnings注释：属于基本Annotation(注释)
	
	作用：
		1、这个注释是用来指定被该Annotation修饰的程序元素(以及该程序元素中的所有子元素)
			取消显示指定的编译器警告。@SuppressWarnings会一直作用于该程序元素的所有子元素。

	为此Annotation添加成员变量：
		在括号里使用name=value的形式为该Annotation的成员变量设置值。  

	注意：
		SuppressWarnings这个基本Annotation接口在java.lang包下，默认是导入的！
*/

import java.util.List;
import java.util.ArrayList;

//关闭整个类里的编译器警告
@SuppressWarnings(value="unchecked")
public class SuppressWarningsTest
{
	public static void main(String[] args)
	{
		List<String> myList = new ArrayList();
	}
}

/*
	上面的例子中，如果没有@SuppressWarnings(value="unchecked")这行代码
	就会有“基本Annotation\SuppressWarningsTest.java使用了未经检查或不安全的操作。
注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。”这样的 “未检查” 警告。
	但是加上这行代码之后，value="unchecked" 这个成员变量就指定了抑制“未检查”的警告！！
*/
