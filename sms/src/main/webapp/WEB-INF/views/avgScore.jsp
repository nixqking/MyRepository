<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div style="height: 20px; clear: both; display: block"></div>
	<table class="table">
		<thead>
			<tr>
				<th>课程编号</th>
				<th>平均成绩</th>
				<th>最低成绩</th>
				<th>最高成绩</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${cModel.cno}</td>
				<td>${sessionScope.cInfo.get("Avg")}</td>
				<td>${sessionScope.cInfo.get("Min")}</td>
				<td>${sessionScope.cInfo.get("Max")}</td>
			</tr>
		</tbody>
	</table>
	<div style="height: 40px; clear: both; display: block"></div>
	<div align="center">
		<a class="btn btn-primary footer" href="/sms/queryStudentScore">返回</a>
	</div>
</body>
</html>