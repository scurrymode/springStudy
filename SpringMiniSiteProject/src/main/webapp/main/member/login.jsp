<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${res=='NOID' }">
		<script>alert("���̵� �������� �ʽ��ϴ�");</script>
		history.back();
	</c:when>
	<c:when test="${res=='NOPWD' }">
		<script>alert("��й�ȣ�� �ٸ��ϴ�");</script>
		history.back();
	</c:when>
	<c:when test="${res=='OK' }">
		<c:redirect url="main.do"/>
	</c:when>
</c:choose>