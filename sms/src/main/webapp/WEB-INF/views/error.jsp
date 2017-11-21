<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<script type="text/javascript" src="static/js/bootstrapValidator.js"></script>
</head>
<body style="text-align: center;">
	<div style="height: 40px; clear: both; display: block"></div>
	<h1>密码修改失败！</h1>
	<div style="height: 20px; clear: both; display: block"></div>
	<c:choose>
		<c:when test="${sessionScope.teacher!=null}">
			<a class="btn btn-primary" href="/sms/tpu">返回</a>
		</c:when>
		<c:when test="${sessionScope.student!=null}">
			<a class="btn btn-primary" href="/sms/spu">返回</a>
		</c:when>
		<c:when test="${sessionScope.administrator!=null}">
			<a class="btn btn-primary" href="/sms/apu">返回</a>
		</c:when>
	</c:choose>
</body>
</html>