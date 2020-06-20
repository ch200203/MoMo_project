/**
 * club_detail 부분 javascript 소스 파일, 2020-01-05 수정, 인철환.
 */

$(document).ready(function() {
		$("input").attr("readonly", true); // 전체 input 태그에 readonly 추가
		$("select").attr("disabled", true); // 전체 input 태그에 readonly 추가
		
		
		$("#update_btn").on("click", function() {
			// 수정 버튼
			var input_stat = $("input").attr("readonly"); 
			var select_stat = $("select").attr("disabled"); // 수정할 태그(input / select) 현재상태 받아오기
			$("#search").attr("readonly", false);
			
			if($("#update_btn").hasClass("on") == true){
				
				
				var chk = $("#club_picture").val();
				
				if(chk == "" || chk == null){
					// 사진파일 null 확인
					var imgName = $("#club_img").attr("src").split("/").pop(); // url 사진 이름.jpg 리턴
					$("#nullpicture").attr("value", imgName); // hidden에 imgName을 담아서 db에 저장
					$("#nullpicture").attr("name", "club_picture");
				} 
				
				//var detail_frm = $("#detail_frm").serialize(); // 버튼을 클릭하면, form태그안의 값이 같이 넘어감 추후에 ajax로 재구성
				// var real = decodeURIComponent(detail_frm); // 직렬화한 것을 역직렬화해서 풀어줌
				// multipart/form 에서는 serialize() 가 작동하지 않는다. 따라서 FormData라는 API를 사용하여 보내주어야한다.
				var detail_frm = $("#detail_frm")[0];
				var real = new FormData(detail_frm);
				
				alert("real : " +  real + "\ndetail_frm : " + detail_frm);
				
		
				$.ajax({
					url : "momo.do?command=club_update",
					type : "post",	
					enctype: 'multipart/form-data',
					processData: false,  // Important!
			        contentType: false,
					data : real,
					success : function(result){
						alert("성공 : "  + real);
						location.reload();
					},
					error : function(request, status, error){
						alert(error);
					}
				});
				
				
				$("input").attr("readonly", true);
				$("select").attr("disabled", true);
				$("textarea").attr("readonly", true);
				
				$("#update_btn").removeClass("on");
				$("#btn1").removeClass("on");

			} else {
				$("input").attr("readonly", false);
				$("select").attr("disabled", false);
				$("textarea").attr("readonly", false);
				
				
				$("#btn1").addClass("on"); 
				$("#update_btn").addClass("on"); // 구분자 on 추가
				
				$("#update_btn").html("수정 완료");
				$("#btn1").html("취소");
			}
			// 버튼 바꾸기
			///////////////////////////////////////////////////
			// update_btn 클릭시, file이 null 일경우.
		});
		
		
		$("#btn1").on("click", function() {
			// 목록, 취소버튼 클릭
			if($("#btn1").hasClass("on") == true){
				/* alert("취소버튼임"); */
				location.reload();
			} else {
				/* alert("목록버튼임"); */
				location.href="momo.do?command=selectedClubList&selectedClubLocation=지역+구분&selectedClubCategory=C&selectedClubSort=정렬+구분";
			}
		});
		
		$("#joinbtn2").on("click", function() {
			// 비회원이 가입신청 버튼 클릭
			alert("해당 기능은 로그인 한 회원만 이용 가능합니다. \n 확인을 클릭하시면  로그인창으로 이동합니다.");
			location.href="momo.do?command=login";
		});
		
		$("#join_btn").on("click", function() {
			// 회원이 가입신청 버튼 클릭
			var clubTotal = $("#total").val();
			var nowTotal = $("#cnt").val();
			if(clubTotal != nowTotal){
				var result = confirm("정말 신청하시겠습니까?");
				if(result){
					alert("가입 신청 완료 되었습니다.");
					location.href="momo.do?command=clubMember_insert&clubNo="+ $("#clubNo").val();
				} else {
					alert("신청이 실패되었습니다.");
				}
			} else {
				alert("모집인원이 다 찼습니다!");
			}
		});
		
		$("#openYN").on("change", function() {
			var state = $("#openYN option:selected").val();
			if(state == "N"){
				alert("비활동중으로 선택하시면 앞으로 이 모임은 이용하실 수 없습니다. \n 신중하게 선택해 주세요");
			}
		});
		
		$("#join_btn_N").on("click", function() {
			alert("현재 가입을 받지 않고있습니다!");
		});
		
		$("#join_cancel").on("click", function() {
			// 가입신청회원이 가입신청했을때
			var result = confirm("가입 신청을 정말 취소 하시겠습니까?");
			var clubNo = $("#clubNo2").val();
			if(result){
				$.ajax({
					url: "momo.do?command=clubMember_cancel&clubNo=" + clubNo,
					type: "post",
					success: function(data) {
						if(data == 1){
							alert("가입신청이 취소되었습니다.");
							location.reload();
						} else{
							alert("취소 실패!");
						}
					},
					error : function(request, status, error){
						alert(error);	
					}
				});
			}
		});
	});

function getout(memberNo, clubVo){
	var result = confirm("정말 이 회원을 추방하시겠습니까?");
	var kickUser = memberNo;
	var clubNo = clubVo;
	
	if(result){
	alert("userNo : "  + kickUser);
	$.ajax({
		url: "momo.do?command=clubMember_kick&kickUserNo=" + kickUser + "&clubNo="+clubNo,
		type: "post",
		success: function(data) {
			if(data == 1){
				alert("추방 성공");
				location.reload();
			} else {
				alert("추방 실패 \n 잠시 후 다시시도 해주세요!");
				location.reload();
			}
		},
		error : function(request, status, error) {
			alert("추방 실패 \n stauts : " + stauts +  "\n error : " + error);
		} 
	});
	}
}


function getRej(memberNo, clubNo) {
	// 신청회원 거절버튼 클릭
	var userNo = memberNo;
	var result = confirm("거절하시겠습니까?");

	if(result){
		alert("memberNo : " + memberNo );
		$.ajax({
			url: "momo.do?command=clubMember_reject&rejectMember="+userNo+"&clubNo="+clubNo,
			type: "post",
			success: function(data) {
				if(data == 1){
					alert("거절 성공");
					location.reload();
				} else {
					alert("거절 실패 \n 잠시 후 다시시도 해주세요!");
				}
			},
			error : function(request, status, error) {
				// alert("거절 실패 \n stauts : " + stauts +  "\n error : " + error);
			}  
			
		});

	}
}

function getAppr(memberNo, clubNo) {
	var result = confirm("승인하시겠습니까?");
	
	if(result){
		alert("memberNo : " + memberNo);
		location.href="momo.do?command=clubMember_approve&insertMember=" + memberNo + "&clubNo=" + clubNo;
	} 
}




