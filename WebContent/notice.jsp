<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!-- 공지사항 게시판 -->
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>공지 게시판</title>

<!-- Fontfaces CSS-->
<link href="board/css/font-face.css" rel="stylesheet" media="all">
<link href="board/vendor/font-awesome-4.7/css/font-awesome.min.css"
   rel="stylesheet" media="all">
<link href="board/vendor/font-awesome-5/css/fontawesome-all.min.css"
   rel="stylesheet" media="all">
<link
   href="board/vendor/mdi-font/css/material-design-iconic-font.min.css"
   rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="board/vendor/bootstrap-4.1/bootstrap.min.css"
   rel="stylesheet" media="all">

<!-- Vendor CSS-->
<link href="board/vendor/animsition/animsition.min.css" rel="stylesheet"
   media="all">
<link
   href="board/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
   rel="stylesheet" media="all">
<link href="board/vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="board/vendor/css-hamburgers/hamburgers.min.css"
   rel="stylesheet" media="all">
<link href="board/vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="board/vendor/select2/select2.min.css" rel="stylesheet"
   media="all">
<link href="board/vendor/perfect-scrollbar/perfect-scrollbar.css"
   rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="board/css/theme.css" rel="stylesheet" media="all">


<!-- 추가해준 부분 -->
<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<!-- 추가해준 부분 끝 -->

<!-- 제이쿼리 추가 -->
<script src="js/jquery/jquery-2.2.4.min.js"></script>
</head>


<body class="animsition">
   <jsp:include page="header.jsp"/>
   <div class="page-wrapper" style="background-color:lavender" >
      
      <!-- MAIN CONTENT-->
      
<% 
String userNo = (String) session.getAttribute("userNo");
%>
      
      
      <div class="main-content" >
         <div class="section__content section__content--p30">
            <div class="container-fluid">
               <div class="row">
                  <div class="col-md-12">


                     <!-- DATA TABLE -->
                     
                     <h3 class="title-5 m-b-35">공지게시판</h3>
                     
                     <div class="table-data__tool" style="float:right">
                        
                      <c:if test="${userId == 'admin04' || userId =='admin01' || userId == 'admin02' || userId == 'admin03' || userId == 'admin05' }">
                        <div class="table-data__tool-right" >
                           <button class="au-btn au-btn--green au-btn--small " onclick="location.href='momo.do?command=noticewrite'" style="background-color:#5d25dd;">
                              <i class="zmdi zmdi-plus"></i>&nbsp; 글쓰기
                           </button>
                        </div>
                     </c:if>    
                        
                     </div>
                     
                     
                     <div class="table-responsive table-responsive-data2">
                        <table class="table table-data2">
                        <col width="10%"><col width="40%"><col width="10%">
                        <col width="10%"><col width="20%"><col width="10%">
                           <thead>
                              <tr>
                                 <th>글번호</th>
                                 <th>제목</th>   
                                 <th>작성자</th>                              
                                 <th>작성일</th>
                                 <th>조회수</th>
                                 
                              </tr>
                           </thead>

                           <tbody>
                              <!-- 주석 풀어서 쓰시면 됩니다.  -->
                              <c:forEach var="noticeList" items="${noticeList }"> 
                              <tr class="tr-shadow">
                                 <td name="noNotice">${noticeList.noNotice }</td>
                                                      
                                 <td>
                                 
                                  <!--    <c:forEach begin="1" end="${titletab }"> 
                                       &nbsp;
                                    </c:forEach>  -->
                                    
                                    <a href="momo.do?command=noticeDetail&noNotice=${noticeList.noNotice}">${noticeList.titleNotice }</a><!-- 제목 클릭시 상세보기로 가기 -->
                                    
                                    
                              <c:set var="date" value="${sysdate}" />

                              <c:if test = "${noticeList.dateNotice eq date}">                  
                                    <img src="//img.echosting.cafe24.com/design/skin/admin/ko_KR/ico_new.gif" alt="NEW" class="ec-common-rwd-image">
                              </c:if> 
                                    
                                 </td>
                                                  
                                 <td>관리자</td>
                                 <td>${noticeList.dateNotice}</td>
                                 <td>${noticeList.hitNotice }</td>
                                 <td>
                                    <div class="table-data-feature">
                                    
                                     <c:if test="${userId == 'admin04' || userId =='admin01' || userId == 'admin02' || userId == 'admin03' || userId == 'admin05' }">
                                       <div class="table-data-feature">
                                          <button class="item" data-toggle="tooltip" data-placement="top" title="수정" onclick="location.href='momo.do?command=noticeUpdateForm&noNotice=${noticeList.noNotice}'">
                                             <i class="zmdi zmdi-edit"></i>
                                          </button>
                                          <button class="item" data-toggle="tooltip" data-placement="top" title="삭제" onclick="location.href='momo.do?command=noticeDelete&noNotice=${noticeList.noNotice}'">
                                             <i class="zmdi zmdi-delete"></i>
                                          </button>
                                       </div>
                                    </c:if>   
                                       
                                    </div>
                                 </td>
                              </tr>
                              <tr class="spacer"></tr>
                              </c:forEach> 
                           </tbody>
                        </table>
                     </div>
                  
                     <!-- END DATA TABLE -->
                     
                     
                  
                     <!--기능때 페이지네이션 추가 -->
                     


<jsp:include page="/paging/paging.jsp">
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>

                     
                     <!-- 페이지네이션 끝-->
               
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>

   
   <!-- Bootstrap JS-->
   <script src="board/vendor/bootstrap-4.1/popper.min.js"></script>
   <script src="board/vendor/bootstrap-4.1/bootstrap.min.js"></script>
   <!-- Vendor JS       -->
   <script src="board/vendor/slick/slick.min.js">
      
   </script>
   <script src="board/vendor/wow/wow.min.js"></script>
   <script src="board/vendor/animsition/animsition.min.js"></script>
   <script
      src="board/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
      
   </script>
   <script src="board/vendor/counter-up/jquery.waypoints.min.js"></script>
   <script src="board/vendor/counter-up/jquery.counterup.min.js">
      
   </script>
   <script src="board/vendor/circle-progress/circle-progress.min.js"></script>
   <script src="board/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
   <script src="board/vendor/chartjs/Chart.bundle.min.js"></script>
   <script src="board/vendor/select2/select2.min.js">
      
   </script>

   <!-- Main JS-->
   <script src="js/active.js"></script>
   <script src="board/js/main.js"></script>
 <jsp:include page="footer.jsp" />
</body>

</html>
<!-- end document-->