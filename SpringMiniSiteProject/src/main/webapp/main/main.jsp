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
				<a href="main.do">채제원의 크롤링 스쿨</a>
			</h1>

			<h6>D강의장</h6>

		</div>
		<!--header end-->


		<div id="menu-top">
			<!--menu top-->

			<div id="top_nav">
				<!--top nav-->

				<ul>

					<li><a href="main.do">Home</a></li>
					<li><a href="join.do">회원가입</a></li>
					<li><a href="loc.do">지역별 맛집</a></li>
					<li><a href="best.do">베스트 맛집</a></li>
					<li><a href="board_list.do">커뮤니티</a></li>
					<li><a href="news.do">뉴스검색</a></li>
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
		<!-- 이제 여기가 기능에 따라 다른 모양으로 보일거다. -->
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
