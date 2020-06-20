package momo.vo;

public class TutorVo {
	
	private String tutorNo;
	private int tutorScore;
	private String tutorIntroduce;
	private String educationFile;
	private String experienceFile;
	private String certificateFile;
	private String lastUpdateDate;
	private String lastUpdateManager;
	
	public TutorVo() {}

	public TutorVo(String tutorNo, int tutorScore, String tutorIntroduce, String educationFile, String experienceFile,
			String certificateFile, String lastUpdateDate, String lastUpdateManager) {
		super();
		this.tutorNo = tutorNo;
		this.tutorScore = tutorScore;
		this.tutorIntroduce = tutorIntroduce;
		this.educationFile = educationFile;
		this.experienceFile = experienceFile;
		this.certificateFile = certificateFile;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateManager = lastUpdateManager;
	}

	public TutorVo(String tutorNo, String tutorIntroduce, String educationFile, String experienceFile,
			String certificateFile) {
		this.tutorNo = tutorNo;
		this.tutorIntroduce = tutorIntroduce;
		this.educationFile = educationFile;
		this.experienceFile = experienceFile;
		this.certificateFile = certificateFile;
	}

	public String getTutorNo() {
		return tutorNo;
	}

	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}

	public int getTutorScore() {
		return tutorScore;
	}

	public void setTutorScore(int tutorScore) {
		this.tutorScore = tutorScore;
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
		return "TutorVo [tutorNo=" + tutorNo + ", tutorScore=" + tutorScore + ", tutorIntroduce=" + tutorIntroduce
				+ ", educationFile=" + educationFile + ", experienceFile=" + experienceFile + ", certificateFile="
				+ certificateFile + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager
				+ "]";
	}
	
}