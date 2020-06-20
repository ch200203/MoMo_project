package momo.vo;

public class MemberVo {
	
	private String memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String birthday;
	private String gender;
	private String phone;
	private String email;
	private String memberAddress;
	private int memberScore;
	private String tutorYN;
	private String managerYN;
	private String memberPicture;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	public MemberVo() {}
	
	public MemberVo(String memberNo, String memberId, String memberPwd, String memberName, String birthday,
			String gender, String phone, String email, String memberAddress, int memberScore, String tutorYN,
			String managerYN, String memberPicture, String lastUpdateDate, String lastUpdateManager) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.memberAddress = memberAddress;
		this.memberScore = memberScore;
		this.tutorYN = tutorYN;
		this.managerYN = managerYN;
		this.memberPicture = memberPicture;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}
	
	public MemberVo(String memberId, String memberPwd, String memberName, String birthday, String gender, String phone,
			String email, String memberAddress, String memberPicture) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.memberAddress = memberAddress;
		this.memberPicture = memberPicture;
	}

	public MemberVo(String memberNo, String memberId, String memberPwd) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}
	
	public MemberVo(String memberId) {
		this.memberId = memberId;
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

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public int getMemberScore() {
		return memberScore;
	}

	public void setMemberScore(int memberScore) {
		this.memberScore = memberScore;
	}

	public String getTutorYN() {
		return tutorYN;
	}

	public void setTutorYN(String tutorYN) {
		this.tutorYN = tutorYN;
	}

	public String getManagerYN() {
		return managerYN;
	}

	public void setManagerYN(String managerYN) {
		this.managerYN = managerYN;
	}

	public String getMemberPicture() {
		return memberPicture;
	}

	public void setMemberPicture(String memberPicture) {
		this.memberPicture = memberPicture;
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
		return "MemberVo [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", memberAddress=" + memberAddress + ", memberScore=" + memberScore
				+ ", tutorYN=" + tutorYN + ", managerYN=" + managerYN + ", memberPicture=" + memberPicture
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager + "]";
	}
	
}