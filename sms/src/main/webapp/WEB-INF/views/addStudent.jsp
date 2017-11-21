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
<script type="text/javascript" src="static/js/modifyStudent.js"></script>
</head>
<body>
	<div class="container"
		style="margin: auto auto; width: 400px; height: 200px;">
		<div style="height: 10px; clear: both; display: block"></div>
		<form class="form-signin" role="form" action="/sms/addStudent"
			method="post">
			<%-- <input type="hidden" name="sno" value="${sessionScope.student.sno}"> --%>
			<h2 class="form-signin-heading" style="text-align: center;">添加学生信息</h2>
			<div style="height: 10px; clear: both; display: block"></div>
			<div class="form-group">
				<label class="sr-only">StudentNumber</label><input type="text"
					class="form-control" name="sno" placeholder="请输入学生学号" id="sno">
			</div>

			<div style="height: 5px; clear: both; display: block"></div>

			<div class="form-group">
				<label class="sr-only">sname</label> <input type="text"
					class="form-control" placeholder="请输入学生姓名" name="sname" id="sname">
			</div>
			<div style="height: 5px; clear: both; display: block"></div>
			<div class="form-group">
				<label class="sr-only">sex</label> <input type="text"
					class="form-control" placeholder="请输入学生性别" name="sex" id="sex">
			</div>
			<div style="height: 5px; clear: both; display: block"></div>
			<div class="form-group">
				<label class="sr-only">sdept</label><input type="text"
					class="form-control" name="sdept" placeholder="请输入所属学院" id="sdept">
			</div>

			<div style="height: 5px; clear: both; display: block"></div>
			<div class="form-group">
				<label class="sr-only">classe</label><input type="text"
					class="form-control" name="classe" placeholder="请输入所属班级"
					id="classe">
			</div>

			<div style="height: 5px; clear: both; display: block"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				id="submitBtn">确定</button>
		</form>
		<div style="height: 5px; clear: both; display: block"></div>
		<a class="btn btn-primary btn-block" href="/sms/manageStudent">返回</a>
	</div>
</body>
</html>