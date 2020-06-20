<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">
<script type="text/javascript">
	var httpRequest = null;

	function pValue() {
		document.getElementsByName("memberId")[0].value = window.opener.document.memberInfo.memberId.value; 
 	}
	
	function idCheck() {
		var id = document.getElementsByName("memberId")[0].value;
		
		if (!id) {
			alert("아이디를 입력하지 않았습니다.");
			return false;
		
		} else if ((id < "0" || id > "9") && (id < "a" || id > "z") && (id > "A" && id < "Z")) {
			alert("대문자, 한글, 특수문자는 아이디로 사용할 수 없습니다.");
			return false;
			
		} else if (!idForm(id)) {
			return false;
			
		} else if (id.length < 6){
			alert("아이디를 6자 이상 입력하세요.");
			return false;
			
		} else {
			var param="memberId="+id;
			
			httpRequest = new window.XMLHttpRequest();
			if (httpRequest == null) {
				alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
			    return false;
			}
			
			httpRequest.onreadystatechange = callback;
			httpRequest.open("POST", "momo.do?command=idCheck", true);
			httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			httpRequest.send(param);
		}
	}
	
	function idForm(id) {
		var checkNumber = id.search(/[0-9]/g);
		var checkEnglish = id.search(/[a-z]/ig);

		if(checkNumber < 0 || checkEnglish < 0){
			alert("아이디는 숫자와 영문자를 혼용해야 합니다.");
			return false;
		}
		
		return true;
	}
	
	function callback() {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
		    	var resultText = httpRequest.responseText;
		    	if (resultText == 0) {
		    		document.getElementById("cancelBtn").style.visibility='visible';
					document.getElementById("useBtn").style.visibility='hidden';
					document.getElementById("msg").innerHTML ="사용할 수 없는 아이디입니다.";
		    	} else if (resultText == 1) {
			    	document.getElementById("cancelBtn").style.visibility='hidden';
					document.getElementById("useBtn").style.visibility='visible';
					document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";	    		
		    	} else {
					alert("아이디를 입력하지 않았습니다.");		    		
		    	}
			} else {
		        alert('아이디 중복검증에 문제가 있어요.');
			}
		}
	}
	
	// 사용하기 클릭 시 부모창으로 값 전달 
	function sendCheckValue(){
		// 중복체크 결과인 idCheck 값을 전달한다.
		opener.document.memberInfo.idDuplication.value ="idCheck";
		
		// 회원가입 화면의 ID입력란에 값을 전달
		opener.document.memberInfo.memberId.value = document.getElementsByName("memberId")[0].value;
		
		if (opener != null) {
        	opener.chkForm = null;
        	self.close();
		}	
	}	
</script>

<style type="text/css">
.btn {
	background: #7643ea;
	color: #fff;
	border: 0;
	outline: 0;
	padding: 3px 3px;
	font-size: 12px;
	margin: 2px 2px;
	border-radius: 6px;
}

.btn:hover {
	background-color: darken(#7643ea, 10%);
}
</style>
</head>

<body onload="pValue()" style="background:lavender">
	<div id="wrap">
		<br>
		<center><b><font size="4" color="#7643ea">아이디 중복체크</font></b>
		<br>
		<hr size="1" width="270" color="#7643ea">
		<div id="chk">
			<form id="checkForm">
				<input type="text" name="memberId" id="memberId" style="border:none; border-radius:6px">
				<input type="button" value="중복확인" onclick="idCheck()" class="btn">
			</form>
			<div id="msg"></div>
			<br>
			<input class="btn" id="cancelBtn" type="button" value="취소" onclick="window.close()"><br>
			<input class="btn" id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
		</div>
		</center>
	</div>
</body>
</html>