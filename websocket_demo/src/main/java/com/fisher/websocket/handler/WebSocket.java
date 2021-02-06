package com.fisher.websocket.handler;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-06 13:30
 */

import com.alibaba.fastjson.JSONObject;
import com.fisher.websocket.config.WebSocketConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Component
@ServerEndpoint(value = "/ws/{userId}", configurator = WebSocketConfig.class)
public class WebSocket {
	private Session session;
	//存储所有的session
	public static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<>();
	//存储所有在线人数
	public static CopyOnWriteArrayList<WebSocket> webSockets = new CopyOnWriteArrayList<>();

	/**
	 * 这里可以通过EndpointConfig 获取到连接时携带的session 判断用户的合法性
	 * 如果用户验证失败 可以使用session.close()来断开连接
	 *
	 * @param session
	 * @param userId
	 * @param config
	 * @throws IOException
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId, EndpointConfig config) throws IOException {
		log.info("取得用户id为:{}", config.getUserProperties().get("userId"));
		this.session = session;
		sessionPool.put(userId, session);
		webSockets.add(this);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg_content", "heartbeat");
		this.session.getBasicRemote().sendText(jsonObject.toJSONString());
		log.info("用户:{},加入连接,当前在线人数:{}", userId, webSockets.size());
	}

	@OnMessage
	public void onMessage(String message, @PathParam("userId") String userId) {
		log.info("收到客户端消息,{}:{}", userId, message);
	}

	@OnClose
	public void onClose(@PathParam("userId") String userId) {
		webSockets.remove(this);
		sessionPool.remove(userId);
		log.info("用户:{},d断开连接,当前在线人数:{}", userId, webSockets.size());

	}

}
