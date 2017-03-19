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
		<h4 class="box-title" style="text-align:center">판매자 상세 페이지</h4>
		<hr />

		<div class="box-tools">
		<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
				<td colspan="2">${sellerVO.company_name}</td>
				<td style="dispaly:none"></td>
				<td>회사분류</td><td>${sellerVO.company_type}</td>
				<td style="dispaly:none"></td>
				<td>진행중인 광고</td><td>${sellerVO.progress_adv}</td>
				<td style="dispaly:none"></td>
				<td>모든 광고</td><td>${sellerVO.total_adv}</td>
			</tr>
			<tr>
				<td>회사 전화번호</td><td>${sellerVO.company_phone}</td>
				<td style="dispaly:none"></td>
				<td>대표명</td><td>${sellerVO.company_type}</td>
				<td style="dispaly:none"></td>
				<td style="dispaly:none"></td><td style="dispaly:none"></td>
				<td style="dispaly:none"></td>
				<td style="dispaly:none"></td><td style="dispaly:none"></td>
			</tr>
			<tr>
				<td>회사 주소</td><td>${sellerVO.company_address}</td>
				<td style="dispaly:none"></td>
				<td>대표번호</td><td>${sellerVO.company_prephone}</td>
				<td style="dispaly:none"></td>
				<td colspan="5" rowspan="2">
					<textarea name="item_inform" rows="2" readonly="readonly">${sellerVO.company_detail}
                	</textarea></td>
			</tr>
			<tr>
				<td>홈페이지</td><td>${sellerVO.company_homepage}</td>
				<td style="dispaly:none"></td>
				<td>사업자번호</td><td>${sellerVO.company_serial}</td>
				<td style="dispaly:none"></td>
			</tr>
		</table>
		</div>
		<hr />
	</div>

	<div class="box-body table-responsive no-padding">
		<table class="table table-hover list-table">
			<tbody>
			
				<tr class="scrollLocation">
					<th scope="col"><p>판매자번호</p></th>
					<th scope="col"><p>상호명</p></th>
					<th scope="col"><p>제품이름</p></th>
					<th scope="col"><p>할인가</p></th>
					<th scope="col"><p>광고 타이틀</p></th>
					<th scope="col"><p>광고 시작일</p></th>
					<th scope="col"><p>광고 마감일</p></th>
					<th scope="col"><p>광고 상태</p></th>
				</tr>
				<c:forEach items="${sellerItemlist}" var="sellerVO">
					<tr class="listToChange"onclick="location.href='/servlet/seller/detail?company_key=${advVO.adv_key}'"> 
						<td><p>${sellerVO.company_key}</p></td>
						<td><p>${sellerVO.company_name}</p></td>
						<td><p>${sellerVO.item_name}</p></td>
						<td><p>${sellerVO.item_sale_price}</p></td>
						<td><p>${sellerVO.adv_title}</p></td>
						<td><p>${sellerVO.adv_time}</p></td>
						<td><p>${sellerVO.product_period}</p></td>
						<td><p>${sellerVO.trade_status}</p></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.box-body -->

</div>

</body>
</html>