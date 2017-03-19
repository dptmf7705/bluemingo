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
.small1{ width: 100px;}
.small2{ height: 100px;}
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

	function procedure2(image_key) {

		var uri = "/servlet/android/imageDownload?image_key="+image_key;
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
						<col width="10%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">key</th>
							<th scope="col">이미지</th>
							<th scope="col">원본이름</th>
							<th scope="col">저장이름</th>
							<th scope="col">파일크기</th>
							<th scope="col">업로드일</th>
							<th scope="col">작성자명</th>
							<th scope="col">삭제여부</th>

						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${fn:length(list) > 0}">
								<c:forEach items="${list}" var="imageVO">
									<tr class="listToChange" width="200">
										<td>${imageVO.image_key}</td>
										<td><img class="small1" src="/bluemingo/image/${imageVO.stored_file_name}"></td>
										<td><%-- 새창에서 받기 스크립트 적용 <a href="javascript:procedure2(${imageVO.image_key});"> --%>
										<a href="/servlet/android/imageDownload?image_key=${imageVO.image_key}">${imageVO.original_file_name}</a></td>
										<td>${imageVO.stored_file_name}</td>
										<td>${imageVO.file_size}</td>
										<td>${imageVO.crea_dtm}</td>
										<td>${imageVO.crea_id}</td>
										<td>${imageVO.del_gb}</td>
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
				<input type="file" name="file">
				<input type="hidden" name="item_key" value="1">
				<input type="hidden" name="item_name" value="item_key">
				<input type="submit" style="width: 30pt; height: 20pt"
								value="업로드">
			</form>
			<br />
		</div>
	</div>
</body>
</html>