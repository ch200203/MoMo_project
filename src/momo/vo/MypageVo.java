package momo.vo;

public class MypageVo {
	
	private String memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String birthday;
	private String phone;
	private String email;
	private String memberAddress;
	private int memberScore;
	private String memberPicture;
	private String tutorYN;
	private String managerYN;
	private String categoryNo;
	private String categoryName;
	
	public MypageVo() {}

	public MypageVo(String memberNo, String memberId, String memberPwd, String memberName, String birthday,
			String phone, String email, String memberAddress, int memberScore, String memberPicture, String tutorYN,
			String managerYN, String categoryNo, String categoryName) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.memberAddress = memberAddress;
		this.memberScore = memberScore;
		this.memberPicture = memberPicture;
		this.tutorYN = tutorYN;
		this.managerYN = managerYN;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	public MypageVo(String memberPwd, String email, String phone, String memberAddress, String memberPicture,
			String categoryName) {
		this.memberPwd = memberPwd;
		this.email = email;
		this.phone = phone;
		this.memberAddress = memberAddress;
		this.memberPicture = memberPicture;
		this.categoryName = categoryName;
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

	public String getMemberPicture() {
		return memberPicture;
	}

	public void setMemberPicture(String memberPicture) {
		this.memberPicture = memberPicture;
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

	@Override
	public String toString() {
		return "MypageVo [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email
				+ ", memberAddress=" + memberAddress + ", memberScore=" + memberScore + ", memberPicture="
				+ memberPicture + ", tutorYN=" + tutorYN + ", managerYN=" + managerYN + ", categoryNo=" + categoryNo
				+ ", categoryName=" + categoryName + "]";
	}

}
