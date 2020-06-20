package momo.vo;

public class ClubVo {

	private String clubNo;
	private String clubName;
	private String clubCategoryNo;
	private String managerNo;
	private String managerName;
	private int clubTotal;
	private String openYN;
	private String recruitYN;
	private String clubAddress;
	private String clubContent;
	private String clubPicture;
	private int clubScore;
	private String lastUpdateDate;
	private String lastUpdateManger;
	
	//수업신청시 필요한 필드 추가
	private String memberName;
	private String categoryName;
	
	public ClubVo() {
	}

	public ClubVo(String clubNo, String clubName, String clubCategoryNo, String managerNo, String managerName,
			int clubTotal, String openYN, String recruitYN, String clubAddress, String clubContent, String clubPicture,
			int clubScore, String lastUpdateDate, String lastUpdateManger, String memberName, String categoryName) {
		super();
		this.clubNo = clubNo;
		this.clubName = clubName;
		this.clubCategoryNo = clubCategoryNo;
		this.managerNo = managerNo;
		this.managerName = managerName;
		this.clubTotal = clubTotal;
		this.openYN = openYN;
		this.recruitYN = recruitYN;
		this.clubAddress = clubAddress;
		this.clubContent = clubContent;
		this.clubPicture = clubPicture;
		this.clubScore = clubScore;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManger = lastUpdateManger;
		this.memberName = memberName;
		this.categoryName = categoryName;
	}

	public ClubVo(String clubNo, String clubCategoryNo, int clubTotal, String openYN, String recruitYN,
			String clubAddress, String clubContent, String clubPicture) {
		super();
		this.clubNo = clubNo;
		this.clubCategoryNo = clubCategoryNo;
		this.clubTotal = clubTotal;
		this.openYN = openYN;
		this.recruitYN = recruitYN;
		this.clubAddress = clubAddress;
		this.clubContent = clubContent;
		this.clubPicture = clubPicture;
	}	
	
	//수업신청페이지에서 필요한 생성자
	public ClubVo(String clubNo, String clubName, int clubTotal, String clubAddress,
			String clubPicture, int clubScore, String memberName, String categoryName) {
		super();
		this.clubNo = clubNo;
		this.clubName = clubName;
		this.clubTotal = clubTotal;
		this.clubAddress = clubAddress;
		this.clubPicture = clubPicture;
		this.clubScore = clubScore;
		this.memberName = memberName;
		this.categoryName = categoryName;
	}

	//수업신청한 모임 불러올 때 필요한 생성자
	public ClubVo(String clubNo, String clubName, String categoryName, String memberName, int clubTotal, int clubScore) {
		super();
		this.clubNo = clubNo;
		this.clubName = clubName;
		this.categoryName = categoryName;
		this.memberName = memberName;
		this.clubTotal = clubTotal;
		this.clubScore = clubScore;
	}
	
	public String getClubNo() {
		return clubNo;
	}

	public void setClubNo(String clubNo) {
		this.clubNo = clubNo;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubCategoryNo() {
		return clubCategoryNo;
	}

	public void setClubCategoryNo(String clubCategoryNo) {
		this.clubCategoryNo = clubCategoryNo;
	}

	public String getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}

	public int getClubTotal() {
		return clubTotal;
	}

	public void setClubTotal(int clubTotal) {
		this.clubTotal = clubTotal;
	}

	public String getOpenYN() {
		return openYN;
	}

	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}

	public String getRecruitYN() {
		return recruitYN;
	}

	public void setRecruitYN(String recruitYN) {
		this.recruitYN = recruitYN;
	}

	public String getClubAddress() {
		return clubAddress;
	}

	public void setClubAddress(String clubAddress) {
		this.clubAddress = clubAddress;
	}

	public String getClubContent() {
		return clubContent;
	}

	public void setClubContent(String clubContent) {
		this.clubContent = clubContent;
	}

	public String getClubPicture() {
		return clubPicture;
	}

	public void setClubPicture(String clubPicture) {
		this.clubPicture = clubPicture;
	}

	public int getClubScore() {
		return clubScore;
	}

	public void setClubScore(int clubScore) {
		this.clubScore = clubScore;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateManger() {
		return lastUpdateManger;
	}

	public void setLastUpdateManger(String lastUpdateManger) {
		this.lastUpdateManger = lastUpdateManger;
	}
	
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ClubVo [clubNo=" + clubNo + ", clubName=" + clubName + ", clubCategoryNo=" + clubCategoryNo
				+ ", managerNo=" + managerNo + ", managerName=" + managerName + ", clubTotal=" + clubTotal + ", openYN="
				+ openYN + ", recruitYN=" + recruitYN + ", clubAddress=" + clubAddress + ", clubContent=" + clubContent
				+ ", clubPicture=" + clubPicture + ", clubScore=" + clubScore + ", lastUpdateDate=" + lastUpdateDate
				+ ", lastUpdateManger=" + lastUpdateManger + ", memberName=" + memberName + ", categoryName="
				+ categoryName + "]";
	}




}