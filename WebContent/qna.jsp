<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<!-- JSTL사용시 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="momo.vo.QnaVo" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>
<!DOCTYPE html>
<!-- qna게시판입니다 -->
<html>
<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Q&A</title>

<!-- Fontfaces CSS-->
<link href="board/css/font-face.css" rel="stylesheet" media="all">
<link href="board/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
<link href="board/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
<link href="board/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
<!-- Bootstrap CSS-->
<link href="board/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
<!-- Vendor CSS-->
<link href="board/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
<link href="board/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
<link href="board/vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="board/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
<link href="board/vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="board/vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="board/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
<!-- Main CSS-->
<link href="board/css/theme.css" rel="stylesheet" media="all">
<!-- 추가해준 부분 -->
<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">
<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">
<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<!-- 추가해준 부분 끝 -->
<style type="text/css">
.title-51 {
    text-transform: capitalize;
    font-weight: 500;
    color: #393939;
    text-align:center;
}
</style>

<% 
String userId = (String)session.getAttribute("userId");

ArrayList<Integer> list = (ArrayList)request.getAttribute("rplList"); 
System.out.println("jsp의 reply_list: "+list);
                                 	
List qna_all = (List)request.getAttribute("qna_all");
System.out.println("jsp의 qna_all: "+qna_all);
                                 	
int i = 0;	//리스트의 인덱스
System.out.println("jsp의 i : "+i);
%>

<script type="text/javascript">

function click_qna_write()	{
	
	var userId = "${userId}";
	if(userId == null || userId=="")	{
		var Del = confirm("해당 기능은 회원만 이용 가능합니다.\n로그인창으로 이동하시겠습니까?")
	    if (Del == true){
	        location.href='momo.do?command=login';
	    } else {
	        alert("취소 되었습니다.")
	    }
	} else {
		location.href='momo.do?command=qna_write';
	}	
			
}

function click_title_private(noQnaV, hitQnaV)	{

	var userId = "${userId}";
	//alert(userId);
	if(userId==null || userId=="")	{
		alert("비공개글입니다.");
		location.href='momo.do?command=qna_list'
		
	} else if(userId.indexOf("admin")!= -1){
		alert("관리자계정입니다.");
		location.href='momo.do?command=qna_detail&noQna='+noQnaV+'&hitQna='+hitQnaV;
	      
	} else {

		document.getElementById('noQna').value = noQnaV;
		document.getElementById('hitQna').value = hitQnaV;
			
		var noQna1 = noQnaV;
		//alert("매개변수 : "+noQna1);
		var hitQna1 = hitQnaV;
		//alert("매개변수 : "+hitQna1);
		var noQna2 = document.getElementById('noQna').value;
		//alert("input태그값 : "+noQna2);
		var hitQna2 = document.getElementById('hitQna').value;
		//alert("input태그값 : "+hitQna2);

		 var url = "momo.do?command=openPassChk&noQna="+noQnaV+"&hitQna="+hitQnaV;
		 window.open(url, "qna_pass",
			"width=350, height=180, resizable=no, scrollbars=no, top = 200, left = 500, location = no");

	}
	
}


