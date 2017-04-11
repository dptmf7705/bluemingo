<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../views/servlet/header.jsp" %>
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
	padding:5px;
}
.box_login{
	float:right;
	width:300px;
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top adv</title>
</head>
<body>
<!-- Main content -->

<div class="box box-header">

	<div class="box-header with-border">
    	<h3 class="box-title">HOME PAGE</h3>
		    
		<div class="box_login">
			<sec:authorize access="isAnonymous()">
			<h4>로그인</h4>
			<hr>
			<form method="POST"  action="/servlet/login/loginProcess">
			<div class="login_form">
				<input type="text" id="loginId" name="loginId" value="아이디" onfocus="onf(this)" onblur="onb(this)"/>
				<input type="text" id="loginPassword" name="loginPassword" value="비밀번호" onfocus="onf(this)" onblur="onb(this)"/>
				<input type="checkbox" id="rememberMe"><p style="float:left">아이디 저장</p>
				<button type="submit" id="loginBtn">로그인</button>
			</div>
			</form>
			</sec:authorize>
		</div>
	    	
	    </div>
    
	<div class="box-body">
		<label for="examplInputADVTEXT">Server Time</label>
		<P>  The time on the server is ${serverTime2}. </P>
	</div>
</div>
</body>
</html>
