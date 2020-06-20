package momo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import momo.vo.ClassReviewListVo;
import momo.vo.ClassReviewVo;
import momo.vo.ClubReviewListVo;
import momo.vo.ClubReviewVo;
import momo.vo.TutorVo;

public class ClassReviewDao extends JDBCTemplate {

	public List<ClassReviewListVo> classReviewSelectAll() {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClassReviewListVo> res = new ArrayList<ClassReviewListVo>();

		String sql = " SELECT * FROM REVIEWCLASSLIST_VIEW ORDER BY DATE_CLASS_REVIEW DESC ";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비: " + sql);

			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) {
				ClassReviewListVo tmp = new ClassReviewListVo(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13),
						rs.getString(14));

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

	public ClassReviewVo classReviewDetail(String noClassReview) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ClassReviewVo res = new ClassReviewVo();

		String sql = " SELECT * FROM CLASS_REVIEW WHERE NO_CLASS_REVIEW = ? ";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비: " + sql);
			pstm.setString(1, noClassReview);

			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");

			while (rs.next()) {
				res = new ClassReviewVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db 종료\n");
		}

		return res;

	}


	public int writeClassReview(ClassReviewVo classReview) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String classNo = findClassNo(classReview);
		String tutorNo = findTutorNo(classNo);
		String tutorName = findTutorName(tutorNo);
		
		String sql = "INSERT INTO CLASS_REVIEW VALUES('CLASSR' || CLASS_REVIEW_SEQUENCE.NEXTVAL, ?, ?, ?, ?,"
				+ "?, ?, ?, SYSDATE, 0, ?, ?, 0, 'N', '강현주', SYSDATE)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classNo);
			pstmt.setString(2, classReview.getClassName());
			pstmt.setString(3, tutorNo);
			pstmt.setString(4, tutorName);
			pstmt.setString(5, classReview.getClassReviewTitle());
			pstmt.setString(6, classReview.getWriternoClassReview());
			pstmt.setString(7, classReview.getWriteridClassReview());
			pstmt.setString(8, classReview.getClassReviewContent());
			pstmt.setString(9, classReview.getClassReviewPicture());
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			
			if (res > 0) {
				return res;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. db 종료\n");
		}
		
		return res;
	}

	public String findClassNo(ClassReviewVo classReview) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT CLASS_NO FROM CLASS WHERE CLASS_NAME = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classReview.getClassName());
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			if(rs.next()) {
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

	private String findTutorNo(String classNo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT TUTOR_NO FROM CLASS WHERE CLASS_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classNo);
			
			rs = pstmt.executeQuery();
			
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

	private String findTutorName(String tutorNo) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MEMBER_NAME FROM MEMBER WHERE MEMBER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tutorNo);
			
			rs = pstmt.executeQuery();
			
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
	
	public ClassReviewVo selectOne(String classReviewNo) {
		System.out.println("다오들어와버림");
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassReviewVo res = new ClassReviewVo();
		
		String sql = "SELECT CLASS_NAME, NO_CLASS_REVIEW, TITLE_CLASS_REVIEW, CONTENT_CLASS_REVIEW, PICTURE_CLASS_REVIEW "
				+ "FROM CLASS_REVIEW WHERE NO_CLASS_REVIEW = ?";
		
		ClassReviewVo classReview = new ClassReviewVo();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classReviewNo);
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			if (rs.next()) {
				res.setClassName(rs.getString(1));
				res.setClassReviewNo(rs.getString(2));
				res.setClassReviewTitle(rs.getString(3));
				res.setClassReviewContent(rs.getString(4));
				res.setClassReviewPicture(rs.getString(5));
			}
			
			System.out.println(res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. db 종료\n");
		}
		return res;
	}
	
	public int updateClassReview(ClassReviewVo classReview) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "UPDATE CLASS_REVIEW SET TITLE_CLASS_REVIEW = ?, CLASS_NO = ?, CLASS_NAME = ?, TUTOR_NO = ?, TUTOR_NAME = ?, CONTENT_CLASS_REVIEW = ?, PICTURE_CLASS_REVIEW = ?"
				+ " WHERE NO_CLASS_REVIEW = ?";
		
		String classNo = findClassNo(classReview);
		String tutorNo = findTutorNo(classNo);
		String tutorName = findTutorName(tutorNo);
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classReview.getClassReviewTitle());
			pstmt.setString(2, classNo);
			pstmt.setString(3, classReview.getClassName());
			pstmt.setString(4, tutorNo);
			pstmt.setString(5, tutorName);
			pstmt.setString(6, classReview.getClassReviewContent());
			pstmt.setString(7, classReview.getClassReviewPicture());
			pstmt.setString(8, classReview.getClassReviewNo());
			System.out.println("3. query 준비: " + sql);
			
			res = pstmt.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			
			if (res > 0) {
				return res;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. db 종료\n");
		}
		
		return 0;
	}

	public int classReviewDelete(String classReviewNo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE CLASS_REVIEW SET DELETEYN_CLASS_REVIEW = 'Y' WHERE NO_CLASS_REVIEW = ? ";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비: " + sql);
			pstm.setString(1, classReviewNo);

			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");

			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm, con);
			System.out.println("5. db 종료\n");
		}
		
		return res;
	}
}
