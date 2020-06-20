<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!-- 상세보기 페이지 -->
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Title -->
<title>수업후기상세</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">
<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<!-- font-awe-some -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" />
<% String userNo = (String) session.getAttribute("userNo"); %>

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
	display: inline-block;
	width: auto;
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
	width: auto;
}

.updateTitle {
	height: 50px;
	border: none;
	width: 670px;
}

#reply {
	display: inline-block;
	width: auto;
}

.reviewImg {
	width: 80%;
	height: 80%;
}

#reviewReply {
	width: 600px;
	height: 90px;
}

.like_a{
	float:right; 
	position: relative; 
	right: -480px; 
}
.like_b{
	float:right; 
	position: relative; 
	right: -480px; 
}
.like_cnt{
	float:right; position: relative; right: -470px;  
}

#like_btn{
	float: right;
	position: relative;
	right : 100px;
	top : -30px;
}
</style>

</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>

	<!-- ***** Single Listing Area Start ***** -->
	<section class="dorne-single-listing-area section-padding-100">
		<div class="container1">


			<!-- 수업상세정보 -->
			<div id="qnaUpdate">
				<div class="row1 justify-content-center">
					<div class="contact-form"
						style="padding-top: 25px; padding-bottom: 50px;">
						<form action="momo.do?command=reviewClassDetail" method="post">
							<div class="row1" style="margin-top: 40px; margin-bottom: 20px;">
								<h2>
									<b>${classReviewDetail.classReviewTitle }</b>
									<input type="hidden" id="clubNo2" value="${classReviewDetail.classReviewNo }"/>
								</h2>
								<c:choose>
               						<c:when test="${empty userNo }"> <!-- 비회원일 때 -->
 										<div class="like_div" >
            								<a id="like_notUser" class="like_b"><i style="font-size: 40px;" class="far fa-thumbs-up"></i></a>
             								<h5><span class="like_cnt">${likeVo.likeCnt } </span></h5> <!-- 좋아요 수 표시 -->
          								</div>	
                					</c:when>
                				<c:otherwise> <!-- 회원일 때 -->
                					<c:choose>
                						<c:when test="${likeVo.likeYN eq 'Y' && likeVo.memberNo eq userNo}"> <!-- 좋아요 누른상태 -->
                							<div class="like_div" >
            									<a class="like_a"><i style="font-size: 40px;" class="fas fa-thumbs-up"></i></a>
            									<h5><span class="like_cnt">${likeVo.likeCnt } </span></h5> <!-- 좋아요 수 표시 -->
            									<input type="hidden" name="likeYN" class="like" value="Y">
          									</div>
                						</c:when>
                				<c:otherwise> <!-- 좋아요 안누른 상태 -->
                					<div class="like_div" >
            							<a class="like_a"><i style="font-size: 40px;" class="far fa-thumbs-up"></i></a>
 										<h5><span class="like_cnt">${likeVo.likeCnt } </span></h5> <!-- 좋아요 수 표시 -->
             							<input type="hidden" name="likeYN" class="like" value="N">
          							</div>
               					</c:otherwise>
               					</c:choose>		
              				</c:otherwise>
						</c:choose>
					</div>
							<small><span style="color: gray;">&emsp;
									수업명 : &emsp;</span></small><small>${classReviewDetail.className }</small>
							<small><span style="color: gray;">&emsp;&emsp;&emsp;
									강사명 : &emsp;</span></small> <small>${classReviewDetail.tutorName }</small>
							<small><span style="color: gray;">&emsp;&emsp;&emsp; 
									작성자 : &emsp;</span></small> <small>${classReviewDetail.writeridClassReview }</small>
							<small><span style="color: gray;">&emsp;&emsp;&emsp;
									작성일 : &emsp;</span></small> <small>${classReviewDetail.classReviewDate }</small>
							<small><span style="color: gray;">&emsp;&emsp;&emsp;
									조회수 : &emsp;</span></small> <small>${classReviewDetail.classReviewHit }</small>
							<hr>

							<div>
								<!-- 후기 사진 -->
								<c:choose>
									<c:when test="${empty classReviewDetail.classReviewPicture }">
										<center>
											<img class="reviewImg"
												src=img/default_img/default_picture_2.png alt=""
												id="reviewPRF">
										</center>
									</c:when>
									<c:otherwise>
										<center>
											<img class="reviewImg"
												src="img/classReview_img/${classReviewDetail.classReviewPicture}"
												alt="">
										</center>
									</c:otherwise>
								</c:choose>
							</div>

							<br>

							<div class="row1">
								<textarea name="message" class="form-control11" id="Message"
									cols="170" rows="20" placeholder="후기내용을 작성해주세요">${classReviewDetail.classReviewContent }</textarea>
							</div>

							<div class="row1">
								<%
									String userId = (String) session.getAttribute("userId");
									System.out.println("userId: " + userId);
								%>
								<c:choose>
									<c:when
										test="${classReviewDetail.writeridClassReview eq userId }">
										<!-- 수업장일 경우 -->
										<input type="button" class="btn dorne-btn"
											style="min-width: 130px;" id="list" value="목록"
											onclick="location.href='momo.do?command=reviewClassList'">
										&emsp;
										<input type="button" class="btn dorne-btn"
											style="min-width: 130px;" id="mod" value="수정"
											onclick="location.href='momo.do?command=showClassReviewUpdate&classReviewNo=${classReviewDetail.classReviewNo }'">
										&emsp;
										<!-- style="display:none" -->
										<input type="button" class="btn dorne-btn"
											style="min-width: 130px;" id="del" value="삭제"
											onclick="location.href='momo.do?command=reviewClassDelete&classReviewNo=${classReviewDetail.classReviewNo }'">
									</c:when>
									<c:otherwise>
										<!-- 비회원일 경우  -->
										<input type="button" class="btn dorne-btn"
											style="min-width: 130px;" id="list" value="목록"
											onclick="location.href='momo.do?command=reviewClassList'">
										&emsp;
									</c:otherwise>
								</c:choose>
							</div>
						</form>

					</div>
				</div>
			</div>

		</div>
	</section>



	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp" />
	<!-- ****** Footer Area End ****** -->

	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap-4 js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js/others/plugins.js"></script>
	<!-- Active JS -->
	<script src="js/active.js"></script>
</body>

</html>

</html>