</script>
</head>
<body class="animsition">
   	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	
   <div class="page-wrapper" style="background-color: lavender">
      <!-- MAIN CONTENT-->
      <div class="main-content">
         <div class="section__content section__content--p30">
            <div class="container-fluid">
               <div class="row">
                  <div class="col-md-12">

                     <!-- DATA TABLE -->
                     <h1 class="title-51 m-b-35">Q&A</h1>
                     	<div class="table-data__tool-right" style="float:left; margin-right:10px;">
   							<button class="au-btn au-btn-icon au-btn--small" onclick="location.href='momo.do?command=qna_list'" style="float:right; background-color:#5d25dd;">
      							전체목록 보기
   							</button>
						</div>

						<div class="table-data__tool-right" style="float:left;">
   							<button class="au-btn au-btn-icon au-btn--small" onclick="location.href='momo.do?command=qna_list_my'" style="float:right; background-color:#5d25dd;">
      							내가 쓴 글
   							</button>
						</div> 
                     
                     
                      <div class="table-data__tool-right" >
                           <button class="au-btn au-btn-icon au-btn--small" onclick="click_qna_write()" style="float:right; background-color:#5d25dd;">
                              <i class="zmdi zmdi-plus"></i>글쓰기
                           </button>
                      </div>
                        
                     <!-- 테이블 시작 -->            
                     <div class="table-responsive table-responsive-data2">
                        <table class="table table-data2">
                        <col width="10%"><col width="40%"><col width="15%">
						<col width="15%"><col width="10%"><col width="10%">
                           <thead>
                              <tr>
                                 <th>글번호</th>
                                 <th>제목</th>
                                 <th>아이디</th>
                                 <th>답변상태</th>
                                 <th>작성일</th>
                                 <th>조회수</th>
                              </tr>
                           </thead>

                           <tbody>
                               <c:forEach var="qna_all" items="${qna_all}"> 


                              <tr class="tr-shadow">
                                 <td>${qna_all.noQna}</td>	<!-- 글번호 -->
                                 
							<% QnaVo qnaVo = (QnaVo)qna_all.get(i);
								System.out.println("jsp의 i번째 qnaVo: "+qnaVo);
								
								String showYN = qnaVo.getShowYNQna();
								String writer = qnaVo.getWriterQna();
								String date = qnaVo.getDateQna();
								System.out.println("date: "+date);
								
								SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
						        Calendar c1 = Calendar.getInstance();
							 	String today = sdf.format(c1.getTime());
								System.out.println("today: "+today);
										
								
								System.out.println("jsp의 i번째 showYN: "+showYN); 

								if(showYN.equals("Y"))	{%>     	<%--공개글일때 --%>
                                 <td>	<!-- 글제목 + new -->
									<a href="momo.do?command=qna_detail&noQna=${qna_all.noQna}&hitQna=${qna_all.hitQna}">${qna_all.titleQna }</a>
								<% if(date.equals(today))	{ %>	
									<img src="//img.echosting.cafe24.com/design/skin/admin/ko_KR/ico_new.gif" alt="NEW" class="ec-common-rwd-image">
									</td>
								<% } else { %>
									</td>
                                 <%} } else {  %>		<%--비공개글일때 --%>
                                  <td>	<!-- 글제목 + new + 자물쇠 아이콘-->
                        			<form id="test">
                        				<input type="hidden" name="noQna" id="noQna"/>
    									<input type="hidden" name="hitQna" id="hitQna"/>	
                        			</form>
									<a href="javascript:click_title_private(${qna_all.noQna}, ${qna_all.hitQna});" >${qna_all.titleQna }</a>
									<img src="img/core-img/lock.png" style="width:13px; height:13px;">
								<% if(date.equals(today))	{ %>				
									<img src="//img.echosting.cafe24.com/design/skin/admin/ko_KR/ico_new.gif" alt="NEW" class="ec-common-rwd-image">
								  </td>
								<%} else { %>		
								</td>
								<% 		} 
                                 	} 
                                 %>
                                 
                                 <td>${qna_all.writerQna}</td>	<!-- 작성자 -->
                                 
                                 <%
                                 	String noQna = Integer.toString(qnaVo.getNoQna());
                                 	System.out.println("jsp의 i번째 noQna: "+noQna);
                                 	
                                 	if(list.contains(noQna))	{	
                                 %>
                                 		<!-- 답변상태 --> <!-- status--denied -->
                                 		<td><span class="status--process">답변완료</span></td>
                                 <% } else { %>
                                 		<td><span class="status--denied">답변예정</span></td>
                                <% 	}  
                                 	i++;
                                 	System.out.println("jsp의 i++: "+i);
                                %>
                                 
                                 <td>${qna_all.dateQna}</td>	<!-- 작성일 -->
                                 <td>${qna_all.hitQna }</td>	<!-- 조회수 -->
                                 
                              </tr>
                               </c:forEach>
                           </tbody>
                        </table>
                        <c:if test="${empty qna_all}">
                     		<center><small>-- 등록된 글이 없습니다. --</small></center>
                   		</c:if>
                     </div>
                     <!-- END DATA TABLE -->

<jsp:include page="/paging/paging_qna.jsp">
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>    
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"/>
	<!-- ****** Footer Area End ****** -->
   <!-- Bootstrap JS-->
   <script src="board/vendor/bootstrap-4.1/popper.min.js"></script>
   <script src="board/vendor/bootstrap-4.1/bootstrap.min.js"></script>
   <!-- Vendor JS -->
   <script src="board/vendor/slick/slick.min.js"></script>
   <script src="board/vendor/wow/wow.min.js"></script>
   <script src="board/vendor/animsition/animsition.min.js"></script>
   <script src="board/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
   <script src="board/vendor/counter-up/jquery.waypoints.min.js"></script>
   <script src="board/vendor/counter-up/jquery.counterup.min.js"></script>
   <script src="board/vendor/circle-progress/circle-progress.min.js"></script>
   <script src="board/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
   <script src="board/vendor/chartjs/Chart.bundle.min.js"></script>
   <script src="board/vendor/select2/select2.min.js"></script>
   <script src="board/js/main.js"></script>
   <script src="js/active.js"></script>

</body>

</html>