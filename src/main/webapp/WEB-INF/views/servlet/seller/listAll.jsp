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
		<h4 class="box-title">판매자 리스트 조회 (최근 거래일 기준)</h4>
		<hr />

		<div class="input-group">
		<table>
			<tr>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="company_key" class="form-control"
					style="width: 260px;" placeholder="판매자번호">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
				<!-- <input type="hidden" name="adv_key" value="adv_key"> -->
			</form>
			</td>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="company_name" class="form-control"
					style="width: 260px;" placeholder="상호명">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="company_president" class="form-control"
					style="width: 260px;" placeholder="사업자명">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			</tr>
			<tr>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="company_phone" class="form-control"
					style="width: 260px;" placeholder="회사 전화번호">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="company_prephone" class="form-control"
					style="width: 260px;" placeholder="대표 번호">
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
		<td style="padding-left:25px">판매자 기준 광고 현황</td><td></td><td></td><td></td>
		<td>광고 진행중인 판매자 : ${companyCount.progress_company}곳</td>
		<td>배송 대기중인 판매자 : ${companyCount.com_purchase_company}곳</td>
		<td>거래 완료된 판매자 : ${companyCount.complete_company}곳</td>
	</tr>
	</table>
		<table class="table table-hover list-table">
			<tbody>
			
				<tr class="scrollLocation">
					<th scope="col"><p>분류(구분)</p></th>
					<th scope="col"><p>판매자번호</p></th>
					<th scope="col"><p>상호명</p></th>
					<th scope="col"><p>대표명</p></th>
					<th scope="col"><p>회사 전화번호</p></th>
					<th scope="col"><p>대표 전화번호</p></th>
					<th scope="col"><p>진행중인 광고</p></th>
					<th scope="col"><p>모든 광고</p></th>
				</tr>
				
				<c:forEach items="${list}" var="sellerVO">
					<tr class="listToChange"onclick="location.href='/servlet/seller/detail?company_key=${sellerVO.company_key}'"> 
						<td><p>${sellerVO.company_type}</p></td>
						<td><p>${sellerVO.company_key}</p></td>
						<td><p>${sellerVO.company_name}</p></td>
						<td><p>${sellerVO.company_president}</p></td>
						<td><p>${sellerVO.company_phone}</p></td>
						<td><p>${sellerVO.company_prephone}</p></td>
						<td><p>${sellerVO.progress_adv}건</p></td>
						<td><p>${sellerVO.total_adv}건</p></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.box-body -->

</div>

</body>
</html>