package momo.vo;

public class ClubReviewListVo {
   
   private String noClubReview;
   private String titleClubReview;
   private String categoryNo;
   private String categoryName;
   private String memberNo;
   private String memberId;
   private String dateClubReview;
   private String clubNo;
   private String clubName;
   private String contentClubReview;
   private String pictureClubReview;
   private int likeClubReview;
   private String deleteYNClubReview;
   private String hitClubReview;
   
   public ClubReviewListVo() {}

   public ClubReviewListVo(String noClubReview, String titleClubReview, String categoryNo, String categoryName,
         String memberNo, String memberId, String dateClubReview, String clubNo, String clubName,
         String contentClubReview, String pictureClubReview, int likeClubReview, String deleteYNClubReview,
         String hitClubReview) {
      super();
      this.noClubReview = noClubReview;
      this.titleClubReview = titleClubReview;
      this.categoryNo = categoryNo;
      this.categoryName = categoryName;
      this.memberNo = memberNo;
      this.memberId = memberId;
      this.dateClubReview = dateClubReview;
      this.clubNo = clubNo;
      this.clubName = clubName;
      this.contentClubReview = contentClubReview;
      this.pictureClubReview = pictureClubReview;
      this.likeClubReview = likeClubReview;
      this.deleteYNClubReview = deleteYNClubReview;
      this.hitClubReview = hitClubReview;
   }

   public String getNoClubReview() {
      return noClubReview;
   }

   public void setNoClubReview(String noClubReview) {
      this.noClubReview = noClubReview;
   }

   public String getTitleClubReview() {
      return titleClubReview;
   }

   public void setTitleClubReview(String titleClubReview) {
      this.titleClubReview = titleClubReview;
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

   public String getDateClubReview() {
      return dateClubReview;
   }

   public void setDateClubReview(String dateClubReview) {
      this.dateClubReview = dateClubReview;
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

   public String getContentClubReview() {
      return contentClubReview;
   }

   public void setContentClubReview(String contentClubReview) {
      this.contentClubReview = contentClubReview;
   }

   public String getPictureClubReview() {
      return pictureClubReview;
   }

   public void setPictureClubReview(String pictureClubReview) {
      this.pictureClubReview = pictureClubReview;
   }

   public int getLikeClubReview() {
      return likeClubReview;
   }

   public void setLikeClubReview(int likeClubReview) {
      this.likeClubReview = likeClubReview;
   }

   public String getDeleteYNClubReview() {
      return deleteYNClubReview;
   }

   public void setDeleteYNClubReview(String deleteYNClubReview) {
      this.deleteYNClubReview = deleteYNClubReview;
   }

   public String getHitClubReview() {
      return hitClubReview;
   }

   public void setHitClubReview(String hitClubReview) {
      this.hitClubReview = hitClubReview;
   }

   @Override
   public String toString() {
      return "ClubReviewListVo [noClubReview=" + noClubReview + ", titleClubReview=" + titleClubReview
            + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", memberNo=" + memberNo
            + ", memberId=" + memberId + ", dateClubReview=" + dateClubReview + ", clubNo=" + clubNo + ", clubName="
            + clubName + ", contentClubReview=" + contentClubReview + ", pictureClubReview=" + pictureClubReview
            + ", likeClubReview=" + likeClubReview + ", deleteYNClubReview=" + deleteYNClubReview
            + ", hitClubReview=" + hitClubReview + "]";
   }
   
   

   
}