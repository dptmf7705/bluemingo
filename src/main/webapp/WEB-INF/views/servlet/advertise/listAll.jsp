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

<%@ include file="../header.jsp"%>

<meta charset="utf-8">
<title>BlueMingo</title>

<style>

</style>
<script type="text/JavaScript">
function whenClick() {
	console.log('click');
	alert('click');
}
function AdvDetail(text) {

	alert(text+'click');
	
	/* var avo = vo;
	var formObj = document.createElement("form");
	formObj.attr("action", "/servlet/advertise/detail");
	formObj.attr("method", "post");
	document.body.appendChild(form);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "advVO");
	hiddenField.setAttribute("value", avo);
	form.appendChild(hiddenField);

	formObj.submit(); */
}
</script>

</head>
<body>
<div class="box">
	<div class="box-tools">
		<h4 class="box-title">광고 리스트 조회 (최근 거래일 기준)</h4>
		<hr />

		<div class="input-group">
		<table>
			<tr>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="adv_key" class="form-control"
					style="width: 260px;" placeholder="광고번호">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
				<!-- <input type="hidden" name="adv_key" value="adv_key"> -->
			</form>
			</td>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="item_id" class="form-control"
					style="width: 260px;" placeholder="제품번호">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="product_id" class="form-control"
					style="width: 260px;" placeholder="묶음번호">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			</tr>
			<tr>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="trade_status" class="form-control"
					style="width: 260px;" placeholder="광고상태">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			<td colspan="2">
			<form class="input-search"  name="search_form" role="form" method="get">
				<input type="date" name="adv_time" class="form-control"
					style="width: 200px;" placeholder="광고일자">
				<input type="date" name="product_period" class="form-control"
					style="width: 200px;" placeholder="광고일자">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			</tr>
		</table>
			
			
			
			
		</div>
		<hr />
	</div>

	<div class="box-body table-responsive no-padding">
	<table class="advtable count-table">
	<tr>
		<td style="padding-left:25px">대기중인 광고</td><td>${advCount.wait_adv}건</td>
		<td>진행중인 광고</td><td>${advCount.progress_adv}건</td>
		<td>결제중인 광고</td><td>${advCount.purchase_adv}건</td>
		<td>배송중인 광고</td><td>${advCount.deliver_adv}건</td>
		<td>총 광고</td><td>${advCount.total_adv}건</td>
	</tr>
	</table>
		<table class="table table-hover list-table">
			<tbody>
				
				<tr class="scrollLocation">
					<th scope="col"><p>광고번호</p><p>거래번호</p></th>
					<th scope="col"><p>이미지</p></th>
					<th scope="col"><p>TITLE</p><p>MESSAGE</p><p>TICKER</p></th>
					<th scope="col"><p>시작일~마감일</p><p>현재수량/목표수량</p></th>
					<th scope="col"><p>즉구가</p><p>할인가</p><p>최저가</p></th>
					<th scope="col"><p>광고상태</p></th>
				</tr>
				<c:forEach items="${list}" var="advVO">
					<tr class="listToChange"> 
						<td><p>${advVO.adv_key}</p><p>${advVO.adv_key}</p></td>
						<td><img class="small1"
							src="/bluemingo/image/${advVO.adv_image}"></td>
						<td class="title pic" onclick="location.href='/servlet/advertise/detail?adv_key=${advVO.adv_key}'">
							<p>${advVO.adv_title}</p>
							<p>${advVO.adv_message}</p>
							<p>${advVO.adv_ticker}</p></td>
						<td><p>${advVO.adv_time}~${advVO.product_period}</p>
							<p>${advVO.trade_rescount}/${advVO.product_max_count}</p></td>
						<td class="title"><p>${advVO.product_direct_price}</p>
							<p>${advVO.product_sale_price}</p>
							<p>${advVO.product_naver_price}</p></td>
						<td><p>${advVO.trade_status}</p>
							<p>
							<input class="btn" type="button" value="수정">
							</p></td>
						<%-- <a href="javascript:procedure2(${advertiseVO.company_key});"></a> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.box-body -->

	<div class="box-footer">
		<form name="image_form" role="form" method="post"
			action="/servlet/advertise/detail" >
			<input type="hidden" name="advVO" value="${list}">
			<!-- <input type="file" name="file"> <input type="hidden"
				name="item_key" value="1"> <input type="hidden"
				name="item_name" value="item_key"> --> <input type="submit"
				style="width: 30pt; height: 20pt" value="업로드">
		</form>
	</div>
</div>

</body>
</html>