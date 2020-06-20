package momo.vo;

public class PagingVo {

	private int page =1;//현재 페이지 (get)
	private int totalCount;//row전체의 수(get)
	private int beginPage;//출력 시작
	private int endPage;//출력끝
	private int displayRow =10;//한 페이지에 몇 개의 로우(선택 set)
	private int displayPage =10;//한 페이지에 몇 개의 페이지(선택 set)
	boolean prev;//prev 버튼이 보일건지 안보일건지
	boolean next;//next버튼이 보일건지 안보일건지
	private int startNum;
	private int endNum;

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int page) {
		this.startNum = (page-1)*displayRow+1;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int page) {
		this.endNum =page*displayRow;
	}

	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page =page;
		
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		//setTotalCount()를 꼭 호출해야 paging이 되기 때문에
		//paging()함수를 setTotalCount()를 호출 했을때 자동으로 호출 되게 한다
		this.totalCount=totalCount;
		paging();
	}
	public int getDisplayRow() {
		return displayRow;
	}
	
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	
	public int getDisplayPage() {
		return displayPage;
	}
	
	public void setDisplayPage(int displayPage) {
		this.displayPage=displayPage;
	}
	
	public int getBeginPage() {
		return beginPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	private void paging() {
		//prev,next,beginPage,endPage를 계산해서 만든다.

		endPage = ((int)Math.ceil(page/(double)displayPage))*displayPage;
		System.out.println("page : " + page + "endPage:"+endPage);
		
		beginPage= endPage-(displayPage-1);
		System.out.println("beginPage:"+beginPage);
		
		//글 32개 
		//32/10=3.2(올림)4페이지
		//2=? 2/10
		
		int totalPage=(int)Math.ceil(totalCount/(double)displayRow);
		
		if(totalPage<endPage) {
			endPage = totalPage;
			next=false;
		}else {
			next=true;
		}
		prev = (beginPage==1)?false:true;//page가 11이상에만 나온다.
		System.out.println("endPage:"+endPage);
		System.out.println("totalPage:"+totalPage);
		
	}

	@Override
	public String toString() {
		return "PagingVo [page=" + page + ", totalCount=" + totalCount + ", beginPage=" + beginPage + ", endPage="
				+ endPage + ", displayRow=" + displayRow + ", displayPage=" + displayPage + ", prev=" + prev + ", next="
				+ next + ", startNum=" + startNum + ", endNum=" + endNum + "]";
	}
	
	
	
	
	
	
}
