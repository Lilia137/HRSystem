<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/login.css"/>
	<style>

		/* ---- particles.js container ---- */
		#particles-js {
			width: 100%;
			height: 100%;
			background-image: url("https://img.wenhairu.com/images/2021/06/29/9gXZg.jpg");
			background-size: cover;
			background-position: 50% 50%;
			background-repeat: no-repeat;
			width: 100%;
			height: 100%;
			position: absolute;
			top: 0;
			left: 0;
		}

		.login-content {
			width: 400px;
			height: 280px;
			margin: 0 auto;
			position: relative;
			top: 200px;
			border: 1px solid #ffffff;
			background: rgba(135, 154, 173, 0.5);
			border-radius: 5px;
		}

		.login-tit {
			background: rgba(0, 0, 0, 0.8);
			border: 1px solid #3c92e7;
			color: #ffffff;
			padding: 15px;
			font-size: 25px;
			text-align: center;
		}

		.login-input {
			width: 90%;
			margin: 30px auto 0 auto;
		}

		.login-input input {
			background: rgba(0, 0, 0, 0);
			border: 0;
			height: 30px;
			width: 100%;
			line-height: 30px;
			color: #fff;
			border-bottom: 1px solid rgba(40, 144, 250, 0.4);
		}

		.login-input input:focus {
			outline: none;
		}

		input::placeholder{
			color:#f5f5f5;
			font-size: 15px;
		}

		.login-btn {
			width: 90%;
			display: flex;
			color: #ffffff;
			margin: 40px auto 0 auto;
		}

		.login-btn-left span {
			background: #1b6319;
			padding: 10px 30px;
			border-radius: 5px;
			margin-left: 20px;
			cursor: pointer;
		}
	</style>
</head>
<body background="https://img.wenhairu.com/images/2021/06/29/9gT6U.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;
background-attachment: fixed;">
<!-- particles.js container -->
<div id="particles-js"
	 style="display: flex; align-items: center; justify-content: center">
</div>
<div class="login-page">
	<div class="login-content">
		<div class="login-tit">人力资源管理系统</div>

		<!--  <form name="myf" action="./Login" method="GET">
                -->
		<form action="./Login" method="get" name="myf">
			<c:if test="${not empty isOK}">
				<div style="color:red;font-size: 15px;font-weight: 400; margin-top: 1px;margin-left: 10px" >
					账号或者密码错误，请重新输入！
				</div>
			</c:if>
			<div class="login-input">
				<input name="userid" type="text" placeholder="账号"
					   value="${not empty userid? userid:'' }">
			</div>

			<div class="login-input">
				<input name="userpsw" type="password" value="" placeholder="密码">
			</div>
			<div class="login-btn">
				<div class="login-btn-left">
					<span onclick="mySubmit()">登陆</span>
				</div>
				<div class="login-btn-left">
					<span onclick="redirect1()">注册</span>
				</div>
				<div class="login-btn-left">
					<span onclick="redirect2()">招聘信息</span>
				</div>
			</div>
		</form>
	</div>
</div>


<!-- scripts -->
<script src="js/particles.js"></script>
<script src="js/app.js"></script>
<script>
	function mySubmit() {
		let userid = document.getElementsByName("userid")[0].value;
		let userpsw = document.getElementsByName("userpsw")[0].value;

		if (userid.length < 1) {
			alert('工号不能为空');
			document.getElementById('useridSpan').innerHTML = '*';
			return;
		}

		if (userpsw.length < 1) {
			alert('密码不能为空');
			document.getElementById('userpswSpan').innerHTML = '*';
			return;
		}
		myf.submit();
	}

	function redirect1() {
		window.location.href = "./Reg.jsp";

	}

	function redirect2() {
		window.location.href = "./AllRecruit?from='out'";
	}
</script>
</body>
</html>
