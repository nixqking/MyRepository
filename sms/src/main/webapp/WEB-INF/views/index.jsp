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
<script type="text/javascript" src="static/js/index.js"></script>
<script type="text/javascript" src="static/js/jquery.cookie.js"></script>
<script type="text/javascript">
<%-- <%="updateSucceed".equals(session.getAttribute("state"))%>
	; --%>
<%-- <%=session.getAttribute("Tstate") == null%>
	; --%>
	$(function() {
		var active =<%=session.getAttribute("Tstate") == null%>;
		var succeed =<%="updateSucceed".equals(session.getAttribute("state"))%>; 
		if (succeed) {
			jQuery.cookie("username", '', {expires : -1});
			jQuery.cookie("password", '', {expires : -1});
		}
		if (active) {
			$("#studentLi").addClass("active");
			$("#student").addClass("active");
		} else {
			$("#teacherLi").addClass("active");
			$("#teacher").addClass("active");
		}
	});
</script>
</head>
<body
	style="background-image: url('static/image/gdut.jpg'); background-size: cover;">
	<ul id="myTab" class="nav nav-tabs">
		<%
			//创建令牌
			String token = java.util.UUID.randomUUID().toString();
			//存在session中一份,以后做判断
			session.setAttribute("TOKEN_IN_SESSION", token);
			/* System.out.println("index:" + session.getAttribute("TOKEN_IN_SESSION")); */
		%>
		<li style="background-color: #6989B0;" id="studentLi"><a
			href="#student" data-toggle="tab"><font color="black">学生登录</font></a></li>
		<li style="background-color: #6989B0;" id="teacherLi"><a
			href="#teacher" data-toggle="tab"><font color="black">教师登录</font></a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane" id="student">
			<div class="container"
				style="margin: auto auto; width: 400px; height: 200px;">
				<div style="height: 10px; clear: both; display: block"></div>
				<form class="form-signin" role="form" action="/sms/studentlogin"
					method="post" target="_parent">
					<input type="hidden" value="<%=token%>" name="token">
					<c:choose>
						<c:when test="${'updateSucceed' eq sessionScope.state}">
							<c:remove var="state" scope="session" />
							<h2 class="form-signin-heading">密码修改成功，请重新登录</h2>
						</c:when>
						<c:when test="${'logout' eq sessionScope.state}">
							<c:remove var="state" scope="session" />
							<h2 class="form-signin-heading">已退出登录，请重新登录</h2>
						</c:when>
						<c:when test="${'error' eq sessionScope.state}">
							<c:remove var="state" scope="session" />
							<h2 class="form-signin-heading">登陆失败，请重新登录</h2>
						</c:when>
						<c:otherwise>
							<c:remove var="state" scope="session" />
							<h2 class="form-signin-heading">欢迎登录</h2>
						</c:otherwise>
					</c:choose>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">username</label><input type="text"
							class="form-control" name="sno" placeholder="请输入学生号"
							id="username">
					</div>

					<div style="height: 10px; clear: both; display: block"></div>

					<div class="form-group">
						<label class="sr-only">password</label> <input type="password"
							class="form-control" placeholder="请输入密码" name="password"
							id="password">
					</div>

					<div class="checkbox">
						<label> <input type="checkbox" id="rememberMe">
							记住登录状态
						</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="submitBtn">登录</button>
				</form>
				<div style="height: 10px; clear: both; display: block"></div>
				<a class="btn btn-primary btn-block" href="/sms/administratorLogin">管理员登录</a>
			</div>
		</div>
		<div class="tab-pane" id="teacher">
			<div class="container"
				style="margin: auto auto; width: 400px; height: 200px;">
				<div style="height: 10px; clear: both; display: block"></div>
				<form class="form-signin" role="form" action="/sms/teacherlogin"
					target="_parent" method="post">
					<input type="hidden" value="<%=token%>" name="token">
					<c:choose>
						<c:when test="${'updateSucceed' eq sessionScope.Tstate}">
							<c:remove var="Tstate" scope="session" />
							<h2 class="form-signin-heading">密码修改成功，请重新登录</h2>
						</c:when>
						<c:when test="${'logout' eq sessionScope.Tstate}">
							<c:remove var="Tstate" scope="session" />
							<h2 class="form-signin-heading">已退出登录，请重新登录</h2>
						</c:when>
						<c:when test="${'error' eq sessionScope.Tstate}">
							<c:remove var="Tstate" scope="session" />
							<h2 class="form-signin-heading">登陆失败，请重新登录</h2>
						</c:when>
						<c:otherwise>
							<c:remove var="Tstate" scope="session" />
							<h2 class="form-signin-heading">欢迎登录</h2>
						</c:otherwise>
					</c:choose>
					<div style="height: 10px; clear: both; display: block"></div>
					<div class="form-group">
						<label class="sr-only">username</label><input type="text"
							class="form-control" name="tno" placeholder="请输入工号" id="uname">
					</div>

					<div style="height: 10px; clear: both; display: block"></div>

					<div class="form-group">
						<label class="sr-only">password</label> <input type="password"
							class="form-control" placeholder="请输入密码" name="password"
							id="psword">
					</div>

					<div class="checkbox">
						<label> <input type="checkbox" id="rmbMe"> 记住登录状态
						</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="sBtn">登录</button>
				</form>
				<div style="height: 10px; clear: both; display: block"></div>
				<a class="btn btn-primary btn-block" href="/sms/administratorLogin">管理员登录</a>
			</div>
		</div>
	</div>
</body>
</html>