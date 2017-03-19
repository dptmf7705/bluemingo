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
					style="width: 260px;" placeholder="판매자번호">
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
		<table class="table table-hover list-table">
			<tbody>
				<tr class="scrollLocation">
					<th scope="col"><p>광고번호</p><p>거래번호</p></th>
					<th scope="col">이미지</th>
					<th scope="col"><p>TITLE</p><p>MESSAGE</p><p>TICKER</p></th>
					<th scope="col"><p>시작일~마감일</p><p>현재수량/목표수량</p></th>
					<th scope="col"><p>즉구가</p><p>할인가</p><p>최저가</p></th>
					<th scope="col"><p>광고상태</p></th>
				</tr>
				<c:forEach items="${list}" var="advertiseVO">
					<tr class="listToChange" onclick="location.href='/servlet/seller/listAll'"> 
						<td><p>${advertiseVO.adv_key}</p><p>${advertiseVO.adv_key}</p></td>
						<td><img class="small1"
							src="/bluemingo/image/${advertiseVO.adv_resource}"></td>
						<td class="title"><p>${advertiseVO.adv_title}</p>
							<p>${advertiseVO.adv_message}</p>
							<p>${advertiseVO.adv_ticker}</p></td>
						<td><p>${advertiseVO.adv_time}~${advertiseVO.period}</p>
							<p>${advertiseVO.now_count}</p></td>
						<td class="title"><p>${advertiseVO.adv_title}</p>
							<p>${advertiseVO.adv_message}</p>
							<p>${advertiseVO.adv_ticker}</p></td>
						<td><p>${advertiseVO.trade_status}</p>
							<p><input class="btn" type="button" value="수정"></p></td>
						<%-- <a href="javascript:procedure2(${advertiseVO.company_key});"></a> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.box-body -->

	<div class="box-footer">
		<form name="image_form" role="form" method="post"
			action="/servlet/android/create" enctype="multipart/form-data">
			<input type="file" name="file"> <input type="hidden"
				name="item_key" value="1"> <input type="hidden"
				name="item_name" value="item_key"> <input type="submit"
				style="width: 30pt; height: 20pt" value="업로드">
		</form>
	</div>
</div>

</body>
</html>