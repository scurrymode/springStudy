<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
 #chatArea{
    width: 400px;
    height:150px;
    overflow-y:auto;
    border:1px solid black; 
 }
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	var websocket;
	function connection(){
		websocket=new WebSocket("ws://localhost:8080/webchat/chat-ws");
		websocket.onopen=onOpen;
		websocket.onmessage=onMessage;
		websocket.onclose=onClose;
	}
	function onOpen(event){
		alert("연결되었습니다.");
	}
	function onMessage(event){
		var data=event.data;
		if(data.substring(0,4)=="msg:"){
			appendMessage(data.substring(4));
		}
	}
	function onClose(event){
		alert("연결 해제되었습니다.");
	}
	function disconnection(){
		websocket.close();
	}
	function send(){
		var name=$("#name").val();
		var msg=$("#sendMsg").val();
		websocket.send("msg:["+name+"]"+msg);
		$("#sendMsg").val("");
	}
	function appendMessage(msg)
	{
		$('#recvMsg').append(msg+"<br>");
		var ch=$('#chatArea').height();
		var m=$('#recvMsg').height()-ch;
		$('#chatArea').scrollTop(m);
	}
	$(function(){
		$("#startBtn").click(function(){connection();});
		$("#endBtn").click(function(){disconnection();});
		$("#sendBtn").click(function(){send();});
	});
</script>

</head>
<body>
	<center>
		<table border=0 width=500>
			<tr>
				<td align=left>
					이름:<input type=text id="name">
					<input type=button id="startBtn" value=입장>
					<input type=button id="endBtn" value=퇴장>
				</td>
			</tr>
			<tr>
				<td align=left>
				<div id="chatArea">
				  <div id="recvMsg"></div>
				</div>
				</td>
			</tr>
			<tr>
				<td align=left>
					<input type="text" id="sendMsg" size=40>
					<input type="button" id="sendBtn" value="전송">
				</td> 
			</tr>
		</table>
	</center>
</body>
</html>