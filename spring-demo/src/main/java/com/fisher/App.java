package com.fisher;

import com.fisher.service.MessageService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		System.out.println("Spring容器启动成功");
		System.out.println(applicationContext.getBean(MessageService.class).getMessage());

	}
}
