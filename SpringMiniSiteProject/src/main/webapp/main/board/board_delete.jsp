<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/table.css">
<script src="http://code.jquery.com/jquery.js"></script>
<script>
$(function(){
	$('#delBtn').click(function(){
		var no=$('#no').attr("value");
		var page=$('#page').attr("value");
		var pwd=$('#pwd').val();
		if(pwd.trim()==""){
			$('#pwd').focus();
			return;
		}
		var json={"no":no, "page":page, "pwd":pwd};
		$.ajax({
			type:'post', url: 'board_delete_ok.do', data: json,
			success:function(response){
				
				if(response.trim()==1){//��й�ȣ�� ������
					parent.location.href="board_list.do?page="+page;
					parent.Shadowbox.close();
				}else{
					$('#pwd').val("");
					$('#pwd').focus();
					$('#result').html("<font color=red>��й�ȣ�� �ٸ��ϴ�</font>");
				}
			}
			
		});
	});
	$('#canBtn').click(function(){
		parent.Shadowbox.close();
	});
});
</script>
</head>
<body>
	<center>
		<div style="height:30px"></div>
		<table id="table_content" width=250>
		<tr>
			<td align=left>
			<input type=hidden name=no value=${no } id=no>
			<input type=hidden name=page value=${page } id=page>
			��й�ȣ:<input type="password" name=pwd id=pwd size=12>
			</td>
		</tr>
		<tr>
			<td id="result"></td>
		</tr>
		<tr>
			<td align=center>
				<input type=button value=���� id=delBtn>
				<input type=button value=��� id=canBtn>
			</td>
		</tr>
		</table>
	</center>
</body>
</html>