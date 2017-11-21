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
<script type="text/javascript" src="static/js/administratorLogin.js"></script>
<script type="text/javascript" src="static/js/jquery.cookie.js"></script>
</head>
<body
	style="background-image: url('static/image/gdut.jpg'); background-size: cover;">
	<%
		//创建令牌
		String token_admini = java.util.UUID.randomUUID().toString();
		//存在session中一份,以后做判断
		session.setAttribute("TOKEN_IN_SESSION_ADMINI", token_admini);
		/* System.out.println("index:" + session.getAttribute("TOKEN_IN_SESSION_ADMINI")); */
	%>
	<div class="container"
		style="margin: auto auto; width: 400px; height: 200px;">
		<div style="height: 10px; clear: both; display: block"></div>
		<form class="form-signin" role="form" action="/sms/administratorLogin"
			method="post" target="_parent">
			<input type="hidden" value="<%=token_admini%>" name="token_admini">
			<%
				if ("updateSucceed".equals(session.getAttribute("Astate"))) {
					session.removeAttribute("Astate");
			%>
			<h2 class="form-signin-heading">密码修改成功，请重新登录</h2>
			<%
				} else if ("logout".equals(session.getAttribute("Astate"))) {
					session.removeAttribute("Astate");
			%>
			<h2 class="form-signin-heading">已退出登录，请重新登录</h2>
			<%
				} else if ("error".equals(session.getAttribute("Astate"))) {
					session.removeAttribute("Astate");
			%>
			<h2 class="form-signin-heading">登陆失败，请重新登录</h2>
			<%
				} else {
					session.removeAttribute("Astate");
			%>
			<h2 class="form-signin-heading">管理员登录</h2>
			<%
				}
			%>
			<div style="height: 10px; clear: both; display: block"></div>
			<div class="form-group">
				<label class="sr-only">username</label><input type="text"
					class="form-control" name="account" placeholder="请输入账号"
					id="username">
			</div>

			<div style="height: 10px; clear: both; display: block"></div>

			<div class="form-group">
				<label class="sr-only">password</label> <input type="password"
					class="form-control" placeholder="请输入密码" name="password"
					id="password">
			</div>
			<div style="height: 10px; clear: both; display: block"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				id="submitBtn">登录</button>
			<div style="height: 10px; clear: both; display: block"></div>
		</form>
		<div style="height: 10px; clear: both; display: block"></div>
		<a class="btn btn-primary btn-block" href="/sms/">普通登录</a>
	</div>