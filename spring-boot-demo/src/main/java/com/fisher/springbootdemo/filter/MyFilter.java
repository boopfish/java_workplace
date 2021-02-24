package com.fisher.springbootdemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @Description 自定义实现一个过滤器
 * @Author fisher
 * @Date 2021-02-24 16:18
 */
//@Component
public class MyFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		logger.info("请求进入过滤器");
		HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
		logger.info("请求地址为:{}",servletRequest1.getRequestURI());
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {
		logger.info("销毁过滤器");
	}
}
