<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8" />
<title>Company Name</title>
<link rel="stylesheet" type="text/css" href="style/style_sheet.css"
	media="screen" />
<script src="http://code.jquery.com/jquery.js"></script>
<script>
$(function(){
	$('#loginBtn').click(function(){
		var id=$('#id').val();
		if(id.trim()==""){
			$('#id').focus();
			return;
		}
		var pwd=$('#pwd').val();
		if(pwd.trim()==""){
			$('#pwd').focus();
			return;
		}
		$('#log_frm').submit();
	});
	$('#logoutBtn').click(function(){
		$('#logout_frm').submit();
	});
});
</script>
</head>

<body>

	<div id="wrapper">
		<!--####  wrapper  ###-->

		<div id="top_strip"></div>
		<!--top strip end-->

		<div id="header">
			<!--header-->

			<h1>
				<a href="main.do">ä������ ũ�Ѹ� ����</a>
			</h1>

			<c:if test="${sessionScope.id==null}">
			<form method="post" action="login.do" id="log_frm">
				<div style="margin-left: 550px; font-size: 10px; color: white">
					ID:<input type=text id=id name=id size=12> &nbsp; PW:<input
						type=password name=pwd size=12 id=pwd> &nbsp; <input type=button
						value=�α��� id=loginBtn>
				</div>
			</form>
			</c:if>
			<c:if test="${sessionScope.id!=null}">
			<form method="post" action="logout.do" id="logout_frm">
				<div style="margin-left: 550px; font-size: 10px; color: white">
					${sessionScope.name }(${sessionScope.admin=='y'?"������":"�Ϲݻ����" })��
					�α������Դϴ� &nbsp; <input type=button value=�α׾ƿ� id=logoutBtn>
				</div>
			</form>
			</c:if>

		</div>
		<!--header end-->


		<div id="menu-top">
			<!--menu top-->

			<div id="top_nav">
				<!--top nav-->

				<ul>

					<li><a href="main.do">Home</a></li>
					<c:if test="${sessionScope.id==null }">
					<li><a href="join.do">ȸ������</a></li>
					</c:if>
					<c:if test="${sessionScope.id!=null }">
					<li><a href="join_update.do">ȸ������</a></li>
					</c:if>					
					<li><a href="loc.do">������ ����</a></li>
					<li><a href="best.do">����Ʈ ����</a></li>
					<li><a href="board_list.do">Ŀ�´�Ƽ</a></li>
					<li><a href="news.do">�����˻�</a></li>
					<c:if test="${sessionScope.id!=null }">
					<li><a href="reserve.do">���༾��</a></li>
					</c:if>
					<c:if test="${sessionScope.admin=='y' }">
					<li><a href="reserve_config.do">������Ȳ</a></li>
					</c:if>
					
				</ul>

			</div>
			<!--top nav end-->


			<div id="search_area">
				<!--search box-->

				<form action="" method="get" id="form_search"></form>

			</div>
			<!--search box end-->


		</div>
		<!--menu top end-->


		<div id="banner">
			<!--banner-->

			<img src="images/header1.jpg" alt="" width="940" height="280" />

		</div>
		<!--banner end-->

		<%--content --%>
		<!-- ���� ���Ⱑ ��ɿ� ���� �ٸ� ������� ���ϰŴ�. -->
		<jsp:include page="${main_jsp }"></jsp:include>

		<div id="footer">
			<!--footer-->

			<div id="footer_nav">

				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Sample Page</a></li>
					<li><a href="#">Sample Page2</a></li>
					<li><a href="#">Sample Page3</a></li>
					<li><a href="#">Sample Page 4</a></li>
					<li><a href="#">Sample Page 5</a></li>
				</ul>

			</div>

		</div>
		<!--footer end-->

		<div class="clr"></div>
	</div>
	<!--####  wrapper  ###-->

</body>
</html>
