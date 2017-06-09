<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8" />
<title>Company Name</title>
<link rel="stylesheet" type="text/css" href="style/style_sheet.css"
	media="screen" />
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

			<h6>D������</h6>

		</div>
		<!--header end-->


		<div id="menu-top">
			<!--menu top-->

			<div id="top_nav">
				<!--top nav-->

				<ul>

					<li><a href="main.do">Home</a></li>
					<li><a href="join.do">ȸ������</a></li>
					<li><a href="loc.do">������ ����</a></li>
					<li><a href="best.do">����Ʈ ����</a></li>
					<li><a href="board_list.do">Ŀ�´�Ƽ</a></li>
					<li><a href="news.do">�����˻�</a></li>
				</ul>

			</div>
			<!--top nav end-->


			<div id="search_area">
				<!--search box-->

				<form action="" method="get" id="form_search">

					<input name="input" type="text" id="search_box" /> <input name=""
						type="image" id="search_btn" value="" />


				</form>

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
