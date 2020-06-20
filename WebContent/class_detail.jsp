<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<!-- JSTL사용시 -->
<%@page import="momo.vo.ClassVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Title -->
<title>수업 상세보기</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<style type="text/css">
.contact-form textarea.form-control1 {
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
.max-small1 {
    width: auto; height: auto;
    max-width: 300px;
    max-height: 300px;
}
.max-small2 {
    width: auto; height: auto;
    max-width: 500px;
    max-height: 500px;
}
.contact102-form-btn {
    display: -webkit-box;
    display: -webkit-flex;
    display: -moz-box;
    display: -ms-flexbox;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 0 20px;
    height: 30px;
    background-color: #57b846;
    border-radius: 25px;
    font-family: Poppins-Regular;
    font-size: 16px;
    color: #fff;
    line-height: 1.2;
    -webkit-transition: all 0.4s;
    -o-transition: all 0.4s;
    -moz-transition: all 0.4s;
    transition: all 0.4s;
    background-color: #7643ea;
    border:0;
    outline:none;
   }
   .moims {
    background-color: #f3edff;
    padding: 20px 40px;
    margin-bottom: 5px;
    justify-content: space-between!important;
	display: flex!important;
	}
	button:focus {
  	outline: none;
	}
	.wrap-input101 {
	position: relative;
	line-height: 40px;
	margin-bottom: 20px;
	}
.label-input103 {
    font-family: Poppins-Regular;
    font-size: 15px;
    color: #808080;
    position: absolute;
    top: 14px;
    left: 0px;
    width: 300px;
	}
.disabled {
    pointer-events: none;
    background-color: #eee;
    color: #555;
    opacity: 1;
}
.single-listing-menu1 {
    background-color: #e1d2ff;
    padding: 20px 40px;
    margin-bottom: 5px;
}

.single-listing-menu1 p {
    margin-bottom: 0;
}

.single-listing-menu1:nth-child(odd) {
    background-color: #fbf9ff;   
}

.like_a{
	float:right; 
	position: relative; 
	right: 65px; 
	top:-55px;
}
.like_b{
	float:right; 
	position: relative; 
	right: 65px; 
	top:-55px;
}
.like_cnt{
	float:right; position: relative; right: 40px; top: -10px; 
}

#like_btn{
	float: right;
	position: relative;
	right : 100px;
	top : -30px;
}
#level{
	font-family: FontAwesome;
	font-size: 23pt;
}

</style>	

<% ClassVo classVo = (ClassVo)session.getAttribute("classVo"); %>
<% String classNo = (String)request.getAttribute("classNo"); %>
<% String userNo = (String) session.getAttribute("userNo"); %>

<%
String userId = (String)session.getAttribute("userId");					//회원/비회원
String classMemberId = (String)request.getAttribute("classMemberId");	//해당수업 강사인지 아닌지
String tutorYN = (String)request.getAttribute("tutorYN");				//강사계정인지 아닌지
String clubMngYN = (String)request.getAttribute("clubMngYN");			//모임장인지 아닌지
%>
<script src="class_js/classDetail.js"></script>
<!-- font-awsome CSS 추가 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" />
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	
   <!-- ***** Single Listing Area Start ***** -->
   <section class="dorne-single-listing-area section-padding-100">
      <div class="container">
         <div class="row justify-content-center">
            <!-- Single Listing Content -->
            <div class="col-12 col-lg-8">
               <div class="single-listing-content">
                  <div class="single-listing-nav">
                     <nav>
                        <ul id="listingNav">		<!-- 탭 부분 -->
                           <li class="active"><a href="#club_detail">수업상세정보</a></li>
					
							<c:if test="${classMemberId eq userId }">
								<!-- 해당 수업의 강사만 수업신청 모임 관리 가능. -->
								<li ><a id="club_cmpl_tab" href="#club_cmpl">수업신청 수락된 모임 관리</a></li>
								<li ><a id="club_mng_tab" href="#club_mng">신청중인 모임 관리</a></li>
							</c:if>
                        </ul>
                     </nav>
                  </div>
