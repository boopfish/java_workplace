package com.fisher.springbootdemo.config;

import com.fisher.springbootdemo.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Description 注册自定义的过滤器
 * @Author fisher
 * @Date 2021-02-24 16:25
 */
//@Configuration
public class MyFilterConfig {
	@Autowired
	private MyFilter myFilter;

	@Bean
	public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(myFilter);
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/api/*"));
		return filterRegistrationBean;
	}
}
