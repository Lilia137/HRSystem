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

		table tr:nth-child(even) {
			background:#e1e2e2;
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
	收到的简历信息
</h1>
<hr>
<br>
<div>
	<form action="./ResPage.jsp" method="get">
		查询条件：<select name="tip" id="">
		<option value ="all">全部</option>
		<option value ="wholename">名字</option>
		<option value ="sex">性别</option>
		<option value="age">最大年龄</option>
		<option value="workyear">最低工作年限</option>
		<option value="edulevel">学历</option>
	</select>
		<input type="text" name="content" placeholder="请输入">
		<input type="submit" value="确认">
	</form><br>
</div>

<table border="1">
	<thead>
	<tr>
		<th>名字</th>
		<th>性别</th>
		<th>年龄</th>
		<th>工作年限</th>
		<th>学历</th>
		<th>手机号</th>
		<th>清除</th>
	</tr>
	<thead>
	<tbody>
	<c:set var="aid" value="${requestScope.aid}"></c:set>
	<c:if test="${param.tip=='all' || param.tip==null}">
		<c:forEach items="${sessionScope.resList}" var="res" varStatus="status">
			<tr>
				<c:if test="${aid eq res.aid}">
					<td>${res.wholename }</td>
					<td>${res.sex }</td>
					<td>${res.age }</td>
					<td>${res.workyear }</td>
					<td>${res.edulevel }</td>
					<td>${res.phone }</td>
					<c:set var="delete" value="DeleteResume?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='wholename'}">
		<c:forEach items="${sessionScope.resList}" var="res" varStatus="status">
			<tr>
				<c:if test="${res.wholename eq param.content && aid eq res.aid}">
					<td>${res.wholename }</td>
					<td>${res.sex }</td>
					<td>${res.age }</td>
					<td>${res.workyear }</td>
					<td>${res.edulevel }</td>
					<td>${res.phone }</td>
					<c:set var="delete" value="DeleteResume?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='sex'}">
		<c:forEach items="${sessionScope.resList}" var="res" varStatus="status">
			<tr>
				<c:if test="${res.sex eq param.content && aid eq res.aid}">
					<td>${res.wholename }</td>
					<td>${res.sex }</td>
					<td>${res.age }</td>
					<td>${res.workyear }</td>
					<td>${res.edulevel }</td>
					<td>${res.phone }</td>
					<c:set var="delete" value="DeleteResume?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='age'}">
		<c:forEach items="${sessionScope.resList}" var="res" varStatus="status">
			<tr>
				<c:if test="${res.age le param.content && aid eq res.aid}">
					<td>${res.wholename }</td>
					<td>${res.sex }</td>
					<td>${res.age }</td>
					<td>${res.workyear }</td>
					<td>${res.edulevel }</td>
					<td>${res.phone }</td>
					<c:set var="delete" value="DeleteResume?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='workyear'}">
		<c:forEach items="${sessionScope.resList}" var="res" varStatus="status">
			<tr>
				<c:if test="${res.workyear ge param.content && aid eq res.aid}">
					<td>${res.wholename }</td>
					<td>${res.sex }</td>
					<td>${res.age }</td>
					<td>${res.workyear }</td>
					<td>${res.edulevel }</td>
					<td>${res.phone }</td>
					<c:set var="delete" value="DeleteResume?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='edulevel'}">
		<c:forEach items="${sessionScope.resList}" var="res" varStatus="status">
			<tr>
				<c:if test="${res.edulevel eq param.content && aid eq res.aid}">
					<td>${res.wholename }</td>
					<td>${res.sex }</td>
					<td>${res.age }</td>
					<td>${res.workyear }</td>
					<td>${res.edulevel }</td>
					<td>${res.phone }</td>
					<c:set var="delete" value="DeleteResume?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	<c:if test="${param.tip=='phone'}">
		<c:forEach items="${sessionScope.resList}" var="res" varStatus="status">
			<tr>
				<c:if test="${res.phone eq param.content && aid eq res.aid}">
					<td>${res.wholename }</td>
					<td>${res.sex }</td>
					<td>${res.age }</td>
					<td>${res.workyear }</td>
					<td>${res.edulevel }</td>
					<td>${res.phone }</td>
					<c:set var="delete" value="DeleteResume?did="></c:set>
					<c:set var="index" value="${status.index}"></c:set>
					<td><a href="${delete.concat(index)}">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>

	</tbody>
</table>

</body>
</html>