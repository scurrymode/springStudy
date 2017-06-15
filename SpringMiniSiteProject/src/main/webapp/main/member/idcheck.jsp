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
	$('#idBtn').click(function(){
		var id=$('#id').val();
		if(id.trim()==""){
			//alert("아이디를 입력하세요");
			$('#id').focus();
			return;
		}
		$.ajax({
			type:"POST",
			url:"idcheck_result.do",
			data:{"id":id},
			success:function(response){
				$('#id_view').html(response);
			}
		});
	});
	
});
</script>
</head>
<body>
	<center>
		<div style="height:30px"></div>
		<table id="table_content" width=300>
			<tr>
			<td align=left>
				ID:<input type=text name=id size=12 id=id>
				<input type=button value="아이디체크" id=idBtn>
			</td>
			</tr>
		</table>
		<div id=id_view></div>
	</center>
</body>
</html>