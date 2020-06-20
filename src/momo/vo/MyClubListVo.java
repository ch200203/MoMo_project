package momo.vo;

public class MyClubListVo {
	
	private String memberNo;
	private String clubNo;
	private String clubName;

	public MyClubListVo() {}
	
	public MyClubListVo(String memberNo, String clubNo, String clubName) {
		super();
		this.memberNo = memberNo;
		this.clubNo = clubNo;
		this.clubName = clubName;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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

	@Override
	public String toString() {
		return "MyClubListVo [memberNo=" + memberNo + ", clubNo=" + clubNo + ", clubName=" + clubName + "]";
	}
	
}
