<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<script type="text/x-javascript">
	
var httpRequest = null;

function pValue() {
	document.getElementsByName("className")[0].value = window.opener.document.reviewClass.className.value; 
 }

function findClassName() {
	var name = document.getElementsByName("className")[0].value;

	var obj = new Object();
	obj.className = name;

	var jsonData = JSON.stringify(obj);
	var param="jsonParameter="+jsonData;

	httpRequest = new window.XMLHttpRequest();
	if (httpRequest == null) {
		alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
	return false;
	}

	httpRequest.onreadystatechange = callback;
	httpRequest.open("POST", "momo.do?command=findClassName", true);
	httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	httpRequest.send(param);
}

function callback() {
	if (httpRequest.readyState === XMLHttpRequest.DONE) {
		if (httpRequest.status === 200) {
    		var resultText = httpRequest.responseText;
    		if (resultText) {
    			var jsonObj = JSON.parse(resultText);
    			var trTags = '';
    			var classList = jsonObj.classList;

                //td 생성
                classList.forEach(function(val){
                	trTags += '<tr><td>' + val.className + '</td>';
                	trTags += '<td><input type="button" class="btn"';
                	trTags += ' onclick="sendCheckValue(\'' + val.className + '\')" value="선택"></td>';
                	trTags += '</tr>';
                });

                document.getElementsByClassName("grid-body")[0].innerHTML = trTags;
                document.getElementById('resultForm').style.display = 'block';
    		} else {
				alert("해당하는 수업이 없습니다.");    
    		}
		} else {
        	alert('수업명 찾기에 문제가 있어요.');
		}
	}
}

function sendCheckValue(className){
	// 회원가입 화면의 ID입력란에 값을 전달
	opener.document.reviewClass.className.value = className;

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

.className {
	border: 0;
	outline: 0;
	padding: 3px 3px;
	font-size: 12px;
	margin: 2px 2px;
}
</style>
</head>

<body style="background: lavender" onload="pValue()">
	<div id="wrap">

		<br>
		<center>
			<b><font size="4" color="#7643ea">수업명 찾기</font></b> <br>

			<hr size="1" width="270" color="#7643ea">

			<div id="chk">
				<div id="checkForm">

					<input type="text" name="className" id="className"
						style="border: none; border-radius: 6px"> <input
						type="button" value="찾기" class="btn" onclick="findClassName()">
						
					<div class="container" style="margin: auto; display: none;"
						id="resultForm">
						<div class="row">
							<span></span>
							<h4>검색결과</h4>
						</div>
						<div class="row">
							<div class="col-12">

								<hr size="1" width="270" color="#7643ea">

								<table style="word-break:break-all;">
									<tbody class="grid-body"></tbody>
								</table>

								<!-- 검색된 모임 리스트  -->
								<%-- <c:forEach var="clubData" items="${clubList}"> --%>
								<%-- <c:choose> --%>
								<%-- <c:when test="${empty clubData }"> --%>
								<!-- <div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div> -->
								<%-- </c:when> --%>
								<%-- <c:otherwise> --%>
								<!-- <div class="feature-title"> -->
								<%-- <input class="clubName" name="clubNameResult" type="button" value="${clubData.clubName }" onclick="sendCheckValue()"> --%>
								<!-- </div> -->
								<%-- </c:otherwise> --%>
								<%-- </c:choose> --%>
								<%-- </c:forEach> --%>
							</div>
						</div>
						<br>
					</div>

				</div>

				<input class="btn" id="cancelBtn" type="button" value="취소"
					onclick="window.close()">
			</div>
	</div>
	</center>
</body>
</html>