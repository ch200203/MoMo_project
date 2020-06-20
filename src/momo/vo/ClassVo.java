package momo.vo;

public class ClassVo {
	
	private String classNo;
	private String tutorNo;
	private String className;
	private String classCategoryNo;
	private String classAddress;
	private String classAge;
	private String classContent;
	private String classPicture;
	private String classScore;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	//수업상세보기에서 필요한 필드 추가
	private String memberName;
	private String memberPicture;
	private String email;
	private String categoryName;
	private String tutorIntroduce;
	private String educationFile;
	private String experienceFile;
	private String certificateFile;
	
	
	public ClassVo() {
		super();
	}

	public ClassVo(String classNo, String tutorNo, String className, String classCategoryNo, String classAddress,
			String classAge, String classContent, String classPicture, String classScore, String lastUpdateDate,
			String lastUpdateManager, String memberName, String memberPicture, String email,
			String categoryName, String tutorIntroduce, String educationFile, 
			String experienceFile, String certificateFile) {
		super();
		this.classNo = classNo;
		this.tutorNo = tutorNo;
		this.className = className;
		this.classCategoryNo = classCategoryNo;
		this.classAddress = classAddress;
		this.classAge = classAge;
		this.classContent = classContent;
		this.classPicture = classPicture;
		this.classScore = classScore;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
		this.memberName = memberName;
		this.memberPicture = memberPicture;
		this.email = email;
		this.categoryName = categoryName;
		this.tutorIntroduce=tutorIntroduce;
		this.educationFile=educationFile;
		this.experienceFile=experienceFile;
		this.certificateFile=certificateFile;
	}

	//수업상세보기에서 필요한 생성자
	public ClassVo(String className, String classAddress, String classAge, String classContent, String classPicture,
			String classScore, String memberName, String memberPicture, String email,
			String categoryName, String tutorIntroduce, String educationFile, String experienceFile, String certificateFile) {
		super();
		this.className = className;
		this.classAddress = classAddress;
		this.classAge = classAge;
		this.classContent = classContent;
		this.classPicture = classPicture;
		this.classScore = classScore;
		this.memberName = memberName;
		this.memberPicture = memberPicture;
		this.email = email;
		this.categoryName = categoryName;
		this.tutorIntroduce=tutorIntroduce;
		this.educationFile=educationFile;
		this.experienceFile=experienceFile;
		this.certificateFile=certificateFile;
	}

	
	//수업정보 수정시 필요한 생성자
	public ClassVo(String classNo, String classCategoryNo, String classAddress, String classAge, String classContent,
			String classPicture, String classScore) {
		super();
		this.classNo = classNo;
		this.classCategoryNo = classCategoryNo;
		this.classAddress = classAddress;
		this.classAge = classAge;
		this.classContent = classContent;
		this.classPicture = classPicture;
		this.classScore = classScore;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getTutorNo() {
		return tutorNo;
	}

	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
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

	public String getClassAddress() {
		return classAddress;
	}

	public void setClassAddress(String classAddress) {
		this.classAddress = classAddress;
	}

	public String getClassAge() {
		return classAge;
	}

	public void setClassAge(String classAge) {
		this.classAge = classAge;
	}

	public String getClassContent() {
		return classContent;
	}

	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}

	public String getClassPicture() {
		return classPicture;
	}

	public void setClassPicture(String classPicture) {
		this.classPicture = classPicture;
	}

	public String getClassScore() {
		return classScore;
	}

	public void setClassScore(String classScore) {
		this.classScore = classScore;
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

	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPicture() {
		return memberPicture;
	}

	public void setMemberPicture(String memberPicture) {
		this.memberPicture = memberPicture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTutorIntroduce() {
		return tutorIntroduce;
	}

	public void setTutorIntroduce(String tutorIntroduce) {
		this.tutorIntroduce = tutorIntroduce;
	}

	public String getEducationFile() {
		return educationFile;
	}

	public void setEducationFile(String educationFile) {
		this.educationFile = educationFile;
	}

	public String getExperienceFile() {
		return experienceFile;
	}

	public void setExperienceFile(String experienceFile) {
		this.experienceFile = experienceFile;
	}

	public String getCertificateFile() {
		return certificateFile;
	}

	public void setCertificateFile(String certificateFile) {
		this.certificateFile = certificateFile;
	}

	@Override
	public String toString() {
		return "ClassVo [classNo=" + classNo + ", tutorNo=" + tutorNo + ", className=" + className
				+ ", classCategoryNo=" + classCategoryNo + ", classAddress=" + classAddress + ", classAge=" + classAge
				+ ", classContent=" + classContent + ", classPicture=" + classPicture + ", classScore=" + classScore
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager + ", memberName="
				+ memberName + ", memberPicture=" + memberPicture + ", email=" + email + ", categoryName="
				+ categoryName + ", tutorIntroduce=" + tutorIntroduce + ", educationFile=" + educationFile
				+ ", experienceFile=" + experienceFile + ", certificateFile=" + certificateFile + "]";
	}

	

}	