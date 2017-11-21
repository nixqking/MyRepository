<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">
<title>Welcome!</title>
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
</head>
<body style="text-align: center;">
	<div style="height: 40px; clear: both; display: block"></div>
	<h1>没有查到相关纪录！</h1>
	<div style="height: 20px; clear: both; display: block"></div>
	<c:choose>
		<c:when test="${sessionScope.student!=null}">
			<a class="btn btn-primary" href="/sms/queryScore">返回</a>
		</c:when>
		<c:when test="${sessionScope.teacher!=null}">
			<a class="btn btn-primary" href="/sms/queryStudentScore">返回</a>
		</c:when>
	</c:choose>
</body>
</html>