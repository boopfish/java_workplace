package org.example.staticproxy;

import org.example.SendSmsService;

/**
 * @Description 发送短信代理类 ，可以额外做自定义操作
 * @Author fisher
 * @Date 2021-02-21 10:39
 */

public class SendSmsProxy implements SendSmsService {
	private SendSmsService sendSmsService;

	public SendSmsProxy(SendSmsService sendSmsService) {
		this.sendSmsService = sendSmsService;
	}

	@Override
	public void sendSms() {
		System.out.println("发送短信前");
		sendSmsService.sendSms();
		System.out.println("发送短信后");
	}
}
