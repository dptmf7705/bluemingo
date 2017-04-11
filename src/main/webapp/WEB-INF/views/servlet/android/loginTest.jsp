<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>

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
<body>

<div class="box box-header">
	<div class="box_login">
		<h3>로그인</h3>
		<hr>
		<form method="POST" action="/servlet/android/loginProcess">
		<div class="login_form">
				<input type="text" id="loginId" name="loginId" value="아이디" onfocus="onf(this)" onblur="onb(this)"/>
				<input type="text" id="loginPassword" name="loginPassword" value="비밀번호" onfocus="onf(this)" onblur="onb(this)"/>
				<input type="checkbox" id="rememberMe"><p style="margin: 0px;float:left">아이디 저장</p>
				<button type="submit" id="loginBtn">로그인</button>
		</div>
		
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