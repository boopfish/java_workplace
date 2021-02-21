package org.example;

import org.example.SendSmsService;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-21 10:38
 */

public class SendSmsServiceImpl implements SendSmsService {
	@Override
	public void sendSms() {
		System.out.println("发送短信");
	}
}
