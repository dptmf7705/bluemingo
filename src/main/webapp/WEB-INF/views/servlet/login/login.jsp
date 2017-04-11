<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@include file="../header.jsp" %>
<script> 
function onf(a){ 
	if(a.id=="loginPassword"){
		a.type = "password";
	}
	if (a.defaultValue==a.value) {
		a.value = "";
   }
}
function onb(a){
	if(a.value==""){
		if(a.id=="loginPassword"){
			a.type = "text";
		}
		a.value=a.defaultValue;
	}
}
</script>
<html>
<head>

<style>
.login_form{
	padding:10px;
}
.box_login{
	margin:10px;
	float:left;
	width:350px;
	text-align: center;
}
.login_form>input{
	margin:5px 0px; 
	padding:10px; 
	width:100%;
}
.login_form>button{
	margin:5px 0px; 
	padding:10px; 
	width:100%;
}
#rememberMe{
	margin: 5px 2px;
	padding: 0px;
	width:auto;
	float:left;
}
.login_bottom{
	padding:0px; 
	width:100%; 
	float:left;
}
</style>


</head>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- modify in 2017.2 by Bluemingo -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="/resources/dist/css/BlueMingoUi.min.css" rel="stylesheet" type="text/css" />
<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>

<!-- jQuery-UI -->
<script src="/resources/jquery-ui-1.11.4/jquery-ui.min.js"></script>
	
	
<body>

<div class="box box-header">
	<div class="box_login">
		<h3>로그인</h3>
		<hr>
		<c:if test="${not empty param.fail}">
			<font color="red">login fail, try again.</font>
		</c:if>
			<form method="POST" action="/servlet/login/loginProcess">
			<div class="login_form">
				<input type="text" id="loginId" name="loginId" value="아이디" onfocus="onf(this)" onblur="onb(this)"/>
				<input type="text" id="loginPassword" name="loginPassword" value="비밀번호" onfocus="onf(this)" onblur="onb(this)"/>
				<input type="checkbox" id="rememberMe" name="rememberMe"><p style="float:left;">아이디 저장</p>
				<button type="submit" id="loginBtn">로그인</button>
			</div>
			
			<input type="hidden" name="loginRedirect" value="${loginRedirect}">
			</form>
			
		<div class="login_form" >
			<a href="" style="float:left;">회원가입</a>
			<a href="" style="float:right;">비밀번호 찾기</a>
			<a href="" style="margin:0px 3px ;float:right;">아이디 /</a>
	 	</div>
	</div>
</div>
</body>
</html>