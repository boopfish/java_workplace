package com.fisher.websocket.config;

import com.fisher.websocket.listener.RequestListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import javax.websocket.Extension;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-06 13:33
 */
@Configuration
@Slf4j
public class WebSocketConfig extends ServerEndpointConfig.Configurator {
	@Resource
	private RequestListener requestListener;

	/**
	 * 由于websocket和http请求协议不是一样 所以需要进行转换
	 *
	 * @param sec
	 * @param request
	 * @param response
	 */
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		log.info("握手");
		/*HttpSession httpSession = (HttpSession) request.getHttpSession();
		sec.getUserProperties().put(httpSession.getId(), httpSession);*/
		List<String> userId = request.getParameterMap().get("userId");
		sec.getUserProperties().put("userId", userId.get(0));
		super.modifyHandshake(sec, request, response);
	}

	@Bean
	public ServerEndpointExporter getServerEndpointExporter() {
		return new ServerEndpointExporter();
	}

	/**
	 * 将自己配置的requestListener注册为监听器
	 *
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean() {
		ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
		servletListenerRegistrationBean.setListener(requestListener);
		return servletListenerRegistrationBean;
	}
}
