<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			body{
				margin: 0px;
				background-image: url("https://img.wenhairu.com/images/2021/06/29/9g4nv.jpg");
			}
			.top{
				position: absolute;
				top: 0px;
				left: 0px;
				right: 0px;
				height: 80px;
				background: rgb(222, 226, 226,0.5);
				text-align: center;
				color: rgb(0, 0, 0);
				line-height: 100px;
				font-size: 30px;
				font-weight: 520;
			}
			span{
				margin-top: 1px;
			}
			.menu{
				position: absolute;
				top: 80px;
				bottom: 15px;
				left: 0px;
				width: 200px;
				background: rgba(179, 138, 247, 0.877);
			}
			.menu ul{
				margin: 1.5em 0px;
				padding: 0px;
				
			}
			
			.menu ul li{
				margin-top: 10px;
				padding: 0px;
				width: 100%;
				height: 3em;
				line-height: 3em;
				text-align: center;
				
			}
			.menu ul li:hover{
				background: rgb(212, 212, 238);
			}
			.menu ul li a{
				font-size: 20px;
				font-family: "微软雅黑";
				color: #fff;
				text-decoration: none;
			}
			
			.main{
				position: absolute;
				top: 80px;
				bottom: 15px;
				left: 200px;
				right: 0px;
				background: rgb(255, 255, 255, 0.7);
			}
			.main iframe[name=mainFrame]{
				border: none 0px ;
			}
		</style>
	</head>
	<body background="https://img.wenhairu.com/images/2021/06/29/9g4nv.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;
background-attachment: fixed;">
		<div class="top">
			<span>人力资源管理系统</span>
		</div>
		<div class="menu">
			<ul>
				<li><a href="Shouye.jsp" target="mainFrame">首页</a></li>
				<li><a href="./AllEmp" target="mainFrame">所有员工</a></li>
				<li><a href="./AddEmp.jsp" target="mainFrame">添加员工</a></li>
				<li><a href="./AllRecruit" target="mainFrame">招聘信息</a></li>
				<li><a href="./AddRec.jsp" target="mainFrame">发布招聘</a></li>
				<li><a href="./Login.jsp" target="">退出系统</a></li>
			</ul>
		</div>
		<div class="main">
			<iframe name="mainFrame" src="Shouye.jsp" width="100%" height="100%" scrolling="auto"></iframe>
		</div>
	</body>
</html>