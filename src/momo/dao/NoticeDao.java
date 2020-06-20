package momo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JDBCTemplate;
import momo.vo.NoticeVo;
import momo.vo.PagingVo;

public class NoticeDao extends JDBCTemplate {

	public List<NoticeVo> selectAll(PagingVo paging) {
		
		   int startNum = paging.getStartNum();
	       int endNum = paging.getEndNum();
	       
	       System.out.println(startNum);
	       System.out.println(endNum);

		// TODO Auto-generated method stub
		Connection con=getConnection();
		PreparedStatement pstm =null;
		ResultSet rs=null;
		List<NoticeVo> res= new ArrayList<>();
		

		
		String sql="SELECT * FROM (SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY N.NO_NOTICE DESC) row_num, N.* FROM NOTICE N) WHERE row_num >= ?) WHERE row_num <=?";
		
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, startNum);
			pstm.setInt(2, endNum);
			
			System.out.println("3. query 준비: " + sql);

			rs = pstm.executeQuery();
			
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) {
				NoticeVo vo=new NoticeVo();
				
				vo.setRownum(rs.getInt(1));
				 vo.setNoNotice(rs.getInt(2));
				 vo.setPageNoNotice(rs.getInt(3));
				 vo.setTitleNotice(rs.getString(4));
				 vo.setWriterNotice(rs.getString(5));
				 vo.setDateNotice(rs.getString(6));
				
				 vo.setHitNotice(rs.getInt(7));
				 vo.setContentNotice(rs.getString(8));
				 vo.setDeleteYNNotice(rs.getString(9));
				 vo.setLastUpdateDate(rs.getString(10));
				 vo.setLastUpdateDate(rs.getString(11));
				

				 
				res.add(vo);
			
			}
			System.out.println(res.size());
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			close(rs,pstm,con);
			System.out.println("5.db 종료\n");
		}
		return res;
		
		
	}
	
	public int countNotice() {
		
		Connection con=getConnection();
		PreparedStatement pstm =null;
		ResultSet cnt = null;
		int cnt2 =0;
		
		String sql = "SELECT COUNT(*) FROM NOTICE";
		
		try {
			pstm = con.prepareStatement(sql);
			cnt = pstm.executeQuery();
			
			while(cnt.next()) {
				
				cnt2 = cnt.getInt(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt2;
	}
	
	public int insert(NoticeVo vo) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql="INSERT INTO NOTICE "
				+ "VALUES(NO_NOTICE_SQ.NEXTVAL,PAGENO_NOTICE_SQ.NEXTVAL,?,'dd',SYSDATE,0,?,'N',NULL,NULL)";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitleNotice());
			pstmt.setString(2, vo.getContentNotice());
			
			System.out.println(sql);
			
			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, con);
		}

		
		
		return res;
	}
	
	

	public NoticeVo selectOne(int noNotice) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		NoticeVo res = new NoticeVo();
		
		
		String sql = "SELECT * FROM  NOTICE WHERE  NO_NOTICE=?";
		
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noNotice);
			
			rs=pstm.executeQuery();
			
			while (rs.next()) {
				
				res.setNoNotice(rs.getInt(1));
				res.setPageNoNotice(rs.getInt(2));
				res.setTitleNotice(rs.getString(3));
				res.setWriterNotice(rs.getString(4));
				res.setDateNotice(rs.getString(5));
				res.setHitNotice(rs.getInt(6));
				res.setContentNotice(rs.getString(7));
				res.setDeleteYNNotice(rs.getString(8));
				res.setLastUpdateDate(rs.getString(9));
				res.setLastUpdateManager(rs.getString(10));
				
				
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close (rs,pstm,con);
		}
		
		
		
		
		return res;
	}
	
	public int hitNotice(NoticeVo vo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "UPDATE NOTICE SET HIT_NOTICE=HIT_NOTICE+1 WHERE NO_NOTICE=?";
		
		
		try {
			pstm=con.prepareStatement(sql);
		
			pstm.setInt(1, vo.getNoNotice());
			
			res = pstm.executeUpdate();
			
			
			if(res>0) {
				commit(con);
			}
			
		}catch(SQLException e){
			System.out.println("updateHit_Notice err:"+e);
		}finally {
			close(pstm,con);
		}
		
		return res;
	}
	
	

	public int update(NoticeVo vo) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE NOTICE SET TITLE_NOTICE=?,CONTENT_NOTICE=? WHERE NO_NOTICE=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, vo.getTitleNotice());
			pstm.setString(2, vo.getContentNotice());
			pstm.setInt(3, vo.getNoNotice());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstm,con);
		}
		
		
		
		return res;
	}
	
	public int delete(int noNotice) {
		
		Connection con= getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "DELETE FROM NOTICE WHERE NO_NOTICE=?";
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noNotice);
			
			res = pstm.executeUpdate();
			
			if (res>0) {
				commit(con);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm,con);
		}
		
		return res;
	}

	public String sysdate() {
		
		Date date = new Date();
		SimpleDateFormat format2 = new SimpleDateFormat("yy/MM/dd");
		System.out.println(format2.format(date));
		
		String str = format2.format(date);

		return str;
	}
	
	

}
