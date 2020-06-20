/**
 *  레벨처리
 */

$(document).ready(function() {
	var level = $("#level2").val();
	
	if(level >= 0 && level <= 20){
		$("#level").css("color", "#7643ea");
	} else if(level <= 50){
		$("#level").css("color", "#D8F781");
	} else if(level <= 100){
		$("#level").css("color", "#A9F5F2");
	} else if(level <= 200) {
		$("#level").css("color", "#2E9AFE");
	} else {
		$("#level").css("color", "#F4FA58");
	}
});

