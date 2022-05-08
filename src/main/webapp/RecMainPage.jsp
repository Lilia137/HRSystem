<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>

		body {
			text-align: center;

		}


		table {
			border-collapse: collapse;
			font-family: Futura, Arial, sans-serif;
			width: 1000px;
			text-align: center;
			margin: 0 auto;
		}
		caption {
			font-size: larger;
			margin: 1em auto;
		}
		table tr:nth-child(even) {
			background:#e1e2e2;
		}

		th,td {
			padding: .65em;
			text-align: center;
			font-size: 15;
		}

		th {
			background: rgb(141, 177, 233) scroll 0 0;
			color: #fff;
			font-size: 15px;
			text-align: center;

		}

		tbody tr:nth-child(odd) {
			background: rgb(238, 240, 161);
		}

		th:first-child {
			border-radius: 9px 0 0 0;
		}

		th:last-child {
			border-radius: 0 9px 0 0;
		}

		tr:last-child td:first-child {
			border-radius: 0 0 0 9px;
		}

		tr:last-child td:last-child {
			border-radius: 0 0 9px 0;
		}
	</style>

</head>
<body>
<h1>
	招聘信息
</h1>
<hr>
<br>
<div>
	<form action="./RecMainPage.jsp" method="get">
		查询条件：<select name="tip" id="">
		<option value ="all">全部</option>
		<option value ="pname">职位名称</option>
		<option value ="ptype">职位类型</option>
		<option value="worktime">最长周工作时间</option>
		<option value="salary">最低年薪</option>
	</select>
		<input type="text" name="content" placeholder="请输入">
		<input type="submit" value="确认">
	</form><br>
</div>

<table border="1">
	<thead>
	<tr>
		<th>职位名称</th>
		<th>职位类型</th>
		<th>周工作时间/h</th>
		<th>年薪/万</th>
		<th>需要人数</th>
		<th>截止日期</th>
		<th>修改</th>
		<th>删除</th>
		<th>查看简历</th>
	</tr>
	<thead>
	<tbody>
	<c:if test="${param.tip=='all' || param.tip==null}">
		<c:forEach items="${sessionScope.recList}" var="rec" varStatus="status">
			<tr>
				<td>${rec.pname }</td>
				<td>${rec.ptype }</td>
				<td>${rec.worktime }</td>
				<td>${rec.salary }</td>
				<td>${rec.neednum }</td>
				<td>${rec.deadline }</td>
				<c:set var="revise" value="./ReviseRec.jsp?rid="></c:set>
				<c:set var="delete" value="DeleteRecruit?did="></c:set>
				<c:set var="resumes" value="AllResumes?aid="></c:set>
				<c:set var="index" value="${status.index}"></c:set>
				<td><a href="${revise.concat(index)}">修改</a></td>
				<td><a href="${delete.concat(index)}">删除</a></td>
				<td><a href="${resumes.concat(index)}">简历投递情况</a></td>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='pname'}">
		<c:forEach items="${sessionScope.recList}" var="rec" varStatus="status">
			<tr>
				<c:if test="${rec.pname eq param.content}">
					<td>${rec.pname }</td>
					<td>${rec.ptype }</td>
					<td>${rec.worktime }</td>
					<td>${rec.salary }</td>
					<td>${rec.neednum }</td>
					<td>${rec.deadline }</td>
					<c:set var="revise" value="./ReviseRec.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteRecruit?did="></c:set>
					<c:set var="resumes" value="AllResumes?aid="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
					<td><a href="${resumes.concat(index)}">简历投递情况</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='ptype'}">
		<c:forEach items="${sessionScope.recList}" var="rec" varStatus="status">
			<tr>
				<c:if test="${rec.ptype eq param.content}">
					<td>${rec.pname }</td>
					<td>${rec.ptype }</td>
					<td>${rec.worktime }</td>
					<td>${rec.salary }</td>
					<td>${rec.neednum }</td>
					<td>${rec.deadline }</td>
					<c:set var="revise" value="./ReviseRec.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteRecruit?did="></c:set>
					<c:set var="resumes" value="AllResumes?aid="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
					<td><a href="${resumes.concat(index)}">简历投递情况</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='worktime'}">
		<c:forEach items="${sessionScope.recList}" var="rec" varStatus="status">
			<tr>
				<c:if test="${rec.worktime le param.content}">
					<td>${rec.pname }</td>
					<td>${rec.ptype }</td>
					<td>${rec.worktime }</td>
					<td>${rec.salary }</td>
					<td>${rec.neednum }</td>
					<td>${rec.deadline }</td>
					<c:set var="revise" value="./ReviseRec.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteRecruit?did="></c:set>
					<c:set var="resumes" value="AllResumes?aid="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
					<td><a href="${resumes.concat(index)}">简历投递情况</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='salary'}">
		<c:forEach items="${sessionScope.recList}" var="rec" varStatus="status">
			<tr>
				<c:if test="${rec.salary ge param.content}">
					<td>${rec.pname }</td>
					<td>${rec.ptype }</td>
					<td>${rec.worktime }</td>
					<td>${rec.salary }</td>
					<td>${rec.neednum }</td>
					<td>${rec.deadline }</td>
					<c:set var="revise" value="./ReviseRec.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteRecruit?did="></c:set>
					<c:set var="resumes" value="AllResumes?aid="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
					<td><a href="${resumes.concat(index)}">简历投递情况</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	</tbody>
</table>

</body>
</html>