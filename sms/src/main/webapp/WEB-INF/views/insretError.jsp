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
<body style="text-align: center;">
	<div style="height: 80px; clear: both; display: block"></div>
	<h2>出错了！</h2>
	<div style="height: 20px; clear: both; display: block"></div>
	<div>
		<p style="text-align: center; font-size: x-large;">输入的学生学号：${requestScope.insretError.sno},课程编号：${requestScope.insretError.cno},
			课程成绩：${requestScope.insretError.score},已经存在或者出现了错误，
			请检查课程编号是否为您所授课课程的编号以及学生学号是否为选修您所授课程的学生学号</p>
	</div>
	<div style="height: 40px; clear: both; display: block"></div>
	<div align="center">
		<a class="btn btn-primary footer" href="/sms/insertScore">返回</a>
	</div>
</body>
</html>