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
.ItemOptionTable,
.ItemCompanyTable{
	display: none;
	width: 100%;
}
.item_btn{
	background: #7becdb;
}
.item_btn.click{
	background: #faab94;
}

</style>
<script src="https://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript">

$(document).ready( function() {
	var slideIndex = 1;
	showDivs(1);
});

(function setSlide() {
	var slideIndex = 1;
	showDivs(1);
	})()



function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("ItemOptionTable");
  var y = document.getElementsByClassName("ItemCompanyTable");
  var dots = document.getElementsByClassName("item_btn");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
     y[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" click", "");
  }
  x[slideIndex-1].style.display = "block";  
  y[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " click";
}
</script>

</head>
<body>
<div class="box">
	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">광고 상세 페이지</h4>
		<hr />
		
			<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
				<td colspan="10" style="background:#ff8000"><p style="text-align:center">${advVO.trade_status}</p></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2">광고번호</td>
				<td colspan="2" class="advtd">${advVO.adv_key}</td>
				<td colspan="4"></td>
				<td colspan="1">거래번호</td>
				<td colspan="1" class="advtd">${advVO.trade_key}</td>
			</tr>
			<tr>
				<td colspan="4" rowspan="3"><img class="small1"
							src="/bluemingo/image/${advVO.adv_image}"></td>
				<td colspan="4"><p>${advVO.adv_title}</p></td>
				<td colspan="2"><p>${advVO.adv_time}~${advVO.product_period}</p></td>
			</tr>
			<tr>
				<td colspan="4"><p>${advVO.adv_message}</p></td>
				<td colspan="2"><p>${advVO.trade_rescount}/${advVO.product_max_count}</p></td>
			</tr>
			<tr>
				<td colspan="4"><p>${advVO.adv_ticker}</p></td>
				<td colspan="2"></td>
			</tr>
			</table>
		<hr />
	</div>

	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">묶음</h4>
		<hr />
		
			<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
				<td>묶음id(product_id)</td>
				<td>${advVO.product_id}</td>
			</tr>
			<tr></tr>
			<c:forEach items="${itemCompanylist}" var="icVO">
			<tr class="item_btn" onclick="currentDiv(${icVO.table_num})">
				<td><p>제품이름</p>
					<p>제품id</p></td>
				<td><p>${icVO.item_name}</p>
					<p>${icVO.item_id}</p></td>
			</tr>
			</c:forEach>
			<tr></tr>
			<tr><td>즉시구매가</td><td>${advVO.product_direct_price}</td></tr>
			<tr><td>할인가</td><td>${advVO.product_sale_price}</td></tr>
			<tr><td>N사 최저가</td><td>${advVO.product_naver_price}</td></tr>
			<tr></tr>
			<tr><td>최대목표수량</td><td>${advVO.product_max_count}</td></tr>
			<tr><td>최소목표수량</td><td>${advVO.product_max_extra}</td></tr>
			<tr><td>마감일</td><td>${advVO.product_period}</td></tr>
			<tr></tr>
			<tr><td>배송사(임시코드)</td><td>${advVO.deliver_company}</td></tr>
			<tr><td>배송가격</td><td>${advVO.deliver_price}</td></tr>
			<tr></tr>
			<tr><td>최소구매수량</td><td>${advVO.product_min}</td></tr>
			</table>
	</div>
	
	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">제품정보</h4>
		<hr />
		<c:forEach items="${itemCompanylist}" var="icVO">
		<div class="ItemOptionTable">
			<table class="advtable advtable-bordered table-hover detail-table text-center">
				<tr><td colspan="6"><img class="small1"
							src="/bluemingo/image/${icVO.item_image}"></td></tr>
				<tr></tr>
				<tr><td colspan="6">${icVO.item_name}</td></tr>
				<tr><td colspan="2">${icVO.item_category_top}</td>
					<td colspan="2">${icVO.item_category_mid}</td>
					<td colspan="2">${icVO.item_category_bot}</td></tr>
				<tr><td colspan="2">${icVO.item_direct_price}</td>
					<td colspan="2">${icVO.item_sale_price}</td>
					<td colspan="2">${icVO.item_naver_price}</td></tr>
				<tr><td colspan="6">최대수량   ${icVO.option_value}</td></tr>
				<tr><td colspan="6">간단설명</td></tr>
				<tr><td colspan="6"> <textarea name="item_inform"
                  	rows="3" readonly="readonly">${icVO.item_inform}
                	</textarea></td></tr>
                <tr></tr>
                
                <c:forEach items="${icVO.option_list}" var="optionVO">

                <tr><td colspan="6">제품옵션  ${optionVO.ref_id}</td></tr>
                <tr><td colspan="2">${optionVO.option_name}</td>
					<td colspan="2">${optionVO.option_value}</td>
					<td colspan="2">${optionVO.option_price}</td></tr>

                </c:forEach>
                
                <tr></tr>
                <tr><td colspan="6">상세설명</td></tr>
                <tr><td colspan="6"> <textarea name="item_inform"
                  	rows="10" readonly="readonly">${icVO.item_detail_inform}
                	</textarea></td></tr>
                <tr></tr>
                <tr><td colspan="6"><img class="small1"
							src="/bluemingo/image/${icVO.item_image}"></td></tr>
			</table>
		</div>
		</c:forEach>
	</div>
	
	<div class="w3-center">
  <div class="w3-section">
    <button class="w3-btn" onclick="plusDivs(-1)">❮ Prev</button>
    <button class="w3-btn" onclick="plusDivs(1)">Next ❯</button>
  </div>
  <button class="w3-btn demo" onclick="currentDiv(1)">1</button> 
  <button class="w3-btn demo" onclick="currentDiv(2)">2</button> 
  <button class="w3-btn demo" onclick="currentDiv(3)">3</button> 
</div>


	
	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">회사정보</h4>
		<hr />
		<c:forEach items="${itemCompanylist}" var="icVO">
		<div class="ItemCompanyTable">
			<table class="advtable advtable-bordered table-hover detail-table text-center">
				<tr><td>회사이름</td><td>${icVO.company_name}</td></tr>
				<tr><td>대표이름</td><td>${icVO.company_president}</td></tr>
				<tr><td>회사주소</td><td>${icVO.company_address}</td></tr>
				<tr><td>WebSite</td><td>${icVO.company_homepage}</td></tr>
				<tr><td>사업자번호</td><td>${icVO.company_serial}</td></tr>
				<tr></tr>
				<tr><td>대표번호</td><td>${icVO.company_prephone}</td></tr>
				<tr><td>회사번호</td><td>${icVO.company_phone}</td></tr>
				<tr><td>회사분류</td><td>${icVO.company_type}</td></tr>
			</table>
		</div>
		</c:forEach>
	</div>
	
	
	<div class="box-body table-responsive no-padding">
		<table class="table table-hover list-table">
			<tbody>
				
			</tbody>
		</table>
	</div>

	<div class="box-footer">

	</div>
</div>

</body>
</html>