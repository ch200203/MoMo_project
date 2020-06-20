package momo.vo;

public class ClubReviewVo {
	
	private String clubReviewNo;
	private String clubNo;
	private String clubName;
	private String clubReviewTitle;
	private String memberNo;
	private String memberId;
	private String clubReviewDate;
	private String clubReviewHit;
	private String clubReviewContent;
	private String clubReviewPicture;
	private String clubReviewLike;
	private String clubReviewDeleteYN;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	public ClubReviewVo() {
		super();
	}

	public ClubReviewVo(String clubReviewNo, String clubNo, String clubName, String clubReviewTitle, String memberNo,
			String memberId, String clubReviewDate, String clubReviewHit, String clubReviewContent,
			String clubReviewPicture, String clubReviewLike, String clubReviewDeleteYN, String lastUpdateDate,
			String lastUpdateManager) {
		super();
		this.clubReviewNo = clubReviewNo;
		this.clubNo = clubNo;
		this.clubName = clubName;
		this.clubReviewTitle = clubReviewTitle;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.clubReviewDate = clubReviewDate;
		this.clubReviewHit = clubReviewHit;
		this.clubReviewContent = clubReviewContent;
		this.clubReviewPicture = clubReviewPicture;
		this.clubReviewLike = clubReviewLike;
		this.clubReviewDeleteYN = clubReviewDeleteYN;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}

	public ClubReviewVo(String clubName, String clubReviewTitle, String memberNo, String memberId, String clubReviewContent,
			String clubReviewPicture) {
		this.clubName = clubName;
		this.clubReviewTitle = clubReviewTitle;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.clubReviewContent = clubReviewContent;
		this.clubReviewPicture = clubReviewPicture;
	}
	
	public ClubReviewVo(String clubReviewNo, String clubName, String clubReviewTitle, String clubReviewContent, String clubReviewPicture) {
		this.clubReviewNo = clubReviewNo;
		this.clubName = clubName;
		this.clubReviewTitle = clubReviewTitle;
		this.clubReviewContent = clubReviewContent;
		this.clubReviewPicture = clubReviewPicture;
	}

	public String getClubReviewNo() {
		return clubReviewNo;
	}

	public void setClubReviewNo(String clubReviewNo) {
		this.clubReviewNo = clubReviewNo;
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

	public String getClubReviewTitle() {
		return clubReviewTitle;
	}

	public void setClubReviewTitle(String clubReviewTitle) {
		this.clubReviewTitle = clubReviewTitle;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getClubReviewDate() {
		return clubReviewDate;
	}

	public void setClubReviewDate(String clubReviewDate) {
		this.clubReviewDate = clubReviewDate;
	}

	public String getClubReviewHit() {
		return clubReviewHit;
	}

	public void setClubReviewHit(String clubReviewHit) {
		this.clubReviewHit = clubReviewHit;
	}

	public String getClubReviewContent() {
		return clubReviewContent;
	}

	public void setClubReviewContent(String clubReviewContent) {
		this.clubReviewContent = clubReviewContent;
	}

	public String getClubReviewPicture() {
		return clubReviewPicture;
	}

	public void setClubReviewPicture(String clubReviewPicture) {
		this.clubReviewPicture = clubReviewPicture;
	}

	public String getClubReviewLike() {
		return clubReviewLike;
	}

	public void setClubReviewLike(String clubReviewLike) {
		this.clubReviewLike = clubReviewLike;
	}

	public String getClubReviewDeleteYN() {
		return clubReviewDeleteYN;
	}

	public void setClubReviewDeleteYN(String clubReviewDeleteYN) {
		this.clubReviewDeleteYN = clubReviewDeleteYN;
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
		return "ClubReviewVo [clubReviewNo=" + clubReviewNo + ", clubNo=" + clubNo + ", clubName=" + clubName
				+ ", clubReviewTitle=" + clubReviewTitle + ", memberNo=" + memberNo + ", memberId=" + memberId
				+ ", clubReviewDate=" + clubReviewDate + ", clubReviewHit=" + clubReviewHit + ", clubReviewContent="
				+ clubReviewContent + ", clubReviewPicture=" + clubReviewPicture + ", clubReviewLike=" + clubReviewLike
				+ ", clubReviewDeleteYN=" + clubReviewDeleteYN + ", lastUpdateDate=" + lastUpdateDate
				+ ", lastUpdateManager=" + lastUpdateManager + "]";
	}
	
}