<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="../include-header.jspf"%>

<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/listALl2.css" />
<meta charset="utf-8">
<title>BlueMingo</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<style>
.small1 {
	width: 100px;
}

.small2 {
	height: 100px;
}

#topMenu {
	padding-top: 20px;
	margin: 0 auto;
	text-align: center;
	width: 970px;
	height: 70px;
	margin: 0 auto;
}

#topMenu ul li {
	list-style: none;
	color: white;
	background-color: #2d2d2d;
	float: left;
	line-height: 50px;
	vertical-align: middle;
	text-align: center;
}

#topMenu .menuLink {
	text-decoration: none;
	color: white;
	display: block;
	width: 150px;
	font-size: 14px;
	font-weight: bold;
	font-family: "Trebuchet MS", Dotum, Arial;
}

#topMenu .menuLink:hover {
	color: red;
	background-color: #4d4d4d;
}

#middleMenu {
	margin: 0 auto;
	text-align: center;
}

.input_text, .selected {
	margin: 5px 3px 5px 2px;
	width: 200px;
	height: 30px;
}

#footer {
	text-align: center;
	padding-top: 20px;
}
</style>


<!-- 팝업창스크립트 -->

<script type="text/javascript">
	function procedure() {

		var uri = 'http://localhost:8080/servlet/advertise/advDeta'
		var width = 800;
		var height = 500;
		var top = (screen.availHeight - height) / 2;
		var left = (screen.availWidth - width) / 2;

		var strFeature;
		strFeature = 'height='
				+ height
				+ ',width='
				+ width
				+ ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top='
				+ top + ',left=' + left

		window.open("http://localhost:8080/servlet/advertise/advDeta",
				'DocAttach', strFeature);

	}

	function procedure2(company_uri) {

		var uri = "http://www.bluemingo.xyz/servlet/seller/search?search_key="
				+ company_uri + "&company_key=company_key";
		var width = 800;
		var height = 500;
		var top = (screen.availHeight - height) / 2;
		var left = (screen.availWidth - width) / 2;

		var strFeature;
		strFeature = 'height='
				+ height
				+ ',width='
				+ width
				+ ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top='
				+ top + ',left=' + left

		window.open(uri, 'DocAttach', strFeature);

	}
</script>
</head>
<body>
	<div id="con">
		<div id="topMenu">
			<ul>
				<li><a class="menuLink" href="/servlet/advertise/listAll2">광고</a></li>
				<li><a class="menuLink" href="/servlet/seller/listAll2">판매자</a></li>
				<li><a class="menuLink" href="/servlet/order/listAll2">주문배송</a></li>
				<li><a class="menuLink" href="/servlet/user/listAll2">회원관리</a></li>
				<li><a class="menuLink" href="#">고객센터</a></li>
				<li><a class="menuLink" href="/servlet/dbPage/listAll2">DB생성</a></li>
			</ul>
		</div>
		<hr />
		<div id="content">
			<div id="middleMenu"></div>
		</div>
		<hr />
		<div id="footer">

			<div id="lastMenu">
				<table class="board_list">
					<colgroup>
						<col width="10%" />
						<col width="25%" />
						<col width="20%" />
						<col width="15%" />
						<col width="15%" />
						<col width="5%" />
						<col width="5%" />
						<col width="5%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">product_key</th>
							<th scope="col">product_id</th>
							<th scope="col">product_max_sum</th>
							<th scope="col">product_min</th>
							<th scope="col">deliver_company</th>
							<th scope="col">deliver_price</th>
							<th scope="col">판매자번호</th>
							<th scope="col">묶음번호</th>

						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${fn:length(list) > 0}">
								<c:forEach items="${list}" var="productVO">
									<tr class="listToChange" width="200">
										<td>${productVO.product_key}</td>
										<td>${productVO.product_id}"</td>
										<td>${productVO.product_max_sum}</td>
										<td>${productVO.product_min}</td>
										<td>${productVO.deliver_company}</td>
										<td>${productVO.deliver_price}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="4">조회된 결과가 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<form name="image_form" role="form" method="post"
				action="/servlet/android/create" enctype="multipart/form-data">
				<input type="file" name="file"> <input type="hidden"
					name="item_key" value="1"> <input type="hidden"
					name="item_name" value="item_key"> <input type="submit"
					style="width: 30pt; height: 20pt" value="업로드">
			</form>
			<br />
		</div>
	</div>
</body>
</html>