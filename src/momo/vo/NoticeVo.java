package momo.vo;

public class NoticeVo {
	
	private int rownum;
	private int noNotice;
	private int pageNoNotice;
	private String titleNotice;
	private String writerNotice;
	private String dateNotice;
	private String datenowNotice;
	private int hitNotice;
	private String contentNotice;
	private String deleteYNNotice;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	
	
	public NoticeVo() {}

	public NoticeVo(int noNotice, int pageNoNotice, String titleNotice, String writerNotice, String dateNotice,
			int hitNotice, String contentNotice, String deleteYNNotice, String lastUpdateDate,
			String lastUpdateManager) {
		super();
		this.noNotice = noNotice;
		this.pageNoNotice = pageNoNotice;
		this.titleNotice = titleNotice;
		this.writerNotice = writerNotice;
		this.dateNotice = dateNotice;
		this.hitNotice = hitNotice;
		this.contentNotice = contentNotice;
		this.deleteYNNotice = deleteYNNotice;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}
	
	

	public NoticeVo(int rownum, int noNotice, int pageNoNotice, String titleNotice, String writerNotice,
			String dateNotice, String datenowNotice, int hitNotice, String contentNotice, String deleteYNNotice, String lastUpdateDate,
			String lastUpdateManager) {
		super();
		this.rownum = rownum;
		this.noNotice = noNotice;
		this.pageNoNotice = pageNoNotice;
		this.titleNotice = titleNotice;
		this.writerNotice = writerNotice;
		this.dateNotice = dateNotice;
		this.datenowNotice = datenowNotice;
		this.hitNotice = hitNotice;
		this.contentNotice = contentNotice;
		this.deleteYNNotice = deleteYNNotice;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}

	public int getNoNotice() {
		return noNotice;
	}

	public void setNoNotice(int noNotice) {
		this.noNotice = noNotice;
	}

	public int getPageNoNotice() {
		return pageNoNotice;
	}

	public void setPageNoNotice(int pageNoNotice) {
		this.pageNoNotice = pageNoNotice;
	}

	public String getTitleNotice() {
		return titleNotice;
	}

	public void setTitleNotice(String titleNotice) {
		this.titleNotice = titleNotice;
	}

	public String getWriterNotice() {
		return writerNotice;
	}

	public void setWriterNotice(String writerNotice) {
		this.writerNotice = writerNotice;
	}

	public String getDateNotice() {
		return dateNotice;
	}

	public void setDateNotice(String dateNotice) {
		this.dateNotice = dateNotice;
	}

	


	public String getDatenowNotice() {
		return datenowNotice;
	}

	public void setDatenowNotice(String datenowNotice) {
		this.datenowNotice = datenowNotice;
	}

	public int getHitNotice() {
		return hitNotice;
	}

	public void setHitNotice(int hitNotice) {
		this.hitNotice = hitNotice;
	}

	public String getContentNotice() {
		return contentNotice;
	}

	public void setContentNotice(String contentNotice) {
		this.contentNotice = contentNotice;
	}

	public String getDeleteYNNotice() {
		return deleteYNNotice;
	}

	public void setDeleteYNNotice(String deleteYNNotice) {
		this.deleteYNNotice = deleteYNNotice;
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
	
	

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "NoticeVo [rownum=" + rownum + ", noNotice=" + noNotice + ", pageNoNotice=" + pageNoNotice
				+ ", titleNotice=" + titleNotice + ", writerNotice=" + writerNotice + ", dateNotice=" + dateNotice
				+ ", datenowNotice=" + datenowNotice + ", hitNotice=" + hitNotice + ", contentNotice=" + contentNotice
				+ ", deleteYNNotice=" + deleteYNNotice + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateManager="
				+ lastUpdateManager + "]";
	}

	

	
	
}