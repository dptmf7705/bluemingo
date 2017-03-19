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

<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">READ ADVERTISE BOARD</h3>
            </div>
            <!-- /.box-header -->
            
            <!-- advVO.adv_message, advVO.adv_ticker, advVO.adv_title, advVO.adv_resource, advVO.product_product_key   -->
            <!-- ADV NO, TITLE, MESSAGE, TICKER, RESOURCE, PRODUCT -->
            
            <!-- 조회화면에서 수정 또는 삭제 버튼을 클릭하면 현재 해당하는 bno값을 필요로 하기 때문에 조회페이지에서 hidden속성으로 가지고 있어야한다. -->
            <form role="form" method="post">
            	<input type="hidden" name="adv_key" value="${advVO.adv_key}">
            </form>
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
                  	value="${advVO.adv_title}" readonly="readonly">
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT">MESSAGE</label>
                  <textarea name="adv_message" class="form-control"
                  	rows="3" readonly="readonly">${advVO.adv_message}
                  </textarea>
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT ">TICKER</label>
                  <input name="adv_ticker" type="adv_ticker" class="form-control" 
                  	value="${advVO.adv_ticker}" readonly="readonly"">
                </div>  
                <div class="form-group">
                  <label for="examplInputADVTEXT">RESOURCE</label>
                  <input name="adv_resource" type="adv_resource" class="form-control" 
                  	value="${advVO.adv_resource}" readonly="readonly">
                </div>
                <div class="form-group">
                  <label for="examplInputADVTEXT">TIME</label>
                  <input name="adv_resource" type="adv_time" class="form-control" 
                  	value="${advVO.adv_time}" readonly="readonly">
                </div>
                <div class="form-group">
                  <label for="examplInputADVTEXT">PRODUCT</label>
                  <input name="product_product_key" type="product_product_key" class="form-control" 
                  	value="${advVO.product_product_key}" readonly="readonly">
                </div>  
              </div>
              <!-- /.box-body -->

			  <!-- 수정, 삭제, 리스트 버튼 
			  		이 버튼의 type이 sumbit이니까 form이 전송된다. 즉, hidden 속성으로 갖고 있던 bno값을 넘겨주게 된다.
			  -->
              <div class="box-footer">
                <button type="submit" class="btn btn-warning">UPDATE</button>
                <button type="submit" class="btn btn-danger">DELETE</button>
                <button type="submit" class="btn btn-primary">LIST ALL</button>
              </div>
          </div>
<script>
	// 버튼 클릭 이벤트로 폼 태그에 action 속성을 달아주면 된다. 원하는 곳에..
	$(function(){
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		// 수정
		// 버튼 클릭됐을때 formObj에 action 속성을 /board/modify로 주고,
		// submit()를 사용해서 셀렉터의 submit이벤트를 발생시켜서 form데이터가 전송되도록 해준다.
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/adv/update");
			formObj.attr("method", "get");
			formObj.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
		});
		
		// 삭제
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/adv/delete");
			formObj.attr("method", "post");
			formObj.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
		});
		
		// 리스트 올
		$(".btn-primary").on("click", function(){
			self.location = "/adv/listAll";
		});

	});//$(function(){})
</script>
</body>
</html>