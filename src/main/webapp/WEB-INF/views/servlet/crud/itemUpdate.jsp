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

function doImageUpload(id){
	var target_id = id;
	var file_name = null;
	var data = null;
	var image = null;
	
	var form = $('<form></form>');
    form.attr('method', 'post');
    form.attr('enctype', 'multipart/form-data');
    
	
	if(target_id == "item_image"){
		image = document.getElementById("imageFile");
		file_name = image.value;
		
	}else{
		image = document.getElementById("detail_imageFile");
		file_name = image.value;
	}
	
	if(file_name == ""){
    	alert("업로드 할 파일이 없습니다.");
    	return;
    }else{
    	alert(file_name+"\n\n위 이미지 파일을 업로드 하시겠습니까?");
    	form.append(image)
    	data = new FormData(form[0]);
    	
    	$.ajax({	
    		url: '/servlet/crud/imageUpload',
            type: "post",
            dataType: "text",
            data: data,
            // cache: false,
            processData: false,
            contentType: false,
            success: function(data, textStatus, jqXHR) {
            	document.getElementById(target_id).value = data;
            }, error: function(jqXHR, textStatus, errorThrown) {}
    	});
    }
	
	
}
$(document).ready( function() {
	var purpose = '${msg_purpose}';
	var status = '${msg_status}';
	var value = '${msg_value}';
	var from = '${msg_from}';
	
	msg_parsing(purpose,from,status,value);
	
	setNum();
});

$(function(){
		$("#createOptionBtn").click(function(){
			var num = addNum();
			var input_name = "option_list["+num+"]"
			var tag = "<tr>"
			+"<td>"
			+"<label for="+"input_item_data"+">Option_name ["+num+"] </label>"
			+"<input name="+input_name+".option_name"+" id="+"option_test"+num+" type="+"text"+" class="+"form-control"+" placeholder="+"옵션을&nbsp입력하세요"+">"
			+"</td>"
			+"<td>"
			+"<label for="+"input_item_data"+">Option_value</label>"
			+"<input name="+input_name+".option_value"+" type="+"text"+" class="+"form-control"+" placeholder="+"옵션을&nbsp입력하세요"+">"
			+"</td>"
			+"<td><label for="+"input_item_data"+">Option_price</label>"
			+"<input name="+input_name+".option_price"+" type="+"text"+" class="+"form-control"+" placeholder="+"추가비용을&nbsp입력하세요"+">"
			+"</td>"+"</tr>";

		$("#option_subject").append(tag);
			
	});
	
})
function addNum(){
	return document.getElementById("option_num").value++;
}
function setNum(){
	var option_label = document.getElementById("option_label");
	
}

</script>

</head>
<body>
<div class="box">

