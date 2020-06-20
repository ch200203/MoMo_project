package momo.vo;

public class QnaVo {
	
	private int rownum;					//페이징에 필요한 필드
	private int noQna;					//글번호
	private int pageNoQna;				//페이지번호
	private String titleQna;			//제목
	private String writerQna;			//작성자
	private String dateQna;				//작성일
	private int hitQna;					//조회수
	private String contentQna;			//내용
	private String deleteYNQna;			//삭제여부
	private String showYNQna;			//공개여부
	private String pwdQna;				//비공개 비밀번호
	private String lastUpdateDate;		//최근수정일
	private String lastUpdateManager;	//최근수정관리자
	
	public QnaVo() {}

	public QnaVo(int rownum, int noQna, int pageNoQna, String titleQna, String writerQna, String dateQna, int hitQna,
			String contentQna, String deleteYNQna, String showYNQna, String pwdQna, String lastUpdateDate,
			String lastUpdateManager) {
		super();
		this.rownum = rownum;
		this.noQna = noQna;
		this.pageNoQna = pageNoQna;
		this.titleQna = titleQna;
		this.writerQna = writerQna;
		this.dateQna = dateQna;
		this.hitQna = hitQna;
		this.contentQna = contentQna;
		this.deleteYNQna = deleteYNQna;
		this.showYNQna = showYNQna;
		this.pwdQna = pwdQna;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}

	//Q&A 목록에 불러올 생성자
	public QnaVo(int rownum, int noQna, int pageNoQna, String titleQna, String writerQna, String dateQna, int hitQna,
			String contentQna, String deleteYNQna, String showYNQna, String pwdQna) {
		super();
		this.rownum = rownum;
		this.noQna = noQna;
		this.pageNoQna = pageNoQna;
		this.titleQna = titleQna;
		this.writerQna = writerQna;
		this.dateQna = dateQna;
		this.hitQna = hitQna;
		this.contentQna = contentQna;
		this.deleteYNQna = deleteYNQna;
		this.showYNQna = showYNQna;
		this.pwdQna = pwdQna;
	}

	//글쓰기에 필요한 생성자
	public QnaVo(String titleQna, String writerQna, String contentQna, String showYNQna, String pwdQna) {
		super();
		this.titleQna = titleQna;
		this.writerQna = writerQna;
		this.contentQna = contentQna;
		this.showYNQna = showYNQna;
		this.pwdQna = pwdQna;
	}
	
	//글 수정시 필요한 생성자
	public QnaVo(int noQna, String titleQna, String contentQna, String showYNQna, String pwdQna) {
		super();
		this.noQna = noQna;
		this.titleQna = titleQna;
		this.contentQna = contentQna;
		this.showYNQna = showYNQna;
		this.pwdQna = pwdQna;
	}
	
	
	
	
	
	
	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getNoQna() {
		return noQna;
	}

	public void setNoQna(int noQna) {
		this.noQna = noQna;
	}

	public int getPageNoQna() {
		return pageNoQna;
	}

	public void setPageNoQna(int pageNoQna) {
		this.pageNoQna = pageNoQna;
	}

	public String getTitleQna() {
		return titleQna;
	}

	public void setTitleQna(String titleQna) {
		this.titleQna = titleQna;
	}

	public String getWriterQna() {
		return writerQna;
	}

	public void setWriterQna(String writerQna) {
		this.writerQna = writerQna;
	}

	public String getDateQna() {
		return dateQna;
	}

	public void setDateQna(String dateQna) {
		this.dateQna = dateQna;
	}

	public int getHitQna() {
		return hitQna;
	}

	public void setHitQna(int hitQna) {
		this.hitQna = hitQna;
	}

	public String getContentQna() {
		return contentQna;
	}

	public void setContentQna(String contentQna) {
		this.contentQna = contentQna;
	}

	public String getDeleteYNQna() {
		return deleteYNQna;
	}

	public void setDeleteYNQna(String deleteYNQna) {
		this.deleteYNQna = deleteYNQna;
	}

	public String getShowYNQna() {
		return showYNQna;
	}

	public void setShowYNQna(String showYNQna) {
		this.showYNQna = showYNQna;
	}

	public String getPwdQna() {
		return pwdQna;
	}

	public void setPwdQna(String pwdQna) {
		this.pwdQna = pwdQna;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateManager() {
		return lastUpdateManager;
	}

	public void setLastUpdateManager(String lastUpdateManager) {
		this.lastUpdateManager = lastUpdateManager;
	}

	@Override
	public String toString() {
		return "QnaVo [rownum=" + rownum + ", noQna=" + noQna + ", pageNoQna=" + pageNoQna + ", titleQna=" + titleQna
				+ ", writerQna=" + writerQna + ", dateQna=" + dateQna + ", hitQna=" + hitQna + ", contentQna="
				+ contentQna + ", deleteYNQna=" + deleteYNQna + ", showYNQna=" + showYNQna + ", pwdQna=" + pwdQna
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager + "]";
	}

	
	
}