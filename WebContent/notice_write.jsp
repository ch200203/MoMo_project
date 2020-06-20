<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<!-- 유진 공지 작성부분 -->

<head>




<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">




<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>공지 작성 페이지입니다</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">




</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>





	<!-- Preloader -->
	<div id="preloader">
		<div class="dorne-load"></div>
	</div>


	<!-- ***** Search Form Area 삭제 ***** -->

	<!-- ***** Header Area Start 삭제 ***** -->

	<!-- ***** Breadcumb Area 삭제 ***** -->



	<!-- ***** Contact Area Start ***** -->

	<!-- Contact Form Area -->

	<br></br>

	<center>

		<div class="col-lg-6" style="padding-bottom: 25px;">
			<div class="card">
				<div class="card-header">
					<strong>공지</strong>
				</div>
				<div class="card-body card-block">
					<form action="momo.do?command=noticeInsert" method="post"
						 class="form-horizontal">
						
						<input type="hidden" name="command" value="noticeInsert">
						
						<div class="row form-group">
							<div class="col col-md-3">
								<label for="text-input" class=" form-control-label">제목</label>
							</div>
							<div class="col-12 col-md-9">
								<input type="text" id="text-input" name=titleNotice
									placeholder="글을 작성하세요" class="form-control">
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-3">
								<label for="textarea-input" class=" form-control-label">내용 </label>
									
							</div>
							<div class="col-12 col-md-9">
								<textarea name="contentNotice" id="textarea-input" rows="9"
									placeholder="내용을 입력해주세요...." class="form-control"></textarea>
							</div>
						</div>
				</div>


				<div class="card-footer">
					<input type="submit" class="btn btn-primary btn-sm" value="등록하기">
					<input type="button" class="btn btn-danger btn-sm" onclick="location.href='momo.do?command=noticeList'" value="취소하기">
				</div>
				</form>
			</div>
		</div>
	</center>
	
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