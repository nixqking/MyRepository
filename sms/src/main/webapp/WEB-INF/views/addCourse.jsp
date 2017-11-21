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
<script type="text/javascript" src="static/js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="static/css/bootstrapValidator.css">
<script type="text/javascript" src="static/js/modifyCourse.js"></script>
</head>
<body>
	<div class="container"
		style="margin: auto auto; width: 400px; height: 200px;">
		<div style="height: 10px; clear: both; display: block"></div>
		<form class="form-signin" role="form" action="/sms/addCourse"
			method="post">
			<%-- <input type="hidden" name="tno" value="${sessionScope.course.tno}"> --%>
			<h2 class="form-signin-heading" style="text-align: center;">添加课程信息</h2>
			<div style="height: 10px; clear: both; display: block"></div>
			<div class="form-group">
				<label class="sr-only">courseNumber</label><input type="text"
					class="form-control" name="cno" placeholder="请输入课程编号" id="cno">
			</div>

			<div style="height: 5px; clear: both; display: block"></div>

			<div class="form-group">
				<label class="sr-only">cname</label> <input type="text"
					class="form-control" placeholder="请输入课程名称" name="cname" id="cname">
			</div>
			<div style="height: 5px; clear: both; display: block"></div>
			<div class="form-group">
				<label class="sr-only">tno</label> <input type="text"
					class="form-control" placeholder="请输入教师工号" name="tno" id="tno">
			</div>
			<div style="height: 5px; clear: both; display: block"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				id="submitBtn">确定</button>
		</form>
		<div style="height: 5px; clear: both; display: block"></div>
		<a class="btn btn-primary btn-block" href="/sms/manageCourse">返回</a>
	</div>
</body>
</html>