package com.spring.board.common;

public class Pagination {
	private int listSize = 10; //한 페이지당 목록 개수
	private int rangeSize = 10; //한 페이지 범위에 보여질 페이지의 개수
	private int page; // 현재 목록의 페이지 번호
	private int range; //각 페이지 범위 시작 번호
	private int listCnt; //게시물 총 개수
	private int pageCnt; //전체 페이지 범위의 개수 
	private int startPage; //각 페이지 범위 시작 번호 
	private int startList; //
	private int endPage; //각 페이지 범위 끝 번호 
	private boolean prev; //이전 페이지 여부
	private boolean next; //다음 페이지 여부
	
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getRangeSize() {
		return rangeSize;
	}
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getListCnt() {
		return listCnt;
	}
	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getStartList() {
		return startList;
	}
	public void setStartList(int startList) {
		this.startList = startList;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public void pageInfo(int page, int range, int listCnt) { //현재 페이지/ 현재페이지범위/ 게시물총개수
		this.page =page;
		this.range=range;
		this.listCnt=listCnt;
		
		//전체 페이지 수//listCnt  게시물 총 개수  listSize = 10; //한 페이지당 목록 개수 
		this.pageCnt= (int)Math.ceil(listCnt/(double)listSize); //소수값 존재 시 값 올림
		
		//시작페이지 // range 현재 표시되는 페이지 범위 //rangeSize = 10; 한 페이지 범위에 보여질 페이지의 개수 
		// 범위1 1-10  , 범위 2 11-20
		this.startPage = (range - 1) * rangeSize +1 ; 
		
		//끝 페이지 : 다음에 나올 다음버튼 활성화 여부 판단위해
		this.endPage = range * rangeSize;
		

		//게시판 시작번호 : MYSQL을 이용해 원하는 목록을 가져오기위해서 0,10,20
		this.startList = (page - 1) * listSize;
		
		//이전 버튼 상태 : 첫번째 페이지 범위에서는 이전버튼 필요없어서 FALSE
		this.prev = range == 1 ? false : true;

		 
		 
		//다음 버튼 상태 : 현재 페이지의 마지막 번호가 전체 페이지 개수보다 크면 다음버튼 활성화
		//endPage 현재 범위의 마지막 페이지 번호 30
		// pageCnt 총 페이지 수 25
		//this.next = this.endPage > this.pageCnt ? false : true;

		
		//this.next = this.pageCnt > 0 && this.endPage < this.pageCnt;
		this.next = this.endPage < this.pageCnt;
		
	    // 페이지가 총 페이지 수를 넘지 않도록 조정
	    if (this.endPage > this.pageCnt) {
	        this.endPage = this.pageCnt;
	    }
//		
	    // Logging for debugging
	    System.out.println("====Page: " + page + ", Range: " + range + ", List Count: " + listCnt);
	    System.out.println("pagination===Start Page: " + startPage + ", End Page: " + endPage);
	    System.out.println("Total Pages (pageCnt): " + pageCnt);
	    System.out.println("Prev: " + prev + ", Next: " + next);
	    System.out.println("rangeSize: " + rangeSize );
	    
				
	}

	
}