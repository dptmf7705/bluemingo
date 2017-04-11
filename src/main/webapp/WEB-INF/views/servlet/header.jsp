<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Top adv</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	



    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- modify in 2017.2 by Bluemingo -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="/resources/dist/css/BlueMingoUi.min.css" rel="stylesheet" type="text/css" />



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.menu-box{
	height:200px;
}

</style>
</head>


<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>

<!-- jQuery-UI -->
<script src="/resources/jquery-ui-1.11.4/jquery-ui.min.js"></script>

<!-- Bluemingo Common javascript -->
<script type="text/javascript" src="/js/common.js"></script> 
<body>

	<div class="box-header">
		<button type="button" onclick="location.href='/servlet/advertise/listAll'" class="btn btn-default">광고</button>
		<button type="submit" onclick="location.href='/servlet/seller/listAll'" class="btn btn-default">판매자</button>
		<button type="submit" onclick="location.href='/servlet/order/listAll'" class="btn btn-default">주문</button>

		<div style="width:200px; float:right">
			<sec:authorize access="isAuthenticated()">
			<sec:authentication var="user" property="principal"/>
			<p>${user.user_name}님 반갑습니다.</p>
			<button type="submit" onclick="location.href='/servlet/login/logout'">로그아웃</button>
			</sec:authorize>
		</div>
	</div>

	
</body>
</html>


