package com.yori.zori.websocketconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SocketConfig implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 웹소켓 주소, 접근, SockJS 사용여부, 사용할 SockJS 경로 지정
		registry.addEndpoint("/webserver").setAllowedOrigins("*").withSockJS().setClientLibraryUrl("https://cdn.jsdelivr.net/sockjs/latest/sockjs.min.js");
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 서버로 부터 값을 받아올 주소(subscribe), 서버에게 값을 전달할 주소(publish) 지정
		registry.setApplicationDestinationPrefixes("/publish");
		registry.enableSimpleBroker("/subscribe");
	}
}
