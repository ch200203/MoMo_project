<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=utf-8");
%>
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
<title>����������</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<!-- font-awsome CSS �߰� -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" />

<%
	String userId = (String) session.getAttribute("userId");
	String test = (String)request.getParameter("tutorYN"); 
%>


</head>

<style type="text/css">
.contact-form textarea.form-control4 {
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

.btn_1234567890 {
	height: 30px;
	width: 70px;
	color: #fff;
	font-weight: 600;
	font-size: 15px;
	border: 0;
}

.club_btn {
	background: #7643EA;
	color: #fff;
	border: 0;
	outline: 0;
	padding: 8px 8px;
	font-size: 15px;
	margin: 2px 2px;
	margin-top: 15px;
	border-radius: 6px;
}

.club_btn:hover {
	background-color: darken(#7643EA, 10%);
}
#level{
	font-family: FontAwesome;
	font-size: 23pt;
}
</style>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="hero-search-form"
		style="margin-left: 22%; margin-right: 22%; margin-bottom: 10%">
		<!-- Tabs -->
		<div class="nav nav-tabs" id="heroTab" role="tablist">
			<a class="nav-item nav-link active" id="nav-places-tab"
				data-toggle="tab" href="#nav-places" role="tab"
				aria-controls="nav-places" aria-selected="true">�� ���� ����</a> <a
				class="nav-item nav-link" id="nav-events-tab" data-toggle="tab"
				href="#nav-events" role="tab" aria-controls="nav-events"
				aria-selected="false">���� ���� ����</a>
		</div>

		<!-- Tabs Content -->
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-places"
				role="tabpanel" aria-labelledby="nav-places-tab">
				<form action="momo.do?command=mypage-form" method="post" name="mypage" onsubmit="return checkValue()" enctype="multipart/form-data">
					<div class="overview-content mt-50" id="club_detail">
						<div class="contact-form">
							<div class="contact-form-title">
								<h3>${mypage.memberName}���� ����������</h3>
								<br>
							</div>
							<div class="row">
								<div class="col-12">
									<!-- ������ ���� -->
									<center>
										<c:choose>
											<c:when test="${empty mypage.memberPicture}">
												<img src="img/header-img/logo_02.png" alt="">
											</c:when>
											<c:otherwise>
												<img src="img/memberProfile_img/${mypage.memberPicture}" name="memberPicture">
											</c:otherwise>
										</c:choose>
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="file" name="memberPicture" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="memberPicture_or" value="${mypage.memberPicture}"/> <br> <br> <br>
									</center>
								</div>
								<div class="col-12 col-md-6">
									<small>���̵�</small> <input type="text" name="memberName"
										id="memberName" class="form-control" readonly="readonly"
										value="${mypage.memberId}">
								</div>
								<div class="col-12 col-md-6">
									<small>����</small> 
									<input type="text" id="level" name="memberScore" class="form-control" placeholder="��������" value="&#xf005;" readonly="readonly">
                                 	<input type="hidden" id="level2" name="memberScore" class="form-control" placeholder="��������" value="${mypage.memberScore}" readonly>
								</div>
								<div class="col-12 col-md-6">
									<small>��й�ȣ ����</small> <input type="password" name="memberPwd"	id="memberPwd" class="form-control">
										<input type="hidden" id="nowPwd" value="${mypage.memberPwd }"/>
								</div>
								<div class="col-12 col-md-6">
									<small>��й�ȣ ���� Ȯ��</small> <input type="password"
										name="memberPwdCheck" id="memberPwdCheck" class="form-control">
								</div>
								<div class="col-12 col-md-6">
									<small>�������</small> <input type="text" name="birthday"
										id="birthday" class="form-control" readonly="readonly"
										value="${mypage.birthday}">
								</div>
								<div class="col-12 col-md-6">
									<small>�̸���</small> <input type="email" name="email" id="email"
										class="form-control" value="${mypage.email}">
								</div>
								<div class="col-12 col-md-6">
									<small>��ȭ��ȣ</small> <input type="text" name="phone" id="phone"
										class="form-control" value="${mypage.phone}">
								</div>
								<div class="col-12 col-md-6">
									<small>�ּ�</small> <input type="text" name="memberAddress"
										id="memberAddress" class="form-control"
										value="${mypage.memberAddress}">
								</div>
								<div class="col-12 col-md-6">
									<small>���� ī�װ�</small> <select class="form-control"
										style="height: 50px" name="categoryName" id="categoryName">
										<option selected>${mypage.categoryName}</option>
										<option value="����/����">����/����</option>
										<option value="����/�����">����/�����</option>
										<option value="����">����</option>
										<option value="��ȭ/����/����">��ȭ/����/����</option>
										<option value="�ݷ�����">�ݷ�����</option>
										<option value="���͵�">���͵�</option>
										<option value="������/�ƿ�����">������/�ƿ�����</option>
										<option value="�丮/�Թ�">�丮/�Թ�</option>
										<option value="����/��">����/��</option>
										<option value="��������">��������</option>
									</select>
								</div>
								<div class="col-12">
									<input type="submit" class="btn dorne-btn" value="�����ϱ�">
									<input type="button" class="btn dorne-btn" onclick="location.href='momo.do?command=main'" value="���ư���">
								</div>
							</div>
						</div>
					</div>
				</form>

				<!-- Ȱ������ ���� ���� ------------------------------------------------------------------------------>
				<div class="listing-menu-area mt-100" id="club_member">
					<hr>
					<h3 style="color: white">Ȱ�� ���� ����</h3>
					<br>
					<c:choose>
						<c:when test="${empty myClubList}">
							<p style="text-align: center; color: white;">
								<b>--- Ȱ�� ���� ������ �����ϴ� ---</b>
							</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="myClubList" items="${myClubList}">
								<%-- <c:forEach var="myClassList" items=${myClassList }>
								
								</c:forEach> --%>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<br>
										<h6 style="color: black">${myClubList.clubName}</h6>
									</div>
									<div class="listing-menu-price">
										<button type="button" class="club_btn"
											onclick="location.href='momo.do?command=club_detail&clubNo=${myClubList.clubNo}'">����
											�� ����</button>
									</div>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<div class="tab-pane fade" id="nav-events" role="tabpanel"
				aria-labelledby="nav-events-tab">
			<br>
			<br>
			<c:choose>
			<c:when test="${tutorYN eq 'N'}">
				<div id="tutorRegister">
				<input type="hidden" id="userNo" value="<%=userId%>">
					<button type="button" class="btn dorne-btn" onclick="tutorRegister()">����� ����ϱ�</button>
					<br>
					<br>
					<p style="color: white">
						����� ����ϱ� ��ư�� Ŭ���ϸ� ���� ������ ���ε��� �� �ֽ��ϴ�.
						<br> ���� ���� ���� ���ε带 �Ϸ��ؾ� ����� Ȱ���� �� �ֽ��ϴ�.
					</p>
				</div>
			</c:when>
			<c:otherwise>
				<div id="tutorRegister2">
					<button type="button" class="btn dorne-btn"
						onclick="tutorFileUpload()">���� ���� ���ε�</button>
					<br>
				</div>
			</c:otherwise>
			</c:choose>
				<form class="tutor-file" action="momo.do?command=uploadTutorFile"
					method="post" enctype="multipart/form-data" id="registerForm"
					style="display: none;">
					<div class="listing-menu-area mt-30" id="club_member">
						<h3 style="color: white">���� ���� ���ε�</h3>
						<br>
						<p style="color: white">
							�з� ����, ��� ����, �ڰ��� �� ���ο��� �ش��ϴ� ������ ���ε� �� �� �ֽ��ϴ�. <br> ���ε���
							���ϰ� ���� �Ұ��� ���� ��� �� ���� �󼼺��� ���������� ������ ������ �����մϴ�. <br> ������ ������
							���ε��ϰų� ���� ������ ���ε����� �� �߻��ϴ� ������ ���� ��� å���� ���ο��� �ֽ��ϴ�.
						</p>
						<br>
						<div class="row">
							<div class="col-12 col-md-6">
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<small>�з� ����</small>
										<br>
										<a href="img/tutorFile_img/${tutor.educationFile}" onclick="window.open(this.href, '', 'width=400, height=430'); return false;" style="color: black">${tutor.educationFile}</a>
										<input type="file" name="education" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="education_or" value="${tutor.educationFile}"/>
									</div>
								</div>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<small>��� ����</small>
										<br>
										<a href="img/tutorFile_img/${tutor.experienceFile}" onclick="window.open(this.href, '', 'width=400, height=430'); return false;" style="color: black">${tutor.experienceFile}</a>
										<input type="file" name="work_experience" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="experience_or" value="${tutor.experienceFile}"/>
									</div>
								</div>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<small>�ڰ���</small>
										<br>
										<a href="img/tutorFile_img/${tutor.certificateFile}" onclick="window.open(this.href, '', 'width=400, height=430'); return false;" style="color: black">${tutor.certificateFile}</a>
										<input type="file" name="certificate" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="certificate_or" value="${tutor.certificateFile}"/>
									</div>
								</div>
							</div>
							<div class="col-12 col-md-6">
								<h6 style="margin-bottom: 16px;">���� ���</h6>
								<textarea name="tutorIntroduce" id="tutorIntroduce"
									class="form-control" cols="13" rows="16"
									 placeholder="���� �Ұ��� �Է����ּ���.">${tutor.tutorIntroduce}</textarea>
							</div>
							<br>
							<div class="col-12">
								<input type="submit" class="btn dorne-btn" value="���ε� �Ϸ�">
							</div>
						</div>
					</div>
				</form>

				<div class="listing-menu-area mt-100" id="club_member">
					<hr>
					<h3 style="color: white">���� ���� ����</h3>
					<br>					
					<c:forEach var="myClass" items="${myClassList}">
						<c:choose>
							<c:when test="${empty myClass.className}">
								<p style="text-align: center; color: white;">
									<b>--- ���� ���� ������ �����ϴ� ---</b>
								</p>
							</c:when>
							<c:otherwise>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<br>
										<h6 style="color: black">${myClass.className}</h6>
									</div>
									<div class="listing-menu-price">
										<button type="button" class="club_btn"
											onclick="location.href='momo.do?command=class_detail&classNo=${myClass.classNo}'">������ ����</button>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- ****** Footer Area End ****** -->

	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap-4 js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js/others/plugins.js"></script>
	<!-- Google Maps js -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDk9KNSL1jTv4MY9Pza6w8DJkpI_nHyCnk"></script>
	<script src="js/google-map/location-map-active.js"></script>
	<!-- Active JS -->
	<script src="js/active.js"></script>
	<script src="club_js/levelJS.js"></script>
	<script src="imgjs/imgChk_js"></script>
	<!-- ���� �������� �ҽ����� -->
	<script src="member/mypageJS.js?version=1.2"></script>
</body>

</html>