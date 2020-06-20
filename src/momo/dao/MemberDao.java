package momo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import momo.vo.MemberVo;
import momo.vo.MypageVo;
import momo.vo.TutorVo;

public class MemberDao extends JDBCTemplate {
	
	public MemberVo login(String id, String pwd) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo res = null;
		
		String sql = "SELECT MEMBER_NO, MEMBER_ID, MEMBER_PWD FROM MEMBER WHERE MEMBER_ID = ?"; //controller에서 넘어온 id를 가진 member의 id와 pwd조회
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			if (rs.next()) { //같은 id의 member가 존재할 경우
				if (rs.getString(3).equals(pwd)) { //controller에서 넘어온 pwd와 member의 pwd가 같은지 비교
					res = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3)); //같다면 res 객체에 member의 id와 pwd를 담음
					
				} else { //pwd가 틀렸을 경우
					res = new MemberVo(rs.getString(1), rs.getString(2), null); //res에 id와 pwd=null을 담음
				}
			} else { //조회된 id가 없을 경우
				res = null; //res에 null을 담아줌
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return res;
	}

	public String searchId(String memberName, String email) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NAME = ? AND EMAIL = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, email);
			System.out.println("3. query 준비: " + sql);
			
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

	public String searchPwd(String memberName, String memberId, String email) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "UPDATE MEMBER SET MEMBER_PWD = ? WHERE MEMBER_NAME = ? AND MEMBER_ID = ? AND EMAIL = ?";
		
		try {
			String newPwd = Integer.toString((int)(Math.random()*1000000)+100000);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, memberName);
			pstmt.setString(3, memberId);
			pstmt.setString(4, email);
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			
			if (res > 0) {
				return newPwd;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return null;
	}
	
	public String selectId(String id) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?"; 
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			System.out.println("3. query 준비: " + sql);
			
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
	
	public int signup(MemberVo member) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "INSERT INTO MEMBER VALUES ('M' || MEMBER_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, 0, 'N', 'N', ?, 'INITIAL', '강현주')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getBirthday());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberPicture());
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return res;
	}

	public MypageVo selectOne(String userId) {
	
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MYPAGE WHERE MEMBER_ID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				MypageVo mypage = new MypageVo();
				mypage.setMemberNo(rs.getString("MEMBER_NO"));
				mypage.setMemberId(rs.getString("MEMBER_ID"));
				mypage.setMemberPwd(rs.getString("MEMBER_PWD"));
				mypage.setMemberName(rs.getString("MEMBER_NAME"));
				mypage.setBirthday(rs.getString("BIRTHDAY"));
				mypage.setEmail(rs.getString("EMAIL"));
				mypage.setPhone(rs.getString("PHONE"));
				mypage.setMemberAddress(rs.getString("MEMBER_ADDRESS"));
				mypage.setMemberScore(rs.getInt("MEMBER_SCORE"));
				mypage.setMemberPicture(rs.getString("MEMBER_PICTURE"));
				mypage.setTutorYN(rs.getString("TUTORYN"));
				mypage.setManagerYN(rs.getString("MANAGERYN"));
				mypage.setCategoryNo(rs.getString("CATEGORY_NO"));
				mypage.setCategoryName(rs.getString("CATEGORY_NAME"));
				System.out.println("4. 쿼리 실행");
				
				return mypage;
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

	public int updateMypage(MypageVo mypage, String userId) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "UPDATE MEMBER SET MEMBER_PWD = ?, EMAIL = ?, PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_PICTURE = ? WHERE MEMBER_ID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mypage.getMemberPwd());
			pstmt.setString(2, mypage.getEmail());
			pstmt.setString(3, mypage.getPhone());
			pstmt.setString(4, mypage.getMemberAddress());
			pstmt.setString(5, mypage.getMemberPicture());
			pstmt.setString(6, userId);
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			
			if (res > 0) {
				return res;
			} else {
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

	public int updateMyCategory(MypageVo mypage, String userId) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String categoryNo = findCategoryNo(mypage);
		String memberNo = findMemberNo(userId);
		
		String sql = "UPDATE MEMBER_CATEGORY SET CATEGORY_NO = ? WHERE MEMBER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, categoryNo);
			pstmt.setString(2, memberNo);
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			
			if (res > 0) {
				return res;
			} else {
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

	private String findCategoryNo(MypageVo mypage) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mypage.getCategoryName());
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			if (rs.next()) {
				String categoryNo = rs.getString(1);
				
				return categoryNo;
				
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
	
	public String findMemberNo(String userId) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MEMBER_NO FROM MEMBER WHERE MEMBER_ID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			if (rs.next()) {
				String memberNo = rs.getString(1);
				
				return memberNo;
				
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
	
	public int registerTutor(String id) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String memberNo = findMemberNo(id);
		System.out.println(memberNo);
		
		String sql = "INSERT INTO TUTOR VALUES(?, 0, null, null, null, null, SYSDATE, '강현주')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			System.out.println("res : " +res);
			
			if (res > 0) {
				int res2 = updateTutorYN(memberNo);
				System.out.println("res2 : " +res2);
				
				return res2;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return 0;
	}

	private int updateTutorYN(String userNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "UPDATE MEMBER SET TUTORYN = 'Y' WHERE MEMBER_NO = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNo);
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
		
		return 0;
	}
	
	public int updateTutor(TutorVo tutor, String userNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "UPDATE TUTOR SET TUTOR_INTRODUCE = ?, EDUCATION_FILE = ?, EXPERIENCE_FILE = ?, CERTIFICATE_FILE = ? WHERE TUTOR_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tutor.getTutorIntroduce());
			pstmt.setString(2, tutor.getEducationFile());
			pstmt.setString(3, tutor.getExperienceFile());
			pstmt.setString(4, tutor.getCertificateFile());
			pstmt.setString(5, userNo);
			
			System.out.println("3. query 준비: " + sql);
			
			
			
			res = pstmt.executeUpdate();
			System.out.println("res : "+res);
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
		
		return 0;
	}

	public TutorVo tutorInfo(String userNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TUTOR WHERE TUTOR_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNo);
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			if (rs.next()) {
				TutorVo tmp = new TutorVo(rs.getString("TUTOR_NO"), rs.getString("TUTOR_INTRODUCE"), rs.getString("EDUCATION_FILE"), rs.getString("EXPERIENCE_FILE"), rs.getString("CERTIFICATE_FILE"));
				return tmp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return null;
	}

	public String selectTutorYN(String userNo) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT TUTORYN FROM MEMBER WHERE MEMBER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNo);
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		return null;
	}

	public int updateMemberScore(int score, String userNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "UPDATE MEMBER SET MEMBER_SCORE = ? WHERE MEMBER_NO = ?";
		
		int originalScore = plusMemberScore(userNo);
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, score+originalScore);
			pstmt.setString(2, userNo);
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. 쿼리 실행");
			
			if (res > 0) {
				System.out.println("회원점수 + !");
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
	
	public int plusMemberScore(String userNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MEMBER_SCORE FROM MEMBER WHERE MEMBER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNo);
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
	
	
	
}