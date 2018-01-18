/*
	定义Annotation：
		①：使用@interface关键字定义Annotation
		②：在定义Annotation时，以定义方法的形式来定义成员变量
		③：使用default关键字来为成员变量设置默认值
		④：如果不对成员变量设置默认值，则使用该Annotation时，
			应该对每个成员变量进行显式赋值。对成员变量设置默认值之后，
			也可以对成员变量进行显式赋值

	标记Annotation：
		没有定义成员变量的Annotation类型被称为标记。
	元Annotation：
		包含成员变量的Annotation，它们可以接受更多的元数据，
		所以也被称为元数据Annotation。
*/	

		//定义一个带有name和age两个成员变量的 @MyTag Annotation，但不带有默认值
		public @interface MyTag
		{
			String name();
			int age();
		}

//--------------------------------------------
		//定义一个带有name和age两个成员变量的 @MyTag Annotation,且带有默认值
		public @interface MyTag
		{
			String name() default "dumonody";
			int age() default 20;
		}

		//使用上面定义的Annotation
		public class Test
		{
			//使用带成员变量的Annotation
			//因为它的成员变量有默认值，所以可以不为它的成员变量指定值，但也可以指定值
			@MyTag(name="duyanhan", age=22)
			public void info()
			{

			}
		}