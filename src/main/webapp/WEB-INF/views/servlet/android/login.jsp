<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<form name="form" method="POST" action="/servlet/android/loginProcess">
	<input type="text" id="loginId" name="loginId" value="${loginId}"/>
	<input type="text" id="loginPassword" name="loginPassword" value="${loginPassword}"/>
</form>
<script>document.form.submit();</script>

</body>
</html>