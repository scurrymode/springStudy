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
	$('#findBtn').click(function(){
		var dong=$('#dong').val();
		if(dong.trim()==""){
			alert("��/��/���� �Է��ϼ���");
			return;
		}
		$.ajax({
			type:'POST', url:'postfind_result.do', data:{'dong':dong}, //JSON���� �����°Ŵ�~!
			success:function(response){
				$('#post_view').html(response);
			}
		});
	});
});
</script>
</head>
<body>
	<div style="height:30px"></div>
	<center>
	<table id="table_content" width=430>
	<tr>
		<td>
		�Է�: <input type=text name=dong size=12 id="dong">
		<input type=button value=�˻� id="findBtn">
		</td>
	</tr>
	</table>
		<div id="post_view"></div>
	</center>
</body>
</html>