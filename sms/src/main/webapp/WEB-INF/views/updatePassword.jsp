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
<script type="text/javascript" src="static/js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="static/css/bootstrapValidator.css">
<script type="text/javascript" src="static/js/updatePassword.js"></script>
</head>
<body>
	<div class="container"
		style="margin: auto auto; width: 400px; height: 200px;">
		<div style="height: 10px; clear: both; display: block"></div>
		<c:choose>
			<c:when test="${sessionScope.administrator!=null}">
				<form class="form-signin" role="form" action="/sms/apu"
					method="post">
					<input type="hidden" name="account"
						value="${sessionScope.administrator.account}">
					<h2 class="form-signin-heading" style="text-align: center;">修改密码</h2>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">username</label><input type="text"
							class="form-control" name="oldPassword" placeholder="请输入原密码"
							id="oldPassword">
					</div>

					<div style="height: 10px; clear: both; display: block"></div>

					<div class="form-group">
						<label class="sr-only">password</label> <input type="text"
							class="form-control" placeholder="请输入新密码" name="newPassword"
							id="newPassword">
					</div>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">password</label> <input type="text"
							class="form-control" placeholder="请确认新密码" name="repeatPassword"
							id="repeatPassword">
					</div>
					<div style="height: 10px; clear: both; display: block"></div>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="submitBtn">确定</button>
				</form>
			</c:when>
			<c:when test="${sessionScope.teacher!=null}">
				<form class="form-signin" role="form" action="/sms/tpu"
					method="post">
					<input type="hidden" name="tno" value="${sessionScope.teacher.tno}">
					<h2 class="form-signin-heading" style="text-align: center;">修改密码</h2>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">username</label><input type="text"
							class="form-control" name="oldPassword" placeholder="请输入原密码"
							id="oldPassword">
					</div>

					<div style="height: 10px; clear: both; display: block"></div>

					<div class="form-group">
						<label class="sr-only">password</label> <input type="text"
							class="form-control" placeholder="请输入新密码" name="newPassword"
							id="newPassword">
					</div>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">password</label> <input type="text"
							class="form-control" placeholder="请确认新密码" name="repeatPassword"
							id="repeatPassword">
					</div>
					<div style="height: 10px; clear: both; display: block"></div>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="submitBtn">确定</button>
				</form>
			</c:when>
			<c:when test="${sessionScope.student!=null}">
				<form class="form-signin" role="form" action="/sms/spu"
					method="post">
					<input type="hidden" name="sno" value="${sessionScope.student.sno}">
					<h2 class="form-signin-heading" style="text-align: center;">修改密码</h2>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">username</label><input type="text"
							class="form-control" name="oldPassword" placeholder="请输入原密码"
							id="oldPassword">
					</div>

					<div style="height: 10px; clear: both; display: block"></div>

					<div class="form-group">
						<label class="sr-only">password</label> <input type="text"
							class="form-control" placeholder="请输入新密码" name="newPassword"
							id="newPassword">
					</div>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">password</label> <input type="text"
							class="form-control" placeholder="请确认新密码" name="repeatPassword"
							id="repeatPassword">
					</div>
					<div style="height: 10px; clear: both; display: block"></div>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="submitBtn">确定</button>
				</form>
			</c:when>
		</c:choose>

	</div>
</body>
</html>