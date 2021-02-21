package org.example.staticproxy;

import org.example.SendSmsService;
import org.example.SendSmsServiceImpl;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SendSmsService sendSmsService = new SendSmsServiceImpl();
		sendSmsService.sendSms();
		/**
		 * 调用代理类的时候 还是会调用本身的方法
		 */
		SendSmsProxy sendSmsProxy = new SendSmsProxy(sendSmsService);
		sendSmsProxy.sendSms();
	}
}
