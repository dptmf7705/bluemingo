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
		<h4 class="box-title">주문 리스트 조회 (최근 거래일 기준)</h4>
		<hr />

		<div class="input-group">
		<table>
			<tr>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="item_id" class="form-control"
					style="width: 260px;" placeholder="제품ID">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
				<!-- <input type="hidden" name="adv_key" value="adv_key"> -->
			</form>
			</td>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="product_id" class="form-control"
					style="width: 260px;" placeholder="묶음ID">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="user_id" class="form-control"
					style="width: 260px;" placeholder="구매자ID">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			</tr>
			<tr>
			<td>
			<form class="input-search" name="search_form" role="form" method="get">
				<input type="text" name="res_status" class="form-control"
					style="width: 260px;" placeholder="주문상태">
				<button type="submit" class="btn btn-search-default">
					<i class="fa fa-search"></i>
				</button>
			</form>
			</td>
			<td colspan="2">
			<form class="input-search"  name="search_form" role="form" method="get">
				<input type="date" name="res_date" class="form-control"
					style="width: 200px;" placeholder="주문일자">
				<input type="date" name="res_date" class="form-control"
					style="width: 200px;" placeholder="주문일자">
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
		<td style="padding-left:25px">주문량 현황</td><td colspan="2"></td><td></td><td></td>
		<td>어제 주문건수 : ${orderCount.yesterday_count}곳</td>
		<td>오늘 주문건수 : ${orderCount.nowday_count}곳</td>
	</tr>
	</table>
		<table class="table table-hover list-table">
			<tbody>
			
				<tr class="scrollLocation">
					<th scope="col"><p>회원번호</p></th>
					<th scope="col"><p>주문번호</p></th>
					<th scope="col"><p>구매방법</p></th>
					<th scope="col"><p>제품번호</p></th>
					<th scope="col"><p>구매자 이름</p></th>
					<th scope="col"><p>구매자 ID</p></th>
					<th scope="col"><p>주문금액</p></th>
					<th scope="col"><p>주문수량</p></th>
					<th scope="col"><p>주문상태</p></th>
				</tr>
				
				<c:forEach items="${list}" var="orderVO">
					<tr class="listToChange"onclick="location.href='/servlet/order/detail?res_id=${orderVO.res_id}'"> 
						<td><p>${orderVO.user_key}</p></td>
						<td><p>${orderVO.res_id}</p></td>
						<td><p>${orderVO.res_type}</p></td>
						<td><p>${orderVO.item_id}</p></td>
						<td><p>${orderVO.user_name}</p></td>
						<td><p>${orderVO.user_id}</p></td>
						<td><p>${orderVO.res_price}</p></td>
						<td><p>${orderVO.res_quantity}</p></td>
						<td><p>${orderVO.res_status}</p></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.box-body -->

</div>

</body>
</html>