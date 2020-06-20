<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<script type="text/javascript"
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="js/jquery/jquery-2.2.4.min.js"></script>
<!--     Popper js -->
<script src="js/bootstrap/popper.min.js"></script>
<!--     Bootstrap-4 js -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!--     All Plugins js -->
<script src="js/others/plugins.js"></script>
<!--     Active JS -->
<script src="js/active.js"></script>
<style type="text/css">
.max-small {
   width: auto;
   height: auto;
   max-width: 70px;
   max-height: 70px;
}
</style>
<script type="text/javascript">
   function popup_profile() {
      var url = "profile.jsp";
      var name = "profile";
      var option = "width = 600, height = 550, top = 100, left = 500, location = no, scrollbars=yes"
      window.open(url, name, option);
   }
</script>
</head>
<body>
   <!-- ***** Search Form Area ***** -->
   <!-- 검색창 입니다를 클릭하면 이녀석이 튀어나옵니다. -->
   <div class="dorne-search-form d-flex align-items-center">
      <div class="container">
         <div class="row">
            <div class="col-12">
               <div class="search-close-btn" id="closeBtn">
                  <i class="pe-7s-close-circle" aria-hidden="true"></i>
               </div>
               <form action="momo.do" method="get">
                  <input type="hidden" name="command" value="searchedList">
                  <input type="search" name="searchedWord" id="search" placeholder="검색어를 입력하세요"> 
                  <input type="submit" class="d-none" value="submit">
               </form>
            </div>
         </div>
      </div>
   </div>

   <header class="header_area" id="header">
      <div class="container-fluid h-100">
         <div class="row h-100">
            <div class="col-12 h-100">
               <nav class="h-100 navbar navbar-expand-lg">
                  <a class="navbar-brand" href="index.html"><img
                     src="img/header-img/logo.png" alt="로고이미지" class="max-small"></a>
                  <button class="navbar-toggler" type="button"
                     data-toggle="collapse" data-target="#dorneNav"
                     aria-controls="dorneNav" aria-expanded="false"
                     aria-label="Toggle navigation">
                     <span class="fa fa-bars"></span>
                  </button>
                  <!-- Nav -->
                  <div class="collapse navbar-collapse" id="dorneNav">
                     <ul class="navbar-nav mr-auto" id="dorneMenu">
                        <li class="nav-item dropdown"><a
                           class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
                           role="button" data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false">모임 <i class="fa fa-angle-down"
                              aria-hidden="true"></i></a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                              <a class="dropdown-item"
                                 href="momo.do?command=selectedClubList&selectedClubLocation=지역+구분&selectedClubCategory=C&selectedClubSort=정렬+구분">모임 찾기</a>
                              <a class="dropdown-item" href="momo.do?command=test_insert">모임 생성</a>
                           </div></li>
                        <li class="nav-item dropdown"><a
                           class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
                           role="button" data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false">수업<i class="fa fa-angle-down"
                              aria-hidden="true"></i></a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                              <a class="dropdown-item"
                                 href="momo.do?command=selectedClassList&selectedClassLocation=지역+구분&selectedClassCategory=C&selectedClassSort=정렬+구분">수업 찾기</a>
                              <a class="dropdown-item" href="momo.do?command=tab_classRegister">수업 개설</a>
                           </div></li>
                        <li class="nav-item dropdown"><a
                           class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
                           role="button" data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false">후기<i class="fa fa-angle-down"
                              aria-hidden="true"></i></a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                              <a class="dropdown-item" href="momo.do?command=reviewClubList">모임 후기</a> <a
                                 class="dropdown-item" href="momo.do?command=reviewClassList">수업 후기</a>
                           </div></li>
                        <li class="nav-item dropdown"><a
                           class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
                           role="button" data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false">공지사항 &amp; QnA <i
                              class="fa fa-angle-down" aria-hidden="true"></i></a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                               <a class="dropdown-item" href="momo.do?command=noticeList">공지사항</a> <a
                                 class="dropdown-item" href="momo.do?command=qna_list">QnA</a>
                           </div></li>
                     </ul>
                     <!-- Search btn -->
                     <div class="dorne-search-btn">
                        <a id="search-btn" href="#"><i class="fa fa-search"
                           aria-hidden="true"></i> 검색</a>
                     </div>
                     <!-- Signin btn -->
                     <%
                        // 로그인 안되어있을 경우
                        String userId = (String) session.getAttribute("userId");
                        if (userId == null || userId == "") {
                     %>
                     <div class="dorne-signin-btn">
                        <a href="momo.do?command=signup">회원가입</a>
                     </div>
                     <!-- Add listings btn -->
                     <div class="dorne-add-listings-btn">
                        <a href="momo.do?command=login" class="btn dorne-btn">로그인</a>
                     </div>
                     <%
                        // 관리자 계정으로 로그인 했을 경우
                        } else if (userId.equals("admin01") || userId.equals("admin02") || userId.equals("admin03")
                              || userId.equals("admin04") || userId.equals("admin05")) {
                     %>
                     <div class="dorne-signin-btn">
                        <a href="#" onclick="location.href='momo.do?command=mypage'">마이페이지</a>
                        <!-- 관리자 페이지로 이동(없어도 무방합니다.) -->
                     </div>
                     <div class="dorne-add-listings-btn">
                        <a href="#" class="btn dorne-btn"
                           onclick="location.href='momo.do?command=logout'">로그아웃</a>
                     </div>
                     <%
                        // 멘토or일반회원으로 로그인 했을 경우
                        } else {
                     %>
                     <div class="dorne-signin-btn">
                        <a href="#" onclick="location.href='momo.do?command=mypage'">마이페이지</a>
                     </div>
                     <div class="dorne-add-listings-btn">
                        <a href="#" class="btn dorne-btn"
                           onclick="location.href='momo.do?command=logout'">로그아웃</a>
                     </div>
                     <%
                        }
                     %>
                  </div>
               </nav>
            </div>
         </div>
      </div>
   </header>
   <!-- ***** Breadcumb Area Start ***** -->
   <!-- <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/mainbg-1.jpg)"></div> -->
   <div class="breadcumb-area bg-img bg-overlay"
      style="background-color: rgba(14, 2, 35, 0.9)"></div>
   <!-- ***** Breadcumb Area End ***** -->
</body>
</html>