<!--------------------------- 수업정보상세 -------------------------->
    <div class="overview-content mt-50" id="club_detail" style="display:block">	<!-- 수정불가! -->
       <div class="contact-form">
          <div class="contact-form-title">
            <h4>수업 상세정보</h4>
            <input type="hidden" id="clubNo2" value="${classNo } "/>	
            <input type="hidden" id="userIdVal" value="<%=userId%>"/>
            <input type="hidden" id="clubMngYNVal" value="<%=clubMngYN%>"/>
          </div>
            <c:choose>
               <c:when test="${empty userNo }"> <!-- 비회원일 때 -->
 					<div id="like_div" >
            			<a id="like_notUser" class="like_b"><i style="font-size: 40px;" class="far fa-thumbs-up"></i></a>
             			<h5><span class="like_cnt">${likeVo.likeCnt } </span></h5> <!-- 좋아요 수 표시 -->
          				</div>
                </c:when>
                <c:otherwise> <!-- 회원일 때 -->
                <c:choose>
                	<c:when test="${likeVo.likeYN eq 'Y' && likeVo.memberNo eq userNo}"> <!-- 좋아요 누른상태 -->
                		<div id="like_div" >
            				<a class="like_a"><i style="font-size: 40px;" class="fas fa-thumbs-up"></i></a>
            				<h5><span class="like_cnt">${likeVo.likeCnt } </span></h5> <!-- 좋아요 수 표시 -->
            				<input type="hidden" name="likeYN" class="like" value="Y">
          				</div>
                	</c:when>
                <c:otherwise> <!-- 좋아요 안누른 상태 -->
                	<div id="like_div" >
            			<a class="like_a"><i style="font-size: 40px;" class="far fa-thumbs-up"></i></a>
 						<h5><span class="like_cnt">${likeVo.likeCnt } </span></h5> <!-- 좋아요 수 표시 -->
             			<input type="hidden" name="likeYN" class="like" value="N">
          			</div>
               </c:otherwise>
               </c:choose>		
              </c:otherwise>
			</c:choose>
          <br>
          <br>
          <div class="row">
             <div class="col-12">	
               <h6>수업명</h6> 
               <input type="text" name="class_name" class="form-control " value="${classVo.className }" disabled style="background-color: #fff">
             </div>
             <br>
             <hr>
             <br>    
             <div class="col-12 " style="margin-bottom:30px">
                 <h6>강사 프로필 사진</h6>   
                 <img class="max-small2" src="img/memberProfile_img/${classVo.memberPicture }" /> 
             </div> 
                          
             <div class="col-12 col-md-6">	
                <h6>강사명</h6> 
                <input type="text" name="tutor_name" class="form-control" value="${classVo.memberName }" disabled style="background-color: #fff">
             </div>
                       
             <div class="col-12 col-md-6">	
                <h6>선호 연령대</h6> 
                <input type="text" name="tutor_name" class="form-control" value="${classVo.classAge }" disabled style="background-color: #fff">
             </div>
                              
             
                              
             <div class="col-12 col-md-6">	
                  <h6>강사 이메일</h6> 
                  <input type="text" name="tutor_name" class="form-control" value="${classVo.email }" disabled style="background-color: #fff">
             </div>
             <div class="wrap-input101 validate-input" >
				<span class="label-input103">* 문의사항은 E-mail로 보내주시길 바랍니다.</span>
			 </div>
			 <br>
			 <br>
			 <br>
			 
             <!-- 강사 약력 관련 파일 -->       
             <div class="col-12" >
                <h6>강사 약력 파일</h6> <p style="color:gray; margin-bottom: 0px;">*무단복제, 재배포, 개인정보 도용 시 강력한 형사처벌이 있을 수 있습니다.</p>
                <div class="single-listing-menu1 d-flex justify-content-between">
                     <div class="listing-menu-title">
                        <small style="color:black">학력 증명</small>&emsp; <!-- img/tutorFile_img/${classVo.educationFile } -->
         				<a href="img/tutorFile_img/${classVo.educationFile }" id="education" onClick="window.open(this.href, '', 'width=400, height=430'); return false;">${classVo.educationFile }</a>
                     </div>
                  </div>
                  <div class="single-listing-menu1 d-flex justify-content-between">
                     <div class="listing-menu-title">
                        <small style="color:black">경력 증명</small>&emsp; <!-- img/tutorFile_img/${classVo.experienceFile } -->
						<a href="img/tutorFile_img/${classVo.experienceFile }" id="experiene" onClick="window.open(this.href, '', 'width=400, height=430'); return false;">${classVo.experienceFile }</a>
                     </div>
                  </div>
                  <div class="single-listing-menu1 d-flex justify-content-between">
                     <div class="listing-menu-title">
                        <small style="color:black">&nbsp;&nbsp;자격증&nbsp;</small>&emsp;&nbsp;&nbsp; <!-- img/tutorFile_img/${classVo.certificateFile } -->
 						<a href="img/tutorFile_img/${classVo.certificateFile }" id="certificate" onClick="window.open(this.href, '', 'width=400, height=430'); return false;">${classVo.certificateFile }</a>
                     </div>
                  </div>
                  <br>
               </div>
             </div>
                              
             <div class="col-12">
                <h6>강사 소개</h6>
                <textarea name="class_content" class="form-control1" id="Message"
                 cols="30" rows="10" disabled style="background-color: #fff">${classVo.tutorIntroduce }</textarea>
             </div>
                              
             <br>
             <hr>
             <br>                 
             <div class="col-12 col-md-6">
                <h6>수업 카테고리</h6> 
                <select class="form-control" style="height: 50px">
                <option selected>${classVo.categoryName }</option>
                </select>
             </div>
             
             <div class="col-12 col-md-6">	
                <h6>수업 등급</h6> 
                <input type="text" id="level" name="class_level" class="form-control" placeholder="모임점수" value="&#xf005;" readonly="readonly">
                <input type="hidden" id="level2" name="class_level" class="form-control" placeholder="모임점수" value="${classVo.classScore}" readonly>
             </div>
                              
             <div class="col-12">
                <h6>수업 장소</h6> 
                <input type="text" name="class_location" class="form-control" value="${classVo.classAddress }" disabled style="background-color: #fff">
             </div>
                              
             <div class="col-12 col-md-6" style="margin-bottom:30px">
                <h6>수업 관련 사진</h6> 
               	<img class="max-small2" src="img/class_img/${classVo.classPicture }" /> 
             </div>
                              
             <div class="col-12">
                <h6>수업내용</h6> 
                <textarea name="class_content" class="form-control1" id="Message"
                    cols="30" rows="10" disabled >${classVo.classContent }</textarea>
             </div>
                   
             <div class="col-12">
             	<c:choose>
                 	<c:when test="${classMemberId eq userId }"> <%-- 해당 수업의 강사일 경우 --%>
                        <input type="button" class="btn dorne-btn" style="min-width: 130px;" id="list" value="목록" onclick="location.href='class_search.jsp'">&emsp;
						<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="mod" value="수정하기" onclick="class_detail_mod()"> &emsp; <!-- style="display:none" -->
 						<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="del" value="삭제하기" onclick="class_delete()">
                    </c:when>
                    <c:when test="${classAllow eq 'W' }">		<%-- 신청 후 수락대기 상태--%>
                    	<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="list" value="목록" onclick="location.href='class_search.jsp'">&emsp;
                    	<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="reqCancel" value="수업신청 취소" onclick="classCancel()">&emsp;  
                    </c:when>
                    <c:otherwise>								<%-- 비회원 포함 나머지 계정 전부 --%>
                        <input type="button" class="btn dorne-btn" style="min-width: 130px;" id="list" value="목록" onclick="location.href='class_search.jsp'">&emsp;
               			<input type="button" class="btn dorne-btn" style="min-width: 130px;" id="req" value="수업신청하기" onclick="classReq()">&emsp;                      
                    </c:otherwise>
                </c:choose>
             </div>
           </div>
        </div>
    </div>
