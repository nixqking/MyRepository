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
<script type="text/javascript">
	$(function() {
		$('#iframe').height($(window).height() - 1.1 * $('#div1').height());
		$('#iframe').width($(window).width() - 1.2 * $('#div2').width());
		window.onresize = function() {
			$('#iframe').height($(window).height() - 1.1 * $('#div1').height());
			$('#iframe').width($(window).width() - 1.2 * $('#div2').width());
		};
	});
</script>
</head>
<body style="background-color: #F0EEF5">
	<div class="container" style="width: 100%; float: left;">
		<div id="div1" style="width: 100%; float: left;">
			<c:if
				test="${sessionScope.student!=null && '' ne sessionScope.student.sname}">
				<h1 style="text-align: center;">
					你好！<a href="/sms/queryStudent" target="myfraame">${sessionScope.student.sname}</a>同学
				</h1>
			</c:if>
		</div>
		<div id="div2" style="width: 8%; float: left; height: 100%;">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div>
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 功能 <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li class="divider"></li>
									<li><a href="/sms/queryScore" target="myfraame">成绩查询</a></li>
									<li class="divider"></li>
									<li><a href="/sms/querycourse" target="myfraame">课程查询</a></li>
									<li class="divider"></li>
									<li><a href="/sms/spu" target="myfraame">修改密码</a></li>
									<li class="divider"></li>
									<li><a href="/sms/logout">退出系统</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div style="width: 90%; float: left;">
			<iframe name="myfraame" src="hello.jsp"
				style="width: 100%; float: left; border: none;" id="iframe"></iframe>
		</div>
	</div>
</body>
</html>