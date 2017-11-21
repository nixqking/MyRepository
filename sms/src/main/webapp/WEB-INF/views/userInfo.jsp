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
		<!-- 	<div style="height: 80px; clear: both; display: block"></div> -->
		<c:choose>
			<c:when test="${sessionScope.teacher!=null}">
				<table class="table">
					<caption style="text-align: center;">
						<font size="5">授课信息</font>
					</caption>
					<thead>
						<tr>
							<th>工号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>课程编号</th>
							<th>课程名称</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach begin="0" end="${sessionScope.teacherInfo.size()}"
							items="${sessionScope.teacherInfo}" var="i">
							<tr>
								<td>${i.teacher.tno}</td>
								<td>${i.teacher.tname}</td>
								<td>${i.teacher.sex}</td>
								<td>${i.cno}</td>
								<td>${i.cname}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${sessionScope.student!=null}">
				<table class="table">
					<caption style="text-align: center;">
						<font size="5">学生信息</font>
					</caption>
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>学院</th>
							<th>班级</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${sessionScope.student.getSno()}</td>
							<td>${sessionScope.student.getSname()}</td>
							<td>${sessionScope.student.getSex()}</td>
							<td>${sessionScope.student.getSdept()}</td>
							<td>${sessionScope.student.getClasse()}</td>
						</tr>
					</tbody>
				</table>
			</c:when>
			<c:when test="${sessionScope.administrator!=null}">
				<table class="table">
					<caption style="text-align: center;">
						<font size="5">管理员信息</font>
					</caption>
					<thead>
						<tr>
							<th>账号</th>
							<th>姓名</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${sessionScope.administrator.account}</td>
							<td>${sessionScope.administrator.name}</td>
						</tr>
					</tbody>
				</table>
			</c:when>
		</c:choose>
	</div>
	<div align="center">
		<a class="btn btn-primary footer" href="/sms/goback" target="_parent">返回</a>
	</div>
</body>
</html>