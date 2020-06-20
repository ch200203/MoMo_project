package momo.vo;

public class ClubListVo {
	
	private String clubNo;
	private String clubName;
	private String clubCategoryNo;
	private String clubCategoryName;
	private String clubAddress;
	private String clubPicture;
	private int clubScore;
	private String openYN;
	
	public ClubListVo() {}

	public ClubListVo(String clubNo, String clubName, String clubCategoryNo, String clubCategoryName,
			String clubAddress, String clubPicture, int clubScore, String openYN) {
		super();
		this.clubNo = clubNo;
		this.clubName = clubName;
		this.clubCategoryNo = clubCategoryNo;
		this.clubCategoryName = clubCategoryName;
		this.clubAddress = clubAddress;
		this.clubPicture = clubPicture;
		this.clubScore = clubScore;
		this.openYN = openYN;
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

	public String getClubCategoryName() {
		return clubCategoryName;
	}

	public void setClubCategoryName(String clubCategoryName) {
		this.clubCategoryName = clubCategoryName;
	}

	public String getClubAddress() {
		return clubAddress;
	}

	public void setClubAddress(String clubAddress) {
		this.clubAddress = clubAddress;
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

	public String getOpenYN() {
		return openYN;
	}

	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}

	@Override
	public String toString() {
		return "ClubListVo [clubNo=" + clubNo + ", clubName=" + clubName + ", clubCategoryNo=" + clubCategoryNo
				+ ", clubCategoryName=" + clubCategoryName + ", clubAddress=" + clubAddress + ", clubPicture="
				+ clubPicture + ", clubScore=" + clubScore + ", openYN=" + openYN + "]";
	}
	
	
	
	
	
	
	
		
	
	
}