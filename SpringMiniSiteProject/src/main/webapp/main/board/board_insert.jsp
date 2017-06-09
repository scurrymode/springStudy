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
/*
 * jquery : javascript ���̺귯��
 	1) selector
 */
 var fileIndex=0;
 $(function(){
	 $('#addBtn').click(function(){
		 $('#fileView').append('<tr id=f'+fileIndex+'><td width=20%>����'+(fileIndex+1)+'</td><td width=80%><input type=file name=upload['+fileIndex+'] size=25></td</tr>');
	 	fileIndex++;
	 });
	 $('#removeBtn').click(function(){
		 if(fileIndex>0){
		 	$('#f'+(--fileIndex)).remove();
		 }
	 });
 });
	
</script>
</head>
<body>
	<center>
		<h3>�۾���</h3>
		<form method="post" action="board_insert_ok.do" enctype="multipart/form-data">
		<table id="table_content" width=500>
			<tr>
				<td width=15%>�̸�</td>
				<td width=85%>
					<input type="text" name="name" size="12">
				</td> 
			</tr>
			<tr>
				<td width=15%>����</td>
				<td width=85%>
					<input type="text" name="subject" size="50">
				</td> 
			</tr>
			<tr>
				<td width=15%>����</td>
				<td width=85%>
					<textarea rows="10" cols="55" name="content"></textarea>
				</td> 
			</tr>
			<tr>
				<td width=15%>����</td>
				<td width=85%>
					<table border=0 width=425>
						<tr>
							<td align=right>
								<input type=button id="addBtn" value="�߰�">
								<input type=button id="removeBtn" value="����">
							</td>
						</tr>
					</table>
					<table border=0 width=425 id="fileView">
						
					</table>
				</td> 
				
			</tr>
			<tr>
				<td width=15%>��ȣ</td>
				<td width=85%>
					<input type="password" name="pwd" size="10">
				</td> 
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="����">
					<input type="button" value="���" onclick="javascript:history.back()">
				</td> 
			</tr>
		</table>
		</form>
	</center>
</body>
</html>