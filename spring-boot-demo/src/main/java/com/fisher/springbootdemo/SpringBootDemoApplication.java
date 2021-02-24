package com.fisher.springbootdemo;

import com.fisher.springbootdemo.property.ReadConfigProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootDemoApplication implements InitializingBean {
	@Autowired
	ReadConfigProperties library;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(library.getLocation());
		System.out.println(library.getBooks());
	}
}
