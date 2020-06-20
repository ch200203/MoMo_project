package momo.vo;

public class CategoryVo {
	
	private String categoryNo;
	private String categoryName;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	public CategoryVo() {}

	public CategoryVo(String categoryNo, String categoryName, String lastUpdateDate, String lastUpdateManager) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
		return "CategoryVo [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", lastUpdateDate="
				+ lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager + "]";
	}
	
}