<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<!-- 
* Last Edit 2017-02-11
* 

 -->

<%@ include file="../popup-header.jsp"%>

<meta charset="utf-8">
<title>BlueMingo</title>

<style>
.small1 {
	width: 100px;
}

.small2 {
	height: 100px;
}
.list-table{
	width: 90%;
}
.input-group{
	margin-left: 40px;
}
.input-search{
	margin-right: 30px;
	margin-bottom: 10px;
}
</style>
<script type="text/JavaScript">

</script>

</head>
<body>
<div class="box">
	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">주문 상세 페이지</h4>
		<hr />

		<div class="box-tools">
		<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
				<td>주문번호</td><td>${resVO.res_id}</td>
				<td></td>
				<td>주문상태</td><td>${resVO.res_status}</td>
				<td></td>
				<td>주문금액</td><td>${resVO.sum_price}</td>
				<td></td>
				<td>ID</td><td>${resVO.user_id}</td>
			</tr>
			<tr>				
				<td>결제일자</td>
				<td><c:if test="${resVO.purchase_date != '' || resVO.purchase_date ne null}">
				${resVO.purchase_date}</c:if></td>
				<td></td>
				<td>구매방법</td><td>${resVO.res_type}</td>
				<td></td>
				<td>주문수량</td><td>${resVO.sum_quantity}</td>
				<td></td>
				<td>이름</td><td>${resVO.user_name}</td>
			</tr>
			<tr></tr>
			<tr>
				<td>배송사</td><td>${resDeliverVO.item_id}</td>
				<td></td>
				<td>주소</td><td colspan="7">${resDeliverVO.option_name}</td>
			</tr>
			<tr>
				<td>배송비</td><td>${resDeliverVO.option_price}</td>
				<td></td>
				<td>특이사항</td><td colspan="7">${resDeliverVO.option_value}</td>
			</tr>
		</table>
		</div>
		<hr />
	</div>

	<div class="box-body table-responsive no-padding">
		<table class="table table-hover list-table">
			<tbody>
			
				<tr class="scrollLocation">
					<th scope="col"><p>주문key</p></th>
					<th scope="col"><p>제품ID</p></th>
					<th scope="col"><p>제품이름</p></th>
					<th scope="col"><p>제품옵션</p></th>
					<th scope="col"><p>제품수량</p></th>
					<th scope="col"><p>제품가격</p></th>
				</tr>
				<c:forEach items="${resOptionlist}" var="resOptionlist">
					<tr class="listToChange"> 
						<td><p>${resOptionlist.res_key}</p></td>
						<td><p>${resOptionlist.item_id}</p></td>
						<td><p>${resOptionlist.item_name}</p></td>
						<td><p>${resOptionlist.item_option}</p></td>
						<td><p>${resOptionlist.res_quantity}</p></td>
						<td><p>${resOptionlist.res_price}</p></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.box-body -->

</div>

</body>
</html>