<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<style>
		.basic-grey {
			margin-left:auto;
			margin-right:auto;
			max-width: 800px;
			background: #F7F7F7;
			padding: 25px 15px 25px 10px;
			font: 12px Georgia, "Times New Roman", Times, serif;
			color: #888;
			text-shadow: 1px 1px 1px #FFF;
			border: 1px solid #E4E4E4;
		}
		.basic-grey h1 {
			font-size: 35px;
			padding: 0px 0px 10px 40px;
			display: block;
			border-bottom:1px solid #E4E4E4;
			margin: -10px -15px 30px -10px;;
			color: rgb(0, 0, 0);
		}
		.basic-grey h1>span {
			display: block;
			font-size: 15px;
		}
		.basic-grey label {
			display: block;
			margin: 0px;
		}
		.basic-grey label>span {
			float: left;
			width: 20%;
			text-align: right;
			padding-right: 10px;
			margin-top: 10px;
			font-size: 15px;
			font-weight: 800;
			color: #000;
		}
		.basic-grey input[type="text"], .basic-grey input[type="email"], .basic-grey textarea, .basic-grey select {
			border: 1px solid #DADADA;
			color: rgb(77, 73, 73);
			height: 30px;
			margin-bottom: 16px;
			margin-right: 6px;
			margin-top: 2px;
			outline:0 none;
			padding: 3px 3px 3px 5px;
			width: 70%;
			font-size: 15px;
			line-height:15px;
			box-shadow:inset 0px 1px 4px #ECECEC;
			-moz-box-shadow: inset 0px 1px 4px #ECECEC;
			-webkit-box-shadow: inset 0px 1px 4px #ECECEC;
		}
		.basic-grey textarea{
			padding: 5px 3px 3px 5px;
		}
		.basic-grey textarea{
			height:100px;
		}
		.basic-grey .button {
			background: #E27575;
			border: none;
			padding: 10px 25px 10px 25px;
			color: #FFF;
			box-shadow: 1px 1px 5px #B6B6B6;
			border-radius: 3px;
			margin-left: 190px;
			text-shadow:1px 1px 1px #9E3F3F;
			cursor:pointer;
		}
		.basic-grey .button:hover {
			background: #CF7A7A
		}
	</style>
</head>
<body>
<form action="./AddResume" name="myf" method="GET" class="basic-grey">
	<h1>个人简历
		<span>请输入您的个人信息</span>
	</h1>
	<label>
		<span>全名 :</span>
		<input type="text" name="wholename" placeholder="">
	</label>
	<label>
		<span>性别 :</span>
		<input name="sex" type="radio" value="男" />男
		<input name="sex" type="radio" value="女" />女
	</label>
	<br>
	<label>
		<span>年龄 :</span>
		<input type="text" name="age" placeholder="">
	</label>
	<label>
		<span>工作年限 :</span>
		<input type="text" name="workyear" >
	</label>
	<label>
		<span>学历 :</span>
		<select name="edulevel" id="">
			<option value ="高中">高中</option>
			<option value ="专科">专科</option>
			<option value="本科">本科</option>
		</select>
	</label>
	<label>
		<span>手机 :</span>
		<input type="text" name="phone" >
	</label>
	<input type="hidden" name="aid" value="${param.aid}">
	<label>
		<span>&nbsp;</span><br>
		<input type="button" class="button" onclick="success()" value="提  交" />
	</label>
</form>

<script>
	function success(){
		myf.submit();
		alert("恭喜你，提交成功！");
		window.location.href = "./Login.jsp";
	}
</script>
</body>
</html>