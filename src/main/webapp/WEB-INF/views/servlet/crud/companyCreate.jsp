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

function CUFormSubmit(){
	var cuForm = document.getElementByID("CUForm");
	cuForm.action="/servlet/crud/companyCreate"
	if(checkFormData()){
		cuForm.submit();
	}
}
function setCheck(){
	var test = document.getElementById("test");
	var test2 = document.getElementById("test2");
	var result;
	result=checkData()
		test.value = result;
	var data = document.forms["CompanyData"].value;
	test2.value = data[data.length-1].value;
}
function checkFormData(){
	var data = document.getElementsByClassName("form-control");
	for(i=0; i<data.length; i++){
		if(data[i].value == ''){
			return false;
		}
	}
	return true;
}
function checkData(){
	var name = document.getElementsByClassName("form-control");
	var data = null;
	for(i=0; i<data.length; i++){
		if(data[i].value == ""){
			return false;
		}
	}
	return true;
}
</script>

</head>
<body>

<div class="box" style="border-top:0px">
<input name="test" id="test" type="text">
<input name="test2" id="test2" type="text">
		<button onclick="setCheck()">test</button>
		<Button class="btn btn-default" onclick="CUFormSubmit()">테스트</Button>
<form:form role="form" id="CUForm" name="CompanyData" method="post" enctype="multipart/form-data">
	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">판매자 정보 생성 페이지</h4>
		
		<hr />
		
		<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
				<td>
					<label for="input_company_data">회사명</label>
					<input name="company_name" type="text" class="form-control" id="input_company_data" placeholder="회사명을 입력하세요">
                </td>
                <td></td>
            </tr>
	        <tr>
				<td>
					<label for="input_company_data">대표명</label>
					<input name="company_president" type="text" class="form-control" id="input_company_data" placeholder="대표명을 입력하세요">
                </td>
                <td>
					<label for="input_company_data">대표 연락처</label>
					<input name="company_prephone" type="text" class="form-control" id="input_company_data" placeholder="대표 연락처를 입력하세요">
                </td>
	        </tr>
	        <tr>
				<td>
					<label for="input_company_data">회사 주소</label>
					<input name="company_address" type="text" class="form-control" id="input_company_data" placeholder="회사 주소를 입력하세요">
                </td>
                <td>
					<label for="input_company_data">회사 연락처</label>
					<input name="company_phone" type="text" class="form-control" id="input_company_data" placeholder="회사 연락처를 입력하세요">
                </td>
	        </tr>
	        <tr>
				<td>
					<label for="input_company_data">회사 홈페이지</label>
					<input name="company_homepage" type="text" class="form-control" id="input_company_data" placeholder="회사 홈페이지를 입력하세요">
                </td>
                <td>
					<label for="input_company_data">회사 분류</label>
					<input name="company_type" type="text" class="form-control" id="input_company_data" placeholder="회사 분류를 입력하세요">
                </td>
	        </tr>
	        <tr>
				<td>
					<label for="input_company_data">사업자번호</label>
					<input name="company_serial" type="text" class="form-control" id="input_company_data" placeholder="사업자 번호를 입력하세요">
                </td>
                <td></td>
            </tr>
            <tr>
            	<td colspan="2">
					<label for="input_company_data">상세정보</label>
					<textarea name="company_detail" class="form-control" id="input_company_data" placeholder="Enter Message" rows="5"></textarea>
            	</td>
            </tr>
		</table>
				
		<input type="submit"
				style="width: 30pt; height: 20pt" value="업로드">
		
		<hr />
	</div>
</form:form>
</div>


</body>
</html>
