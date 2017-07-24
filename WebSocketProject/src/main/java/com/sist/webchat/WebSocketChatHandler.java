package com.sist.webchat;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;
import java.util.concurrent.*;
// ws: 일반 웹소켓  ws:/webchat/a.do
// wss: 웹보안  http,https
public class WebSocketChatHandler extends TextWebSocketHandler{
    // 접속자 저장
	private Map<String,WebSocketSession> users=new ConcurrentHashMap<String, WebSocketSession>();
	// 클라이언트가 webSocket 종료 요청  => sessionid , WebSocketSession 
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		System.out.println(session.getId()+"님 퇴장하셨습니다");
		users.remove(session.getId());
	}

	// 클라이언트가 webSocket으로 접속시
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println(session.getId()+"님 입장하셨습니다");
		users.put(session.getId(),session);
		System.out.println("3");
	}
    // 클라이언트가 문자열을 전송했을 경우에 사용 : 접속자 전체 메세지 전송 
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		for(WebSocketSession ws:users.values())
		{
			ws.sendMessage(message);
		}
	}
    // log 파일로 출력 (클라이언트에 에러 메세지 전송)
	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
	}
    
}






