/*
	使用@Deprecated注释：属于基本Annotation(注释)
	
	作用：
		1、用于表明被修饰的程序单元已经过时，让编译器发出使用已经过时的元素的警告

	限制：
		1、这个注释直接用于修饰程序中的程序单元，如方法、类、接口等。

	注意：
		Deprecated这个基本Annotation接口在java.lang包下，默认是导入的！
*/

class Apple
{
	//定义info方法已经过时
	@Deprecated
	public void info()
	{
		System.out.println("Apple的info方法");
	}
}

public class DeprecatedTest
{
	public static void main(String[] args)
	{
		//下面使用info()方法时将会被编译器警告
		new Apple().info();
	}
}