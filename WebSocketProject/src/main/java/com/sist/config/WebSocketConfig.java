package com.sist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.sist.webchat.WebSocketChatHandler;

@Configuration
@EnableWebSocket
// ��������� (�ص�����Ʈ ����)
public class WebSocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		System.out.println("1");
		registry.addHandler(chatHandler(), "/chat-ws");
	}
	@Bean
	public WebSocketChatHandler chatHandler()
	{
		System.out.println("2");
		return new WebSocketChatHandler();
	}

}