<!--------------------------- 수업정보상세 끝-------------------------->

<!--------------------------- 수업정보수정 -------------------------->
                   <div class="overview-content mt-50" id="club_detail_mod" style="display:none">	
                     <div class="contact-form">
                        <div class="contact-form-title">
                       	 <h4>수업 정보수정</h4>
                        </div>
                        <br>
                        <br>
                         <form action="momo.do?command=class_detail_mod&classNo=${classNo }" method="post" name="classModInfo" id="classModInfo" enctype="multipart/form-data">
                           <div class="row">
                              <div class="col-12">	
                              <h6>수업명</h6> 
                                 <input type="text" name="class_name" class="form-control" readonly="readonly" style="background-color:white;" value="${classVo.className }">
                              </div>
                              <hr>
                              <div class="col-12 col-md-6">	
                              <h6>강사명</h6> 
                                 <input type="text" name="tutor_name" class="form-control" value="${classVo.memberName }" disabled style="background-color: #fff">
                              </div>
                           
                              <div class="col-12" style="margin-bottom:30px">	
                              <h6>선호 연령대</h6> 
								<span class="label-input101">선호 연령대:</span> 
									<input type="radio" name="classAge" id="20" value="20" required="required"/> <span class="ptag"><label for="20">20대 &nbsp;</label></span>
									<input type="radio" name="classAge" id="30" value="30" required="required"/> <span class="ptag"><label for="30">30대 &nbsp;</label></span>
									<input type="radio" name="classAge" id="40" value="40" required="required"/> <span class="ptag"><label for="40">40대 &nbsp;</label></span>
									<input type="radio" name="classAge" id="50" value="50" required="required"/> <span class="ptag"><label for="50">50대 &nbsp;</label></span>
									<input type="radio" name="classAge" id="60" value="60" required="required"/> <span class="ptag"><label for="60">60대 이상</label></span>
								<span class="focus-input100"></span>
                              </div>
                              
                              <div class="col-12 " style="margin-bottom:30px">
                          		 <h6>강사 프로필 사진</h6>   
                              	<img class="max-small2" src="img/memberProfile_img/${classVo.memberPicture }" /> 
                              </div>
                              
                              <div class="col-12 col-md-6">	
                              <h6>강사 이메일</h6> 
                                 <input type="text" name="tutor_name" class="form-control" value="${classVo.email }" disabled style="background-color: #fff">
                              </div>
                              <div class="wrap-input101 validate-input" >
								<span class="label-input103">* 문의사항은 E-mail로 보내주시길 바랍니다.</span>
							  </div>
							  <br>
							  <br>
							  <br>
                              
                              <div class="col-12">
                              	 <h6>강사 소개</h6>
                                 <textarea name="tutorIntroduce" class="form-control1" id="Message"
                                    cols="30" rows="10" disabled style="background-color: #fff">${classVo.tutorIntroduce }</textarea>
                              </div>
                              
                              <br>
                              <hr>
                              <br>
                              
                           	  <div class="col-12 col-md-6" >
                           	  <h6>수업 카테고리</h6> 
                               <select class="form-control" name="classCategoryName" required="required" style="height: 50px;">
                                <option selected="selected">${classVo.categoryName }</option>
									<option value="스포츠/아웃도어">스포츠/아웃도어</option>
									<option value="요리/먹방">요리/먹방</option>
									<option value="게임/오락">게임/오락</option>
									<option value="반려동물">반려동물</option>
									<option value="음악/댄스">음악/댄스</option>
									<option value="공예/만들기">공예/만들기</option>
									<option value="문화/공연/축제">문화/공연/축제</option>
									<option value="스터디">스터디</option>
									<option value="독서">독서</option>
									<option value="자유주제">자유주제</option>
                          	  </select>
                              </div>
                              
                              <div class="col-12 col-md-6">	
              					  <h6>수업 등급</h6> 
               					  <input type="text" name="class_level" class="form-control" value="">
            				  </div>
             
                              <div class="col-12">
                              <h6>수업 장소</h6> 
                                 <input type="text" name="classAddress" class="form-control" required="required" value="${classVo.classAddress }" >
                              </div>
                              
                              <div class="col-12 col-md-6" style="margin-bottom:30px">
                          		<h6>수업 관련 사진</h6>
                          		<span style="font-size:11pt; color:gray;">파일을 변경하려면 '파일선택'을 클릭하세요.</span>
                          		<input type="file" name="class_picture" id="file_tag">
								<input type="hidden" name="class_picture_or" id="nullPicture" value="${classVo.classPicture }"/>
                              	<img class="max-small2" name="class_img" id="class_img" src="img/class_img/${classVo.classPicture }"/>
                              </div>
                              
                              <div class="col-12">
                              <h6>수업내용</h6> 
                                 <textarea name="class_content" class="form-control1" id="Message"
                                    cols="30" rows="10" required="required" >${classVo.classContent }</textarea>
                              </div>
                              
                              <div class="col-12">
                                 <input type="submit" id="update_class_detail" class="btn dorne-btn" value="수정완료">
								 <input type="button" class="btn dorne-btn" value="취소" onclick="location.href='momo.do?command=class_detail&classNo=${classNo}'">
                              </div>
                           </div>
                        </form>
                     </div>
                  </div>
