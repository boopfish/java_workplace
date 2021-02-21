package com.fisher.websocket.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-06 15:14
 */
@Component
public class RequestListener implements ServletRequestListener {

	public void requestInitialized(ServletRequestEvent sre) {
		//将所有request请求都携带上httpSession
		((HttpServletRequest) sre.getServletRequest()).getSession();

	}
}
