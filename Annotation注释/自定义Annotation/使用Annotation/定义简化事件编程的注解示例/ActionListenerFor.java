//定义一个含有成员变量的元数据Annotation：@ActionListenerFor

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.awt.event.ActionListener;

@Target(ElementType.FIELD) //使得@ActionListenerFor注解只能用来修饰成员变量
@Retention(RetentionPolicy.RUNTIME)//使得@ActionListenerFor注解在程序运行时可以通过反射获取注解信息
public @interface ActionListenerFor
{
	//定义一个成员变量，用于设置元数据
	//该 listener 成员变量用于保存监听器实现类
	Class<? extends ActionListener> listener();
}
//注意：ActionListener类是java.awt.event包下面的