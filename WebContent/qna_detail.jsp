<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="momo.vo.QnaVo"  %>
<!DOCTYPE html>
<!-- 상세보기 페이지 -->
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Title -->
    <title>Q&A 상세보기</title>

	<!-- Favicon -->
	<link rel="icon" href="img/favicon-img/logo-favicon.png">
	
    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">
    <!-- Responsive CSS -->
    <link href="css/responsive/responsive.css" rel="stylesheet">

<!--textarea 작성부분 크게-->
<style type="text/css">
.contact-form textarea.form-control11 {
    height: 300px;
    font-size: 12px;
    color: #72728c;
    font-weight: 600;
    border: none;
    border-radius: 0;
    margin-bottom: 30px;
    overflow: auto;
    resize: vertical;
    display: block;
    width: 100%;
    padding: .375rem .75rem;
    background-color: #fff;
    background-image: none;
    background-clip: padding-box;
}
.row1 {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    margin-right: 50px;
    margin-left: 50px;
}
.container1 {
    width: 100%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
    max-width: 960px;
}    
.contact-form textarea.form-control12 {
    font-size: 12px;
    color: #72728c;
    font-weight: 600;
    border: none;
    border-radius: 0;
    overflow: auto;
    resize: vertical;
    display: block;
    width: 95%;
    background-color: #fff;
    background-image: none;
    background-clip: padding-box;
    text-align: center;
}
.btn1 {
	width: 80px;
	height: 90px;
    background-color: #7643ea;
    color: #fff;
    display: inline-block;
    font-weight: 400;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    border: 1px solid transparent;
    font-size: 1rem;
    line-height: 1.5;
    transition: background-color .15s;
    border-radius: 0;
    padding: 0 15px;
    font-weight: 600;
    font-size: 15px;
    -webkit-transition-duration: 500ms;
    transition-duration: 500ms;
}
.qnaTitle{
	height: 50px;
	border:none;
	width:670px;
	background-color:white;
	
}
.btn2{
	width: 100px;
	height:50px;
    background-color: #7643ea;
    color: #fff;
    display: inline-block;
    font-weight: 400;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    border: 1px solid transparent;
    font-size: 1rem;
    line-height: 1.5;
    transition: background-color .15s;
    border-radius: 0;
    padding: 0 15px;
    font-weight: 600;
    font-size: 15px;
    -webkit-transition-duration: 500ms;
    transition-duration: 500ms;
    margin-right:20px;
    margin-top:20px;
}
</style>
<% String userId = (String)session.getAttribute("userId"); %>
<% QnaVo qnaVo = (QnaVo)request.getAttribute("qnaVo");%>
<% int hit1 = qnaVo.getHitQna(); %>
<% int hitOr = hit1 -1; %>
<script type="text/javascript">
//라디오버튼 default값을 가져온 classAge값으로 설정
function qna_mod_click(){		
	$("#qna_detail").hide();
	$("#qna_mod").show();
	
	var showYN = '<%=qnaVo.getShowYNQna()%>';
	
	if(showYN==("Y"))	{
		$('#open').attr('checked', true);
	} else if(showYN==("N"))	{
		$('#private').attr('checked', true);
	}
	
}

function qna_isopen(value)	{
	 if(value == "private")
	   {
	      document.all["qnaPass"].style.display = 'block';         // 보이게
	   }
	   else
	   {
	      document.all["qnaPass"].style.display = 'none';  // 안보이게
	   }

}

function replyUpdate()	{
	$("#reply_detail").hide();
	$("#reply_mod").show();
}

function updateCancel()	{
	$("#reply_detail").show();
	$("#reply_mod").hide();
}
</script>
</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include> 
	
    <!-- ***** Single Listing Area Start ***** -->
    <section class="dorne-single-listing-area section-padding-100">
        <div class="container1">
		<br>
    	<small>&emsp;&emsp;&emsp;&emsp; 고객센터 > Q&A > 상세보기</small>	<!-- 카테고리 -->
   		<br>
        <br>  
