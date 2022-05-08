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
		table tr:nth-child(even) {
			background:#e1e2e2;
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
	员工信息
</h1>

<hr>
<br>
<div>
	<form action="./MainPage.jsp" method="get">
		查询类别：<select name="tip" id="">
		<option value ="all">全部</option>
		<option value ="eid">工号</option>
		<option value ="ename">员工姓名</option>
		<option value="dept">所在部门</option>
		<option value="position">职位</option>
		<option value="phone">电话</option>
		<option value="state">就职状态</option>
	</select>
		&nbsp;&nbsp;
		<input type="text" name="content" placeholder="请输入要查询的字段值">
		<input type="submit" value="确认">
	</form>
</div>
<br>
</div>

<table>
	<thead>
	<tr>
		<th>工号</th>
		<th>姓名</th>
		<th>部门</th>
		<th>职位</th>
		<th>手机号码</th>
		<th>状态</th>
		<th>操作1</th>
		<th>操作2</th>
	</tr>
	<thead>
	<tbody>
	<c:if test="${param.tip=='all' || param.tip==null}">
		<c:forEach items="${sessionScope.empList}" var="emp" varStatus="status">
			<tr>
				<td>${emp.eid }</td>
				<td>${emp.ename }</td>
				<td>${emp.dept }</td>
				<td>${emp.position }</td>
				<td>${emp.phone }</td>
				<td>${emp.state }</td>
				<c:set var="revise" value="./ReviseEmp.jsp?rid="></c:set>
				<c:set var="delete" value="DeleteEmp?did="></c:set>
				<c:set var="index" value="${status.index}"></c:set>
				<td><a href="${revise.concat(index)}">修改</a></td>
				<td><a href="${delete.concat(index)}">删除</a></td>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='eid'}">
		<c:forEach items="${sessionScope.empList}" var="emp" varStatus="status">
			<tr>
				<c:if test="${emp.eid eq param.content}">
					<td>${emp.eid }</td>
					<td>${emp.ename }</td>
					<td>${emp.dept }</td>
					<td>${emp.position }</td>
					<td>${emp.phone }</td>
					<td>${emp.state }</td>
					<c:set var="revise" value="./ReviseEmp.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteEmp?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='ename'}">
		<c:forEach items="${sessionScope.empList}" var="emp" varStatus="status">
			<tr>
				<c:if test="${emp.ename eq param.content}">
					<td>${emp.eid }</td>
					<td>${emp.ename }</td>
					<td>${emp.dept }</td>
					<td>${emp.position }</td>
					<td>${emp.phone }</td>
					<td>${emp.state }</td>
					<c:set var="revise" value="./ReviseEmp.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteEmp?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='dept'}">
		<c:forEach items="${sessionScope.empList}" var="emp" varStatus="status">
			<tr>
				<c:if test="${emp.dept eq param.content}">
					<td>${emp.eid }</td>
					<td>${emp.ename }</td>
					<td>${emp.dept }</td>
					<td>${emp.position }</td>
					<td>${emp.phone }</td>
					<td>${emp.state }</td>
					<c:set var="revise" value="./ReviseEmp.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteEmp?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='position'}">
		<c:forEach items="${sessionScope.empList}" var="emp" varStatus="status">
			<tr>
				<c:if test="${emp.position eq param.content}">
					<td>${emp.eid }</td>
					<td>${emp.ename }</td>
					<td>${emp.dept }</td>
					<td>${emp.position }</td>
					<td>${emp.phone }</td>
					<td>${emp.state }</td>
					<c:set var="revise" value="./ReviseEmp.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteEmp?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='phone'}">
		<c:forEach items="${sessionScope.empList}" var="emp" varStatus="status">
			<tr>
				<c:if test="${emp.phone eq param.content}">
					<td>${emp.eid }</td>
					<td>${emp.ename }</td>
					<td>${emp.dept }</td>
					<td>${emp.position }</td>
					<td>${emp.phone }</td>
					<td>${emp.state }</td>
					<c:set var="revise" value="./ReviseEmp.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteEmp?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='state'}">
		<c:forEach items="${sessionScope.empList}" var="emp" varStatus="status">
			<tr>
				<c:if test="${emp.state eq param.content}">
					<td>${emp.eid }</td>
					<td>${emp.ename }</td>
					<td>${emp.dept }</td>
					<td>${emp.position }</td>
					<td>${emp.phone }</td>
					<td>${emp.state }</td>
					<c:set var="revise" value="./ReviseEmp.jsp?rid="></c:set>
					<c:set var="delete" value="DeleteEmp?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${revise.concat(index)}">修改</a></td>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>

</body>
</html>