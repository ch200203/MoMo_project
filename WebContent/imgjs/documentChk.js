function docFileChk(file) {
	var fileFormat = file.split(".").pop().toLowerCase();
	var maxSize = 3*(1024*1024); // 확장자 크기
	var fileSize = document.getElementById("file_chk").files[0].size;

	if((fileFormat == "jpg" || fileFormat == "png" || fileFormat == "txt" || fileFormat == "docx" || fileFormat == "pdf")){
		if(fileSize > maxSize){
			alert("첨부파일은 3mb 아래여야 합니다.");
			$("#file_chk").val("");
			return;
		}
	} else {
		alert("jpg, png, txt, docx, pdf 파일만 업로드 가능합니다....");
		$("#file_chk").val("");
		return;
	}
}