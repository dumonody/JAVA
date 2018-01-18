/*
	使用@FunctionalInterface注释：属于基本Annotation(注释)
	
	作用：
		1、这个Java8新增的注释是用来告诉编译器检查这个被此Annotation修饰的接口，
			保证该接口只能包含一个抽象方法(即被修饰接口应当是函数式接口)，否则就会编译出错。

		2、当定义接口时，使用此注释，可以避免程序员犯下一些低级错误，比如添加了多余的抽象方法，
			使得接口不止一个抽象方法，从而也就不是函数式接口了。

	限制：
		1、这个注释只能用来修饰接口，不能修饰其他程序元素。

	注意：
		FunctionalInterface这个基本Annotation接口在java.lang包下，默认是导入的！
*/

@FunctionalInterface
public interface FunInterface
{
	static void foo()
	{
		System.out.println("foo类方法");
	}

	default void bar()
	{
		System.out.println("bar默认方法");
	}

	void test();//只定义一个抽象方法
}

/*
	上面这个例子中用“@FunctionalInterface”这个Annotation修饰了FunInterface接口，
	如果再向这个接口中添加一个test1();的抽象方法，就会报错！
*/