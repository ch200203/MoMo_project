package momo.vo;

public class ClassReviewVo {

   private String classReviewNo;
   private String classNo;
   private String className;
   private String tutorNo;
   private String tutorName;
   private String classReviewTitle;
   private String writernoClassReview;
   private String writeridClassReview;
   private String classReviewDate;
   private String classReviewHit;
   private String classReviewContent;
   private String classReviewPicture;
   private String classReviewLike;
   private String classReviewDeleteYN;
   private String lastUpdateDate;
   private String lastUpdateManager;

   public ClassReviewVo() {}

   public ClassReviewVo(String classReviewNo, String classNo, String className, String tutorNo, String tutorName,
         String classReviewTitle, String writernoClassReview, String writeridClassReview, String classReviewDate,
         String classReviewHit, String classReviewContent, String classReviewPicture, String classReviewLike,
         String classReviewDeleteYN, String lastUpdateDate, String lastUpdateManager) {
      super();
      this.classReviewNo = classReviewNo;
      this.classNo = classNo;
      this.className = className;
      this.tutorNo = tutorNo;
      this.tutorName = tutorName;
      this.classReviewTitle = classReviewTitle;
      this.writernoClassReview = writernoClassReview;
      this.writeridClassReview = writeridClassReview;
      this.classReviewDate = classReviewDate;
      this.classReviewHit = classReviewHit;
      this.classReviewContent = classReviewContent;
      this.classReviewPicture = classReviewPicture;
      this.classReviewLike = classReviewLike;
      this.classReviewDeleteYN = classReviewDeleteYN;
      this.lastUpdateDate = lastUpdateDate;
      this.lastUpdateManager = lastUpdateManager;
   }
   
   public ClassReviewVo(String className, String classReviewTitle, String writernoClassReview, String writeridClassReview,
	         String classReviewContent, String classReviewPicture) {
	      super();
	      this.className = className;
	      this.classReviewTitle = classReviewTitle;
	      this.writernoClassReview = writernoClassReview;
	      this.writeridClassReview = writeridClassReview;
	      this.classReviewContent = classReviewContent;
	      this.classReviewPicture = classReviewPicture;
   }

   public String getClassReviewNo() {
      return classReviewNo;
   }

   public void setClassReviewNo(String classReviewNo) {
      this.classReviewNo = classReviewNo;
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

   public String getTutorNo() {
      return tutorNo;
   }

   public void setTutorNo(String tutorNo) {
      this.tutorNo = tutorNo;
   }

   public String getTutorName() {
      return tutorName;
   }

   public void setTutorName(String tutorName) {
      this.tutorName = tutorName;
   }

   public String getClassReviewTitle() {
      return classReviewTitle;
   }

   public void setClassReviewTitle(String classReviewTitle) {
      this.classReviewTitle = classReviewTitle;
   }

   public String getWriternoClassReview() {
      return writernoClassReview;
   }

   public void setWriternoClassReview(String writernoClassReview) {
      this.writernoClassReview = writernoClassReview;
   }

   public String getWriteridClassReview() {
      return writeridClassReview;
   }

   public void setWriteridClassReview(String writeridClassReview) {
      this.writeridClassReview = writeridClassReview;
   }

   public String getClassReviewDate() {
      return classReviewDate;
   }

   public void setClassReviewDate(String classReviewDate) {
      this.classReviewDate = classReviewDate;
   }

   public String getClassReviewHit() {
      return classReviewHit;
   }

   public void setClassReviewHit(String classReviewHit) {
      this.classReviewHit = classReviewHit;
   }

   public String getClassReviewContent() {
      return classReviewContent;
   }

   public void setClassReviewContent(String classReviewContent) {
      this.classReviewContent = classReviewContent;
   }

   public String getClassReviewPicture() {
      return classReviewPicture;
   }

   public void setClassReviewPicture(String classReviewPicture) {
      this.classReviewPicture = classReviewPicture;
   }

   public String getClassReviewLike() {
      return classReviewLike;
   }

   public void setClassReviewLike(String classReviewLike) {
      this.classReviewLike = classReviewLike;
   }

   public String getClassReviewDeleteYN() {
      return classReviewDeleteYN;
   }

   public void setClassReviewDeleteYN(String classReviewDeleteYN) {
      this.classReviewDeleteYN = classReviewDeleteYN;
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
      return "ClassReviewVo [classReviewNo=" + classReviewNo + ", classNo=" + classNo + ", className=" + className
            + ", tutorNo=" + tutorNo + ", tutorName=" + tutorName + ", classReviewTitle=" + classReviewTitle
            + ", writernoClassReview=" + writernoClassReview + ", writeridClassReview=" + writeridClassReview
            + ", classReviewDate=" + classReviewDate + ", classReviewHit=" + classReviewHit
            + ", classReviewContent=" + classReviewContent + ", classReviewPicture=" + classReviewPicture
            + ", classReviewLike=" + classReviewLike + ", classReviewDeleteYN=" + classReviewDeleteYN
            + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateManager=" + lastUpdateManager + "]";
   }

}