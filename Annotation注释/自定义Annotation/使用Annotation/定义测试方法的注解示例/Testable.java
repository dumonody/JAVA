/*
	定义一个标记Annotation：@Testable

	注意：
		@Retention和@Target都是元数据Annotation， 
		所以他们都在java.lang.annotation包下面
		RetentionPolicy和ElementType这两个类也是在java.lang.annotation包下面
*/


import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

//使用JDK的元数据Annotation：@Retention
@Retention(RetentionPolicy.RUNTIME)
//使用JDK的元数据 Annotation：@Target
@Target(ElementType.METHOD)
//定义一个标记注解，不包含任何成员变量，即不可传入元数据
public @interface Testable
{

}