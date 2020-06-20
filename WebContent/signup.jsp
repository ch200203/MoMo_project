<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 shrink-to-fit=no">
<title>Sine Up</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="reg/fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="reg/vendor/nouislider/nouislider.min.css">

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Main css -->
<link rel="stylesheet" href="reg/css/style.css">

<style type="text/css">
#submit_btn {
	background: #7643EA;
	color: #fff;
	margin-right: 25px;
}

#submit_btn:hover {
	background-color: darken(#7643EA, 10%);
}

#reset_btn {
	background: #fff;
	color: #999;
	border: 2px solid #ebebeb;
}

#reset_btn:hover {
	border: 2px solid #7643EA;
	background: #7643EA;
	color: #fff;
}

.id_btn {
	background: #7643EA;
	color: #fff;
	border: 0;
	outline: 0;
	padding: 3px 3px;
	font-size: 12px;
	margin: 2px 2px;
	border-radius: 6px;
}

.id_btn:hover {
	background-color: darken(#7643EA, 10%);
}

.signup-img {
	position: relative;
	top: 250px;
	left: 20px;
}
</style>
<script type="text/javascript">
	function openIdCheck() {
		
		window.name = "parentForm";
		window.open("idCheckForm.jsp", "chkForm",
				"width=500, height=200, resizable=no, scrollbars=no, top = 200, left = 500, location = no");
	}

	// 회원가입 화면의 입력값들을 검사한다.
	function checkValue() {
		var form = document.memberInfo;

		if (!form.memberId.value) {
			alert("아이디를 입력하세요.");
			return false;
		}

		if (form.idDuplication.value != "idCheck") {
			alert("아이디 중복체크를 해주세요.");
			return false;
		}

		if (!form.memberPwd.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if (!checkPassword(form.memberId.value, form.memberPwd.value)) {
			return false;
		}
		
		if(!form.form.memberPwdCheck.value){
			alert("비밀번호 확인을 해주세요.");
		}

		// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
		if (form.memberPwd.value != form.memberPwdCheck.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}

		if (!form.memberName.value) {
			alert("이름을 입력하세요.");
			return false;
		}

		if (!form.birthday.value) {
			alert("생년월일을 입력하세요.");
			return false;
		}

		if (isNaN(form.birthday.value)) {
			alert("생년월일은 숫자만 입력가능합니다.");
			return false;
		}

		if (!form.email.value) {
			alert("메일 주소를 입력하세요.");
			return false;
		}

		if (!form.phone.value) {
			alert("전화번호를 입력하세요.");
			return false;
		}

		if (isNaN(form.phone.value)) {
			alert("전화번호는 - 제외한 숫자만 입력해주세요.");
			return false;
		}

		if (!form.address.value) {
			alert("주소를 입력하세요.");
			return false;
		}
		
		
	}
	
	function checkPassword(id,password){

		if(! /^.*(?=^.{6,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(password)){
			alert("영문, 숫자, 특수문자 조합으로 6~12자리를 사용해야 합니다.");
			return false;
		}

		var checkNumber = password.search(/[0-9]/g);
		var checkEnglish = password.search(/[a-z]/ig);
		var checkCharacter = password.search(/[~!@#$%^&*()_+|<>?:{}]/gi);

		if(checkNumber < 0 || checkEnglish < 0 || chaeckCharacter < 0){
			alert("비밀번호는 숫자, 영문자, 특수문자를 모두 포함해야 합니다.");
			return false;
		}

		if(/(\w)\1\1\1/.test(password)){
			alert("같은 문자를 4번 이상 사용할 수 없습니다.");
			return false;
		}

		if(password.search(id) > -1){
			alert("비밀번호에 아이디가 포함되었습니다.");
			return false;
		}

		return true;
	}

	// 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
	// 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
	// 다시 중복체크를 하도록 한다.
	function inputIdChk() {
		document.memberInfo.idDuplication.value = "idUncheck";
	}
	
	$(document).ready(function() {
		$("#reset_btn").on("click", function() {
			location.href="momo.do?command=main";
		});
	});
</script>
</head>
<body style="padding-top: 0px; padding-bottom: 0px;">
	<!-- header -->
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="main">
		<div class="container" style="margin-left: 150px; margin-right: 0px;">
			<div class="signup-content" style="width: 1400px;">
				<div class="signup-img">
					<img src="img/header-img/logo.png">
					<div class="signup-img-content"></div>
				</div>
				<div class="signup-form">
					<form action="momo.do?command=signup-form" method="POST"
						name="memberInfo" class="join-form" id="join-form"
						onsubmit="return checkValue()" enctype="multipart/form-data">
						<div class="form-row">
							<div class="form-group">
								<div>
									<br> <br> <br> <br>
								</div>
								<div class="form-input">
									<label for="memberId" class="required">아이디</label>
									<input type="text" name="memberId" id="memberId" maxlength="12" onkeydown="inputIdChk()" />
									<small>&nbsp;&nbsp;&nbsp; *영문 소문자와 숫자를 모두 포함하여 6~12자</small>
									<button type="button" class="id_btn" onclick="openIdCheck()">아이디 중복 확인</button>
									<input type="hidden" name="idDuplication" value="idUncheck">
								</div>
								<div class="form-input">
									<label for="memberPwd" class="required" id="memberPwd">비밀번호</label>
									<input type="password" name="memberPwd" id="memberPwd" maxlength="16"/> <small>&nbsp;&nbsp;&nbsp;
										*영문/숫자/특수문자를 모두 포함하여 6~12자</small>
								</div>
								<div class="form-input">
									<label for="memberPwdCheck" class="required"
										id="memberPwdCheck">비밀번호 확인</label> <input type="password"
										name="memberPwdCheck" id="memberPwdCheck" />
								</div>

								<div class="form-input">
									<label for="memberName" class="required">이 름</label> <input
										type="text" name="memberName" id="memberName" />
								</div>
								<div class="form-input">
									<label for="birthday" class="required">생년월일</label> <input
										type="text" name="birthday" id="birthday"
										placeholder="19900000" /> <small>&nbsp;&nbsp;&nbsp;
										*8자리로 입력</small>
								</div>
							</div>

							<!-- class="required 필수 항목 표시-->
							<!-- 열 바뀌는 곳 -->

							<div class="form-group">
								<div class="form-select">
									<div>
										<br> <br> <br> <br>
									</div>
									<div class="label-flex">
										<label for="gender" class="required">성 별</label>
									</div>
									<div class="tab-pane fade show active" id="nav-places"
										role="tabpanel" aria-labelledby="nav-places-tab">
											<!-- 정보를 action에 담아서 보내기 -->
											<select class="custom-select" name="gender" id="gender">
												<option selected>성별</option>
												<option value="남">남</option>
												<option value="여">여</option>
											</select>
									</div>
								</div>
								<div class="form-input">
									<label for="email" class="required">Email</label> <input
										type="email" name="email" id="email" />
								</div>
								<div class="form-input">
									<label for="phone" class="required">전화번호</label> <input
										type="text" name="phone" id="phone" />
									<small>&nbsp;&nbsp;&nbsp; *띄어쓰기와 '-'는 생략</small>
								</div>
								<div class="form-input">
									<label for="address" class="required">주 소</label>
									<div class="address">
										<input type="text" name="memberAddress" id="memberAddress">
										<small>&nbsp;&nbsp;&nbsp; *OO도 OO시 OO구 형식으로 입력, 구 이하 주소 생략</small>
									</div>
								</div>
								<div class="form-input">
									<label for="file_input">회원 사진업로드</label>
									<input type="file" name="memberPicture" id="file_chk" class="form-control-file" onchange="fileChk(this.value);"/>
									<span class="focus-input100"></span>
								</div>
							</div>
						</div>
						<div class="form-submit">
							<input type="submit" value="완료" class="submit" id="submit_btn" name="submit" />
							<input type="reset" value="취소" class="submit" id="reset_btn" onclick="location.href='momo.do?command=main'" name="reset" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp" />
	<!-- ****** Footer Area End ****** -->

	<!-- JS -->
	<script src="reg/vendor/jquery/jquery.min.js"></script>
	<script src="reg/vendor/nouislider/nouislider.min.js"></script>
	<script src="reg/vendor/wnumb/wNumb.js"></script>
	<script src="reg/vendor/jquery-validation/dist/jquery.validate.min.js"></script>
	<script
		src="reg/vendor/jquery-validation/dist/additional-methods.min.js"></script>
	<script src="js/active.js"></script>
	<script src="reg/js/main.js"></script>
	<script src="imgjs/imgChk_js"></script>
</body>
</html>
