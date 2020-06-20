<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<title>수업명 중복체크</title>
<script type="text/javascript">
	var httpRequest = null;

	function pValue() {
		document.getElementsByName("className")[0].value = window.opener.document.classInfo.className.value; 
 	}
	
	function nmCheck() {
		var nm = document.getElementsByName("className")[0].value;
		
		if (!nm) {
			alert("수업명을 입력하지 않았습니다.");
			return false;
		
		} else {
			var param="className="+nm;
			
			httpRequest = new window.XMLHttpRequest();
			if (httpRequest == null) {
				alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
			    return false;
			}
			
			httpRequest.onreadystatechange = callback;
			httpRequest.open("POST", "momo.do?command=clssNmChk", true);
			httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			httpRequest.send(param);
		}
	}
	
	
	function callback() {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
		    	var resultText = httpRequest.responseText;
		    	if (resultText == 0) {
		    		document.getElementById("cancelBtn").style.visibility='visible';
					document.getElementById("useBtn").style.visibility='hidden';
					document.getElementById("msg").innerHTML ="사용할 수 없는 수업명입니다.";
		    	} else if (resultText == 1) {
			    	document.getElementById("cancelBtn").style.visibility='visible';
					document.getElementById("useBtn").style.visibility='visible';
					document.getElementById("msg").innerHTML = "사용 가능한 수업명입니다.";	    		
		    	} else {
					alert("수업명을 입력하지 않았습니다.");		    		
		    	}
			} else {
		        alert('수업명 중복검증에 문제가 있어요.');
			}
		}
	}
	
	// 사용하기 클릭 시 부모창으로 값 전달 
	function sendCheckValue(){
		// 중복체크 결과인 idCheck 값을 전달한다.
		opener.document.classInfo.nmDuplication.value ="nmCheck";
		
		// 회원가입 화면의 ID입력란에 값을 전달
		opener.document.classInfo.className.value = document.getElementsByName("className")[0].value;
		
		if (opener != null) {
        	opener.chkForm = null;
        	self.close();
		}	
	}	
	
	function clickCancel()	{
		opener.document.classInfo.nmDuplication.value = "NmUncheck";
		window.close();
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
		<center><b><font size="4" color="#7643ea">수업명 중복체크</font></b>
		<br>
		<hr size="1" width="270" color="#7643ea">
		<div id="chk">
			<form id="checkForm">
				<input type="text" name="className" id="className" style="border:none; border-radius:6px">
				<input type="button" value="중복확인" onclick="nmCheck()" class="btn">
			</form>
			<div id="msg"></div>
			<br>
			<input class="btn" id="useBtn" type="button" value="사용하기" style="visibility:hidden" onclick="sendCheckValue()">
			<input class="btn" id="cancelBtn" type="button" value="취소" onclick="clickCancel()">
		</div>
		</center>
	</div>
</body>
</html>