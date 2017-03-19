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
              <h3 class="box-title">REGISTER ADVERTISE BOARD</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <!-- form에 action을 따로 지정해주지 않으면 현재 경로를 그대로 action의 대상 경로로 잡는다. 
            	즉, 해당 form 에 데이터를 입력한 후 sumbit 버튼을 누르면 board/create의 경로에 post방식으로 호출되므로
            	이 URI에 매핑되는 컨트롤러에서 폼데이터를 받아서 처리할 것이다.-->
            <!-- (adv_title,adv_message,adv_ticker,adv_resource,product_product_key) -->
            <form role="form" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="examplInputADVTEXT">TITLE</label>
                  <input name="adv_title" type="adv_title" class="form-control" id="examplInputADVTEXT" placeholder="Enter Title">
                </div>
                <div class="form-group">
                  <label for="examplInputADVTEXT">MESSAGE</label>
                  <textarea name="adv_message" class="form-control" placeholder="Enter Message" rows="3"></textarea>
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT ">TICKER</label>
                  <input name="adv_ticker" type="text" class="form-control" placeholder="Enter Ticker">
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT ">RESOURCE</label>
                  <input name="adv_resource" type="text" class="form-control" placeholder="Enter Resource">
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT ">TIME</label>
                  <input name="adv_time" type="text" class="form-control" placeholder="00:00:00">
                </div>
                
                <div class="form-group">
                  <label for="examplInputADVTEXT ">PRODCUT KEY</label>
                  <input name="product_product_key" type="text" class="form-control" placeholder="Enter Product Key">
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
</body>
</html>
