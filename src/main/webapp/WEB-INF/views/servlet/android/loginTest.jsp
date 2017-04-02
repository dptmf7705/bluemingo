<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="com.bluemingo.bluemingo.domain.UserVO" %>
<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();

Object principal = auth.getPrincipal();
String name = "";
if(principal != null && principal instanceof UserVO){
	name = ((UserVO)principal).getUser_name();
}
 %>
 
<html>
<head></head>
<body>

	<div style="margin-left: 30px;">
	<sec:authorize access="isAnonymous()">
		<form method="POST" action="/servlet/android/login">
			<table style="border: 0px">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="loginId" name="loginId" value=""/></td>
				<td rowspan="2"><input type="submit" id="loginBtn" value="로그인"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" id="loginPassword" name="loginPassword" value=""/></td>
			</tr>
			</table>
		</form>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<table><tr>
		<td><%=name%>님 반갑습니다.</td>
		<td>
		<form action="/servlet/android/logout"><input type="submit" value="로그아웃"/></form></td>
		</tr></table>
	</sec:authorize>
	</div>

</body>
</html>