<!------------------------------------------------- 원글 상세 -------------------------------------------------->
          <div id="qnaDetail">
          <div class="row1 justify-content-center">
          <div class="contact-form" style="padding-top: 25px; padding-bottom: 50px;">
          <div id="qna_detail">
        		<div class="row1" style="margin-top:40px; margin-bottom:20px;">
        			<input type="text" class="qnaTitle" name="qnaTitle" disabled value="&emsp;${qnaVo.titleQna }"/> <!-- ${vo.titleQna } -->
           		</div> 
           		<small><span style="color: gray;">&emsp;&emsp;&emsp;&emsp;&nbsp; 글번호 : &emsp;</span></small>
				<small>${qnaVo.noQna}</small>
				<small><span style="color: gray;">&emsp;&emsp;&emsp;&nbsp; 작성자 : &emsp;</span></small>
				<small>${qnaVo.writerQna }</small>
				<small><span style="color: gray;">&emsp;&emsp;&emsp;&nbsp; 작성일 : &emsp;</span></small>
				<small>${qnaVo.dateQna }</small>
				<small><span style="color: gray;">&emsp;&emsp;&emsp;&nbsp; 조회수 : &emsp;</span></small>
				<small>${qnaVo.hitQna }</small>
	       		 <hr>  
               <div class="row1">
                    <textarea name="message" class="form-control11" id="Message"
                             cols="170" rows="20" disabled>${qnaVo.contentQna }</textarea>
               </div>
                       
               <!-- 관리자계정이 아니면서 / 글쓴이계정일 때 목록, 수정, 삭제 버튼 -->
               <!-- 관리자계정이 아니면서 / 비회원 외 다른 계정일 때 목록 버튼 -->  
               <div class="row1">
                   	<c:choose>
                 		<c:when test="${userId eq qnaVo.writerQna}"> <%-- 글쓴이 계정일 경우 --%>
                        	<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="list" value="목록" onclick="location.href='momo.do?command=qna_list'">&emsp;
							<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="mod" value="수정" onclick="qna_mod_click()"> &emsp; <!-- style="display:none" -->
 							<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="del" value="삭제" onclick="location.href='momo.do?command=qnaDelete&noQna=${qnaVo.noQna}&hitQna=${qnaVo.hitQna }'">
                    	</c:when>
                  	 	<c:otherwise>				<%-- 비회원 포함 나머지 계정 전부 --%>
                        	<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="list" value="목록" onclick="location.href='momo.do?command=qna_list'">&emsp;
                  	 	</c:otherwise>
               		</c:choose>
             	</div>
            	</div>	
<!------------------------------------------------- 원글 상세 끝 -------------------------------------------------->  
				
<!------------------------------------------------- 원글 수정 --------------------------------------------------> 
				<div id="qna_mod" style="display:none;">
				<form action="momo.do?command=update_qna&qnaNo=${qnaVo.noQna }&hitQna=<%=hitOr %>" method="post">
        		<div class="row1" style="margin-top:40px; margin-bottom:20px;">
        			<h6 style="text-align:center; padding-top:15px;">제&emsp;목 &emsp;</h6>
        			<span><input type="text" class="title_writer" name="qnaTitle" style="width:500px; height: 50px; border:none;" 
        						required="required" value="${qnaVo.titleQna }"/></span>
           		</div> 
           		<div class="row1" style="margin-top:40px; margin-bottom:20px;">
           			<h6 style="text-align:center; padding-top:15px;">작성자 &emsp;</h6>
        			<span><input type="text" class="title_writer" style="width:200px; background:white; height: 50px; border:none;" 
        						disabled value="&emsp;<%=userId %>" /></span>
           		</div> 
	        <hr>  
                <div class="row1">
                    <textarea name="qnaContent" class="form-control11" id="qnaContent"
                      required="required" cols="170" rows="20">${qnaVo.contentQna }</textarea>
                </div>
                       
                <div class="row1" style="margin-bottom:10px;">
                    <span class="label-input101">공개 설정:&emsp;</span> 
					<input type="radio" name="isopen" id="open" value="Y" required="required" checked onclick="qna_isopen('open');"/><label for="공개">공개 &nbsp;</label>
					<input type="radio" name="isopen" id="private" value="N" required="required" onclick="qna_isopen('private');"/><label for="비공개">비공개 &nbsp;</label>
					<span class="focus-input100"></span>
                </div>       
                <div class="row1" id="qnaPass" style="display:none; margin-bottom:20px;">
                	<small>비밀번호 입력 :&emsp;</small>
                	<span><input type="password" name="pwd_qna" value="${qnaVo.pwdQna }" style="width:200px; border:none;" ></span>
                </div>       
                <div id="row1">
                    <input type="submit" class="btn dorne-btn" style="min-width: 130px;" id="write" value="완료">&emsp;												
					<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="cancel" value="취소" onclick="location.href='momo.do?command=qna_detail&noQna=${qnaVo.noQna}&hitQna=<%=hitOr%>'"> &emsp; <!-- style="display:none" -->
 				</div>
            </form> 

              
           </div>	

<!------------------------------------------------- 원글 수정 끝 --------------------------------------------------> 
                     
                <hr>
