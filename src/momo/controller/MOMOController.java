package momo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import momo.dao.ClassDao;
import momo.dao.ClassReviewDao;
import momo.dao.ClubDao;
import momo.dao.ClubReviewDao;
import momo.dao.MemberDao;
import momo.dao.NoticeDao;
import momo.dao.QnaDao;
import momo.dao.likeDao;
import momo.vo.ClassVo;
import momo.vo.ClubClassVo;
import momo.vo.ClassListVo;
import momo.vo.ClassReviewListVo;
import momo.vo.ClassReviewVo;
import momo.vo.ClubListVo;
import momo.vo.ClubMemberVo;
import momo.vo.ClubReviewListVo;
import momo.vo.ClubReviewVo;
import momo.vo.ClubVo;
import momo.vo.LikeVo;
import momo.vo.MemberVo;
import momo.vo.MyClassListVo;
import momo.vo.MyClubListVo;
import momo.vo.MypageVo;
import momo.vo.NoticeVo;
import momo.vo.PagingVo;
import momo.vo.TutorVo;
import momo.vo.QnaReplyVo;
import momo.vo.QnaVo;

@WebServlet("/momo.do")
public class MOMOController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String userNo = null;
	private String userId = null;

	likeDao likeDao = new likeDao();
	MemberDao memberDao = new MemberDao();
	ClubDao clubDao = new ClubDao();
	ClassDao classDao = new ClassDao();
	NoticeDao noticeDao = new NoticeDao();
	QnaDao qnaDao = new QnaDao();
	ClubReviewDao clubReviewDao = new ClubReviewDao();
	ClassReviewDao classReviewDao = new ClassReviewDao();
	ClassVo classVo = new ClassVo();
	ClubVo clubVo = new ClubVo();
	QnaVo qnaVo = new QnaVo();
	QnaReplyVo replyVo= new QnaReplyVo();
	public MOMOController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String command = request.getParameter("command");
		System.out.printf("${%s}", command);

		System.out.println();

		if (command.equals("main")) { // 메인페이지
			main(request, response);

		} else if (command.equals("login")) { // 로그인
			response.sendRedirect("login.jsp");

		} else if (command.equals("login-form")) { // 로그인 입력 페이지
			processLogin(request, response, out);

		} else if (command.equals("logout")) { // 로그아웃
			processLogout(request, response);

		} else if (command.equals("searchId")) { // 아이디 찾기
			searchId(request, response, out);

		} else if (command.equals("searchPwd")) { // 비밀번호 찾기
			searchPwd(request, response, out);

		} else if (command.equals("signup")) { // 회원가입
			response.sendRedirect("signup.jsp");

		} else if (command.equals("idCheck")) { // 아이디 중복 체크
			processIdCheck(request, response, out);

		} else if (command.equals("signup-form")) { // 회원가입 작성 양식
			processSignup(request, response, out);

		} else if (command.equals("mypage")) { // 마이페이지
			showMypage(request, response);

		} else if (command.equals("mypage-form")) { // 마이페이지 작성 양식
			updateMypage(request, response);

		} else if (command.equals("registerTutor")) { // 강사로 등록하기
			registerTutor(request, response, out);

		} else if (command.equals("uploadTutorFile")) { // 강사 파일 업로드 (강사 정보 업데이트)
			uploadTutorFile(request, response);

		} else if (command.equals("clubList")) { // 모임리스트 출력
			clubList(request, response);

		} else if (command.equals("classList")) { // 수업리스트 출력
			classList(request, response);

		} else if (command.equals("selectedClubList")) { // 조건 검색된 모임리스트 출력
			selectedClubList(request, response);

		} else if (command.equals("selectedClassList")) { // 조건 검색된 수업리스트 출력
			selectedClassList(request, response);

		} else if (command.equals("searchedList")) { // 헤더 검색 결과 출력
			searchedList(request, response);

		}
		///////////////////////////////////////////////////////////////
		else if (command.equals("club_detail")) { // 모임 상세보기 페이지
			club_detail(request, response);

		} else if (command.equals("club_update")) {
			// 모임 업데이트
			club_update(request, response, out);

		} else if (command.equals("test_insert")) { // 클럽생성 테스트
			System.out.println("userNo = " + userNo);
			if(userNo == null || userNo == "") {
				out.println("<script>alert('해당 기능은 로그인 한 회원만 이용 가능합니다. 확인을 클릭하시면 로그인창으로 이동합니다.'); location.href='momo.do?command=login';</script>");
				out.flush();
			} else {
				response.sendRedirect("club_register.jsp");
			}
		} else if (command.equals("club_insert")) { // 클럽 생성하기
			club_insert(request, response);

		} else if (command.equals("clubMember_reject")) { // 클럽멤버 거절
			clubMember_reject(request, response, out);

		} else if (command.equals("clubMember_insert")) { // 가입신청버튼 클릭
			clubMember_insert(request, response);
		} else if (command.equals("clubMember_approve")) { // 멤버 신청 승인
			clubMember_approve(request, response, out);

		} else if (command.equals("clubNameChk")) { // 모임명 중복 검사
			String clubName = request.getParameter("clubName");

			System.out.println("사용자가 입력한 ClubName : " + clubName);

			int res = clubDao.clubNameChk(clubName);

			if (res > 0) {
				out.println(res);
			}

		} else if (command.equals("clubMember_cancel")) { // 가입신청 취소
			String clubNo = request.getParameter("clubNo");
			System.out.println(clubNo);
			int res = clubDao.joinCancel(userNo, clubNo);

			if (res > 0) {
				out.println(res);
			} else {
				System.out.println("가입취소 실패");
			}
		} else if (command.equals("clubMember_kick")) { // 가입멤버 추방
			clubMember_kick(request, response, out);
		} else if(command.equals("likeClick")) { // 좋아요 구현
			likeClick(request, response, out);
		} 		///////////////////////////////////////////////////////////////////////////////////
		else if (command.equals("reviewClubList")) { // 모임 리뷰 목록

			reviewClubList(request, response);

		} else if (command.equals("reviewClassList")) {

			reviewClassList(request, response);

		} else if (command.equals("reviewClubDetail")) {

			reviewClubDetail(request, response);

		} else if (command.equals("reviewClassDetail")) {

			reviewClassDetail(request, response);

		} else if (command.equals("reviewIdClubCk")) { // 모임 리뷰 아이디 체크

			reviewIdClubCk(request, response, out);

		} else if (command.equals("reviewIdClassCk")) { // 수업 리뷰 아이디 체크

			reviewIdClassCk(request, response, out);

		} else if (command.equals("reviewClubDelete")) { // 모임 리뷰 삭제

			reviewClubDelete(request, response);

		} else if (command.equals("reviewClassDelete")) { // 모임 리뷰 삭제

			reviewClassDelete(request, response);

		} else if (command.equals("findClubName")) { // 모임명 찾기
			findClubName(request, response, out);

		} else if (command.equals("writeClubReviewForm")) { // 모임 리뷰 작성
			writeClubReview(request, response, out);

		} else if (command.equals("showClubReviewUpdate")) { // 모임 리뷰 수정 페이지
			showClubReviewUpdate(request, response);

		} else if (command.equals("updateClubReview")) { // 모임 리뷰 수정
			updateClubReview(request, response, out);

		} else if (command.equals("findClassName")) { // 수업명 찾기
			findClassName(request, response, out);

		} else if (command.equals("writeClassReviewForm")) { // 수업 리뷰 작성
			writeClassReview(request, response, out);

		} else if (command.equals("showClassReviewUpdate")) { // 수업 리뷰 수정 페이지
			showClassReviewUpdate(request, response);

		} else if (command.equals("updateClassReview")) { // 수업 리뷰 수정
			updateClassReview(request, response, out);

		} else if (command.equals("noticeList")) { // 공지 리스트 페이지
			noticeList(request, response);

		} else if (command.equals("noticewrite")) { // 공지 작성폼
			response.sendRedirect("notice_write.jsp");

		} else if (command.equals("noticeInsert")) { // 공지 작성
			noticeInsert(request, response);

		} else if (command.equals("noticeDetail")) { // 공지 상세 페이지
			noticeDetail(request, response);

		} else if (command.equals("noticeUpdateForm")) { // 공지 수정 페이지
			noticeUpdateForm(request, response);

		} else if (command.equals("noticeUpdate")) { // 공지 수정
			noticeUpdate(request, response);

		} else if (command.equals("noticeDelete")) { // 공지 삭제
			noticeDelete(request, response);
////////////////////////////////////////////////////////////////////////////////////////////////////
		} else if (command.equals("tab_classRegister")) {	//header의 수업등록 클릭시
			tabClassRegister(request, response, out);

		} else if (command.equals("classRegister")) { 		//[수업등록] 등록버튼 클릭시
			classRegister(request, response, out);

		} else if (command.equals("clssNmChk")) { 	 		//[수업등록] 수업명 중복체크
			classNameCheck(request, response, out);

		} else if (command.equals("class_detail")) {		//[수업상세] 페이지로 연결될 때
			classDetail(request, response, out);

		} else if (command.equals("class_req")) { 	  		//[수업상세] 수업신청 버튼 클릭시
			classReq(request, response, out);

		} else if (command.equals("classAccept")) { 	  	//[수업상세] 수업신청한 모임 [수락]버튼 클릭시
			classAccept(request, response, out);

		} else if (command.equals("classRefuse")) { 	  	//[수업상세] 수업신청한 모임 [거절]버튼 클릭시
			classRefuse(request, response, out);

		} else if (command.equals("class_detail_mod"))	{	//[수업상세] 수정페이지에서 수정완료 버튼 클릭시
			classDetailMod(request, response, out);

		} else if(command.equals("class_delete"))	{		//[수업상세] 수업삭제의 삭제 버튼 클릭시
			classDelete(request, response, out);

		} else if(command.equals("classrq_delete"))	{		//[수업상세] 수업신청 내역 삭제 클릭
			classrq_delete(request, response, out);

////////////////////////////////////////////////////////////////////////////////////////////////////
		} else if(command.equals("qna_list"))	{			//[Q&A 목록] header에서 이동
			System.out.println("qnaList 등장");
			qnaList(request, response, out);

		} else if(command.equals("qna_write"))	{			//[Q&A 목록] 글쓰기버튼 클릭시
			qnaWrite(request, response, out);

		} else if(command.equals("insert_qna"))	{			//[Q&A 글쓰기] Q&A 작성 후 완료 클릭시
			insertQna(request, response, out);

		} else if(command.equals("qna_detail"))	{			//[Q&A 목록] 제목 클릭시
			qnaDetail(request, response, out);	

		} else if(command.equals("qnaDelete")) {			//[Q&A 삭제] 삭제 클릭시
			qnaDelete(request, response, out);	

		} else if(command.equals("update_qna"))	{			//[Q&A 수정]	수정완료 클릭시
			qnaUpdate(request, response, out);

		} else if(command.equals("qna_reply_write")) {		//[Q&A 답글 등록] 
			qnaRplInsert(request, response, out);

		} else if(command.equals("qna_reply_update")) {		//[Q&A 답글 수정] 
			qnaRplUpdate(request, response, out);

		} else if(command.equals("checkQnaPass"))	{		//[Q&A]	비밀글 글쓴이가 클릭, 비밀번호 입력 후 확인
			checkQnaPass(request, response, out);

		} else if(command.equals("openPassChk"))	{		//[Q&A] 제목 클릭시 자식창 열기
			openPassChk(request, response, out);
		} else if(command.equals("qna_list_my"))   {      //[Q&A] 내가 쓴 글 모아보기
	         qnaListMy(request, response, out);
	      }
		
		out.close();

	}

	private void likeClick(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		String likeName = request.getParameter("clubNo"); // 이친구 이름만 나중에 바꿔주면됨
		String likeYN = request.getParameter("likeYN");
		String memberNo = userNo; // 좋아요 누른 사람
		String clubNo = clubDao.searchClubNo(likeName);
        String classNo = classDao.searchClassNo(likeName);
		int res = 0; // 리턴값
		likeDao likeDao = new likeDao();

		System.out.println("memberNo : " + memberNo + " LikeName : " + likeName  + " likeYN : " + likeYN);
		
		
		if(likeYN.equals("Y")) {
			// 좋아요 누른상태에서 클릭 => 좋아요 제거
			// 점수에서 -1
			System.out.println("좋아요 제거 실행");
			res = likeDao.deleteLike(memberNo, likeName);
			if(res > 0) {
				ClubVo cbvo = clubDao.selectOne(clubNo);
				int clubScore = cbvo.getClubScore();
				ClassVo csvo = classDao.classSelectOne(classNo);
				int classScore = Integer.parseInt(csvo.getClassScore());
				MypageVo mvo = memberDao.selectOne(memberNo);
				int memberScore = mvo.getMemberScore();
				
				int res2 = memberDao.updateMemberScore(memberScore-1, memberNo);
				int res3 = clubDao.updateClubScore(clubScore-1, clubNo);
	            int res4 = classDao.updateClassScore(classScore-1, classNo);

	            if (res2 > 0) {
		               System.out.println("멤버 점수 업데이트 성공!");
		            } else {
		               System.out.println("멤버 점수 업데이트 실패!");
		            }

		        if (res3 > 0 || res4 > 0) {
		            System.out.println("모임or수업 점수 업데이트 성공!");
		        } else {
		        	System.out.println("모임or수업 점수 업데이트 실패!");
		        }
				
				System.out.println("좋아요 제거");
				out.println(res);
			} else {
				System.out.println("좋아요 제거 실패");
				out.println(res);
			}
		} else{
			// 좋아요가 안눌린 상태에서 클릭 => 좋아요 삽입
			// 점수에서 +1
			System.out.println("좋아요 삽입 실행");
			res = likeDao.insertLike(memberNo, likeName);
			if(res > 0) {
				System.out.println("좋아요 삽입");
				int score = 1;

	            MemberDao memberDao = new MemberDao();
	            int res2 = memberDao.updateMemberScore(score, userNo);

	            ClubDao clubDao = new ClubDao();
	            
	            int res3 = clubDao.updateClubScore(score, clubNo);
	            int res4 = classDao.updateClassScore(score, classNo);

	            if (res2 > 0) {
	               System.out.println("멤버 점수 업데이트 성공!");
	            } else {
	               System.out.println("멤버 점수 업데이트 실패!");
	            }

	            if (res3 > 0 || res4 > 0) {
		            System.out.println("모임or수업 점수 업데이트 성공!");
		        } else {
		        	System.out.println("모임or수업 점수 업데이트 실패!");
		        }
				out.println(res);

			} else {
				System.out.println("좋아요 삽입 실패");
				out.println(res);
			}
		}
		
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);

		return;
	}

	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClubDao clubDao = new ClubDao();
		List<ClubListVo> clubList = clubDao.clubSelectAll();
		request.setAttribute("clubList", clubList);
		System.out.println(clubList.toString());

		ClassDao ClassDao = new ClassDao();
		List<ClassListVo> classList = ClassDao.classSelectAll();
		request.setAttribute("classList", classList);
		System.out.println(classList.toString());

		HttpSession session = request.getSession(true);
		String memberNo = (String) session.getAttribute("userNo");

		String memberCategoryNo = clubDao.searchCategoryNo(memberNo);
		System.out.println("memberNo: " + memberCategoryNo);

		List<ClubListVo> recommendedClubList = clubDao.recommendedClubList(memberCategoryNo);
		request.setAttribute("recommendedClubList", recommendedClubList);
		System.out.println(recommendedClubList.toString());
		
		ClubReviewDao clubReviewDao = new ClubReviewDao();
	    List<ClubReviewListVo> reviewClubListTopSix = clubReviewDao.clubReviewSelectTopSix();
	    request.setAttribute("reviewClubListTopSix", reviewClubListTopSix);
	    System.out.println(reviewClubListTopSix.toString());

		dispatch("main.jsp", request, response);
	}

	private void processLogin(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException, ServletException {

		String id = request.getParameter("userId"); // login 시 입력한 id
		String pwd = request.getParameter("userpwd"); // login 시 입력한 pwd

		if (id == null || pwd == null) { // id와 pwd가 비어있으면 login 페이지를 다시 띄움
			response.sendRedirect("login.jsp");

		} else { // id와 pwd가 비어있지 않으면

			// id와 pwd를 가지고 memberDao로 보냄 -> memberDao에서 검사를 끝낸 후 id와 pwd를 객체에 담아서 리턴
			MemberDao memberDao = new MemberDao();
			MemberVo member = memberDao.login(id, pwd);

			// 아이디가 없을 경우
			if (member == null) {

				out.print("<script type='text/javascript'>");
				out.print("alert('존재하지 않는 아이디입니다.');");
				out.print("location.href='login.jsp'");
				out.print("</script>");
				out.flush();

				System.out.println("아이디가 없어 로그인 실패");

				// id는 있는데 password가 틀린 경우
			} else if (isEmpty(member.getMemberId()) && !isEmpty(member.getMemberPwd())) {
				out.print("<script type='text/javascript'>");
				out.print("alert('잘못된 비밀번호입니다.');");
				out.print("location.href='login.jsp'");
				out.print("</script>");
				out.flush();

				System.out.println("비밀번호 오류로 로그인 실패");

			} else {
				// 성공적으로 로그인
				HttpSession session = request.getSession(true);

				// session이 새로 생성되었거나, session의 userId가 null이면(=해당 계정으로 이미 로그인 되어있지 않으면)
				if (session.isNew() || session.getAttribute("userId") == null) {

					// 세션에 id를 세팅
					session.setAttribute("userId", member.getMemberId());
					session.setAttribute("userNo", member.getMemberNo());

					userNo = (String) (session.getAttribute("userNo"));
					userId = (String) (session.getAttribute("userId"));

					System.out.println(userNo);

					System.out.println("로그인 성공");

					// 로그인하면 메인페이지로 이동
					main(request, response);

				} else {
					// 이미 생성된 session이 있으면 해당 계정으로 이미 로그인 하고 있는 것이므로 로그인 실패
					out.print("<script type='text/javascript'>");
					out.print("alert('해당 계정은 이미 로그인 중입니다.');");
					out.print("location.href='login.jsp'");
					out.print("</script>");
					out.flush();

					System.out.println("이미 로그인 중인 세션");
				}
			}
		}
	}

	private void processLogout(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession(false);

		// 해당 session이 null이 아니면(=해당 계정으로 로그인한 상태이면)
		if (session != null && session.getAttribute("userId") != null) {

			// 세션 만료
			session.invalidate();

			System.out.println(userNo);

			// 로그아웃하면 메인페이지로 이동
			main(request, response);

			System.out.println("로그아웃 성공");
		}
	}

	private void searchId(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws ServletException, IOException {

		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");

		MemberDao memberDao = new MemberDao();
		String memberId = memberDao.searchId(memberName, email);

		if (!isEmpty(memberId)) {
			out.write("1");
		} else {
			out.write(memberId);
		}

		out.flush();
	}

	private void searchPwd(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {

		String memberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String email = request.getParameter("email");

		System.out.println(memberName);
		System.out.println(memberId);
		System.out.println(email);

		MemberDao memberDao = new MemberDao();
		String memberPwd = memberDao.searchPwd(memberName, memberId, email);

		if (!isEmpty(memberPwd)) {
			out.write("1");
		} else {
			System.out.println(memberPwd);
			out.write(memberPwd);
		}

		out.flush();
	}

	private void processIdCheck(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {

		String id = request.getParameter("memberId");

		if (id == null) {
			out.write("2");
			out.flush();
			return;
		}

		MemberDao memberDao = new MemberDao();

		String checkedId = memberDao.selectId(id);

		if (checkedId == null) {
			out.write("1");

		} else {
			out.write("0");
		}

		out.flush();
	}

	private void processSignup(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {

		final String filePath = "img/memberProfile_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String memberId = multi.getParameter("memberId");

			System.out.println(memberId);

			String memberPwd = multi.getParameter("memberPwd");
			String memberName = multi.getParameter("memberName");
			String birthday = multi.getParameter("birthday");
			String gender = multi.getParameter("gender");
			String email = multi.getParameter("email");
			String phone = multi.getParameter("phone");
			String memberAddress = multi.getParameter("memberAddress");
			String memberPicture = multi.getFilesystemName("memberPicture");

			MemberVo member = new MemberVo();
			member.setMemberId(memberId);
			member.setMemberPwd(memberPwd);
			member.setMemberName(memberName);
			member.setBirthday(birthday);
			member.setGender(gender);
			member.setEmail(email);
			member.setPhone(phone);
			member.setMemberAddress(memberAddress);
			member.setMemberPicture(memberPicture);

			System.out.println("pictureURL : " + memberPicture);

			MemberDao memberDao = new MemberDao();
			int res = memberDao.signup(member);

			if (res > 0) {
				response.sendRedirect("login.jsp");

				System.out.println("회원가입 성공");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('회원가입 실패');");
				out.print("</script>");
				out.flush();

				System.out.println("회원가입 실패");
			}

		} else {
			System.out.println("실패");
		}

	}

	private void showMypage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userNo = (String) session.getAttribute("userNo");

		MypageVo mypage = memberDao.selectOne(userId);
		List<MyClubListVo> myClubList = clubDao.myClubList(userNo);

		TutorVo tutor = memberDao.tutorInfo(userNo);
		List<MyClassListVo> myClassList = classDao.myClassList(userNo);
		System.out.println("myClassList : " + myClassList);

		String tutorYN = memberDao.selectTutorYN(userNo);
		
		request.setAttribute("mypage", mypage);
		request.setAttribute("myClubList", myClubList);
		request.setAttribute("tutor", tutor);
		request.setAttribute("myClassList", myClassList);
		request.setAttribute("tutorYN", tutorYN);

		dispatch("mypage.jsp", request, response);
	}

	private void updateMypage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String filePath = "img/memberProfile_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String memberPwd = (String) multi.getParameter("memberPwd");
			String email = (String) multi.getParameter("email");
			String phone = (String) multi.getParameter("phone");
			String memberAddress = (String) multi.getParameter("memberAddress");
			String memberPicture = (String) multi.getFilesystemName("memberPicture");
			String categoryName = (String) multi.getParameter("categoryName");

			String memberPicture2 = (String) multi.getParameter("memberPicture_or");

			System.out.println("pictureURL : " + multi.getFilesystemName("memberPicture"));

			MypageVo mypage = new MypageVo();
			mypage.setMemberPwd(memberPwd);
			mypage.setEmail(email);
			mypage.setPhone(phone);
			mypage.setMemberAddress(memberAddress);
			mypage.setCategoryName(categoryName);

			if (memberPicture == null) {
				mypage.setMemberPicture(memberPicture2);
			} else {
				mypage.setMemberPicture(memberPicture);
			}

			MemberDao memberDao = new MemberDao();
			int res = memberDao.updateMypage(mypage, userId);
			int res2 = memberDao.updateMyCategory(mypage, userId);

			if (res > 0 && res2 > 0) {
				System.out.println("업데이트 성공");
				showMypage(request, response);

			} else {
				System.out.println("업데이트 실패");
			}

		} else {
			System.out.println("실패");
		}
	}

	private void registerTutor(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {

		String id = request.getParameter("memberId");
		System.out.println("id : " + id);

		MemberDao memberDao = new MemberDao();
		int res = memberDao.registerTutor(id);

		if (res > 0) {
			out.write("1");
			System.out.println("1");

		} else {
			out.write("0");
			System.out.println("0");
		}

		out.flush();
	}

	private void uploadTutorFile(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		final String filePath = "img/tutorFile_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userNo = (String) session.getAttribute("userNo");

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			TutorVo tutor = new TutorVo();
			String education = (String) multi.getFilesystemName("education");
			String experience = (String) multi.getFilesystemName("work_experience");
			String certificate = (String) multi.getFilesystemName("certificate");
			String tutorIntroduce = (String) multi.getParameter("tutorIntroduce");

			String education2 = (String) multi.getParameter("education_or");
			String experience2 = (String) multi.getParameter("work_experience_or");
			String certificate2 = (String) multi.getParameter("certificate_or");

			System.out.println(multi.getFilesystemName("education"));
			System.out.println(multi.getFilesystemName("work_experience"));
			System.out.println(multi.getFilesystemName("certificate"));
			System.out.println(multi.getParameter("tutorIntroduce"));

			if (education == null) {
				tutor.setEducationFile(education2);
			} else {
				tutor.setEducationFile(education);
			}

			if (experience == null) {
				tutor.setExperienceFile(experience2);
			} else {
				tutor.setExperienceFile(experience);
			}

			if (certificate == null) {
				tutor.setCertificateFile(certificate2);
			} else {
				tutor.setCertificateFile(certificate);
			}

			tutor.setTutorIntroduce(tutorIntroduce);
			System.out.println("tutor : " + tutor);

			MemberDao memberDao = new MemberDao();
			int res = memberDao.updateTutor(tutor, userNo);
			System.out.println(res);

			if (res > 0) {
				System.out.println("업데이트 성공");
				showMypage(request, response);

			} else {
				System.out.println("업데이트 실패");
			}
		} else {
			System.out.println("실패");
		}

	}

	private void clubList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClubDao clubDao = new ClubDao();
		List<ClubListVo> clubList = clubDao.clubSelectAll();

		System.out.println(clubList.toString());

		request.setAttribute("clubList", clubList);

		dispatch("club_search.jsp", request, response);
	}

	private void classList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClassDao ClassDao = new ClassDao();
		List<ClassListVo> classList = ClassDao.classSelectAll();

		System.out.println(classList.toString());

		request.setAttribute("classList", classList);

		dispatch("class_search.jsp", request, response);
	}

	private void selectedClubList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String selectedClubLocation = request.getParameter("selectedClubLocation");
		String selectedClubCategory = request.getParameter("selectedClubCategory");
		String selectedClubSort = request.getParameter("selectedClubSort");

		System.out.println("selectedClubLocation=" + selectedClubLocation);
		System.out.println("selectedClubCategory=" + selectedClubCategory);
		System.out.println("selectedClubSort=" + selectedClubSort);

		ClubDao clubDao = new ClubDao();
		List<ClubListVo> clubList = clubDao.selectedClubList(selectedClubLocation, selectedClubCategory,
				selectedClubSort);

		System.out.println(clubList.toString());

		request.setAttribute("clubList", clubList);

		dispatch("club_search.jsp", request, response);
	}

	private void selectedClassList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String selectedClassLocation = request.getParameter("selectedClassLocation");
		String selectedClassCategory = request.getParameter("selectedClassCategory");
		String selectedClassSort = request.getParameter("selectedClassSort");

		System.out.println("selectedClassLocation=" + selectedClassLocation);
		System.out.println("selectedClassCategory=" + selectedClassCategory);
		System.out.println("selectedClassSort=" + selectedClassSort);

		ClassDao classDao = new ClassDao();
		List<ClassListVo> classList = classDao.selectedClassList(selectedClassLocation, selectedClassCategory,
				selectedClassSort);

		System.out.println(classList.toString());

		request.setAttribute("classList", classList);

		dispatch("class_search.jsp", request, response);
	}

	private void searchedList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchedWord = request.getParameter("searchedWord");
		System.out.println("searchedList: " + searchedWord);

		ClubDao clubDao = new ClubDao();
		List<ClubListVo> searchedClubList = clubDao.searchedClubList(searchedWord);
		request.setAttribute("searchedList", searchedClubList);
		System.out.println(searchedClubList.toString());

		ClassDao classDao = new ClassDao();
		List<ClassListVo> searchedClassList = classDao.searchedClassList(searchedWord);
		request.setAttribute("searchedClassList", searchedClassList);
		System.out.println(searchedClassList.toString());

		dispatch("search_list.jsp", request, response);
	}

	private void club_detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String clubNo = request.getParameter("clubNo");

		ClubVo vo = clubDao.selectOne(clubNo);
		List<ClubMemberVo> list = clubDao.clubMeberList(clubNo);
		ClubMemberVo cmvo = clubDao.selectClubMember(clubNo, userNo);
		LikeVo lvo = likeDao.selectLike(clubNo, userNo);
		List<ClubClassVo> ClubClassList = classDao.ClubClassList(clubNo); // 모임이 신청한 클럽 리스트. 이름만 가져오기...
		

		int sizeList = list.size();
		String size = Integer.toString(sizeList);
		
		int cnt = 0;
		int cnt2 = 0;
		
		for (int i = 0; i < sizeList; i++) {
			if(list.get(i).getAllowYN().equals("Y")) {
				cnt += 1;
			} else {
				cnt2 += 1;
			}
		}
		
		String count = Integer.toString(cnt);
		String count2 = Integer.toString(cnt2);
		
		request.setAttribute("cnt2", count2); // 가입신청중인 애들.
		request.setAttribute("clubVo", vo); // club 기본 정보
		request.setAttribute("cmList", list); // 가입된 회원, 신청중인 회원 리스트
		request.setAttribute("cnt", count); // 현재 가입되어있는 인원 수
		request.setAttribute("cmvo", cmvo); // 현재 로그인한 회원의 클럽 가입 여부
		request.setAttribute("likeVo", lvo); // 좋아요 여부 및 count
		request.setAttribute("myClassList", ClubClassList); // ClassList

		dispatch("club_detail.jsp", request, response);
	}

	private void club_insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String filePath = "img/club_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());
			ClubVo clubvo = new ClubVo();

			String clubPicUrl = multi.getFilesystemName("club_picture");
			String clubName = multi.getParameter("club_name");
			String clubCate = multi.getParameter("category");
			String clubLoc = multi.getParameter("club_location");
			String clubCont = multi.getParameter("club_content");
			int clubtotal = Integer.parseInt(multi.getParameter("club_total"));
			String clubManager = userNo;

			clubvo.setClubName(clubName);
			clubvo.setClubCategoryNo(clubCate);
			clubvo.setClubAddress(clubLoc);
			clubvo.setClubPicture(clubPicUrl);
			clubvo.setClubContent(clubCont);
			clubvo.setManagerNo(clubManager);
			clubvo.setClubTotal(clubtotal);

			System.out.println("pictureURL : " + clubPicUrl);
			System.out.println(clubCate);

			int res = clubDao.insertClub(clubvo);

			if (res > 0) {
				// 생성 성공
				System.out.println("클럽 생성 성공");
				String clubNo = clubDao.searchClubNo(clubName);
				System.out.println(clubNo);
				int res2 = clubDao.clubMember_insert2(clubManager, clubNo);
				if (res2 > 0) {
					System.out.println("멤버리스트에 모임장 추가 완료");
				} else {
					System.out.println("멤버리스트에 모임장 추가 실패");
				}
				
				int score = 15; // 회원에게 추가되는 점수
				int score2 = 10; //모임에게 추가되는 점수

				int result = memberDao.updateMemberScore(score, userNo);
				int result2 = clubDao.updateClubScore(score2, clubNo);

				if (result > 0) {
					System.out.println("멤버 점수 업데이트 성공!");
				} else {
					System.out.println("멤버 점수 업데이트 실패!");
				}

				if (result2 > 0) {
					System.out.println("모임 점수 업데이트 성공!");
				} else {
					System.out.println("모임 점수 업데이트 실패!");
				}

				// 완료되면 만들어진 클럽으로 넘어가야함.
				dispatch("momo.do?command=club_detail&clubNo=" + clubNo, request, response);

			} else {
				dispatch("main.jsp", request, response);
				System.out.println("일반 폼 ");
				// 생성실패
			}
		} else {
			System.out.println("실패");
		}
	}

	private void clubMember_insert(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String clubNo = request.getParameter("clubNo");

		System.out.println("clubNo : " + clubNo + "memberNo : " + userNo);

		ClubMemberVo cMemberVo = new ClubMemberVo();
		cMemberVo.setMemberNo(userNo);
		cMemberVo.setClubNo(clubNo);

		int res = clubDao.clubMember_insert(userNo, clubNo);

		if (res > 0) {
			response.sendRedirect("momo.do?command=club_detail&clubNo=" + clubNo);
		} else {
			response.sendRedirect("main.jsp");
		}

	}

	private void club_update(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {

		final String filePath = "img/club_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인,
																			// multipart로 오는지.

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String clubNo = multi.getParameter("clubNo");
			String club_content = multi.getParameter("club_content");
			String clubCategoryNo = multi.getParameter("category");
			String openYN = multi.getParameter("openYN");
			String recuritYN = multi.getParameter("recuritYN");
			String clubAddr = multi.getParameter("club_addr");
			int clubTotal = Integer.parseInt(multi.getParameter("total"));
			String club_picture = multi.getParameter("club_picture"); // 이미지 url
			if (club_picture == null) {
				club_picture = multi.getFilesystemName("club_picture");
			}
			ClubVo vo = new ClubVo(clubNo, clubCategoryNo, clubTotal, openYN, recuritYN, clubAddr, club_content,
					club_picture);

			System.out.println("넘어온 값 : " + vo);

			int res = clubDao.clubUpdate(vo);

			if (res > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('수정 성공!!!');");
				out.print("</script>");
				out.flush();
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('수정오류입니다.');");
				out.print("</script>");
				out.flush();
			}
		} else {
			System.out.println("POST 방식이 아니거나 전송타입 오류입니다. 확인해주세요");
		}
	}

	private void clubMember_kick(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		String kickUserNo = request.getParameter("kickUserNo");
		String clubNo = request.getParameter("clubNo");

		System.out.println(kickUserNo + clubNo);

		int res = clubDao.kickMember(kickUserNo, clubNo);

		if (res > 0) {
			System.out.println("성공 ajax로 data 리턴!");
			out.println(res);
		} else {
			System.out.println("실패...");
			out.println(res);
		}
	}

	private void clubMember_cancel(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		String clubNo = request.getParameter("clubNo");
		System.out.println(clubNo);
		int res = clubDao.joinCancel(userNo, clubNo);

		if (res > 0) {
			out.println(res);
		} else {
			System.out.println("가입취소 실패");
		}
	}

	private void clubMember_reject(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		String rejectMemberNo = request.getParameter("rejectMember");
		String clubNo = request.getParameter("clubNo");

		System.out.println(rejectMemberNo + clubNo);

		int res = clubDao.rejMember(rejectMemberNo, clubNo);

		if (res > 0) {
			System.out.println("성공");
			out.println(res);
		} else {
			System.out.println("실패");
			out.println(res);
		}

	}

	private void clubNameChk(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		String clubName = request.getParameter("clubName");

		System.out.println("사용자가 입력한 ClubName : " + clubName);

		int res = clubDao.clubNameChk(clubName);

		if (res > 0) {
			out.println(res);
		}

	}

	private void reviewClubList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClubReviewDao clubReviewDao = new ClubReviewDao();
		List<ClubReviewListVo> reviewClubList = clubReviewDao.clubReviewSelectAll();

		System.out.println(reviewClubList.toString());

		request.setAttribute("reviewClubList", reviewClubList);

		dispatch("review_club.jsp", request, response);

	}

	private void reviewClassList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClassReviewDao classReviewDao = new ClassReviewDao();
		List<ClassReviewListVo> reviewClassList = classReviewDao.classReviewSelectAll();

		System.out.println(reviewClassList.toString());

		request.setAttribute("reviewClassList", reviewClassList);

		dispatch("review_class.jsp", request, response);

	}

	private void reviewIdClubCk(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException, ServletException {
		if (userId == null || userId == "") {
			response.sendRedirect("login.jsp");
		} else {
			dispatch("review_write_club.jsp", request, response);
		}

	}

	private void reviewIdClassCk(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException, ServletException {
		if (userId == null || userId == "") {
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("로그인되어있음, 아이디체크.");
			response.sendRedirect("review_write_class.jsp");
		}

	}

	private void reviewClubDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noClubReview = (String) request.getParameter("noClubReview");
		System.out.println("noClubReview: " + noClubReview);

		ClubReviewDao clubReviewDao = new ClubReviewDao();
		ClubReviewVo clubReviewDetail = clubReviewDao.clubReviewDetail(noClubReview);

		System.out.println(clubReviewDetail);
		
		LikeVo lvo = likeDao.selectLike(noClubReview, userNo);
		request.setAttribute("likeVo", lvo); 						// 좋아요 여부 및 count
		request.setAttribute("clubReviewDetail", clubReviewDetail);

		dispatch("review_detail_club.jsp", request, response);
	}

	private void reviewClubDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String clubReviewNo = request.getParameter("clubReviewNo");
		System.out.println("clubReviewNo: " + clubReviewNo);

		ClubReviewDao clubReviewDao = new ClubReviewDao();
		int res = clubReviewDao.clubReviewDelete(clubReviewNo);

		if (res > 0) {
			dispatch("momo.do?command=reviewClubList", request, response);
		} else {
			dispatch("momo.do?command=clubReviewDetail&noClubReview=" + clubReviewNo, request, response);
		}
	}

	private void reviewClassDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String classReviewNo = request.getParameter("classReviewNo");
		System.out.println("classReviewNo: " + classReviewNo);

		ClassReviewDao classReviewDao = new ClassReviewDao();
		int res = classReviewDao.classReviewDelete(classReviewNo);

		if (res > 0) {
			dispatch("momo.do?command=reviewClassList", request, response);
		} else {
			dispatch("momo.do?command=classReviewDetail&noClassReview=" + classReviewNo, request, response);
		}

	}

	private void reviewClassDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noClassReview = request.getParameter("noClassReview");
		System.out.println("noClassReview: " + noClassReview);

		ClassReviewDao classReviewDao = new ClassReviewDao();
		ClassReviewVo classReviewDetail = classReviewDao.classReviewDetail(noClassReview);

		System.out.println(classReviewDetail);
		
		LikeVo lvo = likeDao.selectLike(noClassReview, userNo);
		request.setAttribute("likeVo", lvo); 						// 좋아요 여부 및 count
		request.setAttribute("classReviewDetail", classReviewDetail);

		dispatch("review_detail_class.jsp", request, response);

	}

	private void findClubName(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {

		String jsonData = request.getParameter("jsonParameter");
		System.out.println("jsonData = " + jsonData);

		JSONObject json = (JSONObject) JSONValue.parse(jsonData);
		String clubName = (String) json.get("clubName");
		System.out.println(clubName);

		ClubDao clubDao = new ClubDao();
		List<ClubListVo> clubList = clubDao.searchedClubList(clubName);
		System.out.println(clubList);

		if (clubList != null && !clubList.isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < clubList.size(); i++) {
				JSONObject data = new JSONObject();
				data.put("clubName", clubList.get(i).getClubName());
				jsonArray.add(i, data);
			}
			JSONObject obj = new JSONObject();
			obj.put("clubList", jsonArray);
			out.write(obj.toJSONString());
		} else {
			out.write("");
		}
	}

	private void writeClubReview(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException, ServletException {

		final String filePath = "img/clubReview_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userNo = (String) session.getAttribute("userNo");

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String clubReviewTitle = multi.getParameter("reviewTitle");
			String clubName = multi.getParameter("clubName");
			String clubReviewContent = multi.getParameter("reviewContent");
			String clubReviewPicture = multi.getFilesystemName("reviewPicture");

			ClubReviewVo clubReview = new ClubReviewVo(clubName, clubReviewTitle, userNo, userId, clubReviewContent,
					clubReviewPicture);

			ClubReviewDao clubReviewDao = new ClubReviewDao();
			int res = clubReviewDao.writeClubReview(clubReview);

			if (res > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 작성 완료!!!');");
				out.print("</script>");

				////////////////////////////////////
				int score = 3;

				MemberDao memberDao = new MemberDao();
				int res2 = memberDao.updateMemberScore(score, userNo);

				ClubDao clubDao = new ClubDao();
				String clubNo = clubDao.searchClubNo(clubName);
				int res3 = clubDao.updateClubScore(score, clubNo);

				if (res2 > 0) {
					System.out.println("멤버 점수 업데이트 성공!");
				} else {
					System.out.println("멤버 점수 업데이트 실패!");
				}

				if (res3 > 0) {
					System.out.println("모임 점수 업데이트 성공!");
				} else {
					System.out.println("모임 점수 업데이트 실패!");
				}
				////////////////////////////////////

				reviewClubList(request, response);
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 작성 실패!!!');");
				out.print("</script>");
			}

			out.flush();

		} else {
			System.out.println("실패");
		}
	}

	private void showClubReviewUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("함수들어와버림");

		String clubReviewNo = request.getParameter("clubReviewNo");
		System.out.println("clubReviewNo: " + clubReviewNo);

		ClubReviewDao clubReviewDao = new ClubReviewDao();
		ClubReviewVo clubReview = clubReviewDao.selectOne(clubReviewNo);

		if (clubReview != null) {
			request.setAttribute("clubReview", clubReview);
			dispatch("review_update_club.jsp", request, response);
		}
	}

	private void updateClubReview(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException, ServletException {

		final String filePath = "img/clubReview_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userNo = (String) session.getAttribute("userNo");

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String clubReviewNo = multi.getParameter("reviewNo");
			String clubReviewTitle = multi.getParameter("reviewTitle");
			String clubName = multi.getParameter("clubName");
			String clubReviewContent = multi.getParameter("reviewContent");
			String clubReviewPicture = multi.getFilesystemName("reviewPicture");

			String clubReviewPicture2 = (String) multi.getParameter("reviewPicture_or");

			System.out.println("pictureURL : " + multi.getFilesystemName("clubReviewPicture"));

			ClubReviewVo clubReview = new ClubReviewVo();
			clubReview.setClubReviewNo(clubReviewNo);
			clubReview.setClubReviewTitle(clubReviewTitle);
			clubReview.setClubName(clubName);
			clubReview.setClubReviewContent(clubReviewContent);

			if (clubReviewPicture == null) {
				clubReview.setClubReviewPicture(clubReviewPicture2);
			} else {
				clubReview.setClubReviewPicture(clubReviewPicture);
			}

			ClubReviewDao clubReviewDao = new ClubReviewDao();
			int res = clubReviewDao.updateClubReview(clubReview);

			if (res > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 수정 완료!!!');");
				out.print("</script>");

				reviewClubList(request, response);

			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 수정 실패!!!');");
				out.print("</script>");
			}

			out.flush();

		} else {
			System.out.println("실패");
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void findClassName(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {

		String jsonData = request.getParameter("jsonParameter");
		System.out.println("jsonData = " + jsonData);

		JSONObject json = (JSONObject) JSONValue.parse(jsonData);
		String className = (String) json.get("className");
		System.out.println(className);

		ClassDao classDao = new ClassDao();
		List<ClassListVo> classList = classDao.searchedClassList(className);
		System.out.println(classList);

		if (classList != null && !classList.isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < classList.size(); i++) {
				JSONObject data = new JSONObject();
				data.put("className", classList.get(i).getClassName());
				jsonArray.add(i, data);
			}
			JSONObject obj = new JSONObject();
			obj.put("classList", jsonArray);
			out.write(obj.toJSONString());
		} else {
			out.write("");
		}
	}

	private void writeClassReview(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException, ServletException {

		final String filePath = "img/classReview_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		HttpSession session = request.getSession();

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String classReviewTitle = multi.getParameter("reviewTitle");
			String className = multi.getParameter("className");
			String classReviewContent = multi.getParameter("reviewContent");
			String classReviewPicture = multi.getFilesystemName("reviewPicture");

			ClassReviewVo classReview = new ClassReviewVo(className, classReviewTitle, userNo, userId,
					classReviewContent, classReviewPicture);

			ClassReviewDao classReviewDao = new ClassReviewDao();
			int res = classReviewDao.writeClassReview(classReview);

			if (res > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 작성 완료!!!');");
				out.print("</script>");

				////////////////////////////////////
				int score = 3;

				MemberDao memberDao = new MemberDao();
				int res2 = memberDao.updateMemberScore(score, userNo);

				ClassDao classDao = new ClassDao();
				String classNo = classDao.searchClassNo(className);
				int res3 = classDao.updateClassScore(score, classNo);

				if (res2 > 0) {
					System.out.println("멤버 점수 업데이트 성공!");
				} else {
					System.out.println("멤버 점수 업데이트 실패!");
				}

				if (res3 > 0) {
					System.out.println("수업 점수 업데이트 성공!");
				} else {
					System.out.println("수업 점수 업데이트 실패!");
				}
				////////////////////////////////////

				reviewClassList(request, response);
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 작성 실패!!!');");
				out.print("</script>");
			}

			out.flush();

		} else {
			System.out.println("실패");
		}
	}

	private void showClassReviewUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("함수들어와버림");

		String classReviewNo = request.getParameter("classReviewNo");
		System.out.println("classReviewNo: " + classReviewNo);

		ClassReviewDao classReviewDao = new ClassReviewDao();
		ClassReviewVo classReview = classReviewDao.selectOne(classReviewNo);

		if (classReview != null) {
			request.setAttribute("classReview", classReview);
			dispatch("review_update_class.jsp", request, response);
		}
	}

	private void updateClassReview(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException, ServletException {

		final String filePath = "img/classReview_img/"; // 이미지가 저장될 위치
		int maxSize = 3 * (1024 * 1024); // 3MB
		String encoding = "utf-8"; // 파일 인코딩

		String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
		System.out.println("절대 경로 : " + saveDir);

		File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
		if (!upDir.exists()) {
			upDir.mkdirs();
		}

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userNo = (String) session.getAttribute("userNo");

		boolean isMulti = ServletFileUpload.isMultipartContent(request); // boolean 타입으로 넘어오는 Form태그의 전송방식을 확인

		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String classReviewNo = multi.getParameter("reviewNo");
			String classReviewTitle = multi.getParameter("reviewTitle");
			String className = multi.getParameter("className");
			String classReviewContent = multi.getParameter("reviewContent");
			String classReviewPicture = multi.getFilesystemName("reviewPicture");

			String classReviewPicture2 = (String) multi.getParameter("reviewPicture_or");

			System.out.println("pictureURL : " + multi.getFilesystemName("clubReviewPicture"));

			ClassReviewVo classReview = new ClassReviewVo();
			classReview.setClassReviewNo(classReviewNo);
			classReview.setClassReviewTitle(classReviewTitle);
			classReview.setClassName(className);
			classReview.setClassReviewContent(classReviewContent);

			if (classReviewPicture == null) {
				classReview.setClassReviewPicture(classReviewPicture2);
			} else {
				classReview.setClassReviewPicture(classReviewPicture);
			}

			ClassReviewDao classReviewDao = new ClassReviewDao();
			int res = classReviewDao.updateClassReview(classReview);

			if (res > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 수정 완료!!!');");
				out.print("</script>");

				reviewClassList(request, response);

			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('리뷰 수정 실패!!!');");
				out.print("</script>");
			}

			out.flush();

		} else {
			System.out.println("실패");
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void noticeList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("dddddddddddddddddddddddddd");

		NoticeDao dao = new NoticeDao();

		int page = 1;// 페이지 디폴트를 1

		String test = request.getParameter("page");
		System.out.println("--------------------request의 page-------------------" + test);

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		} // 이거 없으면 넘어가지 않음

		System.out.println(page + "===================");

		int count = dao.countNotice();
		System.out.println(count + "dddddd");

		PagingVo paging = new PagingVo();// 페이지 객체 생성

		paging.setPage(page);// 페이징
		paging.setStartNum(page);// 페이징
		paging.setEndNum(page);// 페이징
		paging.setTotalCount(count);// 페이징

		System.out.println(paging);

		List<NoticeVo> noticeList = dao.selectAll(paging);// 리스트 전부 출력

		for (NoticeVo n : noticeList) {
			System.out.println(n);
		}

		String sysdate = dao.sysdate();
		request.setAttribute("sysdate", sysdate);
		// System.out.println(sysdate);

		request.setAttribute("noticeList", noticeList);
		System.out.println(noticeList);
		request.setAttribute("paging", paging);// 페이징
		dispatch("notice.jsp", request, response);

		NoticeVo vo = new NoticeVo();
		int noNotice = 0;
		vo = dao.selectOne(noNotice);

		int res = dao.update(vo);

	}

	private void noticeInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeDao dao = new NoticeDao();

		String titleNotice = request.getParameter("titleNotice");
		String contentNotice = request.getParameter("contentNotice");

		System.out.println(titleNotice);// 지우는거 가능 콘솔에 확인해보려고 썼음
		System.out.println(contentNotice);

		NoticeVo vo = new NoticeVo();

		vo.setTitleNotice(titleNotice);

		vo.setContentNotice(contentNotice);

		int res = dao.insert(vo);

		if (res > 0) {
			dispatch("momo.do?command=noticeList", request, response);
		} else {
			dispatch("momo.do?command=noticewrite", request, response);
		}

	}

	private void noticeDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noNotice = Integer.parseInt(request.getParameter("noNotice"));
		System.out.println(noNotice);

		NoticeDao dao = new NoticeDao();
		NoticeVo vo = new NoticeVo();

		vo = dao.selectOne(noNotice);

		System.out.println(vo);

		request.setAttribute("vo", vo);

		int res = dao.hitNotice(vo);

		dispatch("notice_detail.jsp", request, response);

	}

	private void noticeUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("noNotice"));
		int noNotice = Integer.parseInt(request.getParameter("noNotice"));

		NoticeDao dao = new NoticeDao();
		NoticeVo vo = dao.selectOne(noNotice);

		request.setAttribute("vo", vo);

		dispatch("notice_update.jsp", request, response);

	}

	private void noticeUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noNotice = Integer.parseInt(request.getParameter("noNotice"));
		String titleNotice = request.getParameter("titleNotice");
		String contentNotice = request.getParameter("contentNotice");

		System.out.println("title: " + titleNotice);
		System.out.println("content: " + contentNotice);

		NoticeVo vo = new NoticeVo();

		vo.setNoNotice(noNotice);
		vo.setTitleNotice(titleNotice);
		vo.setContentNotice(contentNotice);

		NoticeDao dao = new NoticeDao();

		int res = dao.update(vo);

		if (res > 0) {
			dispatch("momo.do?command=noticeList", request, response);
		} else {
			dispatch("momo.do?command=noticeDetail&noNotice=" + noNotice, request, response);
		}
	}

	private void noticeDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noNotice = Integer.parseInt(request.getParameter("noNotice"));
		System.out.println(noNotice);

		NoticeDao dao = new NoticeDao();
		int res = dao.delete(noNotice);

		if (res > 0) {
			dispatch("momo.do?command=noticeList", request, response);
		} else {
			dispatch("momo.do?command = detail&noNotice=" + noNotice, request, response);
		}

	}

	private void clubMember_approve(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String insertMemberNo = request.getParameter("insertMember");
		String clubNo = request.getParameter("clubNo");

		System.out.println("insertMemberNo : " + insertMemberNo + " clubNo : " + clubNo);

		ClubMemberVo cmvo = new ClubMemberVo();
		cmvo.setMemberNo(insertMemberNo);
		cmvo.setClubNo(clubNo);

		int res = clubDao.apprMember(insertMemberNo, clubNo);

		if (res > 0) {
			System.out.println("클럽 멤버 승인완료");
			dispatch("momo.do?command=club_detail", request, response);
			
			int score = 3;
			int score2 = 1;
			int res2 = memberDao.updateMemberScore(score, userNo);
			int res3 = clubDao.updateClubScore(score2, clubNo);

			if (res2 > 0) {
				System.out.println("멤버 점수 업데이트 성공!");
			} else {
				System.out.println("멤버 점수 업데이트 실패!");
			}

			if (res3 > 0) {
				System.out.println("모임 점수 업데이트 성공!");
			} else {
				System.out.println("모임 점수 업데이트 실패!");
			}
			
			
			
		} else {
			dispatch("momo.do?command=club_detail", request, response);
			/*
			 * out.print("<script type='text/javascript'>"); out.print("alert('승인 실패');");
			 * out.print("</script>"); out.flush();
			 */
		}
	}

	private boolean isEmpty(String str) { // String값이 null인지 아닌지를 판별하는 메소드
		if (str == null || str == "") { // null이면 false 리턴
			return false;
		} else { // null이 아니면 true 리턴
			return true;
		}
	}

	private void openPassChk(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		int noQna = Integer.parseInt(request.getParameter("noQna"));
		int hitQna = Integer.parseInt(request.getParameter("hitQna"));
		
		request.setAttribute("noQna", noQna);
		request.setAttribute("hitQna", hitQna);
		
		dispatch("qna_password.jsp",request, response);
		//out.print(noQna);
	}

	private void checkQnaPass(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {

		String pass = request.getParameter("pass");
		System.out.println("확인! pass : "+pass);
		int noQna = Integer.parseInt(request.getParameter("noQna"));
		System.out.println("확인! noQna : "+noQna);
		String chk_pass = qnaDao.no_pass(noQna);
		System.out.println("확인! chk_pass : "+chk_pass);
		
		
		if(pass.equals(chk_pass))	{
			
			//out.write("1");
		} else {
			
			//out.write("0");
		}
		
		
	}

	private void qnaRplUpdate(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		System.out.println("넘어온 userId : "+userId);
		
		int noQna = Integer.parseInt(request.getParameter("noQna"));
		System.out.println("넘어온 noQna : "+noQna);
		int hitOr = Integer.parseInt(request.getParameter("hitOr"));
		System.out.println("넘어온 hitOr : "+hitOr);
		
		String rplContent = request.getParameter("re_content_qna");	//내용 가져옴
		System.out.println("넘어온 rplContent"+rplContent);
		
		int res = qnaDao.updateQnaRpl(noQna, userId, rplContent);
		
		if(res>0)	{
			PrintWriter out1 = response.getWriter();
			out1.println("<script>alert('답변 수정 성공!'); location.href='momo.do?command=qna_detail&noQna="+noQna+"&hitQna="+hitOr+"';</script>");
			out1.flush();
		} else	{
			PrintWriter out1 = response.getWriter();
			out1.println("<script>alert('답변 수정 실패!'); location.href='momo.do?command=qna_detail&noQna="+noQna+"&hitQna="+hitOr+"';</script>");
			out1.flush();
		}
	}

	private void qnaRplInsert(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		System.out.println("넘어온 userId : "+userId);
		
		int noQna = Integer.parseInt(request.getParameter("no_qna"));
		System.out.println("넘어온 noQna : "+noQna);
		int hitOr = Integer.parseInt(request.getParameter("hitOr"));
		System.out.println("넘어온 hitOr : "+hitOr);
		
		String rplContent = request.getParameter("re_content_qna");	//내용 가져옴
		System.out.println("넘어온 rplContent"+rplContent);
		
		int res = qnaDao.insertQnaRpl(noQna, userId, rplContent);
		
		if(res>0)	{
			PrintWriter out1 = response.getWriter();
			out1.println("<script>alert('답변 등록 성공!'); location.href='momo.do?command=qna_detail&noQna="+noQna+"&hitQna="+hitOr+"';</script>");
			out1.flush();
		} else	{
			PrintWriter out1 = response.getWriter();
			out1.println("<script>alert('답변 등록 실패!'); location.href='momo.do?command=qna_detail&noQna="+noQna+"&hitQna="+hitOr+"';</script>");
			out1.flush();
		}
		
	}

	private void qnaUpdate(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String qnaTitle = request.getParameter("qnaTitle");
		String qnaContent = request.getParameter("qnaContent");
		String isopen = request.getParameter("isopen");
		String pwd_qna = request.getParameter("pwd_qna");
		int hitQna = Integer.parseInt(request.getParameter("hitQna"));
		
		
		qnaVo.setNoQna(qnaNo);
		qnaVo.setTitleQna(qnaTitle);
		qnaVo.setContentQna(qnaContent);
		qnaVo.setShowYNQna(isopen);
		qnaVo.setPwdQna(pwd_qna);
		
		int res = qnaDao.qnaUpdate(qnaVo);
		System.out.println("res: "+res);
		
		String pass = qnaDao.no_pass(qnaNo);
		
		
		if(res>0) {
			PrintWriter out6 = response.getWriter();
			out6.println("<script>alert('수정 성공!'); location.href='momo.do?command=qna_detail&noQna="+qnaNo+"&hitQna="+hitQna+"&pass="+pass+"';</script>");
				
		}else {	
			PrintWriter out6 = response.getWriter();
			out6.println("<script>alert('수정에 실패했습니다. 다시 시도 후 실패할 시, 관리자에게 문의바랍니다.'); location.href='momo.do?command=qna_detail&noQna="+qnaNo+"&hitQna="+hitQna+"&pass="+pass+"';</script>");
			out6.flush();
		}
		
	}

	private void qnaDelete(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		String noQna = request.getParameter("noQna");
		int hitQna = Integer.parseInt(request.getParameter("hitQna"));
		
		int res = qnaDao.qnaDelete(noQna);
		
		if(res>0)	{
			PrintWriter out2 = response.getWriter();
			out2.println("<script>alert('삭제 성공!'); location.href='momo.do?command=qna_list';</script>");
			out2.flush();
		} else {
			PrintWriter out2 = response.getWriter();
			out2.println("<script>alert('삭제 실패! 다시 시도 후 실패할 시, 관리자에게 문의바랍니다.'); location.href='momo.do?command=qna_detail&noQna='"+noQna+"&hitQna="+hitQna+";</script>");
			out2.flush();
		}
		
		
	}

	private void qnaDetail(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		System.out.println("넘어온 userId : "+userId);
		
		int noQna = Integer.parseInt(request.getParameter("noQna"));
		int hitQna1 = Integer.parseInt(request.getParameter("hitQna"));
		System.out.println("상세보기 들어가기 전 조회수 : "+hitQna1);
		
		//원글에 대한 답글이 존재하는지 여부 
		int reNo = qnaDao.replyYN(noQna);
		System.out.println("답글 등록돼있냐없냐 : "+reNo);
		request.setAttribute("reNo", reNo);
		
		//답변 vo 가져오기
		replyVo = qnaDao.RplSelectOne(noQna);
		request.setAttribute("replyVo", replyVo);
		
		//글쓴이 아이디 가져오기
		String writer = qnaDao.no_writer(noQna);
		
		
		//공개/비공개
		String showYN = qnaDao.showYN_noQna(noQna);
		if(showYN.equals("Y") || userId.contains("admin"))	{	//공개글이거나 관리자계정이 비공개글 클릭시
			//조회수 update 먼저!
			int res = qnaDao.dateQnaUpdate(noQna, hitQna1);
			
			if(res>0)	{
				qnaVo = qnaDao.qnaSelectOne(noQna);
				System.out.println("컨트롤러의 qnaVo : "+qnaVo);
				request.setAttribute("qnaVo", qnaVo);
				dispatch("qna_detail.jsp",request, response);
			} else	{
				qnaVo = qnaDao.qnaSelectOne(noQna);
				System.out.println("컨트롤러의 qnaVo : "+qnaVo);
				request.setAttribute("qnaVo", qnaVo);
				dispatch("qna_detail.jsp",request, response);
				System.out.println("!!!!!!!!!!!!!조회수 업데이트 실패!!!!!!!!!!!!!!!!");
			}
		} else	if(userId.equals(writer))	{				//글쓴이 계정일때
			String pass = request.getParameter("pass");
			System.out.println("확인! pass : "+pass);
			
			String chk_pass = qnaDao.no_pass(noQna);		//글번호의 비밀번호 가져오기
			System.out.println("확인! chk_pass : "+chk_pass);
			
			if(pass.equals(chk_pass))	{					//비밀번호 일치할 때
				//조회수 update 먼저!
				int res = qnaDao.dateQnaUpdate(noQna, hitQna1);
				
				if(res>0)	{
					qnaVo = qnaDao.qnaSelectOne(noQna);
					System.out.println("컨트롤러의 qnaVo : "+qnaVo);
					request.setAttribute("qnaVo", qnaVo);
					dispatch("qna_detail.jsp",request, response);
				} else	{
					qnaVo = qnaDao.qnaSelectOne(noQna);
					System.out.println("컨트롤러의 qnaVo : "+qnaVo);
					request.setAttribute("qnaVo", qnaVo);
					dispatch("qna_detail.jsp",request, response);
					System.out.println("!!!!!!!!!!!!!조회수 업데이트 실패!!!!!!!!!!!!!!!!");
				}
				//out.write("1");
			} else {										//비밀번호 불일치
				PrintWriter out2 = response.getWriter();
				out2.println("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='momo.do?command=qna_list';</script>");
				out2.flush();
				//out.write("0");
			}
			
		} else	{											//글쓴이 계정이 아닐 때
			PrintWriter out2 = response.getWriter();
			out2.println("<script>alert('비공개글이므로 글쓴이만 보기 가능합니다.'); location.href='momo.do?command=qna_list';</script>");
			out2.flush();
		}

	}

	private void insertQna(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		
		String qnaTitle = request.getParameter("qnaTitle");			//제목 가져옴
		String qnaContent = request.getParameter("qnaContent");		//내용 가져옴
		String isopen = request.getParameter("isopen");				//공개여부
		String pwd_qna = request.getParameter("pwd_qna");			//비밀번호 가져옴
		System.out.println("넘어온 qnaTitle"+qnaTitle);
		System.out.println("넘어온 qnaContent"+qnaContent);
		System.out.println("넘어온 isopen"+isopen);
		System.out.println("넘어온 pwd_qna"+pwd_qna);
		
		qnaVo.setTitleQna(qnaTitle);
		qnaVo.setWriterQna(userId);
		qnaVo.setContentQna(qnaContent);
		qnaVo.setShowYNQna(isopen);
		qnaVo.setPwdQna(pwd_qna);
		
		
		int res = qnaDao.insertQna(qnaVo);
		
		if(res>0)	{
			PrintWriter out8 = response.getWriter();
			out8.println("<script>alert('글쓰기 성공!'); location.href='momo.do?command=qna_list';</script>");
			out8.flush();
		} else	{
			PrintWriter out2 = response.getWriter();
			out2.println("<script>alert('글쓰기 실패! 다시 시도 후 실패할 시, 관리자에게 문의바랍니다.'); location.href='momo.do?command=qna_list';</script>");
			out2.flush();
		}
		
		
	}

	private void qnaWrite(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		
		dispatch("qna_write.jsp",request, response);	
		
	}

	private void qnaList(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		System.out.println("qnaList");
		//답변 등록 여부
		List<String> rplList = new ArrayList<>();
		rplList = qnaDao.qnaRpl();
		request.setAttribute("rplList", rplList);
		
		List<QnaVo> qna_all = new ArrayList<>();				//qna list 생성

		int page = 1;//페이징 
		
		if(request.getParameter("page")!=null) {				//qna_list로 넘기면서 page값 받아야함
			page = Integer.parseInt(request.getParameter("page"));
		}//페이징
		
		int count = qnaDao.countQna();							//Q&A 총 게시글 개수 가져옴
		System.out.println(count+"dddddd");
		
		PagingVo paging = new PagingVo();//페이징
		
		paging.setPage(page);//페이징
		paging.setStartNum(page);
		paging.setEndNum(page);
		paging.setTotalCount(count);//페이징
		
		System.out.println(paging);
		
		qna_all = qnaDao.qnaSelectAll(paging);			//리스트 전부 출력	
		
		for(QnaVo n : qna_all) {
			System.out.println(n);
		}
		
		System.out.println("컨트롤러의 paging : "+paging);
		System.out.println("컨트롤러의 qna_all : "+qna_all);
		
		request.setAttribute("qna_all", qna_all);
		request.setAttribute("paging", paging);//페이징
		dispatch("qna.jsp",request,response);

	}

	private void classrq_delete(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		String clubNo = classDao.loginClubNo(userId);				//모임번호 가져옴
		
		String classNo = request.getParameter("classNo");			//수업번호 받아오기
		
		int res = classDao.classrq_delete(clubNo, classNo);						
		
		if(res>0)	{
			PrintWriter out7 = response.getWriter();
			out7.println("<script>alert('수업신청내역이 삭제되었습니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"';</script>");
			out7.flush();
		} else {
			PrintWriter out7 = response.getWriter();
			out7.println("<script>alert('취소 실패하였습니다. 다시 시도 후 실패할 시 관리자에게 문의바랍니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"';</script>");
			out7.flush();
		}
		
	}
	
	private void classDelete(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		String classNo = request.getParameter("classNo");
		System.out.println("넘겨줄classNo: "+classNo);
		
		int res = classDao.classDelete(classNo);
		System.out.println("res: "+res);
		
		if(res>0) {
			PrintWriter out7 = response.getWriter();	//성공시 수업찾기 페이지로
			out7.println("<script>alert('수업이 삭제되었습니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"';</script>");
				
		}else {													//실패시 수업등록 페이지 그대로
			PrintWriter out7 = response.getWriter();
			out7.println("<script>alert('삭제되지 않았습니다. 다시 시도 후 실패할 시, 관리자에게 문의바랍니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"';</script>");
			out7.flush();
		}
	}

	private void classDetailMod(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		final String filePath = "img/class_img/"; // 이미지가 저장될 위치
        int maxSize = 3*(1024*1024); // 3MB
        String encoding = "utf-8"; // 파일 인코딩
        
        String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
        System.out.println("절대 경로 : " + saveDir);
        
        File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
        if(!upDir.exists()) {
        	upDir.mkdirs();
        }

        boolean isMulti = ServletFileUpload.isMultipartContent(request); //boolean 타입으로 넘어오는 Form태그의 전송방식을 확인
        
        if(isMulti) {
        	MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		String className = multi.getParameter("class_name");
		String classAge = multi.getParameter("classAge");
		String classCategoryName = multi.getParameter("classCategoryName");	//가져와야함
		String classAddress = multi.getParameter("classAddress");
		String classPicUrl = multi.getFilesystemName("class_picture");
		System.out.println("[수정]getFilesystemName으로 컨트롤로 넘어온 값: "+classPicUrl);	//변경 후 사진
		String classContent = multi.getParameter("class_content");
		
		String classPicUrl2 = multi.getFilesystemName("class_picture_or");
		System.out.println("getFilesystemName 로 받아온 classPicUrl2"+classPicUrl2); //null
		
		String classPicUrl3 = multi.getParameter("class_picture_or");
		System.out.println("getParameter 로 받아온 classPicUrl3"+classPicUrl3);			//변경 전 사진
		
		String classNo = request.getParameter("classNo");
		String classCategoryNo = classDao.catName_catNo(classCategoryName);	//카테고리명으로 카테고리 번호 가져오기
		
		classVo.setClassNo(classNo);
		classVo.setClassName(className);
		classVo.setClassCategoryNo(classCategoryNo);
		classVo.setClassAge(classAge);
		classVo.setClassAddress(classAddress);
		classVo.setClassContent(classContent);
		
		if(classPicUrl==null)	{
			classVo.setClassPicture(classPicUrl3);
		} else {
			classVo.setClassPicture(classPicUrl);
		}
		
		int res = classDao.classDetailMod(classVo);
		System.out.println("res: "+res);
		
		if(res>0) {
			PrintWriter out6 = response.getWriter();	//성공시 수업찾기 페이지로
			out6.println("<script>alert('수정 성공!'); location.href='momo.do?command=class_detail&classNo="+classNo+"';</script>");
				
		}else {													//실패시 수업등록 페이지 그대로
			PrintWriter out6 = response.getWriter();
			out6.println("<script>alert('수정에 실패했습니다. 다시 시도 후 실패할 시, 관리자에게 문의바랍니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"';</script>");
			out6.flush();
		}
        } else	{
        	System.out.println("실패");
        }
	}

	private void classRefuse(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		String classNo = request.getParameter("classNo");
		System.out.println("classNo: "+classNo);
		String clubNo = request.getParameter("clubNo");
		System.out.println("clubNo : "+clubNo);
		
		int res = classDao.classRefuse(classNo, clubNo);
		
		if(res>0) {	
			PrintWriter out5 = response.getWriter();		
			out5.println("<script>alert('거절하였습니다!'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
		}else {
			PrintWriter out5 = response.getWriter();
			out5.println("<script>alert('거절되지 않았습니다. 새로고침 후 다시 확인해주세요.'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
			out5.flush();
		}
		
	}

	private void classAccept(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
		String classNo = request.getParameter("classNo");
		String clubNo = request.getParameter("clubNo");
		
		int res = classDao.classAccept(classNo, clubNo);
		
		if(res>0) {	
			PrintWriter out4 = response.getWriter();		
			out4.println("<script>alert('수락하였습니다!'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
		}else {
			PrintWriter out4 = response.getWriter();
			out4.println("<script>alert('수락되지 않았습니다. 새로고침 후 다시 확인해주세요.'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
			out4.flush();
		}
		
	}

	private void classReq(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		System.out.println("로그인된 userId: "+userId);
		
		clubVo = classDao.clubselectOne(userId);					//clubNo가 담겨있음
		System.out.println("컨트롤러의 clubvo: "+clubVo);
		request.setAttribute("clubVo", clubVo);
		
		String clubNo = clubVo.getClubNo();
		System.out.println("clubNo를 가져와야함: "+clubNo);
		
		String mngClubNo = clubDao.id_mngClubNo(userId);
		System.out.println("본인이 모임장인 clubNo를 가져와야함: "+mngClubNo);
		
		String classNo = request.getParameter("classNo");
		request.setAttribute("classNo", classNo);
		String tutorID = classDao.classNo_tutorID(classNo);		//수업번호로 강사번호 가져오기
		
		String allowYN = classDao.existReq(classNo, clubNo);
		System.out.println("allowYN: "+allowYN);
		
		
		if(allowYN==null)	{									//해당 수업에 신청한 내역이 없을시
			int res = classDao.insertClassClub(classNo, mngClubNo, tutorID);
			System.out.println("수업신청 성공시 res : "+res);
			
			if(res>0) {	
				int originalScore = clubDao.plusClubScore(mngClubNo);
				System.out.println("원래점수 : "+originalScore);
				int rs = classDao.req_ClsScore(classNo);		//신청받은 수업에 3점
				int rrs = clubDao.reqClubScorePlus(userId);	//신청한 모임에게 5점
				if(rs>0 && rrs>0)	{
					PrintWriter out3 = response.getWriter();		//수업 신청 성공시 수업상세보기 페이지로
					out3.println("<script>alert('신청 되었습니다. 기타 문의사항은 강사 이메일로 문의바랍니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
				} else {
					System.out.println("!!!!!!!!!!!!!!!!!!!!수업점수 업데이트 실패!!!!!!!!!!!!!!!!!!!!");
				}
				
			}else {
				dispatch("class_req_tutor.jsp",request, response);	//수업 신청 실패시 수업신청 페이지 그대로
				PrintWriter out3 = response.getWriter();
				out3.println("<script>alert('수업신청에 실패했습니다. 다시 시도 후 실패할 시, 관리자에게 문의바랍니다.'); window.location.reload();</script>");
				out3.flush();
			}
		} else if(allowYN.equals("W")) {						//수업신청 했으나 대기중
			PrintWriter out3 = response.getWriter();		
			out3.println("<script>alert('이미 신청하여 수락 대기중입니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
		} else if(allowYN.equals("Y")) {
			PrintWriter out3 = response.getWriter();			//수락된 상태
			out3.println("<script>alert('이미 신청하여 수락된 수업입니다. 강사 이메일로 문의바랍니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
		} else if(allowYN.equals("N")) {
			PrintWriter out3 = response.getWriter();			//거절된 상태
			out3.println("<script>alert('거절된 수업입니다. 강사 이메일로 문의바랍니다.'); location.href='momo.do?command=class_detail&classNo="+classNo+"'</script>");
		}
	}

	private void classDetail(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 			//session 객체 생성
		String userId=(String)session.getAttribute("userId");
		request.setAttribute("userId", userId);						//계정별 띄우는 정보 다르게 하기 위해 필요
		
		String classNo = (String)request.getParameter("classNo");	//같이 넘어온 수업번호
		System.out.println("상세페이지로 넘어온 수업번호 : "+classNo);
		String classYN = classDao.classOpenYN(classNo);				//넘겨받은 수업번호로 수업의 openYN받기
		
		String classMemberId = classDao.class_memberId(classNo);	//넘겨받은 수업번호로 그 수업의 강사 id받기	
		request.setAttribute("classMemberId", classMemberId);		//해당 수업의 강사계정일때만 띄우는 부분을 위해 필요
		
		String tutorYN = classDao.tutorYN(userId);					//강사인지 아닌지
		request.setAttribute("tutorYN", tutorYN);
		
		String clubMngYN = classDao.clubMngYN(userId);				//모임장인지 아닌지
		System.out.println("모임장인지아닌지: "+clubMngYN);
		request.setAttribute("clubMngYN", clubMngYN);
		
		String clubNo = classDao.loginClubNo(userId);				//모임번호 가져옴
		String classAllow = classDao.classAllow(clubNo, classNo);	//수업 수락여부
		System.out.println("수업수락상태: "+classAllow);
		request.setAttribute("classAllow", classAllow);
		 
		LikeVo lvo = likeDao.selectLike(classNo, userNo);
		request.setAttribute("likeVo", lvo); 						// 좋아요 여부 및 count
		
		if(classYN.equals("Y"))	{
			classVo = classDao.classSelectOne(classNo);					//수업정보 가져옴
			System.out.println("controller의 vo: "+classVo);
			request.setAttribute("classVo", classVo);
			session.setAttribute("classVo", classVo);
			request.setAttribute("classNo", classNo);					//수업신청페이지로 넘어갈때 필요함
			
			List<ClubVo> clubList_ing = new ArrayList<>();				//신청 중인 모임 정보를 받아올 list 생성
			clubList_ing = classDao.reqClub(userId, classNo);							
			request.setAttribute("clubList_ing", clubList_ing);
			System.out.println("[컨트롤러]clubList_ing: "+clubList_ing);
			
			List<ClubVo> clubList_cmpl = new ArrayList<>();				//신청 수락된 모임 정보를 받아올 list 생성
			clubList_cmpl = classDao.accClub(userId, classNo);
			request.setAttribute("clubList_cmpl", clubList_cmpl);
			
			dispatch("class_detail.jsp",request, response);
		} else if(classYN.equals("N")) {
			PrintWriter out2 = response.getWriter();				//수업이 열려있지않은 상태
			out2.println("<script>alert('삭제된 수업입니다. 수업찾기 페이지로 이동됩니다.'); location.href='class_search.jsp';</script>");
		}
		
	}

	private void classNameCheck(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		String className = request.getParameter("className");
		
		if (className == null) {
			out.write("2");			
			out.flush();
			return;
		}
		
		String checkedNm = classDao.selectNm(className);
		
		if (checkedNm == null) {
			out.write("1");

		} else { 
			out.write("0");
		}
		
		out.flush();
		
	}

	private void classRegister(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		final String filePath = "img/class_img/"; // 이미지가 저장될 위치
        int maxSize = 3*(1024*1024); // 3MB
        String encoding = "utf-8"; // 파일 인코딩
        
        String saveDir = request.getSession().getServletContext().getRealPath(filePath); // 실제 사진이 저장되는 위치(메타데이터)
        System.out.println("절대 경로 : " + saveDir);
        
        File upDir = new File(saveDir); // 저장하려는 경로에 폴더가 없을경우 생성
        if(!upDir.exists()) {
        	upDir.mkdirs();
        }

        boolean isMulti = ServletFileUpload.isMultipartContent(request); //boolean 타입으로 넘어오는 Form태그의 전송방식을 확인
        
        if(isMulti) {
        MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		String className = multi.getParameter("className");
		String classCategoryNo = multi.getParameter("classCategoryNo");
		String classAge = multi.getParameter("classAge");
		String classAddress = multi.getParameter("classAddress");
		String classPicUrl = multi.getFilesystemName("classPicture");
		String classContent = multi.getParameter("classContent");
		
		System.out.println(className);
		System.out.println(classCategoryNo);
		System.out.println(classAge);
		System.out.println(classAddress);
		System.out.println(classContent);
		
		HttpSession session = request.getSession(true); //session 객체 생성
		String userId = (String)session.getAttribute("userId");	//로그인되어 있는 아이디
		System.out.println("로그인된 아이디: "+userId);
		String tutorNo = classDao.id_tutorNo(userId);	//tutorNo를 가져옴
		
		classVo.setTutorNo(tutorNo);
		classVo.setClassName(className);
		classVo.setClassCategoryNo(classCategoryNo);
		classVo.setClassAge(classAge);
		classVo.setClassAddress(classAddress);
		classVo.setClassPicture(classPicUrl);
		classVo.setClassContent(classContent);
		
		System.out.println("pictureURL : "  +	 classPicUrl);
		
		int res = classDao.register(classVo);
		String userNo = memberDao.findMemberNo(userId);
		int reslt = memberDao.updateMemberScore(15, userNo);
		
		if(res>0 && reslt>0) {
			System.out.println("수업 생성 성공");
			String classNo = classDao.searchClassNo(className);
			int res2 = classDao.updateClassScore(10, classNo);
			if(res2 > 0 ) {
				System.out.println("점수 업데이트 성공");
			} else {
				System.out.println("점수 업데이트 실패");
			}
			
			PrintWriter out2 = response.getWriter();	//성공시 개설한 수업으로 이동
			out2.println("<script>alert('수업등록 성공!');</script>");
			
			dispatch("momo.do?command=class_detail&classNo=" + classNo, request, response);

		}else {							 						//실패시 수업등록 페이지 그대로
			PrintWriter out2 = response.getWriter();
			out2.println("<script>alert('수업등록에 실패했습니다. 다시 시도 후 실패할 시, 관리자에게 문의바랍니다.'); location.href='class_register.jsp';</script>");
			out2.flush();
			}
        } else {
        	System.out.println("실패");
        }
	}
	
	private void tabClassRegister(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException, ServletException {
		HttpSession session = request.getSession(true); //session 객체 생성
		String userId = (String)session.getAttribute("userId");	//로그인되어 있는 아이디
		System.out.println("로그인된 아이디: "+userId);
		if(userId!=null)	{
			request.setAttribute("userId", userId);
			String tutorYN = classDao.tutorYN(userId);	//tutorNo를 가져옴
			System.out.println("컨트롤러 tutorYN : "+tutorYN);
			request.setAttribute("tutorYN", tutorYN);
			dispatch("class_register.jsp",request, response);
		} else {
			PrintWriter out3 = response.getWriter();
			out3.println("<script>alert('해당 기능은 로그인 한 회원만 이용 가능합니다. 확인을 클릭하시면 로그인창으로 이동합니다.'); location.href='momo.do?command=login';</script>");
			out3.flush();
		}
	}
	
	 private void qnaListMy(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
	      HttpSession session = request.getSession(true);          //session 객체 생성
	      String userId=(String)session.getAttribute("userId");
	      System.out.println("로그인된 userId: "+userId);
	      request.setAttribute("userId", userId);
	      
	      //답변 등록 여부
	      List<String> rplList = new ArrayList<>();
	      rplList = qnaDao.qnaRpl();
	      request.setAttribute("rplList", rplList);
	      
	      int page = 1;//페이징 
	      
	      if(request.getParameter("page")!=null) {            //qna_list로 넘기면서 page값 받아야함
	         page = Integer.parseInt(request.getParameter("page"));
	      }//페이징
	      
	      PagingVo paging = new PagingVo();//페이징
	      System.out.println(paging);
	      
	      int count = qnaDao.countQna();                     //Q&A 총 게시글 개수 가져옴
	      System.out.println(count+"dddddd");
	      
	      paging.setPage(page);//페이징
	      paging.setStartNum(page);
	      paging.setEndNum(page);
	      paging.setTotalCount(count);//페이징
	      
	      request.setAttribute("paging", paging);//페이징
	      
	      List<QnaVo> qna_all = new ArrayList<>(); //내가 쓴 글
	      qna_all = qnaDao.qnaSelectMy(paging, userId);
	      
	      System.out.println("내가 쓴 글 모음 : "+qna_all);
	      
	      for(QnaVo n : qna_all) {
	         System.out.println(n);
	      }
	      
	      System.out.println("컨트롤러의 paging : "+paging);
	      System.out.println("컨트롤러의 qna_my : "+qna_all);
	      
	      request.setAttribute("qna_all", qna_all);
	      
	      dispatch("qna.jsp",request,response);
	      
	   }
	
}