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
		var clas = "li" + ${requestScope.ManageTeacherPageInfo.getPageNum()};
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
					<th>教职工号</th>
					<th>教师姓名</th>
					<th>教师性别</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" begin="0"
					end="${requestScope.teacherInfoList.size()}"
					items="${requestScope.teacherInfoList}">
					<tr>
						<td><c:out value="${i.getTno()}"></c:out></td>
						<td><c:out value="${i.getTname()}"></c:out></td>
						<td><c:out value="${i.getSex()}"></c:out></td>
						<td><a href="/sms/deleteTeacher?tno=${i.getTno()}"
							onclick="if(confirm('确定删除?')==false)return false;">删除</a></td>
						<td><a
							href="/sms/modifyTeacher?tno=${i.getTno()}&tname=${i.getTname()}&sex=${i.getSex()}">修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination">
			<c:if test="${requestScope.ManageTeacherPageInfo.getPageNum()!=null}">
				<c:if test="${requestScope.ManageTeacherPageInfo.getPageNum()>1}">
					<li><a class="previous"
						href="/sms/manageTeacher?pageNum=${requestScope.ManageTeacherPageInfo.getPageNum()<2
					?1:requestScope.ManageTeacherPageInfo.getPageNum()-1}">Previous</a></li>
				</c:if>
				<c:forEach
					begin="${requestScope.ManageTeacherPageInfo.getPageNum()-2<1
					?1:(requestScope.ManageTeacherPageInfo.getPageNum()-2)}"
					end="${requestScope.ManageTeacherPageInfo.getPageNum()+2<requestScope.ManageTeacherPageInfo.getPages()
					?requestScope.ManageTeacherPageInfo.getPageNum()+2:requestScope.ManageTeacherPageInfo.getPages()}"
					step="1" var="i">
					<li id="li${i}"><a href="/sms/manageTeacher?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<c:if
					test="${requestScope.ManageTeacherPageInfo.getPageNum()<requestScope.ManageTeacherPageInfo.getPages()}">
					<li><a class="next"
						href="/sms/manageTeacher?pageNum=${requestScope.ManageTeacherPageInfo.getPageNum()>=requestScope.ManageTeacherPageInfo.getPages()
					?requestScope.ManageTeacherPageInfo.getPageNum()
					:requestScope.ManageTeacherPageInfo.getPageNum()+1}">Next</a></li>
				</c:if>
			</c:if>
		</ul>
		<div align="right">
			<a class="btn btn-primary footer" href="/sms/addTeacher">添加教师</a>
		</div>
	</div>
</body>
</html>