

$(document).ready(function() {
	$("#clubName").on("blur",function() {

		var clubName = $("#clubName").val();
		
		if(clubName == "" || clubName == null){
			alert("모임명을 입력해 주세요!");
		} else {
			$.ajax({
				url : "momo.do?command=clubNameChk&clubName="+clubName,
				type : "get",
				success: function(data) {
				//	alert("1 = 중복 / 0 = 중복아님 :  " + data);
				
					if(data == 1){
						$("#clubNameChk").text("사용중인 모임명 입니다.");
						$("#clubNameChk").css("color", "red");
					} else {
						$("#clubNameChk").text("사용가능한 모임명 입니다.");
						$("#clubNameChk").css("color", "green");
					}
				},
				error: function(request, status, error) {
					alert("오류 : " + error);
				}
			});
			
		}
	});
	
	$("#btn_frm").on("click", function() {
		if(clubName == "" || clubName == null){
			alert("모임명이 입력되지 않았습니다");
			return false;
		}
	});
});

