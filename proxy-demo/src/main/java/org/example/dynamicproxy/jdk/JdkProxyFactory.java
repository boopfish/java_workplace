package org.example.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Description jdk静态工厂类
 * @Author fisher
 * @Date 2021-02-21 11:24
 */

public class JdkProxyFactory {

	/**
	 * 需要传入被代理的对象
	 * @param target
	 * @return
	 */
	public static Object getProxy(Object target) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new CustomInvocationHandler(target));
	}
}
