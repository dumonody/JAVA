/*
	使用@Overrid注释：属于基本Annotation(注释)
	
	作用：
		1、这个注释是用来指定方法覆盖(重写)的，它可以强制一个子类必须覆盖父类的方法。

		2、当重写父类方法时，使用此注释，可以避免出现写错待重写方法的签名这种低级错误。

	限制：
		1、这个注释只能用来修饰方法，不能修饰其他程序元素。

	注意：
		Overrid这个基本Annotation接口在java.lang包下，默认是导入的！
*/

public class Fruit
{
	public void info()
	{
		System.out.println("水果的info方法...");
	}
}

class Apple extends Fruit
{
	//使用@Override指定下面方法必须重写父类方法
	@Override
	public void info()
	{
		System.out.println("苹果重写水果的info方法...");
	}
}