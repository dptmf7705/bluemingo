<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<!-- 
* Last Edit 2017-03-09
* 

 -->

<%@ include file="../header.jsp"%>

<meta charset="utf-8">
<title>BlueMingo</title>
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
function loadContents(url){
	var load_url = "/servlet/crud/"+url;
	$("#contents").load(load_url);
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top adv</title>
</head>
<body>
<div class="box">

	<div class="box-search" >
	<div  style="margin-top:10px">
		<button type="submit" onclick="loadContents('companyCreate')" class="btn btn-default">판매자</button>
		<button type="submit" onclick="loadContents('itemCreate')" class="btn btn-default">제품</button>
		<button type="submit" onclick="loadContents('productCreate')" class="btn btn-default">묶음</button>
		<button type="submit" onclick="loadContents('advCreate')" class="btn btn-default">광고</button>
	</div>
	<div class="table-search">
	<table>
	<tr>
		<td><label for="input_item_data" style="margin-right:10px">KEY or ID</label></td>
		<td><form class="centered" name="search_form" role="form" method="get">
			<input id="search_key" class="form-control" name="search_key" >
			<input type="hidden" id ="search_table" value="item_id">
		</form></td>
		<td><Button class="btn btn-default" style="margin-left:10px" onclick="readSearch()">검색</Button></td>
	</tr>
	</table>
	</div>
	</div>

	<div class="box-body">
		<div id="contents">
		</div>
	</div>
	
	<div class="box-footer">
	
	</div>

</div>
</body>
</html>
