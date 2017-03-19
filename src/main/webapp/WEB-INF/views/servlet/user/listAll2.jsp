<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>BlueMingo</title>

<style type="text/css">
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
	width: 100%;
	height: 38px;
	margin: 0 auto;
	font-size: 15px;
	background-color: #cccccc;
}
</style>

</head>
<body>

	<div id="con">
		<div id="topMenu">
			<ul>
				<li><a class="menuLink"
					href="http://localhost:8080/bluemingo/servlet/advertise/listAll2">광고</a></li>
				<li><a class="menuLink"
					href="http://localhost:8080/bluemingo/servlet/seller/listAll2">판매자</a></li>
				<li><a class="menuLink"
					href="http://localhost:8080/bluemingo/servlet/order/listAll2">주문배송</a></li>
				<li><a class="menuLink"
					href="http://localhost:8080/bluemingo/servlet/user/listAll2">회원관리</a></li>
				<li><a class="menuLink" href="#">고객센터</a></li>
				<li><a class="menuLink" href="#">DB생성</a></li>
			</ul>
		</div>
		<hr />
		<div id="content">
			<div id="middleMenu">
				<span class='green_window'> <input type='text'
					class='input_text' placeholder="제품번호" />
				</span>
				<button type='submit' class='sch_smit'>검색</button>

				<span class='green_window'> <input type='text'
					class='input_text' placeholder="구매자성함" />
				</span>
				<button type='submit' class='sch_smit'>검색</button>

				<span class='green_window'> <input type='text'
					class='input_text' placeholder="휴대폰번호" />
				</span>
				<button type='submit' class='sch_smit'>검색</button>

			</div>
		</div>
		<hr />
		<div id="footer">
			<div id="lastMenu">

				<table class="table table-hover">
					<tbody>

						<tr>
							<td>회원번호</td>
							<td>성함</td>
							<td>휴대폰번호</td>
							<td>이메일</td>
							<td>공고/즉구</td>

						</tr>
						<c:forEach items="${list}" var="userVO">
							<tr>
							<tr>
								<td class="scrolling" data-user_key="${userVO.user_key}">
									${userVO.user_key}</td>
								<td>${userVO.user_name}</td>
								<td>${userVO.user_phone}</td>
								<td>${userVO.user_id}</td>
								<td>${userVO.res_type}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<%-- 				<table class="tableC" border="1">
					<tbody>
						<c:forEach items="${list}" var="advertiseVO">
							<tr class="listToChange">
								<td rowspan="2">${advertiseVO.trade_status}</td>
								<td rowspan="2">(Img)</td>
								<td>${advertiseVO.adv_title}</td>
								<td>${advertiseVO.adv_time}/${advertiseVO.period}</td>
								<td><input type="button"></td>
								<td rowspan="2">${advertiseVO.adv_key}</td>
								<td rowspan="2">${advertiseVO.company_key}</td>
								<td rowspan="2">${advertiseVO.product_key}</td>
							</tr>
							<tr>
								<td>${advertiseVO.adv_ticker}</td>
								<td>${advertiseVO.now_count}</td>
								<td>(수정)</td>
							</tr>
						</c:forEach>
					</tbody>
				</table> --%>
			</div>
		</div>
	</div>
</body>
</html>