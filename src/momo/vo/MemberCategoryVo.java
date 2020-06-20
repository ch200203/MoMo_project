package momo.vo;

public class MemberCategoryVo {
	
	private String memberNo;
	private String categoryNo;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	public MemberCategoryVo () {}

	public MemberCategoryVo(String memberNo, String categoryNo, String lastUpdateDate, String lastUpdateManager) {
		super();
		this.memberNo = memberNo;
		this.categoryNo = categoryNo;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
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
		return "MemberCategoryVo [memberNo=" + memberNo + ", categoryNo=" + categoryNo + ", lastUpdateDate="
				+ lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager + "]";
	}
	
}