package org.example.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-21 11:49
 */

public class CglibProxyFactory {


	public static Object getProxy(Class<?> clazz) {
		Enhancer enhancer = new Enhancer();
		//设置类加载器
		enhancer.setClassLoader(clazz.getClassLoader());
		//设置被代理类
		enhancer.setSuperclass(clazz);
		//设置方法拦截器
		enhancer.setCallback(new CustomMethodInterceptor());
		//创建代理类
		return enhancer.create();

	}
}
