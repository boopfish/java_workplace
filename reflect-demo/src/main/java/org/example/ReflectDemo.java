package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description 反射的几种实现方式
 * @Author fisher
 * @Date 2021-02-21 9:55
 */

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		//通过类名获取,获取Class对象不会进行初始化
		Class<User> userClass = User.class;
		//通过全限定名获取，本质上调用的是native方法 第二个参数传入的是boolean 表示是是否需要初始化，默认会进行初始化
		Class<?> aClass = Class.forName("org.example.User");
		//通过实例对象获取
		User user = new User();
		Class<? extends User> aClass1 = user.getClass();

		//通过反射获取对象的一些信息
		//获取构造器
		Constructor<User> declaredConstructor = userClass.getDeclaredConstructor();
		//通过构造器创建对象
		User user1 = declaredConstructor.newInstance();
		//获取属性
		Field field = userClass.getDeclaredField("name");
		System.out.println(field.getName());
		//获得类名
		System.out.println(userClass.getSimpleName());
		//获得全限定名
		System.out.println(userClass.getName());
		//获取指定方法并执行
		Method setName = userClass.getDeclaredMethod("setName", String.class);
		setName.invoke(user1,"zhangsan");
		System.out.println(user1.getName());
	}
}
