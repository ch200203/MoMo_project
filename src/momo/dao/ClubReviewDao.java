package momo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import momo.vo.ClubReviewListVo;
import momo.vo.ClubReviewVo;

public class ClubReviewDao extends JDBCTemplate {

	public List<ClubReviewListVo> clubReviewSelectAll() {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ClubReviewListVo> res = new ArrayList<ClubReviewListVo>();

		String sql = " SELECT * FROM REVIEWCLUBLIST_VIEW ORDER BY DATE_CLUB_REVIEW DESC ";
		System.out.println("3. query 준비: " + sql);

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("4. query 실행 및 리턴");

			rs = pstm.executeQuery();
			while (rs.next()) {
				ClubReviewListVo tmp = new ClubReviewListVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));

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
	
	public ClubReviewVo clubReviewDetail(String noClubReview) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ClubReviewVo res = new ClubReviewVo();

		String sql = " SELECT * FROM CLUB_REVIEW WHERE NO_CLUB_REVIEW = ? ";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비: " + sql);
			pstm.setString(1, noClubReview);

			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");

			while (rs.next()) {
				res = new ClubReviewVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db 종료\n");
		}

		return res;
	}

	public int clubReviewDelete(String clubReviewNo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE CLUB_REVIEW SET DELETEYN_CLUB_REVIEW = 'Y' WHERE NO_CLUB_REVIEW = ? ";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비: " + sql);
			pstm.setString(1, clubReviewNo);

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

	public int writeClubReview(ClubReviewVo clubReview) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String clubNo = findClubNo(clubReview);
		
		String sql = "INSERT INTO CLUB_REVIEW VALUES('CLUBR' || CLUB_REVIEW_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE, 0, ?, ?, 0, 'N', '강현주', SYSDATE)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, clubReview.getClubName());
			pstmt.setString(3, clubReview.getClubReviewTitle());
			pstmt.setString(4, clubReview.getMemberNo());
			pstmt.setString(5, clubReview.getMemberId());
			pstmt.setString(6, clubReview.getClubReviewContent());
			pstmt.setString(7, clubReview.getClubReviewPicture());
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
	
	public String findClubNo(ClubReviewVo club) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT CLUB_NO FROM CLUB WHERE CLUB_NAME = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, club.getClubName());
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

	public ClubReviewVo selectOne(String clubReviewNo) {
		System.out.println("다오들어와버림");
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClubReviewVo res = new ClubReviewVo();
		
		String sql = "SELECT CLUB_NAME, NO_CLUB_REVIEW, TITLE_CLUB_REVIEW, CONTENT_CLUB_REVIEW, PICTURE_CLUB_REVIEW "
				+ "FROM CLUB_REVIEW WHERE NO_CLUB_REVIEW = ?";
		
		ClubReviewVo clubReview = new ClubReviewVo();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubReviewNo);
			System.out.println("3. query 준비: " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			if (rs.next()) {
				res.setClubName(rs.getString(1));
				res.setClubReviewNo(rs.getString(2));
				res.setClubReviewTitle(rs.getString(3));
				res.setClubReviewContent(rs.getString(4));
				res.setClubReviewPicture(rs.getString(5));
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

	public int updateClubReview(ClubReviewVo clubReview) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "UPDATE CLUB_REVIEW SET TITLE_CLUB_REVIEW = ?, CLUB_NO = ?, CLUB_NAME = ?, CONTENT_CLUB_REVIEW = ?, PICTURE_CLUB_REVIEW = ?"
				+ " WHERE NO_CLUB_REVIEW = ?";
		
		String clubNo = findClubNo(clubReview);
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubReview.getClubReviewTitle());
			pstmt.setString(2, clubNo);
			pstmt.setString(3, clubReview.getClubName());
			pstmt.setString(4, clubReview.getClubReviewContent());
			pstmt.setString(5, clubReview.getClubReviewPicture());
			pstmt.setString(6, clubReview.getClubReviewNo());
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
	
	   public List<ClubReviewListVo> clubReviewSelectTopSix() {

		      Connection con = getConnection();
		      PreparedStatement pstm = null;
		      ResultSet rs = null;

		      List<ClubReviewListVo> res = new ArrayList<ClubReviewListVo>();

		      String sql = " SELECT * FROM REVIEWCLUBLIST_VIEW WHERE DELETEYN_CLUB_REVIEW = 'N' ORDER BY HIT_CLUB_REVIEW DESC ";
		      System.out.println("3. query 준비: " + sql);

		      try {
		         pstm = con.prepareStatement(sql);
		         System.out.println("4. query 실행 및 리턴");

		         rs = pstm.executeQuery();

		         int cnt = 0;

		         while (rs.next()) {
		            ClubReviewListVo tmp = new ClubReviewListVo(rs.getString(1), rs.getString(2), rs.getString(3),
		                  rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
		                  rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));

		            res.add(tmp);

		            cnt++;
		            if (cnt == 6) {
		               break;
		            }
		         }

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rs, pstm, con);
		         System.out.println("5. db 종료\n");
		      }

		      return res;

		   }


}
