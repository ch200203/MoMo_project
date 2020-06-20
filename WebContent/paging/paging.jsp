<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">
</head>
<body>
<div id="paging" style="font-size:15pt; text-align:center;" >
	<nav aria-label="Page navigation example">
   		<ul class="pagination justify-content-center">

			<c:if test="${paging.prev}">
				<li class="page-item disable">
      				<a class="page-link" tabindex="-1" href="momo.do?command=noticeList&page=${paging.beginPage-1}" style="background-color:#7643ea; color:lavender;">prev</a>
    			</li>
			</c:if>

			<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" step="1" var="index">
				<c:choose>
					<c:when test="${paging.page==index}">
						<li class="page-item">
							<a class="page-link" href="#" style="background-color:#7643ea; color:lavender;">${index}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href ="momo.do?command=noticeList&page=${index}">${index}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:if test="${paging.next}">
				<li class="page-item">
		         	<a class="page-link" href="momo.do?command=noticeList&page=${paging.endPage+1}">next</a>
		      	</li>
			</c:if>
	
   		</ul>
	</nav>
</div>

</body>
</html>