<!------------------------------------------------- 답변부분 --------------------------------------------------->                       
                 <!-- 관리자계정이면서 / 원글에 대한 답글이 존재하지 않을 때 작성버튼 -->      
                 <!-- 관리자계정이면서 / 원글에 대한 답글이 존재할 때 disabled, 수정버튼 / 수정페이지에서는 완료, 취소버튼-->   
                <div> 
                	<c:choose>
                		<%-- 관리자계정일 때 --%>
                 		<c:when test="${userId eq 'admin01'||userId eq 'admin02'||userId eq 'admin03'||userId eq 'admin04'||userId eq 'admin05' }"> 
							<c:choose>
								<%-- & 원글에 대한 답글이 존재하지 않을 경우, 작성버튼 --%>
								<c:when test="${reNo==0 }">
									<div class="row1" style="margin-top:50px;">
                      					<h6>답변</h6>
                    				</div>   
                    				<div class="row1">
                     					<hr style="width:670px; align:center; color:lightgray">
                    				</div>	
                       				<form action="momo.do?command=qna_reply_write&hitOr=<%=hitOr %>" method="post">
                    					<div class="row1">
                    						<input type="hidden" name="no_qna" value="${qnaVo.noQna }"/>
                       						<span><textarea name="re_content_qna" class="form-control12" id="reply"
                               					cols="90" rows="5" placeholder="답변을 작성해주세요." style="text-align:left;"></textarea></span>
                       						<span><input type="submit" class="btn1" id="reply" value="작성"></span>        
                    					</div>
                    				</form>
								</c:when>
								
								<c:otherwise>
									<%-- & 원글에 대한 답글이 존재할 경우, 내용 disabled, 수정버튼 --%>
									<div class="row1" style="margin-top:50px;">
                      					<h6>답변</h6>
                    				</div>   
                    				
                    				<div id="reply_detail">
                    				<div class="row1" id="re_detail">
                       					<small style="color: gray;">작성자 :&emsp;</small><small>${replyVo.reWriterQna }</small> &emsp;&emsp;&emsp;&nbsp;
                       					<small><span style="color: gray;">작성일 :&emsp;</span></small><small>${replyVo.reDateQna }</small>
                   					</div>
                   	
                    				<div class="row1">
                     					<hr style="width:670px; align:center; color:lightgray">
                    				</div>	
                       
                    				<div class="row1">
                       					<span><textarea name="re_content_qna" class="form-control12" id="reply"
                               				cols="90" rows="5" disabled style="text-align:left;">${replyVo.reContentQna}</textarea></span>
                       					<span><input type="submit" class="btn1" id="reply" value="수정" onclick="replyUpdate()"></span>        
                    				</div>
                    				</div>
                    				
                    				<%-- & 원글에 대한 답글 수정할 때 완료, 취소버튼 --%>
                    				<div id="reply_mod" style="display:none;">
                    					<form action="momo.do?command=qna_reply_update&noQna=${qnaVo.noQna }&hitOr=<%=hitOr %>" method="post">
                    						<input type="hidden" name="re_writer_qna" value="${userId }"/>	<!-- 관리자 아이디 -->
                   							
                   							
                    						<div class="row1">
                     						<hr style="width:670px; align:center; color:lightgray">
                    						</div>	
                       
                    						<div class="row1">
                       							<span><textarea name="re_content_qna" class="form-control12" id="reply"
                               						cols="200" rows="5" style="text-align:left;">${replyVo.reContentQna}</textarea></span>
                       							<span style="float:right"><input type="submit" class="btn2" id="reply" value="완료"> </span>      
                    							<span style="float:right"><input type="button" class="btn2" id="cancel" value="취소" onclick="updateCancel()">  </span>
                    						</div>
                    					</form>
                    				</div>
                    			 </c:otherwise>
							</c:choose>
	                   	</c:when>
	                  
	                   	<%-- 관리자 계정이 아니면서 답글 등록 안되어 있을 때 답변 --%>
	                   	<c:when test="${reNo==0 }">	
	                   		<div class="row1" style="margin-top:50px;">
                      			<h6>답변</h6>
                    		</div> 
                    		<div class="row1" style="color:gray;">
                     			<hr style="width:670px; align:center; color:lightgray">
                    		</div>	
                    		<center><small style="color:gray;"> -- 아직 답변이 등록되지 않았습니다. --</small></center>
	                   	</c:when>
	                   	
	                   	<%-- 관리자 계정이 아니면서 답글 등록이 되어 있을 때 답변 --%>
                  	 	<c:otherwise>								
                        	<div class="row1" style="margin-top:50px;">
                      			<h6>답변</h6>
                    		</div>   
                    		
                    		<div class="row1" id="re_detail">
                       			<small style="color: gray;">작성자 :&emsp;</small><small>관리자</small> &emsp;&emsp;&emsp;&nbsp;
                       			<small><span style="color: gray;">작성일 :&emsp;</span></small><small>${replyVo.reDateQna }</small>
                   			</div>
                   	
                    		<div class="row1">
                     			<hr style="width:670px; align:center; color:lightgray">
                    		</div>	
                       
                    		<div class="row1">
                       			<span><textarea name="re_content_qna" class="form-control12" id="reply"
                               		cols="90" rows="5" disabled style="text-align:left;">${replyVo.reContentQna}</textarea></span>        
                    		</div>
                  	 	</c:otherwise>
               		</c:choose>
                  </div>
<!------------------------------------------------- 답변부분 끝--------------------------------------------------->   
            	</div>
           		</div>
          		</div>  
       		 </div>
    	</section>

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"/>
	<!-- ****** Footer Area End ****** -->
	<script src="js/active.js"></script>
</body>

</html>