<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->

<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>CSS Tutorial | Layout</title>
    <style>
     
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }
      
      #jb-sidebar-left1 {
        width: 300px;
        padding: 20px;
        margin-right: 20px;
        float: left;
      }
      #jb-content1 {
        width: 300px;
        padding: 20px;
        margin-right: 20px;
        float: left;
      }
      #jb-sidebar-right1 {
        width: 300px;
        padding: 20px;
        margin-right: 200px;
        float: left;
      }
      #jb-sidebar-left2 {
        width: 300px;
        padding: 20px;
        margin-right: 20px;
        margin-bottom: 20px;
        float: left;
      }
      #jb-content2 {
        width: 300px;
        padding: 20px;
        margin-bottom: 20px;
        margin-right: 20px;
        float: left;
      }
      #jb-sidebar-right2 {
        width: 300px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
      }
      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
         #mask {  
     position:absolute;  
     z-index:9000;  
     background-color:#000;  
     display:none;  
     left:0;
     top:0;
   }
   .window{
     display: none;
     position:absolute;  
     left:100px;
     top:100px;
     z-index:10000;
   }
    </style>
  </head>
  <body>

      <div id="jb-header">
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <!-- jstl 날짜 fotmat -->
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

      <%@include file="../base/header.jsp" %>
      </div>
    
        <div id="jb-sidebar-left1">
         <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 300px;">
                  <form name="search_form" role="form" method="get" action="/user/search">
                  <input type="text" name="search_key" class="form-control" style="width: 260px;" placeholder="제품번호">
                  <button type="submit" class="btn btn-search-default"><i class="fa fa-search"></i></button>
                  <input type="hidden" name="product_key" value="product_key">
                  </form>
                </div>
              </div>
      </div>
      <div id="jb-content1">
        <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 300px;">
                  <form name="search_form" role="form" method="get" action="/user/search">
                  <input type="text" name="search_key" class="form-control" style="width: 260px;" placeholder="구매자성함">
                  <button type="submit" class="btn btn-search-default"><i class="fa fa-search"></i></button>
                  <input type="hidden" name="user_name" value="user_name">
                  </form>
                </div>
              </div>
        </div>
      <div id="jb-sidebar-right1">
         <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 300px;">
                  <form name="search_form" role="form" method="get" action="/user/search">
                  <input type="text" name="search_key" class="form-control" style="width: 260px;" placeholder="휴대폰번호">
                  <button type="submit" class="btn btn-search-default"><i class="fa fa-search"></i></button>
                  <input type="hidden" name="user_phone" value="user_phone">
                  </form>
                </div>
              </div>
        
      </div>

   
      <div id="jb-footer">
        <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                <tr class="scrollLocation">
                  <th>구매자번호</th>
                  <th>성함</th>
                  <th>휴대폰번호</th>
                  <th>이메일</th>
                  <th>제품번호</th>
                  <th>공고/즉구</th>
             
                </tr>
               <c:forEach items="${list}" var="userVO">
                  <tr class="listToChange">
                     <td class="scrolling" data-user_key="${userVO.user_key}">
                        ${userVO.user_key}</td>
                     <td><a href="/user/read?user_key=${userVO.user_name}"
                        class="openMask">${userVO.user_name}</a></td>
                     <td>${userVO.user_phone}</td>
                     <td>${userVO.user_id}</td>
                     <td>${userVO.product_key}</td>
                     <td>${userVO.res_type}</td>

                  </tr>
               </c:forEach>


            </tbody>
            </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        
   
   <script src="https://code.jquery.com/jquery-latest.js"></script> 
   
   <script>
   $(function(){
      
      var formObj = $("form[role='form']");
      console.log(formObj);
      
      // 수정
      // 버튼 클릭됐을때 formObj에 action 속성을 /board/modify로 주고,
      // submit()를 사용해서 셀렉터의 submit이벤트를 발생시켜서 form데이터가 전송되도록 해준다.
      $(".btn-warning").on("click", function(){
         self.location = "/adv/create";
      });
      
      // 삭제
      $(".btn-danger").on("click", function(){
         formObj.attr("action", "/adv/delete");
         formObj.attr("method", "post");
         formObj.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
      });
      
      // 리스트 올
      $(".btn_search-default").on("click", function(){
         formObj.attr("action", "/seller/search");
         formObj.attr("method", "get");
         formObj.submit();
         //self.location = "/item/search?item_search";
      });

   });//$(function(){})
   function wrapWindowByMask(){
      //화면의 높이와 너비를 구한다.
      var maskHeight = $(document).height();  
      var maskWidth = $(window).width();
       var $layerPopupObj = $('.layerPopupBox');
      var left = ( $(window).scrollLeft() + ($(window).width() - $layerPopupObj.width()) / 2 );
      var top = ( $(window).scrollTop() + ($(window).height() - $layerPopupObj.height()) / 2 );
      $layerPopupObj.css({'left':left,'top':top, 'position':'absolute'});
      $('body').css('position','relative').append($layerPopupObj)

      //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
      $('#mask').css({'width':maskWidth,'height':maskHeight});  

      //애니메이션 효과 - 일단 1초동안 까맣게 됐다가 80% 불투명도로 간다.
      $('#mask').fadeIn(1000);      
      $('#mask').fadeTo("slow",0.8);    

      //윈도우 같은 거 띄운다.
      $('.window').show();
   }

   $(document).ready(function(){
      //검은 막 띄우기
      $('.openMask').click(function(e){
         e.preventDefault();
         wrapWindowByMask();
      });

      //닫기 버튼을 눌렀을 때
      $('.window .close').click(function (e) {  
          //링크 기본동작은 작동하지 않도록 한다.
          e.preventDefault();  
          $('#mask, .window').hide();  
      });       

      //검은 막을 눌렀을 때
      $('#mask').click(function () {  
          $(this).hide();  
          $('.window').hide();  
      });      
   });
   </script>

      </div>
    </div>
    
    <div id="mask"></div>
   <div class="window">
      <input type="button" href="#" class="close" value="나는야 닫기 버튼(.window .close)"/>
   </div>
  </body>
</html>