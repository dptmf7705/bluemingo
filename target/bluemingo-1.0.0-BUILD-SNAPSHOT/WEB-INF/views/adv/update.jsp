<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../base/header.jsp" %>​
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top adv</title>
</head>
<body>

	<form role="form" method="post">
		<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">UPDATE ADVERTISE BOARD</h3>
            </div>
            <!-- /.box-header -->
            <!-- advVO.adv_message, advVO.adv_ticker, advVO.adv_title, advVO.adv_resource, advVO.product_product_key   -->
            <!-- ADV NO, TITLE, MESSAGE, TICKER, RESOURCE, PRODUCT -->
            <input type="hidden" name="adv_key" value="${advVO.adv_key}">
            <!-- 받아온 데이터 뿌려주는 부분 -->
              <div class="box-body">
                <div class="form-group">
                  <label for="examplInputADVTEXT">ADV NO</label>
                  <input name="adv_key" type="adv_key" class="form-control" 
                  	value="${advVO.adv_key}" readonly="readonly">
                </div>

				<div class="form-group">
                  <label for="examplInputADVTEXT">TITLE</label>
                  <input name="adv_title" type="adv_title" class="form-control" 
                  	value="${advVO.adv_title}" >
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT">MESSAGE</label>
                  <textarea name="adv_message" class="form-control" STYLE="text-align:left"
                  	rows="3" >${advVO.adv_message}
                  </textarea>
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT ">TICKER</label>
                  <input name="adv_ticker" type="adv_ticker" class="form-control" 
                  	value="${advVO.adv_ticker}" >
                </div>  
                <div class="form-group">
                  <label for="examplInputADVTEXT">RESOURCE</label>
                  <input name="adv_resource" type="adv_resource" class="form-control" 
                  	value="${advVO.adv_resource}">
                </div>
                <div class="form-group">
                  <label for="examplInputADVTEXT">TIME</label>
                  <input name="adv_time" type="adv_time" class="form-control" 
                  	value="${advVO.adv_time}">
                </div>
                <div class="form-group">
                  <label for="examplInputADVTEXT">PRODUCT</label>
                  <input name="product_product_key" type="product_product_key" class="form-control" 
                  	value="${advVO.product_product_key}" >
                </div>  
              </div>
              <!-- /.box-body -->
        </div>     	
	</form>

			  <!-- 수정, 삭제, 리스트 버튼 
			  		이 버튼의 type이 sumbit이니까 form이 전송된다. 즉, hidden 속성으로 갖고 있던 bno값을 넘겨주게 된다.
			  -->
              <div class="box-footer">
                <button type="submit" class="btn btn-primary">SAVE</button>
                <button type="submit" class="btn btn-danger">CANCLE</button>
              </div>
            
          </div>

<script>

$(function(){
	var formObj = $("form[role='form']");
	
	$(".btn-primary").on("click", function(){
		// <form>에 action을 따로 지정하지 않으면 현재 경로의 uri에서 처리하게된다. 
		// 즉, method로는 post로 해놨으니까 /board/update에 POST방식에 매핑되는 컨트롤러가 처리하게된다.
		formObj.submit();
		
	}); // btn-primary click
	
	$(".btn-danger").on("click", function(event){
		event.preventDefault();
		
		self.location = "/adv/listAll";
	});// btn-danger click

}); // $(function(){})



</script>



</body>
</html>