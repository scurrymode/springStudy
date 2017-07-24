package com.sist.webchat;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;
import java.util.concurrent.*;
// ws: �Ϲ� ������  ws:/webchat/a.do
// wss: ������  http,https
public class WebSocketChatHandler extends TextWebSocketHandler{
    // ������ ����
	private Map<String,WebSocketSession> users=new ConcurrentHashMap<String, WebSocketSession>();
	// Ŭ���̾�Ʈ�� webSocket ���� ��û  => sessionid , WebSocketSession 
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		System.out.println(session.getId()+"�� �����ϼ̽��ϴ�");
		users.remove(session.getId());
	}

	// Ŭ���̾�Ʈ�� webSocket���� ���ӽ�
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println(session.getId()+"�� �����ϼ̽��ϴ�");
		users.put(session.getId(),session);
		System.out.println("3");
	}
    // Ŭ���̾�Ʈ�� ���ڿ��� �������� ��쿡 ��� : ������ ��ü �޼��� ���� 
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		for(WebSocketSession ws:users.values())
		{
			ws.sendMessage(message);
		}
	}
    // log ���Ϸ� ��� (Ŭ���̾�Ʈ�� ���� �޼��� ����)
	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
	}
    
}






