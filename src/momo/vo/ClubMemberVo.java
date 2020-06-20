package momo.vo;

public class ClubMemberVo {
	
	private String clubNo;
	private String memberNo;
	private String memberId;
	private String memberName;
	private String gender;
	private String birthday;
	private String email;
	private String memberPictureUrl;
	private String allowYN;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	public ClubMemberVo() {}
	
	

	public ClubMemberVo(String clubNo, String memberNo, String memberId, String memberName, String gender, String birthday,
			String email, String memberPictureUrl, String allowYN, String lastUpdateDate, String lastUpdateManager) {
		super();
		this.clubNo = clubNo;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.memberPictureUrl = memberPictureUrl;
		this.allowYN = allowYN;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
		this.birthday = birthday;
	}
	
	// detail 페이지 실제 사용 데이터
	public ClubMemberVo(String memberNo, String memberId, String memberName, String gender, String birthday, String email,
			String memberPictureUrl, String allowYN) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.memberPictureUrl = memberPictureUrl;
		this.allowYN = allowYN;
	} 
	

	public String getClubNo() {
		return clubNo;
	}

	public void setClubNo(String clubNo) {
		this.clubNo = clubNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getmemberId() {
		return memberId;
	}

	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberPictureUrl() {
		return memberPictureUrl;
	}

	public void setMemberPictureUrl(String memberPictureUrl) {
		this.memberPictureUrl = memberPictureUrl;
	}

	public String getAllowYN() {
		return allowYN;
	}

	public void setAllowYN(String allowYN) {
		this.allowYN = allowYN;
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

	public String getbirthday() {
		return birthday;
	}

	public void setbirthday(String birthday) {
		this.birthday = birthday;
	}



	@Override
	public String toString() {
		return "ClubMemberVo [clubNo=" + clubNo + ", memberNo=" + memberNo + ", memberId=" + memberId
				+ ", memberName=" + memberName + ", gender=" + gender + ", birthday=" + birthday + ", email=" + email
				+ ", memberPictureUrl=" + memberPictureUrl + ", allowYN=" + allowYN + ", lastUpdateDate="
				+ lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager + "]";
	}
}