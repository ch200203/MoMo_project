/**
 * 
 */

//회원가입 화면의 입력값들을 검사한다.
function checkValue() {
	var form = document.mypage;

	if (!form.memberPwd.value) {
		alert("비밀번호를 입력하세요.");
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

	if (!form.memberAddress.value) {
		alert("주소를 입력하세요.");
		return false;
	}
	
	if(!form.categoryName.value){
		alert("카테고리를 선택하세요.");
		return false
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

var httpRequest = null;

function tutorRegister() {
	var id = $("#userNo").val();
	var param="memberId="+id;
	
	httpRequest = new window.XMLHttpRequest();
	
	if (httpRequest == null) {
		alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
	    return false;
	} else {
		httpRequest.onreadystatechange = callback;
		httpRequest.open("POST", "momo.do?command=registerTutor", true);
		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		httpRequest.send(param);
		
	}
	
}

function callback() {
	if (httpRequest.readyState === XMLHttpRequest.DONE) {
		if (httpRequest.status === 200) {
	    	var resultText = httpRequest.responseText;
	    	if (resultText == 0) {
	    		alert("강사 등록에 실패했습니다.");
	    		return false;
	    	} else if (resultText == 1) {
	    		alert("강사 등록 성공");
	    		$("#tutorRegister").hide();
	    		$("#registerForm").show();
		    	return true; 		
	    	} else {
				alert("강사 등록에 문제가 있습니다.");		    		
	    	}
		} else {
	        alert('강사 등록에 문제가 있어요.');
		}
	}
}

function tutorFileUpload() {
	$("#tutorRegister2").hide();
	$("#registerForm").show();
}



$(document).ready(function() {
	$("#checkVal").on("click", function() {
		checkValue();
	});	
	
	
	$("#memberPwdCheck").on("blur", function() {

		var memberPwd = $("#memberPwd").val();
		var memberPwdCheck = $("#memberPwdCheck").val();
		var nowPwd = $("#nowPwd").val();
		
		if(memberPwd != nowPwd){
			if(memberPwd != memberPwdCheck){
				alert("비밀번호가 일치하지 않습니다.");
				$("#memberPwd").val("");
				$("#memberPwdCheck").val("");
			}
		} else{
			alert("기존의 비밀번호와 일치합니다");
			$("#memberPwd").val("");
			$("#memberPwdCheck").val("");
		}

	});
		
});


