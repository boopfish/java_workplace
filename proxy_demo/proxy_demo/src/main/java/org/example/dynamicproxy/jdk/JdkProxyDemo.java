package org.example.dynamicproxy.jdk;

import org.example.SendSmsService;
import org.example.SendSmsServiceImpl;

/**
 * @Description 只能代理实现了接口的类
 * @Author fisher
 * @Date 2021-02-21 11:29
 */

public class JdkProxyDemo {
	public static void main(String[] args) {
		SendSmsService sendSmsService = new SendSmsServiceImpl();
		SendSmsService proxy = (SendSmsService) JdkProxyFactory.getProxy(sendSmsService);
		proxy.sendSms();
	}
}
