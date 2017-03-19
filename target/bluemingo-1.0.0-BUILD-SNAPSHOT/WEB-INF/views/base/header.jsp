<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Top adv</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>
    
    	
    <!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
    
    <!-- jQuery-UI -->
    <script src="/resources/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<body>

<div class="box-header">
                <button type="submit" class="btn btn-default">HOME</button>
                <button type="submit" class="btn btn-danger">SAMPLE</button>
                <button type="submit" class="btn btn-primary">ADV LIST</button>
              </div>
<script>
	// 버튼 클릭 이벤트로 폼 태그에 action 속성을 달아주면 된다. 원하는 곳에..
	$(function(){
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		// 수정
		// 버튼 클릭됐을때 formObj에 action 속성을 /board/modify로 주고,
		// submit()를 사용해서 셀렉터의 submit이벤트를 발생시켜서 form데이터가 전송되도록 해준다.
		$(".btn-default").on("click", function(){
			self.location = "/home";
		});
		
		// 삭제
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/home");
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


