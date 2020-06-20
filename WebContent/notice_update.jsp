<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<!-- 유진 공지 수정부분 -->

<head>




<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">




<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>공지 수정 페이지입니다</title>

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


	
	<br></br>

	<center>
		<div class="col-lg-6">
			<div class="card">
				<div class="card-header">
					<strong>공지</strong>
				</div>
				<div class="card-body card-block">
				
					<form action="momo.do" method="get" enctype="multipart/form-data" class="form-horizontal">
						
						<input type="hidden" name="command" value="noticeUpdate">
							<input type="hidden" name="noNotice" value="${vo.noNotice}">

						<div class="row form-group">
							<div class="col col-md-3">
								<label for="text-input" class=" form-control-label">제목</label>
							</div>
							<div class="col-12 col-md-9">
								<input type="text" id="text-input" name="titleNotice"  class="form-control" value="${vo.titleNotice}"/> 
								
									
									<!-- <small class="form-text text-muted">없어도 될 것 같은 곳 추후 삭제하겠음</small> -->
							</div>
						</div>



						<div class="row form-group">
							<div class="col col-md-3">
								<label for="textarea-input" class=" form-control-label">내용 : </label>
							</div>
							<div class="col-12 col-md-9">
								<textarea name="contentNotice" id="textarea-input" rows="9"	 class="form-control">${vo.contentNotice }</textarea>
								
							</div>
						</div>

				
				</div>


				<div class="card-footer">
					<%-- <button type="location.href='momo.do?command=noticeUpdate&noNotice=${vo.noNotice}'" class="btn btn-primary btn-sm"> --%>
						<input type="submit" value="수정" class="btn btn-primary btn-sm">
						<!-- <i class="fa fa-dot-circle-o"></i> 수정 -->
					</button>
					<button type="button" class="btn btn-danger btn-sm" onclick="location.href='momo.do?command=noticeList'">취소</button>
						<!-- <i class="fa fa-ban"></i>  ban이미지였는데 필요없어서 지움-->
					
				</div>
					</form>
				
			</div>
		</div>
		</div>
		</div>
	</center>



	<!-- ***** Contact Area End ***** -->

	<!-- ****** Footer Area Start ****** -->
	
	 <jsp:include page="footer.jsp" />
	<!-- ****** Footer Area End ****** -->
	<script src="js/active.js"></script>

</body>

</html>