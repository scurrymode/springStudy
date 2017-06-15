<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/table.css">
<script src="http://code.jquery.com/jquery.js"></script>
<!-- <script>
$(function(){
	$('.res_gu').click(function(){
		var kind=$(this).attr("value");
		var gu=$(this).text();
		$.ajax({
			type:"POST",
			url:"reserve_list.do",
			data:{"kind":kind, "addr":gu},
			success:function(response){
				$('#list_view').html(response);
			}
		});
	});
});

</script> -->
</head>
<body>
	<center>
	<div style="overflow-y:auto;height:380px">
		<table id="table_content" width="315">
		<c:forEach var="vo" items="${list }">
			<tr>
			<td rowspan=3 align=center width=45%>
			<img src="food_image/big_${vo.poster}" width=150>
			</td>
			<td colspan=2 align=center>${vo.name }</td>
			</tr>
			<tr>
			<td width=15% align=right>주소</td>
			<td width=40% align=left>${vo.addr }</td>
			</tr>
			<tr>
			<td width=15% align=right>전화</td>
			<td width=40% align=left>${vo.tel}</td>
			</tr>
			<tr>
			<td colspan=3 width=100%><hr></td>
			</tr>
		</c:forEach>
		</table>
	</div>
	</center>
</body>
</html>