<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery.js"></script>
<script>
//$(document.ready(function(){
	
//}));
$(function(){
	$('.h2').css("color","red");
	$("#h5").css("color","yellow");
	/*$('h2').click(function(){
		var data = $(this).html();
		alert(data);
	});*/
	$('h2').hover(function(){//if
		$(this).css("opacity",0.3);
	}, function(){//else
		$(this).css("opacity", 1);
	});
});
</script>
</head>
<body>
	<h2 class="h2"><span>Hello JQuery1</span></h2>
	<h2 class="h2">Hello JQuery2</h2>
	<h2 class="h3">Hello JQuery3</h2>
	<h2 class="h4">Hello JQuery4</h2>
	<h2 id="h5">Hello JQuery5</h2>
</body>
</html>