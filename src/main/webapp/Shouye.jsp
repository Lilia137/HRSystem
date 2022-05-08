<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/29
  Time: 4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style>
        div{
            margin-top: 100px;
            text-align: center;
        }
        h1{
            font-size: 25px;
            margin-top: 50px;
            text-align: center;
        }
        h2{
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>


<h2>
    Welcome！
</h2>

<div>
    <c:set var="pic" value="${sessionScope.loginUser.headpic }"></c:set>
    <img style="width:60px;height:60px" src="${pic }" alt=""/>
<%--    <img style="width:30px;height:30px" src="https://img.wenhairu.com/images/2021/06/29/9gejK.jpg" alt=""/>--%>
</div>
<h1>
    欢迎  [${sessionScope.loginUser.nickname}] 回来
</h1>
</body>
</html>
