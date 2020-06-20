<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<!-- 상세보기 페이지 -->
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<!-- single-listing html에서 가져옴 -->
    <!-- Title -->
    <title>공지사항 상세보기</title>

	<!-- Favicon -->
	<link rel="icon" href="img/favicon-img/logo-favicon.png">

    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="css/responsive/responsive.css" rel="stylesheet">

<!--textarea 작성부분 크게-->
<style type="text/css">
.contact-form textarea.form-control11 {
    height: 300px;
    font-size: 12px;
    color: #72728c;
    font-weight: 600;
    border: none;
    border-radius: 0;
    margin-bottom: 30px;
    overflow: auto;
    resize: vertical;
    display: block;
    width: 100%;
    padding: .375rem .75rem;
    background-color: #fff;
    background-image: none;
    background-clip: padding-box;
    
    
}
</style>


</head>

<body>

<jsp:include page="header.jsp"></jsp:include> 
    <!-- Preloader -->
    <div id="preloader">
        <div class="dorne-load"></div>
    </div>

    <!-- ***** Search Form Area ***** -->
   
    

 

    <!-- ***** Single Listing Area Start ***** -->
    <section class="dorne-single-listing-area section-padding-100">
        <div class="container">
        <form action="momo.do?command=noticeInsert" method="post"
						 class="form-horizontal">
					<h4>${vo.titleNotice }</h4>
					<small><span style="color: gray;">작성자 : &nbsp;<!-- 여기에 작성자 변수명 --> 관리자 </span></small>
					&nbsp;
					<small><span style="color: gray;">작성일 : &nbsp;<!-- 여기에 작성자 변수명 --> ${vo.dateNotice }</span></small>
					&nbsp;
					<small><span style="color: gray; position: relative; left: 65%;">조회수 : ${vo.hitNotice }</span></small>        
	        <hr/>        
            <div class="row justify-content-center">
                 <br>
                <div class="contact-form" style="padding-top: 25px; padding-bottom: 50px;">
                           <div class="	row">
                              
                              
                              <div class="col-12">
                                 <textarea name="message" class="form-control11" id="Message"
                                    cols="170" rows="20" readonly="readonly">${vo.contentNotice }</textarea>
                              </div>
                           </div>
                           <div id="pic">
                           
                           
                           <c:if test="${userId == 'admin04' || userId =='admin01' || userId == 'admin02' || userId == 'admin03' || userId == 'admin05' }">
                          
                           <button type="button" value="수정" onclick="location.href='momo.do?command=noticeUpdateForm&noNotice=${vo.noNotice}'" class="btn dorne-btn" style="position: relative; opacity:0.7; left: 40%;">수정하기</button>
	                     	<button type="button" value="삭제" onclick="location.href='momo.do?command=noticeDelete&noNotice=${vo.noNotice}'" class="btn dorne-btn" style="position: relative; opacity:0.7; left: 40%;">삭제하기</button>
	                     	</c:if>
	                     	
	                     	<button type="button" value="목록" onclick="location.href='momo.do?command=noticeList'" class="btn dorne-btn" style="position: relative; opacity:0.7; left: 40%;">목록으로</button>
	                     	</div>
                     	</div>
            </div>
            </form>
        </div>
    </section>
    <!-- ***** Single Listing Area End ***** -->

    <!— ****** Footer Area Start ****** —>
     <jsp:include page="footer.jsp" />
   <!— footer 끝///////////////////////////////////////////////////////////////////////////////////// —>
    <!— Popper js —>
    <script src="js/bootstrap/popper.min.js"></script>
    <!— Bootstrap-4 js —>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!— All Plugins js —>
    <script src="js/others/plugins.js"></script>
   
    <!— Active JS —>
    <script src="js/active.js"></script>
</body>

</html>