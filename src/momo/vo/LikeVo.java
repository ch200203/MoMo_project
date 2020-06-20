package momo.vo;

public class LikeVo {
	
	private String likeName;
	private String likeYN;
	private String memberNo;
	private int likeCnt;
	
	public LikeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeVo(String likeName, String likeYN, String memberNo, int likeCnt) {
		super();
		this.likeName = likeName;
		this.likeYN = likeYN;
		this.memberNo = memberNo;
		this.likeCnt = likeCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getLikeName() {
		return likeName;
	}

	public void setLikeName(String likeName) {
		this.likeName = likeName;
	}

	public String getLikeYN() {
		return likeYN;
	}

	public void setLikeYN(String likeYN) {
		this.likeYN = likeYN;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "LikeVo [likeName=" + likeName + ", likeYN=" + likeYN + ", memberNo=" + memberNo + ", likeCnt=" + likeCnt
				+ "]";
	}

}