<form:form role="form" commandName="Item_companyVO" name="ItemData" method="post" enctype="multipart/form-data">
	<div class="box-tools">
		<h4 class="box-title" style="text-align:center">제품 정보 생성 페이지</h4>
		
		<hr />
		<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
				<td>
					<label for="input_item_data">제품이름</label>
					<input name="item_name" type="text" class="form-control" placeholder="제품이름을 입력하세요" value="${icVO.item_name}">
                </td>
                <td class="item_id" style="background:#ff8000;">
                	<label for="input_item_data">제품 ID</label>
                	<c:set var="id" value="${icVO.item_id}" />
                	<c:choose>
                	    <c:when test="${!empty id}">
                	    	<p>${icVO.item_id}</p>
                	    	<input type="hidden" name="item_id" id="input_item_id" value="${icVO.item_id}">
                	    </c:when>
                	    <c:when test="${empty id}">
                	    	<p>${item_id}</p>
                	    	<input type="hidden" name="item_id" id="input_item_id" value="${item_id}">
                	    </c:when>
                	    <c:otherwise>
                	   		<p></p>
                	    </c:otherwise>
                	</c:choose>
                </td>
                <td>
					<label for="input_item_data">판매자번호</label>
					<input name="company_key" type="text" class="form-control" placeholder="판매자 번호를 입력하세요" value="${icVO.company_key}">
                </td>
			</tr>
			<tr>
				<td colspan="3">
					<label for="input_item_data">제품 이미지</label>
					<p><input type="text" name="item_image" id="item_image" style="width:300px"></p>
					<input type="file" id="imageFile" name="imageFile" class="centered">
					<button type="button" onclick="doImageUpload('item_image')" class="btn btn-default">업로드</button>
                </td>
			</tr>
			<tr>
				<td>
					<label for="input_item_data">카테코리 1차</label>
					<input name="item_category_top" type="text" class="form-control" placeholder="제품이름을 입력하세요" value="${icVO.item_category_top}">
                </td>
                <td>
					<label for="input_item_data">카테고리 2차</label>
					<input name="item_category_mid" type="text" class="form-control" placeholder="판매자 번호를 입력하세요" value="${icVO.item_category_mid}">
                </td>
                <td>
					<label for="input_item_data">카테고리 3차</label>
					<input name="item_category_bot" type="text" class="form-control" placeholder="판매자 번호를 입력하세요" value="${icVO.item_category_bot}">
                </td>
			</tr>
			<tr>
				<td>
					<label for="input_item_data">즉시구매가</label>
					<input name="item_direct_price" type="text" class="form-control" placeholder="제품이름을 입력하세요" value="${icVO.item_direct_price}">
                </td>
                <td>
					<label for="input_item_data">공동구매가</label>
					<input name="item_sale_price" type="text" class="form-control" placeholder="판매자 번호를 입력하세요" value="${icVO.item_sale_price}">
                </td>
                <td>
					<label for="input_item_data">N사 최저가</label>
					<input name="item_naver_price" type="text" class="form-control" placeholder="판매자 번호를 입력하세요" value="${icVO.item_naver_price}">
                </td>
			</tr>
			<tr>
				<td colspan="3">
					<label for="input_item_data">짧은 설명</label>
					<textarea name="item_inform" class="form-control" placeholder="Enter Message" rows="3" >${icVO.item_inform}</textarea>
                </td>
	        </tr>
		</table>
	</div>
		<table class="advtable advtable-bordered table-hover detail-table text-center" id="option_subject">
			<tr >
				<td>
					<label>제품 옵션 리스트 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
					<input id="option_num" name="option_num" type="hidden" value="0">
					<button type="button" id="createOptionBtn" onclick="createOptionList()" class="btn btn-default">옵션추가</button>
				</td>
			</tr>
			
			<c:forEach items="${icVO.option_list}" var="optionVO">
			<tr>
				<td>
					<label for="input_item_data">option_name</label>
					<input name="option_name"  type="text" class="form-control" placeholder="옵션을 입력하세요" value="${optionVO.option_name}">
                </td>
                <td>
					<label for="input_item_data">option_value</label>
					<input name="option_value" type="text" class="form-control" placeholder="옵션을 입력하세요" value="${optionVO.option_value}">
                </td>
                <td>
					<label for="input_item_data">option_price</label>
					<input name="option_price" type="text" class="form-control" placeholder="추가비용을 입력하세요" value="${optionVO.option_price}">
                </td>
			</tr>
			</c:forEach>
		</table>
	<div class="box-tools">
		<table class="advtable advtable-bordered table-hover detail-table text-center">
			<tr>
	        	<td>
					<label for="input_item_data">제품 상세 이미지</label>
					<p><input type="text" name="item_detail_image" id="item_detail_image" style="width:300px"></p>
					<input type="file" id="detail_imageFile" name="detail_imageFile" class="centered">
					<button type="button" onclick="doImageUpload('item_detail_image')" class="btn btn-default">업로드</button>
                </td>
	        </tr>
	        <tr>
				<td>
					<label for="input_item_data">상세 설명</label>
					<textarea name="item_detail_inform" class="form-control" placeholder="Enter Message" rows="5" >${icVO.item_detail_inform}</textarea>
                </td>
	        </tr>
		</table>
		
		<button type="button" onclick="testOp()" class="btn btn-default">테스트</button>
		
		<input type="submit"
				style="width: 30pt; height: 20pt" value="업로드">
		<hr />
	</div>
</form:form>
</div>


</body>
</html>
