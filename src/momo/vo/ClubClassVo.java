package momo.vo;

public class ClubClassVo {
	
	private String tutorNo;
	private String classNo;
	private String clubNo;
	private String allowYN_W;
	private String className;
	
	public ClubClassVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubClassVo(String tutorNo, String classNo, String clubNo, String allowYN_W, String className) {
		super();
		this.tutorNo = tutorNo;
		this.classNo = classNo;
		this.clubNo = clubNo;
		this.allowYN_W = allowYN_W;
		this.className = className;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTutorNo() {
		return tutorNo;
	}

	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClubNo() {
		return clubNo;
	}

	public void setClubNo(String clubNo) {
		this.clubNo = clubNo;
	}

	public String getAllowYN_W() {
		return allowYN_W;
	}

	public void setAllowYN_W(String allowYN_W) {
		this.allowYN_W = allowYN_W;
	}

	@Override
	public String toString() {
		return "ClubClassVo [tutorNo=" + tutorNo + ", classNo=" + classNo + ", clubNo=" + clubNo + ", allowYN_W="
				+ allowYN_W + ", className=" + className + "]";
	}	

}
