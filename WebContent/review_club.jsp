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
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>모임후기게시판</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>

<style>
#categoryIcon1 {
	min-width: 130px;
	max-width: 130px;
	min-height: 35px;
	max-height: 35px;
	color: white;
	background-color: #7643EA;
}

#reviewPRF {
	min-width: 170px;
	max-width: 170px;
	min-height: 155px;
	max-height: 155px;
}

#reviewListDiv {
	min-width: 570px;
	max-width: 570px;
}

#reviewWriteDiv {
	text-align: right;
}

#reviewWirteBtn {
	height: 55px;
	color: white;
}
</style>

<%
	String userId = (String) session.getAttribute("userId");
%>

<script type="text/javascript">
	function unlogin(userId) {
		alert("userId: " + userId);
		if (userId == null || userId == ""){
			alert("후기작성은 로그인 후 가능합니다.");
		}
	}
</script>

<body>

	<jsp:include page="header.jsp" />
	<!-- Preloader -->
	<div id="preloader">
		<div class="dorne-load"></div>
	</div>

	<section
		class="dorne-features-events-area bg-img bg-overlay-9 section-padding-100-50"
		style="background-image: url(img/bg-img/hero-3.jpg)">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-heading text-center"
						style="margin: 0px; height: 250px;">

						<br> <br> <br>

						<h4>모임 후기 게시판</h4>

						<div class="dorne-add-listings-btn" id="reviewWriteDiv">
							<a href="momo.do?command=reviewIdClubCk" class="btn dorne-btn"
								id="reviewWirteBtn" onclick="unlogin(<%=userId %>)">+ 글쓰기</a>
						</div>
					</div>
				</div>
			</div>

			<!-- 모임후기리스트 -->
			<div class="row">
				<c:choose>
					<c:when test="${empty reviewClubList }">
						<div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="reviewClubList" items="${reviewClubList }">
							<c:if test="${reviewClubList.deleteYNClubReview eq 'N' }">
								<div class="col-12 col-lg-6" id="reviewListDiv"
									onclick="location.href='momo.do?command=reviewClubDetail&noClubReview=${reviewClubList.noClubReview }'">
									<div
										class="single-feature-events-area d-sm-flex align-items-center wow fadeInUpBig"
										data-wow-delay="0.2s">
										<div class="feature-events-thumb">
											<c:choose>
												<c:when test="${empty reviewClubList.pictureClubReview }">
													<img class="picture_size"
														src=img/default_img/default_picture_2.png alt=""
														id="reviewPRF">
												</c:when>
												<c:otherwise>
													<img
														src="img/clubReview_img/${reviewClubList.pictureClubReview}"
														alt="" id="reviewPRF">
												</c:otherwise>
											</c:choose>
											<div class="date-map-area d-flex">
												<a id="categoryIcon1">${reviewClubList.categoryName }</a>
											</div>
										</div>
										<div class="feature-events-content">
											<h5>${reviewClubList.titleClubReview }</h5>
											<h6>
												<td><b>모임명&nbsp;&nbsp;&nbsp;${reviewClubList.clubName }</b></td>
												<br>
												<td>작성자&nbsp;&nbsp;&nbsp;${reviewClubList.memberId }</td> <br>
												<td>작성일&nbsp;&nbsp;&nbsp;${reviewClubList.dateClubReview }</td>
											</h6>
											<p></p>
										</div>
										<div class="feature-events-details-btn">
											<a href="#">+</a>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<!-- /모임후기리스트 -->

			</div>
		</div>
	</section>
	<!-- ***** Features Events Area End ***** -->

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