<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- Q&A 글쓰기 -->
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Title -->
    <title>Q&A 글쓰기</title>

	<!-- Favicon -->
	<link rel="icon" href="img/favicon-img/logo-favicon.png">
	
    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">
    <!-- Responsive CSS -->
    <link href="css/responsive/responsive.css" rel="stylesheet">

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
.row1 {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    margin-right: 50px;
    margin-left: 50px;
}
.container1 {
    width: 100%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
    max-width: 960px;
}    
.contact-form textarea.form-control12 {
    font-size: 12px;
    color: #72728c;
    font-weight: 600;
    border: none;
    border-radius: 0;
    overflow: auto;
    resize: vertical;
    display: block;
    width: 95%;
    background-color: #fff;
    background-image: none;
    background-clip: padding-box;
    text-align: center;
}
.btn1 {
	width: 80px;
	height: 90px;
    background-color: #7643ea;
    color: #fff;
    display: inline-block;
    font-weight: 400;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    border: 1px solid transparent;
    font-size: 1rem;
    line-height: 1.5;
    transition: background-color .15s;
    border-radius: 0;
    padding: 0 15px;
    font-weight: 600;
    font-size: 15px;
    -webkit-transition-duration: 500ms;
    transition-duration: 500ms;
}
.title_writer{
	height: 50px;
	border:none;
	
}
</style>
<%
String userId = (String)session.getAttribute("userId");
%>
</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include> 
	
    <!-- ***** Single Listing Area Start ***** -->
    <section class="dorne-single-listing-area section-padding-100">
        <div class="container1">
		<br>
    	<small>&emsp;&emsp;&emsp;&emsp; 고객센터 > Q&A > 글쓰기</small>	<!-- 카테고리 -->
   		<br>
          <br>  
          <!-- Q&A 작성 -->
          <div id="qnaWrite">
          <div class="row1 justify-content-center">
          <div class="contact-form" style="padding-top: 25px; padding-bottom: 50px;">
            <form action="momo.do?command=insert_qna" method="post">
        		<div class="row1" style="margin-top:40px; margin-bottom:20px;">
        			<h6 style="text-align:center; padding-top:15px;">제&emsp;목 &emsp;</h6>
        			<span><input type="text" class="title_writer" name="qnaTitle" style="width:500px;" 
        						required="required" placeholder="제목을 입력해주세요."/></span> <!-- ${vo.titleQna } -->
           		</div> 
           		<div class="row1" style="margin-top:40px; margin-bottom:20px;">
           			<h6 style="text-align:center; padding-top:15px;">작성자 &emsp;</h6>
        			<span><input type="text" class="title_writer" style="width:200px; background:white;" 
        						disabled value="&emsp;<%=userId %>" /></span> 
        			<input type="hidden" name="qnaWriter" value="" /> <!-- ${vo.titleQna } -->
           		</div> 
	        <hr>  
                <div class="row1">
                    <textarea name="qnaContent" class="form-control11" id="qnaContent"
                      required="required" cols="170" rows="20" placeholder="내용을 입력해주세요."></textarea>
                </div>
                       
                <div class="row1" style="margin-bottom:10px;">
                    <span class="label-input101">공개 설정:&emsp;</span> 
					<input type="radio" name="isopen" id="open" value="Y" required="required" checked onclick="qna_isopen('open');"/><label for="공개">공개 &nbsp;</label>
					<input type="radio" name="isopen" id="private" value="N" required="required" onclick="qna_isopen('private');"/><label for="비공개">비공개 &nbsp;</label>
					<span class="focus-input100"></span>
                </div>       
                <div class="row1" id="qnaPass" style="display:none; margin-bottom:20px;">
                	<small>비밀번호 입력 :&emsp;</small>
                	<span><input type="password" name="pwd_qna" style="width:200px; border:none;" ></span>
                </div>       
                <div id="row1">
                    <input type="submit" class="btn dorne-btn" style="min-width: 130px;" id="write" value="작성완료">&emsp;
					<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="cancel" value="취소" > &emsp;
 				</div>
                       
                <hr>
            </form> 
          </div>
         </div>
       </div>  
     </div>
    </section>
	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"/>
	<script src="js/active.js"></script>
	<!-- ****** Footer Area End ****** -->
	<script type="text/javascript">
function qna_isopen(value)	{
	 if(value == "private")
	   {
	      document.all["qnaPass"].style.display = 'block';         // 보이게
	   }
	   else
	   {
	      document.all["qnaPass"].style.display = 'none';  // 안보이게
	   }

}

$(document).ready(function() {
	$("#cancel").on("click", function() {
		alert("목록으로 돌아갑니다.")
		location.href="momo.do?command=qna_list";
	});
});
</script>
</body>

</html>