package momo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import momo.vo.LikeVo;

public class likeDao extends JDBCTemplate{
	public int insertLike(String memberNo, String clubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "INSERT INTO LIKE_TABLE VALUES(?, ?, 'Y')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, memberNo);
			System.out.println("3. 쿼리문 준비 완료 : " + sql);
			
			res = pstmt.executeUpdate();
			
			if(res > 0 ) {
				commit(con);
				System.out.println("4. insert 완료");
			} else {
				System.out.println("4. insert 실패");
			} 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. db 종료 ===================");
		}
		
		return res;
	}

	public int deleteLike(String memberNo, String clubNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "DELETE FROM LIKE_TABLE WHERE LIKE_NAME=? AND MEMBER_NO=? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, memberNo);
			
			System.out.println("3. 쿼리문 준비 완료 : " + sql);
			
			res = pstmt.executeUpdate();
			
			if(res > 0 ) {
				commit(con);
				System.out.println("4. insert 완료");
			} else {
				System.out.println("4. insert 실패");
			} 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt, con);
			System.out.println("5. db 종료 ===================");
		}
	
		return res;
	}

	public LikeVo selectLike(String clubNo, String userNo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LikeVo res = new LikeVo();
		
		System.out.println(clubNo + userNo);
		
		String sql = "SELECT LIKE_NAME, MEMBER_NO, LIKEYN, "
				+ "(SELECT COUNT(LIKEYN) CNT FROM LIKE_TABLE WHERE LIKE_NAME =?) CNT"
				+ " FROM LIKE_TABLE "
				+ "WHERE LIKE_NAME =? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clubNo);
			pstmt.setString(2, clubNo);
			System.out.println("3. 쿼리문 준비 완료 : " + sql);
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리문 실행 및 리턴");
			
			while(rs.next()) {
				res.setLikeName(rs.getString(1));
				res.setMemberNo(rs.getString(2));
				res.setLikeYN(rs.getString(3));
				res.setLikeCnt(rs.getInt(4));
			}
			
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. db 종료 =============");
		}
		
		return res;
	}
	
}
