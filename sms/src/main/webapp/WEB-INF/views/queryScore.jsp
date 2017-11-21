<%@page import="com.neil.pojo.Sc"%>
<%@page import="com.github.pagehelper.PageInfo"%>
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
<script type="text/javascript">
	$(function() {
		var cls = "li" + ${requestScope.ScorePageInfo.getPageNum()};
		$("#" + cls).addClass("active");
	});
	$(function() {
		$('form').bootstrapValidator({
			fields : {
				search : {
					validators : {
						notEmpty : {
							message : '输入不能为空'
						}
					}
				}
			}
		});
	});
</script>
</head>
<body>
	<div style="height: 20px; clear: both; display: block"></div>
	<div class="container">
		<div>
			<form class="narbar-form navbar-left" role="search" method="post"
				action="/sms/searchScore">
				<div class="form-group col-xs-9">
					<input name="search" type="text" placeholder="请输入课程编号或名称"
						class="form-control">
				</div>
				<button type="submit" class="btn  btn-info col-xs-3">搜索</button>
			</form>
		</div>
		<div align="right">
			<a class="btn btn-primary footer" href="/sms/queryScore?request=all">下载成绩单</a>
		</div>
		<div style="height: 20px; clear: both; display: block"></div>
		<table class="table">
			<thead>
				<tr>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>课程成绩</th>
					<th>学生学号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" begin="0" end="${sessionScope.score.size()}"
					items="${sessionScope.score}">
					<tr>
						<td><c:out value="${i.getCno()}"></c:out></td>
						<td><c:out value="${i.getCourse().getCname()}"></c:out></td>
						<td><c:out value="${i.getScore()}"></c:out></td>
						<td><c:out value="${i.getSno()}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="left">
			<ul class="pagination">
				<c:if test="${requestScope.ScorePageInfo.getPageNum()!=null}">
					<c:if test="${requestScope.ScorePageInfo.getPageNum()>1}">
						<li><a class="previous"
							href="/sms/queryScore?pageNum=${requestScope.ScorePageInfo.getPageNum()<2
					?1:requestScope.ScorePageInfo.getPageNum()-1}">Previous</a></li>
					</c:if>
					<c:forEach
						begin="${requestScope.ScorePageInfo.getPageNum()-2<1
					?1:(requestScope.ScorePageInfo.getPageNum()-2)}"
						end="${requestScope.ScorePageInfo.getPageNum()+2<requestScope.ScorePageInfo.getPages()
					?requestScope.ScorePageInfo.getPageNum()+2:requestScope.ScorePageInfo.getPages()}"
						step="1" var="i">
						<li id="li${i}"><a href="/sms/queryScore?pageNum=${i}">${i}</a></li>
					</c:forEach>
					<c:if
						test="${requestScope.ScorePageInfo.getPageNum()<requestScope.ScorePageInfo.getPages()}">
						<li><a class="next"
							href="/sms/queryScore?pageNum=${requestScope.ScorePageInfo.getPageNum()>=requestScope.ScorePageInfo.getPages()
					?requestScope.ScorePageInfo.getPageNum()
					:requestScope.ScorePageInfo.getPageNum()+1}">Next</a></li>
					</c:if>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>