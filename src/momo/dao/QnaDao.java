package momo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import momo.vo.PagingVo;
import momo.vo.QnaReplyVo;
import momo.vo.QnaVo;

public class QnaDao extends JDBCTemplate {

	public List<QnaVo> qnaSelectAll(PagingVo paging) {
		   int startNum = paging.getStartNum();
	       int endNum = paging.getEndNum();
	       
	       System.out.println("startNum"+startNum);
	       System.out.println("endNum"+endNum);

		Connection con=getConnection();
		PreparedStatement pstm =null;
		ResultSet rs=null;
		List<QnaVo> res = new ArrayList<>();
		
		String sql=" SELECT * FROM (SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY Q.NO_QNA DESC) row_num, Q.* FROM QNA Q WHERE DELETEYN_QNA='N') WHERE row_num >= ?) WHERE row_num <=? ";
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, startNum);
			pstm.setInt(2, endNum);
			
			System.out.println("3. query 준비: " + sql);

			rs = pstm.executeQuery();
			
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) {
				QnaVo vo=new QnaVo();
				
				vo.setRownum(rs.getInt(1));
				vo.setNoQna(rs.getInt(2));
				vo.setPageNoQna(rs.getInt(3));
				vo.setTitleQna(rs.getString(4));
				vo.setWriterQna(rs.getString(5));
				vo.setDateQna(rs.getString(6));
				vo.setHitQna(rs.getInt(7));
				vo.setContentQna(rs.getString(8));
				vo.setDeleteYNQna(rs.getString(9));
				vo.setShowYNQna(rs.getString(10));
				vo.setPwdQna(rs.getString(11));
				
				res.add(vo);
			
			}
			System.out.println("res(qnaList) : "+res);
			System.out.println(res.size());
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			close(rs,pstm,con);
			System.out.println("5. 드라이버 종료");
		}
		return res;
		
	}

	public int insertQna(QnaVo qnaVo) {
		
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO QNA VALUES(NO_QNA_SQ.NEXTVAL, PAGENO_QNA_SQ.NEXTVAL, ?, ?, SYSDATE, 0, ?, 'N', ?, ?, SYSDATE, '관리자') ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, qnaVo.getTitleQna());		
				pstm.setString(2, qnaVo.getWriterQna());
				pstm.setString(3, qnaVo.getContentQna());
				pstm.setString(4, qnaVo.getShowYNQna());
				pstm.setString(5, qnaVo.getPwdQna());
				
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

	public QnaVo qnaSelectOne(int noQna) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		QnaVo qnaVo = new QnaVo();
		
		System.out.println("쿼리문에 넣어줄 noQna : "+noQna);
		
		String sql = " SELECT * FROM QNA WHERE NO_QNA=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noQna);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리문실행");
			
			while(rs.next()) {
				qnaVo.setNoQna(rs.getInt(1));
				qnaVo.setPageNoQna(rs.getInt(2));
				qnaVo.setTitleQna(rs.getString(3));
				qnaVo.setWriterQna(rs.getString(4));
				qnaVo.setDateQna(rs.getString(5));
				qnaVo.setHitQna(rs.getInt(6));
				qnaVo.setContentQna(rs.getString(7));
				qnaVo.setDeleteYNQna(rs.getString(8));
				qnaVo.setShowYNQna(rs.getString(9));
				qnaVo.setPwdQna(rs.getString(10));
				
			System.out.println("qnaVo: "+qnaVo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,pstm,con);
		}
		return qnaVo;
	}

	public int qnaDelete(String noQna) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int rs = 0;
		
		System.out.println("쿼리문에 넣어줄 noQna : "+noQna);
		String sql = " UPDATE QNA SET DELETEYN_QNA='Y' WHERE NO_QNA=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, noQna);	
				
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

	public int dateQnaUpdate(int noQna, int hitQna) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE QNA SET HIT_QNA=?+1 WHERE NO_QNA=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
					pstm.setInt(1, hitQna);		
					pstm.setInt(2, noQna);		
					
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

	public int qnaUpdate(QnaVo qnaVo) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE QNA SET TITLE_QNA=?, CONTENT_QNA=?, SHOWYN_QNA=?, PWD_QNA=? WHERE NO_QNA=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
					
					pstm.setString(1, qnaVo.getTitleQna());
					pstm.setString(2, qnaVo.getContentQna());
					pstm.setString(3, qnaVo.getShowYNQna());
					pstm.setString(4, qnaVo.getPwdQna());
					pstm.setInt(5, qnaVo.getNoQna());
					
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

	public int replyYN(int noQna) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int reNo = 0;
		
		System.out.println("쿼리문에 넣어줄 noQna : "+noQna);
		
		String sql = " SELECT RE_NO_QNA FROM QNA_REPLY WHERE NO_QNA=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noQna);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리문실행");
			
			if(rs.next())	{
				reNo = rs.getInt(1);
			} else {
				reNo = 0;
			}
			
			
			System.out.println("reNo: "+reNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,pstm,con);
		}
		return reNo;
	}

	public int insertQnaRpl(int noQna, String userId, String rplContent) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO QNA_REPLY VALUES(?, ?, '제목없음', ?, SYSDATE, ?, 'N', 'Y', SYSDATE, '관리자') ";
		
			try {
				pstm = con.prepareStatement(sql);
				
				pstm.setInt(1, noQna);		
				pstm.setInt(2, noQna);
				pstm.setString(3, userId);
				pstm.setString(4, rplContent);
				
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

	public QnaReplyVo RplSelectOne(int noQna) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		QnaReplyVo qnarplVo = new QnaReplyVo();
		
		System.out.println("쿼리문에 넣어줄 noQna : "+noQna);
		
		String sql = " SELECT * FROM QNA_REPLY WHERE NO_QNA=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noQna);
			
			rs = pstm.executeQuery();
			System.out.println("쿼리문실행");
			
			while(rs.next()) {
				qnarplVo.setReNoQna(rs.getInt(1));
				qnarplVo.setNoQna(rs.getInt(2));
				qnarplVo.setReWriterQna(rs.getString(4));
				qnarplVo.setReDateQna(rs.getString(5));
				qnarplVo.setReContentQna(rs.getString(6));
				
			System.out.println("qnarplVo: "+qnarplVo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,pstm,con);
		}
		return qnarplVo;
		
		
	}

	public int updateQnaRpl(int noQna, String userId, String rplContent) {
		Connection con = getConnection();
		System.out.println("연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE QNA_REPLY SET RE_WRITER_QNA=?, RE_CONTENT_QNA=? WHERE NO_QNA=? ";
		
			try {
				pstm = con.prepareStatement(sql);
				
					
					pstm.setString(1, userId);
					pstm.setString(2, rplContent);
					pstm.setInt(3, noQna);
					
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

	public List<String> qnaRpl() {
		List<String> rplList = new ArrayList<>();
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT RE_NO_QNA FROM QNA_REPLY "; 
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("3. statement 객체 생성");
			
			rs = pstmt.executeQuery();
			System.out.println("4. 쿼리 실행");
			
			while(rs.next()) { 
				String rplNo = Integer.toString(rs.getInt(1));
				rplList.add(rplNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
			System.out.println("5. 드라이버 종료");
		}
		
		System.out.println("rplList : "+rplList);
		return rplList;
	}

	//Q&A 페이징

	public int countQna() {
		
		Connection con=getConnection();
		PreparedStatement pstm =null;
		ResultSet cnt = null;
		int cnt2 =0;
		
		String sql = "SELECT COUNT(*) FROM QNA";	//총 게시글 개수
		
		try {
			pstm = con.prepareStatement(sql);
			cnt = pstm.executeQuery();
			
			while(cnt.next()) {
				
				cnt2 = cnt.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(cnt, pstm, con);
			System.out.println("5. 드라이버 종료");
		}
		
		
		return cnt2;
	}

	public String showYN_noQna(int noQna) {
		
		Connection con=getConnection();
		PreparedStatement pstm =null;
		ResultSet rs = null;
		String showYN = null;
		
		String sql = "SELECT SHOWYN_QNA FROM QNA WHERE NO_QNA=? ";	//공개여부
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noQna);
			rs = pstm.executeQuery();
			
			rs.next();
			showYN = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. 드라이버 종료");
		}
		
		
		return showYN;
	}

	public String no_pass(int noQna) {
		
		Connection con=getConnection();
		PreparedStatement pstm =null;
		ResultSet rs = null;
		String chk_pass = null;
		
		String sql = "SELECT PWD_QNA FROM QNA WHERE NO_QNA=? ";	//비밀번호 가져오기
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noQna);
			rs = pstm.executeQuery();
			
			rs.next();
			chk_pass = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			close(rs, pstm, con);
			System.out.println("5. 드라이버 종료");
		}
		
		
		return chk_pass;
	}

	public String no_writer(int noQna) {
		
		Connection con=getConnection();
		PreparedStatement pstm =null;
		ResultSet rs = null;
		String writer = null;
		
		String sql = "SELECT WRITER_QNA FROM QNA WHERE NO_QNA=? ";	//비밀번호 가져오기
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, noQna);
			rs = pstm.executeQuery();
			
			rs.next();
			writer = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			close(rs, pstm, con);
			System.out.println("5. 드라이버 종료");
		}
		
		
		return writer;
	}

	public List<QnaVo> qnaSelectMy(PagingVo paging, String userId) {
		int startNum = paging.getStartNum();
        int endNum = paging.getEndNum();
          
          System.out.println("startNum"+startNum);
          System.out.println("endNum"+endNum);

      Connection con=getConnection();
      PreparedStatement pstm =null;
      ResultSet rs=null;
      List<QnaVo> res = new ArrayList<>();
      
      String sql=" SELECT * FROM (SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY Q.NO_QNA DESC) row_num, Q.* FROM QNA Q WHERE DELETEYN_QNA='N' AND WRITER_QNA=?) WHERE row_num >= ?) WHERE row_num <=? ";
      
      try {
         
         pstm = con.prepareStatement(sql);
         pstm.setString(1, userId);
         pstm.setInt(2, startNum);
         pstm.setInt(3, endNum);
         
         System.out.println("3. query 준비: " + sql);

         rs = pstm.executeQuery();
         
         System.out.println("4. query 실행 및 리턴");
         while (rs.next()) {
            QnaVo vo=new QnaVo();
            
            vo.setRownum(rs.getInt(1));
            vo.setNoQna(rs.getInt(2));
            vo.setPageNoQna(rs.getInt(3));
            vo.setTitleQna(rs.getString(4));
            vo.setWriterQna(rs.getString(5));
            vo.setDateQna(rs.getString(6));
            vo.setHitQna(rs.getInt(7));
            vo.setContentQna(rs.getString(8));
            vo.setDeleteYNQna(rs.getString(9));
            vo.setShowYNQna(rs.getString(10));
            vo.setPwdQna(rs.getString(11));
            
            res.add(vo);
         
         }
         System.out.println("res(qnaList) : "+res);
         System.out.println(res.size());
         
      }catch (SQLException e){
         e.printStackTrace();
      }finally {
         close(rs,pstm,con);
         System.out.println("5. 드라이버 종료");
      }
      return res;		
	}

}
