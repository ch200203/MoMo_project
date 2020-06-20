package momo.vo;

public class QnaReplyVo {
	
	private int reNoQna;				//답글번호
	private int noQna;					//답글단원글번호
	private String reTitleQna;			//답글제목
	private String reWriterQna;			//답글작성자
	private String reDateQna;			//답글작성일
	private String reContentQna;		//답글내용
	private String reDelteYNQna;		//답글삭제여부
	private String reShowYNQna;			//답글공개여부
	private String lastUpdateDate;		//답글최근수정일
	private String lastUpdateManager;	//답글최근수정관리자
	
	public QnaReplyVo() {}

	public QnaReplyVo(int reNoQna, int noQna, String reTitleQna, String reWriterQna, String reDateQna,
			String reContentQna, String reDelteYNQna, String reShowYNQna, String lastUpdateDate,
			String lastUpdateManager) {
		super();
		this.reNoQna = reNoQna;
		this.noQna = noQna;
		this.reTitleQna = reTitleQna;
		this.reWriterQna = reWriterQna;
		this.reDateQna = reDateQna;
		this.reContentQna = reContentQna;
		this.reDelteYNQna = reDelteYNQna;
		this.reShowYNQna = reShowYNQna;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}

	//답글 불러올 생성자
	public QnaReplyVo(int reNoQna, int noQna, String reWriterQna, String reDateQna, String reContentQna) {
		super();
		this.reNoQna = reNoQna;
		this.noQna = noQna;
		this.reWriterQna = reWriterQna;
		this.reDateQna = reDateQna;
		this.reContentQna = reContentQna;
	}
	
	
	public int getReNoQna() {
		return reNoQna;
	}

	public void setReNoQna(int reNoQna) {
		this.reNoQna = reNoQna;
	}

	public int getNoQna() {
		return noQna;
	}

	public void setNoQna(int noQna) {
		this.noQna = noQna;
	}

	public String getReTitleQna() {
		return reTitleQna;
	}

	public void setReTitleQna(String reTitleQna) {
		this.reTitleQna = reTitleQna;
	}

	public String getReWriterQna() {
		return reWriterQna;
	}

	public void setReWriterQna(String reWriterQna) {
		this.reWriterQna = reWriterQna;
	}

	public String getReDateQna() {
		return reDateQna;
	}

	public void setReDateQna(String reDateQna) {
		this.reDateQna = reDateQna;
	}

	public String getReContentQna() {
		return reContentQna;
	}

	public void setReContentQna(String reContentQna) {
		this.reContentQna = reContentQna;
	}

	public String getReDelteYNQna() {
		return reDelteYNQna;
	}

	public void setReDelteYNQna(String reDelteYNQna) {
		this.reDelteYNQna = reDelteYNQna;
	}

	public String getReShowYNQna() {
		return reShowYNQna;
	}

	public void setReShowYNQna(String reShowYNQna) {
		this.reShowYNQna = reShowYNQna;
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
		return "QnaReplyVo [reNoQna=" + reNoQna + ", noQna=" + noQna + ", reTitleQna=" + reTitleQna + ", reWriterQna="
				+ reWriterQna + ", reDateQna=" + reDateQna + ", reContentQna=" + reContentQna + ", reDelteYNQna="
				+ reDelteYNQna + ", reShowYNQna=" + reShowYNQna + ", lastUpdateDate=" + lastUpdateDate
				+ ", lastUpdateManager=" + lastUpdateManager + "]";
	}
	
}