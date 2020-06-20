<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<%
   response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>모임 상세보기</title>
<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">
<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<!-- font-awsome CSS 추가 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" />

<% 
String cnt = (String) request.getAttribute("cnt"); //  현재인원의 값
String userNo = (String) session.getAttribute("userNo"); // 현재세션의 userNo 값
String cnt2 = (String) request.getAttribute("cnt2"); // 가입대기중인 친구들
%>
</head>
<style type="text/css">
.contact-form textarea.form-control4 {
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

.btn_approve {
   height: 30px;
   width: 70px;
   color: #fff;
   font-weight: 600;
   font-size: 15px;
   border: 0;
   background-color: #7643EA;
   color: white;
}

.btn_reject {
   height: 30px;
   width: 70px;
   color: #fff;
   font-weight: 600;
   font-size: 15px;
   border: 0;
   background-color: red;
   color: white;
}

.member_img {
   width: 145px;
   height: 100px;   
}
#like_btn{
   float: right;
   position: relative;
   right : 100px;
   top : -30px;
}

.like_cnt{
   float: right;
   position: relative;
   right: 75px;
   top : 10px;
}
.kick_btn{
   height: 30px;
   width: 70px;
   color: #fff;
   font-weight: 600;
   font-size: 15px;
   border: 0;
   background-color: red;
   color: white;
}
.like_a{
   float:right; 
   position: relative; 
   right: 65px; 
   top:-80px;
}
.like_b{
   float:right; 
   position: relative; 
   right: 65px; 
   top:-80px;
}
.like_cnt{
   float:right; position: relative; right: 40px; top: -35px; 
}
#level{
   font-family: FontAwesome;
   font-size: 23pt;
}
.club_btn {
	background: #7643EA;
	color: #fff;
	border: 0;
	outline: 0;
	padding: 8px 8px;
	font-size: 15px;
	margin: 2px 2px;
	margin-top: 15px;
	border-radius: 6px;
}
</style>

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
                        <ul id="listingNav">
                           <li class="active"><a href="#club_detail">모임정보상세</a></li>
                           <li><a href="#club_member">모임회원 보기</a></li>
                           <c:if test="${clubVo.managerNo eq userNo }">
                              <!-- 모임 장만 가입 신청중인 회원 조회 가능. -->
                              <li><a href="#club_reg">가입신청중인 회원</a></li>
                           </c:if>
                           <li><a href="#class_club">신청된 수업</a></li>
                        </ul>
                     </nav>
                  </div>
            <div class="overview-content mt-50" id="club_detail">
                     <div class="contact-form">
                        <div class="contact-form-title">
                           <h4 id="club_name">${clubVo.clubName }</h4>
                           <br>
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
                                       <input type="hidden" name="clubNo" id="clubNo3" value="${clubVo.clubNo }" />
                                     </div>
                                  </c:when>
                                  <c:otherwise> <!-- 좋아요 안누른 상태 -->
                                  		<div id="like_div" >
                                      		 <a class="like_a"><i style="font-size: 40px;" class="far fa-thumbs-up"></i></a>
                                     		<h5><span class="like_cnt">${likeVo.likeCnt } </span></h5> <!-- 좋아요 수 표시 -->
                                        		<input type="hidden" name="likeYN" class="like" value="N">
                                       			 <input type="hidden" name="clubNo" id="clubNo3" value="${clubVo.clubNo }" />
                                     	</div>
                                  </c:otherwise>
                               </c:choose>      
                            </c:otherwise>
                         </c:choose>  
                         
                      <!-- 폼태그 시작====================================================================================== -->
                        <form id="detail_frm" name="detail_frm" enctype="multipart/form-data">
                        <input type="hidden" name="clubNo" id="clubNo2" value="${clubVo.clubNo }" />
                           <div class="row">
                              <div class="col-12">
                                 <img src="img/club_img/${clubVo.clubPicture }" id="club_img" alt="이미지가 선택되지 않았습니다.">   <!-- 모임사진 -->
                                 <br>
                                 <c:if test="${clubVo.managerNo eq userNo }">
                                    <%-- 모임장일 경우에만 file input 수정 가능 --%>
                                    <input type="file" id="club_picture" name="club_picture" accept=".jpg .gif .png"/>
                                    <input type="hidden" id="nullpicture" name=""/> <!-- 이미지에 파일이 없으면 애가 넘어감 -->
                                 </c:if>
                              </div>
                              <div class="col-12 col-md-6">
                                  <h6>모임장</h6>
                                 <input type="text" name="name" class="form-control" value="${clubVo.managerName}" placeholder="모임장명">
                              </div>
                              <div class="col-12 col-md-6">
                                 <h6>카테고리</h6>
                                 <select name="category" class="form-control" style="height: 50px" id="cate">
                                    <option selected value="">카테고리</option>
                                    <option value="C1" <c:if test="${clubVo.clubCategoryNo == 'C1'}">selected</c:if>>스포츠 /  아웃도어</option>
                                    <option value="C2" <c:if test="${clubVo.clubCategoryNo == 'C2'}">selected</c:if>>요리 / 먹방</option>
                                    <option value="C3" <c:if test="${clubVo.clubCategoryNo == 'C3'}">selected</c:if>>게임 / 오락</option>
                                    <option value="C4" <c:if test="${clubVo.clubCategoryNo == 'C4'}">selected</c:if>>반려동물</option>
                                    <option value="C5" <c:if test="${clubVo.clubCategoryNo == 'C5'}">selected</c:if>>음악 / 댄스</option>
                                    <option value="C6" <c:if test="${clubVo.clubCategoryNo == 'C6'}">selected</c:if>>공예 / 만들기</option>
                                    <option value="C7" <c:if test="${clubVo.clubCategoryNo == 'C7'}">selected</c:if>>문화 / 공연 / 축제</option>
                                    <option value="C8" <c:if test="${clubVo.clubCategoryNo == 'C8'}">selected</c:if>>스터디</option>
                                    <option value="C9" <c:if test="${clubVo.clubCategoryNo == 'C9'}">selected</c:if>>독서</option>
                                    <option value="C10" <c:if test="${clubVo.clubCategoryNo == 'C10'}">selected</c:if>>자유주제</option>
                                 </select>
                              </div>
                              <div class="col-12 col-md-6">
                                 <h6>모집 인원</h6>
                                 <%-- <input type="text" name="total" class="form-control" value="<%=size %> / ${clubVo.clubTotal}" placeholder="현재원/모임정원"> --%>
                                 <input type="text" name="total" id="total"class="form-control" value="${clubVo.clubTotal}" placeholder="모임정원">
                              </div>
                              <div class="col-12 col-md-6">
                                 <h6>모집 여부</h6>
                                 <select name="recuritYN" class="form-control" style="height: 50px" >
                                    <option selected value="">모집여부
                                    <option value="Y" <c:if test="${clubVo.recruitYN =='Y'}">selected</c:if> >모집중</option>
                                    <option value="N" <c:if test="${clubVo.recruitYN =='N'}">selected</c:if>>모집완료</option>
                                 </select>
                              </div>
                              <div class="col-12 col-md-6">
                                 <h6>모임 등급</h6>
                                 <input type="text" id="level" name="club_score" class="form-control" placeholder="모임점수" value="&#xf005;">
                                 <input type="hidden" id="level2" name="club_score" class="form-control" placeholder="모임점수" value="${clubVo.clubScore }">
                              </div>
                              <div class="col-12 col-md-6">
                                 <h6>활동 여부</h6>
                                 <select id="openYN" name="openYN"  class="form-control" style="height: 50px">
                                    <option selected value="">활동여부</option>
                                    <option value="Y" <c:if test="${clubVo.openYN =='Y'}">selected</c:if>>활동중</option>
                                    <option value="N" <c:if test="${clubVo.openYN =='N'}">selected</c:if>>비활동중</option>
                                 </select>
                              </div>
                              <div class="col-12">
                                 <h6>모임 장소</h6>
                                 <input type="text" name="club_addr" class="form-control" value="${clubVo.clubAddress}" placeholder="모임장소">
                              </div>
                              <div class="col-12">
                                 <h6>모임 설명</h6>
                                 <textarea name="club_content" class="form-control4" id="Message" 
                                    cols="30" rows="10" readonly="readonly" placeholder="활동내용">${clubVo.clubContent}</textarea>
                              </div>
                              <div class="col-12">
                                 <c:choose>
                                    <c:when test="${empty userNo}">
                           <%-- 로그인을 안했을 경우 --%>
                                       <button id="joinbtn2" type="button" class="btn dorne-btn">가입 신청</button>                        
                                    </c:when>
                                    <c:when test="${clubVo.managerNo eq userNo }">
                                    <%-- 클럽 관리자일 경우 --%>
                                       <button id="update_btn"  type="button" class="btn dorne-btn">수정</button>
                                    </c:when>
                                    <c:when test="${cmvo.allowYN eq 'Y'}">
                                    <%-- 클럽 회원 일 경우 --%>
                                    </c:when>
                                    <c:when test="${cmvo.allowYN eq null}">
                                    <%--클럽 회원이 아닐 경우 --%>
                                      <c:if test="${clubVo.openYN eq 'Y' }"> 
                                    <%--현재모임이 활동중이고 가입을 받을때 --%>
                                       <c:choose>
                                          <c:when test="${clubVo.recruitYN =='Y'}">
                                             <button id="join_btn"  type="button" class="btn dorne-btn">가입 신청</button>
                                             <input type="hidden" id="clubNo" value="${clubVo.clubNo }"/>
                                          </c:when>
                                          <c:otherwise>
                                             <button id="join_btn_N"  type="button" class="btn dorne-btn">가입 신청</button>
                                          </c:otherwise>
                                       </c:choose>
                                      </c:if>
                                    </c:when>
                                    <c:otherwise>
                                       <button id="join_cancel" type="button" class="btn dorne-btn">가입신청 취소</button>                  
                                    </c:otherwise>
                                 </c:choose>
                                 <button id="btn1" type="button" class="btn dorne-btn">목록</button>
                                 <!-- <button type="submit" class="btn dorne-btn">완료</button> -->
                              </div>
                           </div>
                        </form>
                     </div>
                  </div>



                  <!-- 모임회원관리 ------------------------------------------------------------------------------>
                  <div class="listing-menu-area mt-100" id="club_member">
                     <hr>
                     <h3>모임회원 보기</h3>
                     <br> <br>
                     <h5>활동중인 회원</h5><small style="opacity: 0.7">&#40; <%=cnt %>명 활동중 &#41;</small>
                     <input type="hidden" id="cnt" value="<%=cnt %>"/>
                     <!-- Single Listing Menu -->
                     <c:forEach var="cmList" items="${cmList}" varStatus="status">
                        <c:if test="${cmList.allowYN eq 'Y'}">
                           <div class="single-listing-menu d-flex justify-content-between">
                              <!-- Listing Menu Title -->
                              <div class="listing-menu-title">
                                 <h6>${cmList.memberId }</h6>
                                 <p>이름 : ${cmList.memberName }</p>
                                 <p>성별 : ${cmList.gender }</p>
                                 <p>생일 : ${cmList.birthday }</p>
                                 <p>이메일 : ${cmList.email }</p>
                              </div>
                              <div class="listing-menu-price">
                                 <img src="img/clubMember_img/${cmList.memberPictureUrl }" class="member_img">
                                 <!-- ClubMember Vo에 추가하기 -->
                                 <c:if test="${clubVo.managerNo eq userNo }">
                                 <br>   
                                 <br>                              
                                 <%-- 세션에서 유지되는 유저 번호를 넘겨주기위한 input태그 --%>
                                 <c:if test="${cmList.memberNo ne clubVo.managerNo }">
                                  <button id="kick_btn" class="kick_btn" onclick = "getout('${cmList.memberNo}','${clubVo.clubNo }');">추방</button>
                                 </c:if>
                                 <c:if test="${cmList.memberNo eq clubVo.managerNo }"> 
                                    <button id="btn_appr" class="btn_approve" disabled="disabled">모임장</button>
                                 </c:if>
                                 <%-- 모임장은 자기자신을 추방할 수 없다.--%>
                                    <input type="hidden" class="kickUserNo" id="btn_userNoY" value="${cmList.memberNo }"/>
                                    <input type="hidden" class="kickClubNo" id="btn_clubNo" value="${clubVo.clubNo }"/>
                                 <!-- 미구현 -->
                                 </c:if>
                              </div>
                           </div>
                        </c:if>
                     </c:forEach>
                     <!-- Listing Menu Price -->
                  </div>
                  <!-- Single Listing Menu -->
               </div>

               
               <c:if test="${clubVo.managerNo eq userNo }">         
                  <div class="listing-menu-area mt-100" id="club_reg">
                     <h5>가입신청중인 회원</h5>
                     <small style="opacity: 0.7">&#40; <%=cnt2 %>명 활동중 &#41;</small>
                     <c:forEach var="cmList" items="${cmList }">
                              <c:if test="${cmList.allowYN eq 'N'}">
                                 <div class="single-listing-menu d-flex justify-content-between">
                                    <!-- Listing Menu Title -->
                                    <div class="listing-menu-title">
                                       <h6>${cmList.memberId }</h6>
                                       <p>${cmList.memberName }</p>
                                       <p>${cmList.gender }</p>
                                       <p>${cmList.birthday }</p>
                                       <p>${cmList.email }</p>
                                    </div>
                                    <div class="listing-menu-price">
                                       <img src="img/bnbn.jpg" class="member_img"> <br>
                                       <br>
                                       <button id="btn_appr" class="btn_approve" onclick="getAppr('${cmList.memberNo}', '${clubVo.clubNo }');">승인</button>
                                       <button id="btn_rej" class="btn_reject" onclick="getRej('${cmList.memberNo}', '${clubVo.clubNo }');">거절</button>
                                       <input type="hidden" class="btn_userNoN" value="${cmList.memberNo }"/>
                                       <input type="hidden" class="btn_clubNo" value="${clubVo.clubNo }"/>
                                       <%-- 세션에서 유지되는 유저 번호를 넘겨주기위한 input태그 --%>
                                    </div>
                                 </div>
                              </c:if>
                     </c:forEach>
                  </div>
               </c:if>
               <!--if 문 종료 -->
               <div class="listing-menu-area mt-100" id="class_club">
                  <h5>신청된 수업 확인</h5>
                  <br>
                     <c:forEach var="myClassList" items="${myClassList }">
                        <c:choose>
                           <c:when test="${empty myClassList.className}">
                              <p style="text-align: center; color: white;">
                              <b>--- 신청 된 수업이 없습니다 ---</b>
                              </p>
                           </c:when>
                           <c:otherwise>
                              <div class="single-listing-menu d-flex justify-content-between">
                              <div class="listing-menu-title">
                              <br>
                              <h6 style="color: black">${myClassList.className}</h6>
                              </div>
                              <div class="listing-menu-price">
                              <c:if test="${myClassList.allowYN_W eq 'Y' }">
                                 <button type="button" class="club_btn"
                                 onclick="location.href='momo.do?command=class_detail&classNo=${myClassList.classNo}'">수업상세 정보</button>
                              </c:if>
                              <c:if test="${myClassList.allowYN_W eq 'W' }">
                                 <button class="club_btn">가입 진행 중</button>
                              </c:if>
                              </div>
                              </div>
                        </c:otherwise>
                        </c:choose>
                  </c:forEach>
               </div>
            </div>
         </div>
      </div>
   </section>
   <!-- ***** Single Listing Area End ***** -->

   <!-- ****** Footer Area Start ****** -->
   <jsp:include page="footer.jsp" />
   <!-- ****** Footer Area End ****** -->

   <!-- detail 소스파일 호출 -->
   <script src="club_js/detail.js?version=2.5"></script>
   <!-- Popper js -->
   <script src="js/bootstrap/popper.min.js"></script>
   <!-- Bootstrap-4 js -->
   <script src="js/bootstrap/bootstrap.min.js"></script>
   <!-- All Plugins js -->
   <script src="js/others/plugins.js"></script>
   <!-- Active JS -->
   <script src="js/active.js"></script>
   <!-- 이미지 체크 파일 -->
   <script src="imgjs/imgChk_js.js"></script>
   <!-- level 체크 파일  -->
   <script src="club_js/levelJS.js"></script>
</body>

</html>