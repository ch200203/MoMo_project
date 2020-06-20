package momo.vo;

public class ClassListVo {
	
	private String classNo;
	private String className;
	private String classCategoryNo;
	private String classCategoryName;
	private String classAddress;
	private String classPicture;
	private int classScore;
	private String tutorNo;
	private String memberName;
	private String openYN;
	
	public ClassListVo() {}

	public ClassListVo(String classNo, String className, String classCategoryNo, String classCategoryName,
			String classAddress, String classPicture, int classScore, String tutorNo, String memberName,
			String openYN) {
		super();
		this.classNo = classNo;
		this.className = className;
		this.classCategoryNo = classCategoryNo;
		this.classCategoryName = classCategoryName;
		this.classAddress = classAddress;
		this.classPicture = classPicture;
		this.classScore = classScore;
		this.tutorNo = tutorNo;
		this.memberName = memberName;
		this.openYN = openYN;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassCategoryNo() {
		return classCategoryNo;
	}

	public void setClassCategoryNo(String classCategoryNo) {
		this.classCategoryNo = classCategoryNo;
	}

	public String getClassCategoryName() {
		return classCategoryName;
	}

	public void setClassCategoryName(String classCategoryName) {
		this.classCategoryName = classCategoryName;
	}

	public String getClassAddress() {
		return classAddress;
	}

	public void setClassAddress(String classAddress) {
		this.classAddress = classAddress;
	}

	public String getClassPicture() {
		return classPicture;
	}

	public void setClassPicture(String classPicture) {
		this.classPicture = classPicture;
	}

	public int getClassScore() {
		return classScore;
	}

	public void setClassScore(int classScore) {
		this.classScore = classScore;
	}

	public String getTutorNo() {
		return tutorNo;
	}

	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getOpenYN() {
		return openYN;
	}

	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}

	@Override
	public String toString() {
		return "ClassListVo [classNo=" + classNo + ", className=" + className + ", classCategoryNo=" + classCategoryNo
				+ ", classCategoryName=" + classCategoryName + ", classAddress=" + classAddress + ", classPicture="
				+ classPicture + ", classScore=" + classScore + ", tutorNo=" + tutorNo + ", memberName=" + memberName
				+ ", openYN=" + openYN + "]";
	}
	
	
	
	
	

}
