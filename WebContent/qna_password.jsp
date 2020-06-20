<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A pass</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	var httpRequest = null;

 	$(document).ready(function() {
 		$("#cancel").on("click", function() {
 			opener.document.location.reload();

 			self.close();
 		});
 	});
 	
 	function onKeyDown()
 	{
 	     if(event.keyCode == 13)
 	     {
 	    	passCheck()
 	     }
 	}

	function passCheck() {
			
			var pass = document.getElementById("qna_pass").value;

			var url = "momo.do?command=qna_detail&noQna="+${noQna }+"&hitQna="+${hitQna }+"&pass="+pass;
			
			opener.location.href = url;
			window.close();
		}

</script>

<style type="text/css">
.btn {
	background: #7643EA;
	color: #fff;
	border: 0;
	outline: 0;
	padding: 3px 3px;
	font-size: 12px;
	margin: 2px 2px;
	border-radius: 6px;
	width:50px;
	height:30px;
}

.btn:hover {
	background-color: darken(#C39DDC, 10%);
}
</style>
</head>

<body style="background-color:lavender; text-align:center;">
	<div id="wrap">
		<br>
		<h4 color="#7643EA">비밀번호를 입력해주세요.</h4>
		<hr size="1" width="270" color="#7643EA">
		<div id="pass">
			<form id="passChk_frm" action="momo.do?command=checkQnaPass" method="post">
				<input type="password" name="pass" id="qna_pass" onKeyDown="onKeyDown();" style="border:none; border-radius:6px; width:150px; height:30px;">
				<input type="hidden" name="noQna" id="noQna" value="${noQna }"/>
				<input type="hidden" name="hitQna" id="hitQna" value="${hitQna }"/>
				<input class="btn" id="pass" type="button" value="확인 " onclick="passCheck();">
				<input class="btn" id="cancel" type="button" value="취소">
			</form>					
			<br>
		</div>	
			
		
	</div>
</body>
</html>