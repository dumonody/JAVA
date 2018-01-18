/*
	使用@SafeVarargs注释：属于基本Annotation(注释)
	
	作用：
		1、使用这个注释修饰引发“堆污染”警告的方法或者构造器，
			可以抑制编译器产生“堆污染”警告
	注意：
		SafeVarargs这个基本Annotation接口在java.lang包下，默认是导入的！
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ErrorUtilsTest
{
	//@SafeVarargs
	public static void faultyMethod(List<String>... listStrArray)
	{
		//Java语言不允许创建泛型数组，因此listArray只能被当成List[]处理
		//此时相当于把List<String>赋给了List，已经发生了“堆污染”
		List[] listArray = listStrArray;
		
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));

		//把listArray的第一个元素赋为myList
		listArray[0] = myList;

		String s = listStrArray[0].get(0);
	}

	public static void main(String[] args)
	{
		ErrorUtilsTest.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
	}
}

/*
	在上面这个例子中：
		如果将faultyMethod方法前面的对@SafeVarargs的注释取消，就可以发现，编译时
		@safeVarargs这个Annotation抑制了编译时产生的堆污染的警告。
*/