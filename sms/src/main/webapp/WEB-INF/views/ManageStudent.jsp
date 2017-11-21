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
		var clas = "li" + ${requestScope.ManageStudentPageInfo.getPageNum()}
		;
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
					<th>学生证号</th>
					<th>学生姓名</th>
					<th>学生性别</th>
					<th>所属学院</th>
					<th>所属班级</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" begin="0"
					end="${requestScope.studentInfoList.size()}"
					items="${requestScope.studentInfoList}">
					<tr>
						<td><c:out value="${i.getSno()}"></c:out></td>
						<td><c:out value="${i.getSname()}"></c:out></td>
						<td><c:out value="${i.getSex()}"></c:out></td>
						<td><c:out value="${i.getSdept()}"></c:out></td>
						<td><c:out value="${i.getClasse()}"></c:out></td>
						<td><a href="/sms/deleteStudent?sno=${i.getSno()}"
							onclick="if(confirm('确定删除?')==false)return false;">删除</a></td>
						<td><a
							href="/sms/modifyStudent?sno=${i.getSno()}&sname=${i.getSname()}&sex=${i.getSex()}&sdept=${i.getSdept()}&classe=${i.getClasse()}">修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination">
			<c:if test="${requestScope.ManageStudentPageInfo.getPageNum()!=null}">
				<c:if test="${requestScope.ManageStudentPageInfo.getPageNum()>1}">
					<li><a class="previous"
						href="/sms/manageStudent?pageNum=${requestScope.ManageStudentPageInfo.getPageNum()<2
					?1:requestScope.ManageStudentPageInfo.getPageNum()-1}">Previous</a></li>
				</c:if>
				<c:forEach
					begin="${requestScope.ManageStudentPageInfo.getPageNum()-2<1
					?1:(requestScope.ManageStudentPageInfo.getPageNum()-2)}"
					end="${requestScope.ManageStudentPageInfo.getPageNum()+2<requestScope.ManageStudentPageInfo.getPages()
					?requestScope.ManageStudentPageInfo.getPageNum()+2:requestScope.ManageStudentPageInfo.getPages()}"
					step="1" var="i">
					<li id="li${i}"><a href="/sms/manageStudent?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<c:if
					test="${requestScope.ManageStudentPageInfo.getPageNum()<requestScope.ManageStudentPageInfo.getPages()}">
					<li><a class="next"
						href="/sms/manageStudent?pageNum=${requestScope.ManageStudentPageInfo.getPageNum()>=requestScope.ManageStudentPageInfo.getPages()
					?requestScope.ManageStudentPageInfo.getPageNum()
					:requestScope.ManageStudentPageInfo.getPageNum()+1}">Next</a></li>
				</c:if>
			</c:if>
		</ul>
		<div align="right">
			<a class="btn btn-primary footer" href="/sms/addStudent">添加学生</a>
		</div>
	</div>
</body>
</html>