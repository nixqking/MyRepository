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
		var clas = "li" + ${requestScope.PageInfo.getPageNum()}
		;
		$("#" + clas).addClass("active");
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
			<form class="narbar-form navbar-left" role="search"
				action="/sms/searchStudentScore">
				<div class="form-group col-xs-9">
					<input name="search" type="text" placeholder="请输入学生学号或姓名"
						class="form-control">
				</div>
				<button type="submit" class="btn  btn-info col-xs-3">搜索</button>
			</form>
		</div>
		<div align="right">
			<a class="btn btn-info" href="/sms/queryStudentScore?param=fail">不及格名单</a>
			<c:choose>
				<c:when test="${sessionScope.OrderBy eq 'score'}">
					<a class="btn btn-info"
						href="/sms/queryStudentScore?request=all&param=score">下载成绩单</a>
				</c:when>
				<c:when test="${sessionScope.OrderBy eq 'sdept'}">
					<a class="btn btn-info"
						href="/sms/queryStudentScore?request=all&param=sdept">下载成绩单</a>
				</c:when>
				<c:when test="${sessionScope.OrderBy eq 'fail'}">
					<a class="btn btn-info"
						href="/sms/queryStudentScore?request=all&param=fail">下载成绩单</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-info"
						href="/sms/queryStudentScore?request=all&param=sno">下载成绩单</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div style="height: 20px; clear: both; display: block"></div>
		<div>
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div>
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 排序 <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li class="divider"></li>
									<li><a href="/sms/queryStudentScore?param=score">按成绩排序</a></li>
									<li class="divider"></li>
									<li><a href="/sms/queryStudentScore?param=sno">按学号排序</a></li>
									<li class="divider"></li>
									<li><a href="/sms/queryStudentScore?param=sdept">按学院排序</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
			<table class="table">
				<thead>
					<tr>
						<th>课程编号</th>
						<th>课程名称</th>
						<th>课程成绩</th>
						<th>学生学号</th>
						<th>学生姓名</th>
						<th>学生性别</th>
						<th>所属学院</th>
						<th>学生班级</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" begin="0"
						end="${sessionScope.studentScore.size()+1}"
						items="${sessionScope.studentScore}">
						<tr>
							<td><a href="/sms/avgScore?cno=${i.getCourse().getCno()}"><c:out
										value="${i.getCourse().getCno()}"></c:out></a></td>
							<td><c:out value="${i.getCourse().getCname()}"></c:out></td>
							<td><c:out value="${i.getScore()}"></c:out></td>
							<td><c:out value="${i.getSno()}"></c:out></td>
							<td><c:out value="${i.getStudent().getSname()}"></c:out></td>
							<td><c:out value="${i.getStudent().getSex()}"></c:out></td>
							<td><c:out value="${i.getStudent().getSdept()}"></c:out></td>
							<td><c:out value="${i.getStudent().getClasse()}"></c:out></td>
							<td><a onclick="if(confirm('确定删除?')==false)return false;"
								href="/sms/deleteStudentScore?sno=${i.getSno()}&course.cno=${i.getCourse().getCno()}">删除</a></td>
							<td><a
								href="/sms/modifyStudentScore?sno=${i.getSno()}&course.cno=${i.getCourse().getCno()}&score=${i.getScore()}">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<ul class="pagination">
				<c:if test="${requestScope.PageInfo.getPageNum()!=null}">
					<c:if test="${requestScope.PageInfo.getPageNum()>1}">
						<c:choose>
							<c:when test="${sessionScope.OrderBy eq 'score'}">
								<li><a class="previous"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()<2
					?1:(requestScope.PageInfo.getPageNum()-1)}&param=score">Previous</a></li>
							</c:when>
							<c:when test="${sessionScope.OrderBy eq 'sdept'}">
								<li><a class="previous"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()<2
					?1:(requestScope.PageInfo.getPageNum()-1)}&param=sdept">Previous</a></li>
							</c:when>
							<c:when test="${sessionScope.OrderBy eq 'fail'}">
								<li><a class="previous"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()<2
					?1:(requestScope.PageInfo.getPageNum()-1)}&param=fail">Previous</a></li>
							</c:when>
							<c:otherwise>
								<li><a class="previous"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()<2
					?1:(requestScope.PageInfo.getPageNum()-1)}&param=sno">Previous</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:forEach
						begin="${requestScope.PageInfo.getPageNum()-2<1
					?1:(requestScope.PageInfo.getPageNum()-2)}"
						end="${requestScope.PageInfo.getPageNum()+2<requestScope.PageInfo.getPages()
					?requestScope.PageInfo.getPageNum()+2:requestScope.PageInfo.getPages()}"
						step="1" var="i">
						<c:choose>
							<c:when test="${sessionScope.OrderBy eq 'score'}">
								<li id="li${i}"><a
									href="/sms/queryStudentScore?pageNum=${i}&param=score">${i}</a></li>
							</c:when>
							<c:when test="${sessionScope.OrderBy eq 'sdept'}">
								<li id="li${i}"><a
									href="/sms/queryStudentScore?pageNum=${i}&param=sdept">${i}</a></li>
							</c:when>
							<c:when test="${sessionScope.OrderBy eq 'fail'}">
								<li id="li${i}"><a
									href="/sms/queryStudentScore?pageNum=${i}&param=fail">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li id="li${i}"><a
									href="/sms/queryStudentScore?pageNum=${i}&param=sno">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if
						test="${requestScope.PageInfo.getPageNum()<requestScope.PageInfo.getPages()}">
						<c:choose>
							<c:when test="${sessionScope.OrderBy eq 'score'}">
								<li><a class="next"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()>=requestScope.PageInfo.getPages()
					?requestScope.PageInfo.getPageNum()
					:(requestScope.PageInfo.getPageNum()+1)}&param=score">Next</a></li>
							</c:when>
							<c:when test="${sessionScope.OrderBy eq 'sdept'}">
								<li><a class="next"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()>=requestScope.PageInfo.getPages()
					?requestScope.PageInfo.getPageNum()
					:(requestScope.PageInfo.getPageNum()+1)}&param=sdept">Next</a></li>
							</c:when>
							<c:when test="${sessionScope.OrderBy eq 'fail'}">
								<li><a class="next"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()>=requestScope.PageInfo.getPages()
					?requestScope.PageInfo.getPageNum()
					:(requestScope.PageInfo.getPageNum()+1)}&param=fail">Next</a></li>
							</c:when>
							<c:otherwise>
								<li><a class="next"
									href="/sms/queryStudentScore?pageNum=${requestScope.PageInfo.getPageNum()>=requestScope.PageInfo.getPages()
					?requestScope.PageInfo.getPageNum()
					:(requestScope.PageInfo.getPageNum()+1)}&param=sno">Next</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>