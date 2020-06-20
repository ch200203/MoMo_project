package momo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import momo.vo.ClassListVo;
import momo.vo.MyClassListVo;
import momo.vo.ClassVo;
import momo.vo.ClubClassVo;
import momo.vo.ClubVo;

public class ClassDao extends JDBCTemplate {

	public List<MyClassListVo> myClassList(String userNo) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MyClassListVo> res = new ArrayList<MyClassListVo>();

		String sql = "SELECT TUTOR.TUTOR_NO, CLASS.CLASS_NO, CLASS.CLASS_NAME FROM TUTOR LEFT JOIN CLASS ON(TUTOR.TUTOR_NO = CLASS.TUTOR_NO) WHERE TUTOR.TUTOR_NO = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNo);
			System.out.println("3. query 준비: " + sql);

			rs = pstmt.executeQuery();
			System.out.println("4. query 실행 및 리턴");

			while (rs.next()) {
				MyClassListVo tmp = new MyClassListVo(rs.getString("TUTOR_NO"), rs.getString("CLASS_NO"),
						rs.getString("CLASS_NAME"));

				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. db 종료\n");
		}

		return res;
	}

	public List<ClassListVo> classSelectAll() {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClassListVo> res = new ArrayList<ClassListVo>();

		String sql = " SELECT * FROM CLASSLIST_VIEW ORDER BY CLASS_SCORE DESC ";
		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClassListVo tmp = new ClassListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				res.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db 종료\n");
		}

		return res;
	}

	public List<ClassListVo> selectedClassList(String selectedClassLocation, String selectedClassCategory,
			String selectedClassSort) {
		String classAddr = selectedClassLocation;
		String classCategory = selectedClassCategory;
		String classSort = selectedClassSort;

		// 주소선택값 분리
		String classAddr1 = null;
		String classAddr2 = null;
		String classAddr3 = null;
		String classAddr4 = null;

		if (selectedClassLocation.equals("지역 구분")) { // 주소 기본값
			classAddr1 = "";
			classAddr2 = "";
			classAddr3 = "";
			classAddr4 = "";
		} else if (selectedClassLocation.equals("서울")) {
			classAddr1 = "서울";
			classAddr2 = "서울";
			classAddr3 = "서울";
			classAddr4 = "서울";
		} else if (selectedClassLocation.equals("경기/인천")) {
			classAddr1 = "경기";
			classAddr2 = "인천";
			classAddr3 = "인천";
			classAddr4 = "인천";
		} else if (selectedClassLocation.equals("강원")) {
			classAddr1 = "강원";
			classAddr2 = "강원";
			classAddr3 = "강원";
			classAddr4 = "강원";
		} else if (selectedClassLocation.equals("충청/대전")) {
			classAddr1 = "충청";
			classAddr2 = "대전";
			classAddr3 = "대전";
			classAddr4 = "대전";
		} else if (selectedClassLocation.equals("전라/광주")) {
			classAddr1 = "전라";
			classAddr2 = "광주";
			classAddr3 = "광주";
			classAddr4 = "광주";
		} else if (selectedClassLocation.equals("전라/광주")) {
			classAddr1 = "전라";
			classAddr2 = "광주";
			classAddr3 = "광주";
			classAddr4 = "광주";
		} else if (selectedClassLocation.equals("경상/울산/대구/부산")) {
			classAddr1 = "경상";
			classAddr2 = "울산";
			classAddr3 = "대구";
			classAddr4 = "부산";
		} else if (selectedClassLocation.equals("제주")) {
			classAddr1 = "제주";
			classAddr2 = "제주";
			classAddr3 = "제주";
			classAddr4 = "제주";
		}

		// 카테고리 기본값
		if (classCategory.equals("카테고리 구분")) {
			classCategory = "C";
		}
		// 정렬 기본값
		if (classSort.equals("정렬 구분")) {
			classSort = "CLASS_SCORE";
		}

		System.out.println("classAddr1: " + classAddr1);
		System.out.println("classAddr2: " + classAddr2);
		System.out.println("classAddr3: " + classAddr3);
		System.out.println("classAddr4: " + classAddr4);
		System.out.println("classCategory: " + classCategory);
		System.out.println("classSort: " + classSort);

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClassListVo> res = new ArrayList<ClassListVo>();

		String sql = " SELECT * FROM CLASSLIST_VIEW WHERE (CLASS_ADDRESS LIKE '%" + classAddr1
				+ "%' OR CLASS_ADDRESS LIKE '%" + classAddr2 + "%' OR CLASS_ADDRESS LIKE '%" + classAddr3
				+ "%' OR CLASS_ADDRESS LIKE '%" + classAddr4 + "%') ORDER BY " + classSort + " DESC ";

		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClassListVo tmp = new ClassListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				res.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db 종료\n");
		}

		return res;
	}

	public List<ClassListVo> searchedClassList(String searchedWord) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClassListVo> res = new ArrayList<ClassListVo>();

		String sql = " SELECT * FROM CLASSLIST_VIEW WHERE CLASS_NAME LIKE '%" + searchedWord
				+ "%' ORDER BY CLASS_SCORE DESC ";
		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClassListVo tmp = new ClassListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				res.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db 종료\n");
		}

		return res;
	}

	public int updateClassScore(int score, String classNo) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = "UPDATE CLASS SET CLASS_SCORE = ? WHERE CLASS_NO = ?";

		int originalScore = plusClassScore(classNo);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, score + originalScore);
			pstmt.setString(2, classNo);
			System.out.println("3. query 준비: " + sql);

			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");

			if (res > 0) {
				return res;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. 드라이버 종료");
		}

		return res;
	}

	public int plusClassScore(String classNo) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT CLASS_SCORE FROM CLASS WHERE CLASS_NO = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classNo);
			System.out.println("3. query 준비: " + sql);

			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");

			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 드라이버 종료");
		}

		return 0;
	}

	public String searchClassNo(String className) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT CLASS_NO FROM CLASS WHERE CLASS_NAME = ?";
		String result = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, className);
			System.out.println("3. 쿼리문 준비완료");

			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리문 실행 및 리턴");
			
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("3. 쿼리문 오류");
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 디비 종료");
		}
		
		return result;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String selectNm(String className) {		//수업명 중복체크
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT CLASS_NAME FROM CLASS WHERE CLASS_NAME = ?"; 
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, className);
			System.out.println("3. statement 객체 생성");
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			if (rs.next()) { 
				return rs.getString(1);
			} else { 
				return null; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return null;
	}

	public int register(ClassVo clss) {				//수업등록
		
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO CLASS VALUES('CLASS'||CLASS_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, 10, SYSDATE, '관리자', 'Y') ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, clss.getTutorNo());		//강사번호
				pstm.setString(2, clss.getClassName());
				pstm.setString(3, clss.getClassCategoryNo());
				pstm.setString(4, clss.getClassAddress());
				pstm.setString(5, clss.getClassAge());
				pstm.setString(6, clss.getClassContent());
				pstm.setString(7, clss.getClassPicture());
				
				res = pstm.executeUpdate();
				System.out.println("쿼리실행");
				
				System.out.println("res: "+res);
				if(res>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return res;
	}

	public String id_tutorNo(String userId) {			//로그인된 id로 tutorNo 가져오기
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String tutorNo = null;
		
		System.out.println("넘어온userId: "+userId);
		String sql = " SELECT MEMBER_NO FROM MEMBER WHERE MEMBER_ID=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, userId);
			
			rs = pstm.executeQuery();
			
			rs.next();
			tutorNo = (rs.getString(1));
			System.out.println(tutorNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstm,con);
		}
		
		return tutorNo;
	}
	
	public String class_memberId(String classNo) {			//수업번호로 강사Id 가져오기
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String classMemberId = null;
		
		String sql = " SELECT MEMBER_ID FROM CLASS JOIN MEMBER ON(MEMBER_NO = TUTOR_NO) " + 
				"JOIN CATEGORY ON(CLASS_CATEGORY_NO = CATEGORY_NO) " + 
				"WHERE CLASS_NO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, classNo);
			
			rs = pstm.executeQuery();
			
			rs.next();
			classMemberId = (rs.getString(1));
			System.out.println("classMemberId : "+classMemberId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstm,con);
		}
		
		return classMemberId;
	}
	
	public ClassVo classSelectOne(String classNo) {					//수업 상세정보
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ClassVo classVo = new ClassVo();
		
		String sql = " SELECT CLASS_NAME, MEMBER_NAME, CLASS_AGE, MEMBER_PICTURE, EMAIL, CATEGORY_NAME, " + 
				"CLASS_ADDRESS, CLASS_PICTURE, CLASS_CONTENT, CLASS_SCORE, TUTOR_INTRODUCE, "+ 
				"EDUCATION_FILE, EXPERIENCE_FILE, CERTIFICATE_FILE FROM CLASS " + 
				"JOIN MEMBER ON(MEMBER_NO = TUTOR_NO) " + 
				"JOIN CATEGORY ON(CLASS_CATEGORY_NO = CATEGORY_NO) " + 
				"JOIN TUTOR USING(TUTOR_NO) " + 
				"WHERE CLASS_NO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, classNo);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리문실행");
			
			while(rs.next()) {
			classVo.setClassName(rs.getString(1));
			classVo.setMemberName(rs.getString(2));
			classVo.setClassAge(rs.getString(3));
			classVo.setMemberPicture(rs.getString(4));
			classVo.setEmail(rs.getString(5));
			classVo.setCategoryName(rs.getString(6));
			classVo.setClassAddress(rs.getString(7));
			classVo.setClassPicture(rs.getString(8));
			classVo.setClassContent(rs.getString(9));
			classVo.setClassScore(rs.getString(10));
			classVo.setTutorIntroduce(rs.getString(11));
			classVo.setEducationFile(rs.getString(12));
			classVo.setExperienceFile(rs.getString(13));
			classVo.setCertificateFile(rs.getString(14));
			
			System.out.println("classVo: "+classVo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,pstm,con);
		}
		return classVo;
	}

	public String tutorYN(String userId) {								//강사인지 아닌지
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String tutorYN=null;
		String sql = " SELECT TUTORYN FROM MEMBER WHERE MEMBER_ID=? ";
		System.out.println("dao의 userId : "+userId);
		
		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, userId);
			
			rs = pstm.executeQuery();
			
			rs.next();
			tutorYN = (rs.getString(1));
			System.out.println("dao의 tutorYN: "+tutorYN);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			close(rs,pstm,con);
		}
		
		return tutorYN;
	}

	
	public ClubVo clubselectOne(String userId) {				//수업신청에 모임정보 가져오기
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ClubVo res = new ClubVo();
		
		String sql = " SELECT CLUB_NO, CLUB_NAME, MEMBER_NAME, CLUB_TOTAL, CATEGORY_NAME, CLUB_SCORE, CLUB_ADDRESS, CLUB_PICTURE " + 
				"FROM CLUB " + 
				"JOIN CLUB_MEMBER USING(CLUB_NO) " + 
				"JOIN MEMBER USING(MEMBER_NO) " + 
				"JOIN CATEGORY ON(CLUB_CATEGORY_NO = CATEGORY_NO) " + 
				"WHERE MEMBER_ID=? ";
		
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, userId);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res.setClubNo(rs.getString(1));
				res.setClubName(rs.getString(2));
				res.setMemberName(rs.getString(3));
				res.setClubTotal(rs.getInt(4));
				res.setCategoryName(rs.getString(5));
				res.setClubScore(rs.getInt(6));
				res.setClubAddress(rs.getString(7));
				res.setClubPicture(rs.getString(8));
				System.out.println("dao의 vo: "+res);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstm,con);
		}
		
		return res;
	}

	public String loginClubNo(String userId) {					//세션에 로그인된 아이디의 모임번호 가져오기
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String res = null;
		
		String sql = " SELECT CLUB_NO FROM MEMBER JOIN CLUB ON(MEMBER_NO = MANAGER_NO) WHERE MEMBER_ID=? ";
		
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, userId);
			
			rs = pstm.executeQuery();
			
			rs.next();
			res = rs.getString(1);
			System.out.println("dao의 loginClubNo: "+res);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstm,con);
		}
		
		return res;
	}

	public String classNo_tutorID(String classNo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String tutorID = null;
		
		String sql = " SELECT MEMBER_ID FROM CLASS JOIN MEMBER ON(TUTOR_NO=MEMBER_NO) WHERE CLASS_NO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, classNo);
			rs = pstm.executeQuery();
			rs.next();
			tutorID = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			close(rs, pstm, con);
		}
		
		
		return tutorID;
	}
	
	public int insertClassClub(String classNo, String mngClubNo, String userId) {
		
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
			String sql = " INSERT INTO CLASS_CLUB VALUES(?, ?, ?, 'W', SYSDATE, '이샛별') ";
			
			try {
				pstm = con.prepareStatement(sql);
				
				if(classNo!=null && mngClubNo!=null)	{
					pstm.setString(1, userId);		//담당강사번호 insert
					pstm.setString(2, classNo);		//수업번호 insert
					pstm.setString(3, mngClubNo);		//모임번호 insert
					
					res = pstm.executeUpdate();
					System.out.println("쿼리실행");
				} else	{
					res = 0;
				}
				
				System.out.println("res: "+res);
				if(res>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
		
		return res;
	}

	public List<ClubVo> reqClub(String userId, String classNo) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ClubVo> clubList = new ArrayList<>();
		
		
		String sql = " SELECT CLUB_NO, CLUB_NAME, CATEGORY_NAME, MEMBER_NAME, CLUB_TOTAL, CLUB_SCORE "+
				"FROM CLUB JOIN CLASS_CLUB USING(CLUB_NO) FULL JOIN TUTOR_CLUB USING(CLUB_NO) "+
				"JOIN MEMBER ON(MEMBER_NO = MANAGER_NO) JOIN CATEGORY ON(CLUB_CATEGORY_NO = CATEGORY_NO) "+
				"WHERE ALLOWYN_W='W' AND INCHARGE_TUTOR_ID=? AND CLASS_NO=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, userId);
			pstm.setString(2, classNo);
			System.out.println("sql문에 넣어줄 id : "+userId);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리실행");
			
			while(rs.next()) {
				ClubVo clubVo = new ClubVo();
				clubVo.setClubNo(rs.getString(1));
				clubVo.setClubName(rs.getString(2));
				clubVo.setCategoryName(rs.getString(3));
				clubVo.setMemberName(rs.getString(4));
				clubVo.setClubTotal(rs.getInt(5));
				clubVo.setClubScore(rs.getInt(6));
				System.out.println("리스트 넣기 전 clubVo : "+clubVo);
				clubList.add(clubVo);
			}
			
			System.out.println("dao의 신청모임리스트: "+clubList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstm,con);
		}
		
		return clubList;
	}

	public int classAccept(String classNo, String clubNo) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE CLASS_CLUB SET ALLOWYN_W='Y' WHERE CLASS_NO=? AND CLUB_NO=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
					pstm.setString(1, classNo);		
					pstm.setString(2, clubNo);		
					
					res = pstm.executeUpdate();
					System.out.println("쿼리실행");
				
				System.out.println("res: "+res);
				if(res>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return res;
	}

	public int classRefuse(String classNo, String clubNo) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE CLASS_CLUB SET ALLOWYN_W='N' WHERE CLASS_NO=? AND CLUB_NO=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
					pstm.setString(1, classNo);		
					pstm.setString(2, clubNo);		
					
					res = pstm.executeUpdate();
					System.out.println("쿼리실행");
				
				System.out.println("res: "+res);
				if(res>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return res;
	}

	public int classDetailMod(ClassVo classVo) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE CLASS SET CLASS_NAME=?, CLASS_CATEGORY_NO=?, CLASS_ADDRESS=?, " + 
				"CLASS_AGE=?, CLASS_CONTENT=?, CLASS_PICTURE=? " + 
				"WHERE CLASS_NO=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, classVo.getClassName());		//강사번호
				pstm.setString(2, classVo.getClassCategoryNo());
				pstm.setString(3, classVo.getClassAddress());
				pstm.setString(4, classVo.getClassAge());
				pstm.setString(5, classVo.getClassContent());
				pstm.setString(6, classVo.getClassPicture());
				pstm.setString(7, classVo.getClassNo());
				
				res = pstm.executeUpdate();
				System.out.println("쿼리실행");
				
				System.out.println("res: "+res);
				if(res>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return res;
	}

	public String catName_catNo(String categoryName) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String categoryNo = null;
		
		String sql = " SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, categoryName);
			System.out.println("쿼리에 넣을 카테고리명 : "+categoryName);
			rs = pstm.executeQuery();
			System.out.println("쿼리 실행");
			rs.next();
			categoryNo = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			close(rs, pstm, con);
		}
		
		
		return categoryNo;
	}

	public int tutorIntroMod(String tutorIntroduce, String tutorNo) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int rs = 0;
		
		String sql = " UPDATE TUTOR SET TUTOR_INTRODUCE=? WHERE TUTOR_NO=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, tutorIntroduce);		//강사번호
				pstm.setString(2, tutorNo);
				
				rs = pstm.executeUpdate();
				System.out.println("쿼리실행");
				
				System.out.println("rs: "+rs);
				if(rs>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return rs;
	}

	public int classDelete(String classNo) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int rs = 0;
		
		String sql = " UPDATE CLASS SET OPENYN='N' WHERE CLASS_NO=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, classNo);		//수업
				
				rs = pstm.executeUpdate();
				System.out.println("쿼리실행");
				
				System.out.println("rs: "+rs);
				if(rs>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return rs;
	}

	public String classOpenYN(String classNo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String classYN = null;
		
		String sql = " SELECT OPENYN FROM CLASS WHERE CLASS_NO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, classNo);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리 실행");
			rs.next();
			classYN = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			close(rs, pstm, con);
		}
		
		
		return classYN;
	}

	public String existReq(String classNo, String clubNo) {
		
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String allowYN = null;
		
		System.out.println("dao로 넘어온 classNo"+classNo);
		System.out.println("dao로 넘어온 clubNo"+clubNo);
		String sql = " SELECT ALLOWYN_W FROM CLASS_CLUB WHERE CLASS_NO=? AND CLUB_NO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, classNo);		
			pstm.setString(2, clubNo);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리실행");
			
			rs.next();
			allowYN = rs.getString(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return allowYN;
	}

	public String clubMngYN(String userId) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String clubMng=null;
		String clubMngYN=null;
		String sql = " SELECT CLUB_NO FROM CLUB JOIN MEMBER ON(MEMBER_NO = MANAGER_NO) WHERE MEMBER_ID=? ";
		System.out.println("dao의 userId"+userId);
		
		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, userId);
			
			rs = pstm.executeQuery();
			
			if(rs.next())	{
				clubMng = (rs.getString(1));
			} else {
				clubMng = "null";
			}
			
			System.out.println("해당 아이디의 모임번호(모임장) : "+clubMng);
			
			if(clubMng.equals("null"))	{
				clubMngYN = "N";
			} else {
				clubMngYN = "Y";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			close(rs,pstm,con);
		}
		
		return clubMngYN;
	}

	public int likeClass(String classNo, int classScore) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int rs = 0;
		
		String sql = " UPDATE CLASS SET CLASS_SCORE=?+1 WHERE CLASS_NO=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setInt(1, classScore);
				pstm.setString(2, classNo);		
				
				rs = pstm.executeUpdate();
				System.out.println("쿼리실행");
				
				System.out.println("rs: "+rs);
				if(rs>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return rs;
	}

	public List<ClubVo> accClub(String userId, String classNo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ClubVo> clubList = new ArrayList<>();
		
		
		String sql = " SELECT CLUB_NO, CLUB_NAME, CATEGORY_NAME, MEMBER_NAME, CLUB_TOTAL, CLUB_SCORE "+
				"FROM CLUB JOIN CLASS_CLUB USING(CLUB_NO) FULL JOIN TUTOR_CLUB USING(CLUB_NO) "+
				"JOIN MEMBER ON(MEMBER_NO = MANAGER_NO) JOIN CATEGORY ON(CLUB_CATEGORY_NO = CATEGORY_NO) "+
				"WHERE ALLOWYN_W='Y' AND INCHARGE_TUTOR_ID=? AND CLASS_NO=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, userId);
			pstm.setString(2, classNo);	
			System.out.println("sql문에 넣어줄 id : "+userId);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리실행");
			
			while(rs.next()) {
				ClubVo clubVo = new ClubVo();
				clubVo.setClubNo(rs.getString(1));
				clubVo.setClubName(rs.getString(2));
				clubVo.setCategoryName(rs.getString(3));
				clubVo.setMemberName(rs.getString(4));
				clubVo.setClubTotal(rs.getInt(5));
				clubVo.setClubScore(rs.getInt(6));
				System.out.println("리스트 넣기 전 clubVo : "+clubVo);
				clubList.add(clubVo);
			}
			
			System.out.println("dao의 수락모임리스트: "+clubList);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstm,con);
		}
		
		return clubList;
	}

	public String classAllow(String clubNo, String classNo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String classAllow=null;
		String sql = " SELECT ALLOWYN_W FROM CLASS_CLUB WHERE CLASS_NO=? AND CLUB_NO=? ";
		
		System.out.println("쿼리에 넣어줄 값 : "+clubNo+" 와 "+ classNo );
		
		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, classNo);
			pstm.setString(2, clubNo);
			
			rs = pstm.executeQuery();
			
			if(rs.next())	{
				classAllow = (rs.getString(1));
			} else {
				classAllow = null;
			}
			
			System.out.println("수락 여부 : "+classAllow);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			close(rs,pstm,con);
		}
		
		return classAllow;
		
	}

	public int classrq_delete(String clubNo, String classNo) {
			Connection con = getConnection();
			System.out.println("연결");
			PreparedStatement pstm = null;
			int rs = 0;
			
			String sql = " DELETE FROM CLASS_CLUB WHERE CLASS_NO=? AND CLUB_NO=? ";
			
				try {
					pstm = con.prepareStatement(sql);
					
					pstm.setString(1, classNo);
					pstm.setString(2, clubNo);		
					
					rs = pstm.executeUpdate();
					System.out.println("쿼리실행");
					
					System.out.println("rs: "+rs);
					if(rs>0) {
						commit(con);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstm,con);
				}
				
				return rs;
	}

	public int req_ClsScore(String classNo) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE CLASS SET CLASS_SCORE=(SELECT CLASS_SCORE FROM CLASS WHERE CLASS_NO=?)+3 WHERE CLASS_NO=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
					pstm.setString(1, classNo);		
					pstm.setString(2, classNo);		
					
					res = pstm.executeUpdate();
					System.out.println("쿼리실행");
				
				System.out.println("res: "+res);
				if(res>0) {
					commit(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm,con);
			}
			
			return res;
	}

	public List<ClubClassVo> ClubClassList(String clubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		List<ClubClassVo> res = new ArrayList<ClubClassVo>();
		ClubClassVo vo = new ClubClassVo();
		
		String sql = "SELECT CL.CLASS_NAME, CL.CLASS_NO, C.ALLOWYN_W FROM CLASS CL LEFT OUTER JOIN CLASS_CLUB C ON CL.CLASS_NO = C.CLASS_NO"
				+ " WHERE C.CLUB_NO = ? AND CL.CLASS_NO =(SELECT C.CLASS_NO FROM  CLASS_CLUB C WHERE C.CLUB_NO = ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, clubNo);
			System.out.println("3. 쿼리문 준비 완료");
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리문 실행 및 리턴");
			
			while(rs.next()) {
			vo.setClassName(rs.getString(1));	
			vo.setClassNo(rs.getString(2));
			vo.setAllowYN_W(rs.getString(3));
			
			res.add(vo);
			}
			System.out.println(res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return res;
	}
}
