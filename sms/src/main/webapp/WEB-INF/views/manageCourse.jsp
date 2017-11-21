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
		var clas = "li" + ${requestScope.ManageCoursePageInfo.getPageNum()};
		$("#" + clas).addClass("active");
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
					<th>老师工号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" begin="0"
					end="${requestScope.courseInfoList.size()}"
					items="${requestScope.courseInfoList}">
					<tr>
						<td><c:out value="${i.getCno()}"></c:out></td>
						<td><c:out value="${i.getCname()}"></c:out></td>
						<td><c:out value="${i.getTno()}"></c:out></td>
						<td><a href="/sms/deleteCourse?cno=${i.getCno()}"
							onclick="if(confirm('确定删除?')==false)return false;">删除</a></td>
						<td><a
							href="/sms/modifyCourse?cno=${i.getCno()}&cname=${i.getCname()}&tno=${i.getTno()}">修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination">
			<c:if test="${requestScope.ManageCoursePageInfo.getPageNum()!=null}">
				<c:if test="${requestScope.ManageCoursePageInfo.getPageNum()>1}">
					<li><a class="previous"
						href="/sms/manageCourse?pageNum=${requestScope.ManageCoursePageInfo.getPageNum()<2
					?1:requestScope.ManageCoursePageInfo.getPageNum()-1}">Previous</a></li>
				</c:if>
				<c:forEach
					begin="${requestScope.ManageCoursePageInfo.getPageNum()-2<1
					?1:(requestScope.ManageCoursePageInfo.getPageNum()-2)}"
					end="${requestScope.ManageCoursePageInfo.getPageNum()+2<requestScope.ManageCoursePageInfo.getPages()
					?requestScope.ManageCoursePageInfo.getPageNum()+2:requestScope.ManageCoursePageInfo.getPages()}"
					step="1" var="i">
					<li id="li${i}"><a href="/sms/manageCourse?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<c:if
					test="${requestScope.ManageCoursePageInfo.getPageNum()<requestScope.ManageCoursePageInfo.getPages()}">
					<li><a class="next"
						href="/sms/manageCourse?pageNum=${requestScope.ManageCoursePageInfo.getPageNum()>=requestScope.ManageCoursePageInfo.getPages()
					?requestScope.ManageCoursePageInfo.getPageNum()
					:requestScope.ManageCoursePageInfo.getPageNum()+1}">Next</a></li>
				</c:if>
			</c:if>
		</ul>
		<div align="right">
			<a class="btn btn-primary footer" href="/sms/addCourse">添加课程</a>
		</div>
	</div>
</body>
</html>