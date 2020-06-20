package momo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import momo.vo.ClubListVo;
import momo.vo.ClubMemberVo;
import momo.vo.ClubVo;
import momo.vo.MyClubListVo;

public class ClubDao extends JDBCTemplate {

	public List<MyClubListVo> myClubList(String userNo) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MyClubListVo> res = new ArrayList<MyClubListVo>();

		String sql = "SELECT CLUB_MEMBER.MEMBER_NO, CLUB.CLUB_NO, CLUB.CLUB_NAME FROM CLUB_MEMBER LEFT JOIN CLUB ON(CLUB_MEMBER.CLUB_NO = CLUB.CLUB_NO) WHERE MEMBER_NO = ?";
		System.out.println("3. query 준비: " + sql);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNo);

			rs = pstmt.executeQuery();
			System.out.println("4. query 실행 및 리턴");

			while (rs.next()) {
				MyClubListVo tmp = new MyClubListVo(rs.getString("MEMBER_NO"), rs.getString("CLUB_NO"),
						rs.getString("CLUB_NAME"));

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

	public List<ClubListVo> clubSelectAll() {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClubListVo> res = new ArrayList<ClubListVo>();

		String sql = " SELECT * FROM CLUBLIST_VIEW ORDER BY CLUB_SCORE DESC ";
		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClubListVo tmp = new ClubListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));

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

	public List<ClubListVo> selectedClubList(String selectedClubLocation, String selectedClubCategory,
			String selectedClubSort) {

		String clubAddr = selectedClubLocation;
		String clubCategory = selectedClubCategory;
		String clubSort = selectedClubSort;

		// 주소선택값 분리
		String clubAddr1 = null;
		String clubAddr2 = null;
		String clubAddr3 = null;
		String clubAddr4 = null;

		if (selectedClubLocation.equals("지역 구분")) { // 주소 기본값
			clubAddr1 = "";
			clubAddr2 = "";
			clubAddr3 = "";
			clubAddr4 = "";
		} else if (selectedClubLocation.equals("서울")) {
			clubAddr1 = "서울";
			clubAddr2 = "서울";
			clubAddr3 = "서울";
			clubAddr4 = "서울";
		} else if (selectedClubLocation.equals("경기/인천")) {
			clubAddr1 = "경기";
			clubAddr2 = "인천";
			clubAddr3 = "인천";
			clubAddr4 = "인천";
		} else if (selectedClubLocation.equals("강원")) {
			clubAddr1 = "강원";
			clubAddr2 = "강원";
			clubAddr3 = "강원";
			clubAddr4 = "강원";
		} else if (selectedClubLocation.equals("충청/대전")) {
			clubAddr1 = "충청";
			clubAddr2 = "대전";
			clubAddr3 = "대전";
			clubAddr4 = "대전";
		} else if (selectedClubLocation.equals("전라/광주")) {
			clubAddr1 = "전라";
			clubAddr2 = "광주";
			clubAddr3 = "광주";
			clubAddr4 = "광주";
		} else if (selectedClubLocation.equals("전라/광주")) {
			clubAddr1 = "전라";
			clubAddr2 = "광주";
			clubAddr3 = "광주";
			clubAddr4 = "광주";
		} else if (selectedClubLocation.equals("경상/울산/대구/부산")) {
			clubAddr1 = "경상";
			clubAddr2 = "울산";
			clubAddr3 = "대구";
			clubAddr4 = "부산";
		} else if (selectedClubLocation.equals("제주")) {
			clubAddr1 = "제주";
			clubAddr2 = "제주";
			clubAddr3 = "제주";
			clubAddr4 = "제주";
		}

		// 카테고리 기본값
		if (clubCategory.equals("카테고리 구분")) {
			clubCategory = "C";
		}
		// 정렬 기본값
		if (clubSort.equals("정렬 구분")) {
			clubSort = "CLUB_SCORE";
		}

		System.out.println("clubAddr: " + clubAddr1);
		System.out.println("clubAddr: " + clubAddr2);
		System.out.println("clubAddr: " + clubAddr3);
		System.out.println("clubAddr: " + clubAddr4);
		System.out.println("clubCategory: " + clubCategory);
		System.out.println("clubSort: " + clubSort);

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClubListVo> res = new ArrayList<ClubListVo>();

		String sql = " SELECT * FROM CLUBLIST_VIEW WHERE (CLUB_ADDRESS LIKE '%" + clubAddr1
				+ "%' OR CLUB_ADDRESS LIKE '%" + clubAddr2 + "%' OR CLUB_ADDRESS LIKE '%" + clubAddr3
				+ "%' OR CLUB_ADDRESS LIKE '%" + clubAddr4 + "%') AND CATEGORY_NO LIKE '%" + clubCategory
				+ "%' ORDER BY " + clubSort + " DESC ";
		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClubListVo tmp = new ClubListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));

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

	public List<ClubListVo> searchedClubList(String searchedWord) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClubListVo> res = new ArrayList<ClubListVo>();

		String sql = " SELECT * FROM CLUBLIST_VIEW WHERE CLUB_NAME LIKE '%" + searchedWord
				+ "%' ORDER BY CLUB_SCORE DESC ";
		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClubListVo tmp = new ClubListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));

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

	public ClubVo selectOne(String ClubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ClubVo res = new ClubVo();

		String sql = "SELECT C.MANAGER_NO, M.MEMBER_NAME, C.CLUB_TOTAL, C.OPENYN, C.RECRUITYN, C.CLUB_CATEGORY_NO, C.CLUB_ADDRESS, C.CLUB_CONTENT, C.CLUB_PICTURE , C.CLUB_NAME, C.CLUB_NO, C.CLUB_SCORE "
				+ "FROM MEMBER M LEFT OUTER JOIN CLUB C ON M.MEMBER_NO = C.MANAGER_NO WHERE C.CLUB_NO = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ClubNo);
			System.out.println("3. 쿼리문 준비");

			System.out.println(sql);

			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리문 실행 및 리턴");

			while (rs.next()) {
				// 리턴 값 입력
				res.setManagerNo(rs.getString(1));
				res.setManagerName(rs.getString(2));
				res.setClubTotal(rs.getInt(3));
				res.setOpenYN(rs.getString(4));
				res.setRecruitYN(rs.getString(5));
				res.setClubCategoryNo(rs.getString(6));
				res.setClubAddress(rs.getString(7));
				res.setClubContent(rs.getString(8));
				res.setClubPicture(rs.getString(9));
				res.setClubName(rs.getString(10));
				res.setClubNo(rs.getString(11));
				res.setClubScore(rs.getInt(12));
			}

			System.out.println(res);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3,4. 쿼리문 실패");
		} finally {
			close(rs, pstmt, con);
		}
		return res;
	}

	public List<ClubMemberVo> clubMeberList(String clubNo) {
		// 회원명단 불러오기
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ClubMemberVo> res = new ArrayList<ClubMemberVo>();

		String sql = "SELECT M.MEMBER_NO, M.MEMBER_ID, M.MEMBER_NAME, M.GENDER, M.BIRTHDAY, M.EMAIL, M.MEMBER_PICTURE, CM.ALLOWYN FROM MEMBER M LEFT OUTER JOIN CLUB_MEMBER CM\r\n"
				+ "      ON M.MEMBER_NO = CM.MEMBER_NO WHERE CM.CLUB_NO = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			System.out.println("3. 쿼리문 준비 : " + sql);

			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리문 실행 및 리턴");

			if (rs != null) {
				while (rs.next()) {
					ClubMemberVo cmvo = new ClubMemberVo();

					cmvo.setMemberNo(rs.getString(1));
					cmvo.setmemberId(rs.getString(2));
					cmvo.setMemberName(rs.getString(3));
					cmvo.setGender(rs.getString(4));
					cmvo.setbirthday(rs.getString(5));
					cmvo.setEmail(rs.getString(6));
					cmvo.setMemberPictureUrl(rs.getString(7));
					cmvo.setAllowYN(rs.getString(8));

					res.add(cmvo); // 쿼리 결과값 담아주기
				}
			} else {
				System.out.println("4. rs가 null 입니다.");
			}
			System.out.println(res);
		} catch (SQLException e) {
			System.out.println("3. 쿼리문 준비 오류");
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. db를 종료합니다.");
		}
		return res;
	}

	public int insertClub(ClubVo vo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;

		int res = 0;

		String sql = "INSERT INTO CLUB VALUES('CLUB' || CLUB_SEQUENCE.NEXTVAL, ?, ?, ?, ?, 'Y', 'Y', ?, ?, ?, 5, null, null )";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getClubName());
			pstmt.setString(2, vo.getClubCategoryNo());
			pstmt.setString(3, vo.getManagerNo());
			pstmt.setInt(4, vo.getClubTotal());
			pstmt.setString(5, vo.getClubAddress());
			pstmt.setString(6, vo.getClubContent());
			pstmt.setString(7, vo.getClubPicture());

			System.out.println("3. 쿼리문 준비" + sql);

			res = pstmt.executeUpdate();

			System.out.println("4. 쿼리문 실행 및 리턴");

			if (res > 0) {
				System.out.println("5. 성공적으로 Insert 되었습니다.");
				commit(con);
			} else {
				System.out.println("5. 쿼리문 insert 실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}

		return res;
	}

	public int clubMember_insert(String memberNo, String clubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = "INSERT INTO CLUB_MEMBER VALUES(?, ?, 'N', NULL, NULL)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, memberNo);

			System.out.println("3. sql문 준비 완료 : " + sql);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
				System.out.println("4. insert 완료");
			} else {
				System.out.println("4. insert 실패");
			}

		} catch (SQLException e) {
			System.out.println("3. 쿼리문 준비 실패");
		} finally {
			close(pstmt, con);
		}
		return res;
	}

	public ClubMemberVo selectClubMember(String clubNo, String userNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ClubMemberVo res = new ClubMemberVo();

		String sql = "SELECT * FROM CLUB_MEMBER WHERE CLUB_NO = ? AND MEMBER_NO = ?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, clubNo);
			pstmt.setString(2, userNo);
			System.out.println("3. 쿼리문 준비 완료 : " + sql);

			rs = pstmt.executeQuery();

			System.out.println("4. 쿼리문 실행");

			while (rs.next()) {
				res.setClubNo(rs.getString(1));
				res.setMemberNo(rs.getString(2));
				res.setAllowYN(rs.getString(3));
				res.setLastUpdateDate(rs.getString(4));
				res.setLastUpdateManager(rs.getString(5));

			}

			System.out.println(res);

		} catch (SQLException e) {
			System.err.println("3,4 쿼리문 실패");
		} finally {
			close(rs, pstmt, con);
		}

		return res;
	}

	public int apprMember(String insertMemberNo, String clubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = "UPDATE CLUB_MEMBER SET ALLOWYN = 'Y' WHERE MEMBER_NO = ? AND CLUB_NO= ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertMemberNo);
			pstmt.setString(2, clubNo);

			System.out.println("3. 쿼리문 준비 완료" + sql);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
				System.out.println("4. update 완료");
			} else {
				System.out.println("4. update 실패");
			}
		} catch (SQLException e) {
			System.out.println("3. 쿼리문 준비 오류");
		} finally {
			close(pstmt, con);
		}
		return res;
	}

	public int rejMember(String rejectMemberNo, String clubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "DELETE FROM CLUB_MEMBER WHERE MEMBER_NO = ? AND CLUB_NO = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rejectMemberNo);
			pstmt.setString(2, clubNo);

			System.out.println("3. 쿼리문 준비 완료  : " + sql);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
				System.out.println("4. delete 작업 완료");
			} else {
				System.out.println("4. delete 작업 실패");
			}

		} catch (SQLException e) {
			System.out.println("3. 쿼리문 준비 실패");
		} finally {
			close(pstmt, con);
		}

		return res;
	}

	public String searchClubNo(String clubName) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT CLUB_NO FROM CLUB WHERE CLUB_NAME = ?";
		String result = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubName);
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
		}
		return result;
	}

	public List<ClubListVo> recommendedClubList(String memberCategoryNo) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClubListVo> res = new ArrayList<ClubListVo>();

		String sql = " SELECT * FROM CLUBLIST_VIEW WHERE CATEGORY_NO = '" + memberCategoryNo
				+ "' ORDER BY CLUB_SCORE DESC ";
		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClubListVo tmp = new ClubListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));

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

	public int clubUpdate(ClubVo vo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = "UPDATE CLUB SET CLUB_CATEGORY_NO = ?, CLUB_TOTAL = ?, OPENYN = ?, RECRUITYN = ?, "
				+ "CLUB_ADDRESS= ?, CLUB_CONTENT = ?, CLUB_PICTURE = ? WHERE CLUB_NO = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getClubCategoryNo());
			pstmt.setInt(2, vo.getClubTotal());
			pstmt.setString(3, vo.getOpenYN());
			pstmt.setString(4, vo.getRecruitYN());
			pstmt.setString(5, vo.getClubAddress());
			pstmt.setString(6, vo.getClubContent());
			pstmt.setString(7, vo.getClubPicture());
			pstmt.setString(8, vo.getClubNo());

			System.out.println("3. 쿼리문 준비 완료 : " + sql);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
				System.out.println("4. 수정 완료");
			} else {
				System.out.println("4. 수정 실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("============5. db 종료===========");
		}

		return res;
	}

	public String searchCategoryNo(String memberNo) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT CATEGORY_NO FROM MYPAGE WHERE MEMBER_NO = ?";
		System.out.println("3. query 준비: " + sql);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNo);

			rs = pstmt.executeQuery();
			System.out.println("4. query 실행 및 리턴");

			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. db 종료\n");
		}

		return null;
	}
	
	public int kickMember(String kickUserNo, String clubNo) {
		// 멤버 추방
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "DELETE FROM CLUB_MEMBER WHERE CLUB_NO = ? AND MEMBER_NO =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, kickUserNo);
			System.out.println("3. 쿼리문 준비 "  + sql);
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(con);
				System.out.println("4. Delete 성공");
			} else {
				System.out.println("4. Delete 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt,con);
			System.out.println("================5. DB 종료=================");
		} 

		return res;
	}
	
	public int joinCancel(String userNo, String clubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "DELETE FROM CLUB_MEMBER WHERE CLUB_NO = ? AND MEMBER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, userNo);
			
			System.out.println("3. 쿼리문 준비완료 : " + sql);

			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(con);
				System.out.println("4. 쿼리문 실행 및 커밋완료 ");
			} else {
				System.out.println("4. 쿼리문 실행 실패");
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}

		return res;
	}
	
	public int clubNameChk(String clubName) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "SELECT COUNT(*) CNT FROM CLUB WHERE CLUB_NAME = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubName);
			System.out.println("3. 쿼리문 준비 완료" + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리문 실행 및 리턴");
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}

		return result;
	}
	
	public int clubMember_insert2(String memberNo, String clubNo) {
	      Connection con = getConnection();
	      PreparedStatement pstmt = null;
	      int res = 0;
	      
	      String sql = "INSERT INTO CLUB_MEMBER VALUES(?, ?, 'Y', NULL, NULL)";
	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, clubNo);
	         pstmt.setString(2, memberNo);
	         
	         System.out.println("3. sql문 준비 완료 : " + sql);
	         
	         res = pstmt.executeUpdate();
	         
	         if(res > 0) {
	            commit(con);
	            System.out.println("4. insert 완료");
	         } else {
	            System.out.println("4. insert 실패");
	         }
	         
	      
	      } catch (SQLException e) {
	         System.out.println("3. 쿼리문 준비 실패");
	      } finally {
	         close(pstmt, con);
	      }
	      return res;
	   }
	
	public int updateClubScore(int score, String clubNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		System.out.println("모임점수 플러스! clubNo : "+clubNo);
		String sql = "UPDATE CLUB SET CLUB_SCORE = ? WHERE CLUB_NO = ?";
		
		int originalScore = plusClubScore(clubNo);
		System.out.println("원래점수 : "+originalScore);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, score+originalScore);
			pstmt.setString(2, clubNo);
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			System.out.println("결과는? : "+res);
			
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
	
	public int plusClubScore(String clubNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT CLUB_SCORE FROM CLUB WHERE CLUB_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
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

	public int reqClubScorePlus(String userId) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = " UPDATE CLUB SET CLUB_SCORE = "+ 
				"((SELECT CLUB_SCORE FROM CLUB WHERE MANAGER_NO=(SELECT MEMBER_NO FROM MEMBER WHERE MEMBER_ID=?))+5) " + 
				"WHERE CLUB_NO= " + 
				"(SELECT CLUB_NO FROM CLUB WHERE MANAGER_NO=(SELECT MEMBER_NO FROM MEMBER WHERE MEMBER_ID=?)) ";
		

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			System.out.println("결과는? : "+res);
			
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

	public String id_mngClubNo(String userId) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String mngClubNO = null;
		
		String sql = " SELECT CLUB_NO FROM CLUB WHERE MANAGER_NO=(SELECT MEMBER_NO FROM MEMBER WHERE MEMBER_ID=?) ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			System.out.println("3. query 준비: " + sql);
		
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			rs.next();
			mngClubNO=rs.getString(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return mngClubNO;
	}

}