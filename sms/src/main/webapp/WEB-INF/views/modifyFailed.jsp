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
<body>
	<div class="container">
		<div style="height: 80px; clear: both; display: block"></div>
		<div>
			<p style="text-align: center; font-size: x-large;">修改失败，请返回继续</p>
		</div>
		<div style="height: 40px; clear: both; display: block"></div>

		<c:choose>
			<c:when test="${sessionScope.teacher!=null}">
				<div align="center">
					<a class="btn btn-primary footer" href="/sms/queryStudentScore">返回</a>
				</div>
			</c:when>
			<c:when
				test="${sessionScope.administrator!=null && requestScope.modifyType eq 'modifyStudent'}">
				<div align="center">
					<a class="btn btn-primary footer" href="/sms/manageStudent">返回</a>
				</div>
			</c:when>
			<c:when
				test="${sessionScope.administrator!=null && requestScope.modifyType eq 'modifyTeacher'}">
				<div align="center">
					<a class="btn btn-primary footer" href="/sms/manageTeacher">返回</a>
				</div>
			</c:when>
			<c:when
				test="${sessionScope.administrator!=null && requestScope.modifyType eq 'modifyCourse'}">
				<div align="center">
					<a class="btn btn-primary footer" href="/sms/manageCourse">返回</a>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>