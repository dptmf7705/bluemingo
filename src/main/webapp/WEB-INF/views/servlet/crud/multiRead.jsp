<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@include file="../header.jsp"%>​
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
<script>
$(document).ready( function() {
	var purpose = '${msg_purpose}';
	var status = '${msg_status}';
	var value = '${msg_value}';
	var from = '${msg_from}';
	
	msg_parsing(purpose,from,status,value);

});
function readSearch(){
	var search_key = document.getElementById("search_key").value;
	var search_table = document.getElementById("search_table").value;
	var load_url = "/servlet/crud/multiReadSearch?search_key="+search_key+"&search_table="+search_table;
	$("#contents").load(load_url);
	
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top adv</title>
</head>
<body>

<div class="box-tools" class="centered">
	<form class="input-search" name="search_form" role="form" method="get">
		<label for="input_item_data">KEY or ID</label>
		<input id="search_key" name="search_key" >
		<input type="hidden" id ="search_table" value="item_id">
		<input type="button" style="width: 30pt; height: 20pt" onclick="readSearch()" value="검색">
	</form>
</div>

<div id="contents">
</div>

</body>
</html>
