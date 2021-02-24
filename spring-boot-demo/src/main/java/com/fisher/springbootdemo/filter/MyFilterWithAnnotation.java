package com.fisher.springbootdemo.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description 使用注解的方式实现过滤器 不需要注册了 需要在启动类上添加 @ServletComponentScan注解
 * @Author fisher
 * @Date 2021-02-24 16:32
 */
@WebFilter(filterName ="myFilterWithAnnotation",urlPatterns = "/api/*")
public class MyFilterWithAnnotation implements Filter {
	Logger logger = LoggerFactory.getLogger(MyFilterWithAnnotation.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		logger.info("请求进入过滤器");
		HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
		logger.info("请求地址为:{}", servletRequest1.getRequestURI());
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
