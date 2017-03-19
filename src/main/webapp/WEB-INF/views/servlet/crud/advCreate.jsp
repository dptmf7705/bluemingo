<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@include file="../header.jsp"%>
<%@ include file="../include-header.jspf"%>​
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.small1 {
	width: 100px;
}

.small2 {
	height: 100px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top adv</title>
</head>
<body>

<div class="box-tools">
<form:form role="form" commandName="Item_companyVO" name="ItemData" method="post">
<input id="option_name" name="item_name">
<input id="option_name" name="item_sale_price">
<input id="option_name" name="option_list[0].option_name">
<input id="option_value" name="option_list[0].option_value">
<input id="option_price" name="option_list[0].option_price">
<input type="submit"
				style="width: 30pt; height: 20pt" value="업로드">
</form:form>
</div>

</body>
</html>
