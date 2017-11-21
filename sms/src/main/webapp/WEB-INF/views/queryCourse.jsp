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
		var cls = "li" + ${requestScope.CoursePageInfo.getPageNum()};
		$("#" + cls).addClass("active");
	});
</script>
</head>
<body>
	<div style="height: 20px; clear: both; display: block"></div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>老师姓名</th>
					<th>老师工号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" begin="0" end="${sessionScope.course.size()}"
					items="${sessionScope.course}">
					<tr>
						<td><c:out value="${i.getCno()}"></c:out></td>
						<td><c:out value="${i.getCname()}"></c:out></td>
						<td><c:out value="${i.getTeacher().getTname()}"></c:out></td>
						<td><c:out value="${i.getTeacher().getTno()}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination">
			<c:if test="${requestScope.CoursePageInfo.getPageNum()!=null}">
				<c:if test="${requestScope.CoursePageInfo.getPageNum()>1}">
					<li><a class="previous"
						href="/sms/querycourse?pageNum=${requestScope.CoursePageInfo.getPageNum()<2
					?1:requestScope.CoursePageInfo.getPageNum()-1}">Previous</a></li>
				</c:if>
				<c:forEach
					begin="${requestScope.CoursePageInfo.getPageNum()-2<1
					?1:(requestScope.CoursePageInfo.getPageNum()-2)}"
					end="${requestScope.CoursePageInfo.getPageNum()+2<requestScope.CoursePageInfo.getPages()
					?requestScope.CoursePageInfo.getPageNum()+2:requestScope.CoursePageInfo.getPages()}"
					step="1" var="i">
					<li id="li${i}"><a href="/sms/querycourse?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<c:if
					test="${requestScope.CoursePageInfo.getPageNum()<requestScope.CoursePageInfo.getPages()}">
					<li><a class="next"
						href="/sms/querycourse?pageNum=${requestScope.CoursePageInfo.getPageNum()>=requestScope.CoursePageInfo.getPages()
					?requestScope.CoursePageInfo.getPageNum()
					:requestScope.CoursePageInfo.getPageNum()+1}">Next</a></li>
				</c:if>
			</c:if>
		</ul>
	</div>
</body>
</html>