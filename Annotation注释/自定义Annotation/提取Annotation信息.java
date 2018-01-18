/*
	提取Annotation信息：

		Java使用Annotation接口来代表程序元素前面的注解，该接口是所有注解的父接口

		Java5在java.lang.reflect包下新增了AnnotatedElement接口

			注意：AnnotatedElement接口代表的是可以接受注解的程序元素而不是注解！
			
			实现AnnotatedElement接口的几个实现类(都是java.lang.reflect包中类)：
				Class：类定义
				Constructor：构造器定义
				Field：类的成员变量定义
				Method：类的方法定义
				Package：类的包定义

			AnnotatedElement接口是上面所有程序元素的父接口，
			所以程序通过反射(前提：定义该Annotation时，使用了@Retention(RententionPolicy.RUNTIME)修饰)
			获取了某个类的AnnotatedElement对象之后，
			程序就可以调用该对象的如下几个方法类访问Annotation信息。

		访问Annotateion信息的方法：
		①：<A extends Annotation> A getAnnotation(Class<A> annotationClass):
			返回该程序元素上存在的、指定类型的注解，如果该类型的注解不存在，
			则返回null
		②：<A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass):
			Java8新增的方法，尝试获取直接修饰该程序元素、指定类型的Annotation。
			如果该类型的注解不存在，则返回null

		③：Annotation[] getAnnotations():返回该程序元素上存在的所有注解
		④：Annotation[] getDeclaredAnnotations():返回直接修饰该程序元素的所有注解

		⑤：<A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass):
			与①方法相似，但由于Java8增加了重复注解功能，因此需要使用该方法获取修饰该程序元素、
			指定类型的多个Annotation
		⑥：<A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> annotationClass):
			与②方法相似，但由于Java8增加了重复注解功能，因此需要使用该方法获取直接修饰该程序元素、
			指定类型的多个Annotation

		⑦：boolean isAnnotationPresent(Class<? extends Annotation> annotationClass):
			判断该程序元素上是否存在指定类型的注解，如果存在则返回true，否则返回false。

*/

	//下面程序片段用于获取Test类的info方法里的所有注解，并将这些注解打印出来
	Annotation[] aArray = Class.forName("Test").getMethod("info").getAnnotations();
	//遍历所有注解
	for( Annotation an : aArray)
	{
		System.out.println(an);
	}


	/*
		如果需要获取某个注解里的元数据，则可以将注解强制类型转换成所需的注解类型，
		然后通过注解对象的抽象方法来访问这些元数据
	*/
	//获取tt对象的info方法所包含的的所有注解
	Annotation[] annotation = tt.getClass().getMethod("info").getAnnotations();
	//遍历每个注解对象
	for(Annotation tag : annotation)
	{
		//如果tag注解是MyTag1类型
		if(tag instanceof MyTag1)
		{
			System.out.println("Tag is: " + tag);
			//将tag强制类型转换为MyTag1
			//输出tag对象的method1和method2两个成员变量的值
			System.out.println("tag.name(): " + ((MyTag1)tag).method1());
			System.out.println("tag.age(): " + ((MyTag1)(tag)).method2());

		}
		//如果tag注解是MyTag2类型
		if(tag instanceof MyTag2)
		{
			System.out.println("Tag is: " + tag);
			//将tag强制类型转换为MyTag2
			//输出tag对象的method1和method2两个成员变量的值
			System.out.println("tag.name(): " + ((MyTag2)tag).method1());
			System.out.println("tag.age(): " + ((MyTag2)(tag)).method2());

		}
	}

	/*
		即假设MyTag1的method1这个成员变量是name，则要获取name这个成员变量的元数据
		则应该将"((MyTag1)tag).method1()"修改成"((MyTag1)tag).name()"
	*/