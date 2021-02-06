package com.fisher.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-06 13:33
 */
@Configuration
public class WebSocketConfig {
	@Bean
	public ServerEndpointExporter getServerEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
