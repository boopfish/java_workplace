package org.example.dynamicproxy.cglib;

import org.example.SendSmsService;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-21 11:52
 */

public class CglibProxyDemo {
	public static void main(String[] args) {
		AliSmsService proxy = (AliSmsService)CglibProxyFactory.getProxy(AliSmsService.class);
		proxy.sendSms();
	}
}
