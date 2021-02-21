package org.example.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-21 11:42
 */

public class CustomMethodInterceptor implements MethodInterceptor {
	/**
	 * @param o           被代理的对象 需要增强的对象
	 * @param method      被拦截的方法 需要增强的方法
	 * @param args        参数
	 * @param methodProxy 用于调用原始方法
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("before:"+method.getName());
		Object o1 = methodProxy.invokeSuper(o, args);
		System.out.println("after");
		return o1;
	}
}
