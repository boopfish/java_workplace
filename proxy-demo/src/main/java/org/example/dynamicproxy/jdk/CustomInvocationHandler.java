package org.example.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-21 11:10
 */

public class CustomInvocationHandler implements InvocationHandler {

	/**
	 * 代理类的真实对象
	 */
	private Object target;

	public CustomInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("发送短信前的一些操作");
		//通过反射执行方法
		Object obj = method.invoke(target, args);
		System.out.println("发送短信后的一些操作");
		return obj;
	}
}
