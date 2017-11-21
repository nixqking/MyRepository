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
		<h2 style="text-align: center;">查询结果</h2>
		<div style="height: 20px; clear: both; display: block"></div>
		<table class="table">
			<thead>
				<tr>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>课程成绩</th>
					<th>学生学号</th>
					<th>学生姓名</th>
					<th>学生性别</th>
					<th>所属学院</th>
					<th>学生班级</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" end="${sessionScope.sResult.size()}"
					items="${sessionScope.sResult}" step="1" var="i">
					<tr>
						<td><c:out value="${i.course.cno}"></c:out></td>
						<td><c:out value="${i.course.cname}"></c:out></td>
						<td><c:out value="${i.score}"></c:out></td>
						<td><c:out value="${i.sno}"></c:out></td>
						<td><c:out value="${i.student.sname}"></c:out></td>
						<td><c:out value="${i.student.sex}"></c:out></td>
						<td><c:out value="${i.student.sdept}"></c:out></td>
						<td><c:out value="${i.student.classe}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="center">
			<a class="btn btn-primary footer" href="/sms/queryStudentScore">返回</a>
		</div>
	</div>
</body>
</html>