/*
	元Annotation(元注释)：
		用来修饰Annotation定义的的Annotation就是元Annotation
	

	JDK的四个常用元注释：
		1、@Retention：用于指定被修饰的Annotation可以保留多长时间
		2、@Target：用于指定被修饰的Annotation修饰哪些程序单元
		3、@Documented：用于指定被修饰的Annotation类将被javadoc工具提取成文档
		4、@Inherited：用于指定被修饰的Annotation类将具有继承性

	注意：
		这些元注释都是java.lang.annotation包下面的

	=============================================================

	1、@Retention：
		它包含一个RetentionPolicy类型的value成员变量
		value成员变量的值只有三种：
			①：RententionPolicy.CLASS:编译器将把被修饰的Annotation记录在
				class文件中。当运行Java程序时，JVM不可获取被修饰Annotation的信息。
				这也是默认值。
			②：RetentionPolicy.RUNTIME:编译器将把被修饰的Annotation记录在
				class文件中。当运行Java程序时，JVM可以获取被修饰Annotation的信息。
				程序将通过反射获取该Annotation信息。
			③：RetentionPolicy.SOURCE:被修饰的Annotation将只保留在源代码中，
				编译器会直接丢弃这种Annotation。
			总结：
				第②中比较常用：如果需要通过反射获取注解信息，就需要使用value属性值
				为RetentionPolicy.RUNTIME的@Retention


		示例1：
			//定义下面的@Testable Annotation保留到运行时
			@Retention(value=RetentionPolicy.RUNTIME)
			public @interface Testable{}

		示例2：
			//定义下面的@Testable Annotation将被编译器直接丢弃
			@Retention(RetentionPolicy.SOURCE)
			public @interface Testable{}

		注意：
			示例2中没有使用value=RetentionPolicy.SOURCE的方式来为value成员变量指定值；
			原因是：当Annotation的成员变量名为value时，程序中可以直接在Annotation后
				的括号里指定该成员变量的值，无须使用name=value的形式


	=============================================================

	2、@Target：
		它也包含一个名为value的成员变量，类型是ElementType的
		value成员变量的值只能是以下八种：
			①：ElementType.ANNOTATION_TYPE:指定该策略的Annotation只能修饰Annotation
			②：ElementType.CONSTRUCTOR:指定该策略的Annotation只能修饰构造器
			③：ElementType.FIELD:指定该策略的Annotation只能修饰成员变量
			④：ElementType.LOCAL_VARIABLE:指定该策略的Annotation只能修饰局部变量
			⑤：ElementType.METHOD:指定该策略的Annotation只能修饰方法定义
			⑥：ElementType.PACKAGE:指定该策略的Annotation只能修饰包定义
			⑦：ElementType.PARAMETER:指定该策略的Annotation只能修饰参数
			⑧：ElementType.TYPE:指定该策略的Annotation可以修饰类、接口（包括注解类型）、枚举定义


		示例1：
			//定义下面的@ActionListenerFor Annotation只能修饰成员变量
			@Target(ElementType.FIELD)
			public @interface ActionListenerFor{}

		示例2：
			//定义下面的@Testable Annotation只能修饰方法
			@Target(ElementType.METHOD)
			public @interface Testable{}


		注意：
			示例1和示例2中没有使用name=value的方式来为value成员变量指定值，
			原因同@Retention示例2：
				当Annotation的成员变量名为value时，程序中可以直接在Annotation后
				的括号里指定该成员变量的值，无须使用name=value的形式


	=============================================================
	
	3、@Documented：
		定义Annotation时，如果使用@Documented这个元Annotation来修饰这个Annotation，
		则用此Annotation来修饰的程序元素的API文档中将会包含此Annotation说明。

		示例：

		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.METHOD)
		//定义Testable Annotation将被javadoc工具提取
		@Document
		public @interface Testable
		{

		}

		//上面代码中的粗体字代码指定了javadoc工具生成的API文档将 提取@Testable的使用信息

		public class MyTest
		{
			//使用@Testable修饰info()方法
			@Testable
			pubilc void info()
			{
				System.out.println("info方法...");
			}
		}


	=============================================================

	4、@Inherited：
		如果某个类使用了@Xxx注解(定义该@Xxx Annotation时使用了@Inherited修饰)修饰，
		则其子类将自动被@Xxx注解修饰


		示例：

		@Target(ElementType.TYPE)
		@Retention(RetentionPolicy.RUNTIME)
		@Inherited
		public @interface Inheritable
		{
	
		}

		//上面定义的@Inheritable Annotation将具有继承性，所以被此Annotation修饰的类
		//的子类也将会默认使用@Inheritable修饰

		//使用@Inheritable修饰的Base类
		@Inheritable
		class Base
		{
	
		}
		//InheritableTest类只是继承了Base类
		//并未直接使用@Inheritable Annotation修饰
		public class InheritableTest extends Base
		{
			public static void main(String[] args)
			{
				//打印InheritableTest类是否有@Inheritable修饰
				System.out.println(InheritableTest.class
					.isAnnotationPresent(Inheritable.class));
			}
		}
		//输出结果将会是true！，如果将修饰@Inheritable Annotation的
		//元Annotation @Inherited给删除， 然后重新编译运行，输出结果就是false
	
*/

