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
      max-width: 500px;
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
      font-size: 20px;
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
      color: #888;
      height: 30px;
      margin-bottom: 16px;
      margin-right: 6px;
      margin-top: 2px;
      outline:0 none;
      padding: 3px 3px 3px 5px;
      width: 70%;
      font-size: 12px;
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
      text-shadow:1px 1px 1px #9E3F3F;
      cursor:pointer;
    }
    .basic-grey .button:hover {
      background: #CF7A7A
    }

  </style>
</head>
<body background="https://img.wenhairu.com/images/2021/06/29/9gIV0.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%;
background-attachment: fixed;">
<form action="./Register" method="get" name="myf" class="basic-grey">
  <h1>??????
    <span>?????????????????????</span>
  </h1>
  <label>
    <span>?????? :</span>
    <input type="text" name="userid" placeholder="???????????????">
  </label>
  <label>
    <span>?????? :</span>
    <input type="text" name="userpsw" placeholder="?????????????????????8???" minlength="1" maxlength="8">
  </label>
  <label>
    <span>?????? :</span>
    <input type="text" name="nickname" placeholder="?????????????????????">
  </label>
  <label>
    <span>?????? :</span>
    <input type="file" name="headpic" >
    <button type="button" id="upBtn">????????????</button>
  </label>
  <label>
    <br>
    <br>
    <input type="button" class="button" onclick="success()" style="margin-left:110px;" value="??????" />
    <!-- <span>&nbsp;</span> -->
    <input type="button" class="button" onclick="send()" style="margin-left: 140px;" value="??????" />
  </label>
</form>

<script type="text/javascript">
  document.getElementById("upBtn").onclick = function (){
    let xhr = new XMLHttpRequest();
    let fd = new FormData(document.getElementById("myf"));
    xhr.onreadystatechange = function (){
      if(xhr.readyState ==4){
        if(xhr.status==200){
          alert("????????????");
        }
      }
    }
    xhr.upload.onprogress = function(e) {
      // prog.innerHTML = Math.round(e.loaded/e.total)+'%';
    }
    xhr.onload = function (){

    }
    xhr.open('POST','http://localhost:8080/hr/RegServlet',true);
    xhr.send(fd);
  }

  function send(){
    window.location.href = "./Login.jsp";
  }

  function success(){
    let userid = document.getElementsByName("userid")[0].value;
    let userpsw = document.getElementsByName("userpsw")[0].value;
    let nickname = document.getElementsByName("nickname")[0].value;

    if (userid.length < 1) {
      alert('??????????????????');
      return;
    }

    if (userpsw.length < 1) {
      alert('??????????????????');
      return;
    }

    if (nickname.length < 1) {
      alert('??????????????????');
      return;
    }
    if (userpsw.length < 1) {
      alert('??????????????????');
      return;
    }
    myf.submit();
    alert("???????????????????????????");
    window.location.href = "./Login.jsp";
  }

</script>
</body>
</html>