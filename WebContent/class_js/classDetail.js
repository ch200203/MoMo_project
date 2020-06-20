/**
 * 
 */
//수업신청하기 클릭시
function classReq() {
	var userId = $("#userIdVal").val();
	var clubMngYN = $("#clubMngYNVal").val();
	alert('userId : '+userId+' / clubMngYN : '+clubMngYN)
	
	if(userId!=("null")) {					//회원일때
		//alert("로그인 상태");
		if(clubMngYN=="Y") {			//모임장일 때
		    var Del = confirm("수업 신청하시겠습니까?")
		    if (Del == true){
		        location.href='momo.do?command=class_req&classNo='+ $("#clubNo2").val();
		    } else {
		        alert("취소 되었습니다.")
		    }
		} else {						//모임장이 아닐 때
			alert("수업신청은 모임장인 회원만 가능합니다.\n가입한 모임의 모임장에게 문의바랍니다.")
		}
	} else {							//비회원일 때
		//alert("비로그인 상태");
		var Del = confirm("해당 기능은 로그인 한 회원만 이용 가능합니다.\n로그인창으로 이동하시겠습니까?")
	    if (Del == true){
	        location.href='momo.do?command=login'
	    } else {
	        alert("취소 되었습니다.")
	    }
	}
} 

//수업삭제하기 클릭시
function class_delete() {
    var Del = confirm("수업을 삭제하면 되돌릴 수 없습니다. 그래도 삭제 하시겠습니까?")
        if (Del == true)
        {
            location.href='momo.do?command=class_delete&classNo='+$("#clubNo2").val();
        } else {
            alert("취소 되었습니다.")
                }
} 

//라디오버튼 default값을 가져온 classAge값으로 설정
function class_detail_mod(){		
	$("#club_detail").hide();
	$("#club_detail_mod").show();
	
	var age = "<%=classVo.getClassAge() %>";
	console.log('age : '+age);
	
	if(age==("20"))	{
		$('#20').attr('checked', true);
	} else if(age==("30"))	{
		$('#30').attr('checked', true);
	} else if(age==("40"))	{
		$('#40').attr('checked', true);
	} else if(age==("50"))	{
		$('#50').attr('checked', true);
	} else if(age==("60"))	{
		$('#60').attr('checked', true);
	}
	
}

function classCancel()	{
	var Del = confirm("수업 신청 내역을 삭제 하시겠습니까?")
    if (Del == true)
    {
        location.href='momo.do?command=classrq_delete&classNo=<%=classNo%>';
    } else {
        alert("취소 되었습니다.")
            }
}