<!--------------------------- 수업정보수정 끝-------------------------->


<!-------------------------- 수업 페이지 모임 관리 -------------------------->
<c:if test="${classMemberId eq userId }">
				 <div class="listing-menu-area mt-100" id="club_cmpl">
                  	 <hr>
                     <h4>수업신청 수락된 모임 관리</h4>
 					 <c:choose>
                		<c:when test="${empty clubList_cmpl}"> <!-- list가 비어있을 때 -->
 							<p style="color:gray; margin-bottom: 0px; text-align:center;">-- 수락된 모임이 없습니다. --</p>
                		</c:when>
                		<c:otherwise>					<!-- list가 존재할 때 -->
							<c:forEach var="ClubVo" items="${clubList_cmpl}" varStatus="status"> <!-- 초기식 지정 : list를 하나씩 reqClub에 담음 -->
                     			<!-- Single Listing Menu -->
                     			<div class="moims">
                       			 <!-- Listing Menu Title -->
                        		<div>
                          			<table>
                            			<tr>
											<th width="100"><b>모임명</b></th>
											<td><c:out value="${ClubVo.clubName}"></c:out></td> 
										</tr>
										<tr>
											<th width="100"><b>카테고리</b></th>
											<td><c:out value="${ClubVo.categoryName}"></c:out></td> 
										</tr>
										<tr>
											<th width="100"><b>모임장</b></th>
											<td><c:out value="${ClubVo.memberName}"></c:out></td>
										</tr>
										<tr>
											<th width="100"><b>정원</b></th>
											<td><c:out value="${ClubVo.clubTotal}"></c:out></td> 
										</tr>
										<tr>
											<th width="100"><b>모임등급</b></th>
											<td><c:out value="${ClubVo.clubScore}"></c:out></td>
										</tr>
                           			</table>
                        		</div>
                        		<div class="listing-menu-price">
                           			<button class="contact102-form-btn" id="club_detail_btn" onclick="location.href='momo.do?command=club_detail&clubNo=${ClubVo.clubNo }'">상세정보</button>
                       			</div>
                    		 </div>
                  			</c:forEach>
                		</c:otherwise>
            		</c:choose> 
                  </div>
                  
                  <div class="listing-menu-area mt-100" id="club_mng">
                  <hr>
                     <h4>수업 신청 중인 모임 관리 </h4>
 					<c:choose>
                		<c:when test="${empty clubList_ing}"> <!-- list가 비어있을 때 -->
 							<p style="color:gray; margin-bottom: 0px; text-align:center;">-- 수업 신청한 모임이 없습니다. --</p>
                		</c:when>
                		<c:otherwise>					<!-- list가 존재할 때 -->
							<c:forEach var="ClubVo" items="${clubList_ing}" varStatus="status"> <!-- 초기식 지정 : list를 하나씩 ClubVo에 담음 -->
                    			 <!-- Single Listing Menu -->
                    			 <div class="moims">
                       			 <!-- Listing Menu Title -->
                       			 <div>
                          			 <table>
                           				 <tr>
											<th width="100"><b>모임명</b></th>
											<td><c:out value="${ClubVo.clubName}"></c:out></td> 
										</tr>
										<tr>
											<th width="100"><b>카테고리</b></th>
											<td><c:out value="${ClubVo.categoryName}"></c:out></td>
										</tr>
										<tr>
											<th width="100"><b>모임장</b></th>
											<td><c:out value="${ClubVo.memberName}"></c:out></td> 
										</tr>
										<tr>
											<th width="100"><b>정원</b></th>
											<td><c:out value="${ClubVo.clubTotal}"></c:out></td> 
										</tr>
										<tr>
											<th width="100"><b>모임등급</b></th>
											<td><c:out value="${ClubVo.clubScore}"></c:out></td> 
										</tr>
                           			</table>
                        		</div>
                        		<div class="listing-menu-price">
                          			 <button class="contact102-form-btn" id="accept" onclick="location.href='momo.do?command=classAccept&classNo=${classNo}&clubNo=${ClubVo.clubNo}'">수락</button>
                         			 <br>
                          			 <button class="contact102-form-btn" id="refuse" onclick="location.href='momo.do?command=classRefuse&classNo=${classNo}&clubNo=${ClubVo.clubNo}'">거절</button>
                        		</div>
	                          	</div>
                  			</c:forEach>
                		</c:otherwise>
            		</c:choose>
                  </div>
</c:if> 
<!-------------------------- 수업 페이지 모임 관리 끝-------------------------->
               </div>
            </div>
         </div>
   </section>
   <!-- ***** Single Listing Area End ***** -->

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"/>
	<!-- ****** Footer Area End ****** -->

   <!-- Popper js -->
   <script src="js/bootstrap/popper.min.js"></script>
   <!-- Bootstrap-4 js -->
   <script src="js/bootstrap/bootstrap.min.js"></script>
   <!-- All Plugins js -->
   <script src="js/others/plugins.js"></script>
   <!-- Google Maps js -->
   <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDk9KNSL1jTv4MY9Pza6w8DJkpI_nHyCnk"></script>
   <script src="js/google-map/location-map-active.js"></script>
   <!-- Active JS -->
   <script src="js/active.js"></script>
   <script src="club_js/levelJS.js"></script>
   <script src="imgjs/imgChk_js"></script> <!-- 이미지체크 함수 -->
</body>

</html>