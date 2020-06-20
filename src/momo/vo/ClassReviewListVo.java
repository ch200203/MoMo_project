package momo.vo;

public class ClassReviewListVo {

	private String noClassReview;
	private String titleClassReview;
	private String categoryNo;
	private String categoryName;
	private String tutorNo;
	private String memberName;
	private String writeridClassReview;
	private String dateClassReview;
	private String classNo;
	private String className;
	private String contentClassReview;
	private String pictureClassReview;
	private int likeClassReview;
	private String deleteYNClassReview;
	
	public ClassReviewListVo() {}

	public ClassReviewListVo(String noClassReview, String titleClassReview, String categoryNo, String categoryName,
			String tutorNo, String memberName, String writeridClassReview, String dateClassReview, String classNo,
			String className, String contentClassReview, String pictureClassReview, int likeClassReview,
			String deleteYNClassReview) {
		super();
		this.noClassReview = noClassReview;
		this.titleClassReview = titleClassReview;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.tutorNo = tutorNo;
		this.memberName = memberName;
		this.writeridClassReview = writeridClassReview;
		this.dateClassReview = dateClassReview;
		this.classNo = classNo;
		this.className = className;
		this.contentClassReview = contentClassReview;
		this.pictureClassReview = pictureClassReview;
		this.likeClassReview = likeClassReview;
		this.deleteYNClassReview = deleteYNClassReview;
	}
	
	

	public String getNoClassReview() {
		return noClassReview;
	}

	public void setNoClassReview(String noClassReview) {
		this.noClassReview = noClassReview;
	}

	public String getTitleClassReview() {
		return titleClassReview;
	}

	public void setTitleClassReview(String titleClassReview) {
		this.titleClassReview = titleClassReview;
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

	public String getwriteridClassReview() {
		return writeridClassReview;
	}

	public void setwriteridClassReview(String writeridClassReview) {
		this.writeridClassReview = writeridClassReview;
	}

	public String getDateClassReview() {
		return dateClassReview;
	}

	public void setDateClassReview(String dateClassReview) {
		this.dateClassReview = dateClassReview;
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

	public String getContentClassReview() {
		return contentClassReview;
	}

	public void setContentClassReview(String contentClassReview) {
		this.contentClassReview = contentClassReview;
	}

	public String getPictureClassReview() {
		return pictureClassReview;
	}

	public void setPictureClassReview(String pictureClassReview) {
		this.pictureClassReview = pictureClassReview;
	}

	public int getLikeClassReview() {
		return likeClassReview;
	}

	public void setLikeClassReview(int likeClassReview) {
		this.likeClassReview = likeClassReview;
	}

	public String getDeleteYNClassReview() {
		return deleteYNClassReview;
	}

	public void setDeleteYNClassReview(String deleteYNClassReview) {
		this.deleteYNClassReview = deleteYNClassReview;
	}

	@Override
	public String toString() {
		return "ClassReviewListVo [noClassReview=" + noClassReview + ", titleClassReview=" + titleClassReview
				+ ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", tutorNo=" + tutorNo
				+ ", memberName=" + memberName + ", writeridClassReview=" + writeridClassReview
				+ ", dateClassReview=" + dateClassReview + ", classNo=" + classNo + ", className=" + className
				+ ", contentClassReview=" + contentClassReview + ", pictureClassReview=" + pictureClassReview
				+ ", likeClassReview=" + likeClassReview + ", deleteYNClassReview=" + deleteYNClassReview + "]";
	}
	
	
	
	

}
