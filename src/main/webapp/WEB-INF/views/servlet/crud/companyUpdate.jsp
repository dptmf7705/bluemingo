<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
.item_id {font-color:#000000;}
.centered { display: table; margin-left: auto; margin-right: auto; }
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

$(document).ready(function(){
	var purpose = '${msg_purpose}';
	var status = '${msg_status}';
	var value = '${msg_value}';
	var from = '${msg_from}';
	
	msg_parsing(purpose,from,status,value);
	
});
</script>

</head>
<body>

<div class="box" style="border-top:0px">

<form role="form" name="CompanyData" method="post">
	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">판매자 정보 생성 페이지</h4>
		
		<hr />
		<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
				<td>
					<label for="input_item_data">회사명</label>
					<input name="company_name" type="text" class="form-control" id="input_company_name" placeholder="회사명을 입력하세요" value="${icVO.company_name}">
                </td>
                <td></td>
            </tr>
	        <tr>
				<td>
					<label for="input_item_data">대표명</label>
					<input name="company_president" type="text" class="form-control" id="input_company_president" placeholder="대표명을 입력하세요" value="${icVO.company_president}">
                </td>
                <td>
					<label for="input_item_data">대표 연락처</label>
					<input name="company_prephone" type="text" class="form-control" id="input_company_prephone" placeholder="대표 연락처를 입력하세요" value="${icVO.company_prephone}">
                </td>
	        </tr>
	        <tr>
				<td>
					<label for="input_item_data">회사 주소</label>
					<input name="company_address" type="text" class="form-control" id="input_company_address" placeholder="회사 주소를 입력하세요" value="${icVO.company_address}">
                </td>
                <td>
					<label for="input_item_data">회사 연락처</label>
					<input name="company_phone" type="text" class="form-control" id="input_company_phone" placeholder="회사 연락처를 입력하세요" value="${icVO.company_phone}">
                </td>
	        </tr>
	        <tr>
				<td>
					<label for="input_item_data">회사 홈페이지</label>
					<input name="company_homepage" type="text" class="form-control" id="input_company_homepage" placeholder="회사 홈페이지를 입력하세요" value="${icVO.company_homepage}">
                </td>
                <td>
					<label for="input_item_data">회사 분류</label>
					<input name="company_type" type="text" class="form-control" id="input_company_type" placeholder="회사 분류를 입력하세요" value="${icVO.company_type}">
                </td>
	        </tr>
	        <tr>
				<td>
					<label for="input_item_data">사업자번호</label>
					<input name="company_serial" type="text" class="form-control" id="input_company_serial" placeholder="사업자 번호를 입력하세요" value="${icVO.company_serial}">
                </td>
                <td></td>
            </tr>
            <tr>
            	<td colspan="2">
					<label for="input_item_data">상세정보</label>
					<textarea name="company_detail" class="form-control" placeholder="Enter Message" rows="5">${icVO.company_detail}</textarea>
            	</td>
            </tr>
		</table>
				
		<input type="submit"
				style="width: 30pt; height: 20pt" value="업로드">
		<hr />
	</div>
</form>
</div>


</body>
</html>
