<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="news_area">

		<c:forEach var="vo" items="${list }">
			<div class="news_area1">

				<h2>${vo.category }</h2>
				<span style="font-size: 9pt">${vo.subject }</span>
				<a href="https://www.mangoplate.com${vo.link }">
				<img src="${vo.poster }" alt="" width="275" height="125"/>
				</a>

			</div>
		</c:forEach>
	
	<div class="clr"></div>
	</div>
</body>
</html>