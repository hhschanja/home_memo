package com.choa.util;

public class ListInfo {
	private Integer perPage;
	private int perBlock;
	private Integer curPage;
	
	
	private int curBlock;
	private int totalBlock;
	
	
	private int startNum;
	private int lastNum;
	private int startRow;
	private int lastRow;
	private String kind;
	private String search;
	
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	public int getPerPage() {
		if(perPage==null){
			perPage=10;
		}
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getCurPage() {
		if(curPage==null){
			curPage = 1;
		}
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	
	public void setRow(){
		startRow = (this.getCurPage() - 1) * this.getPerPage() + 1;
		lastRow = this.getCurPage() * this.getPerPage();
	}
	
	
	public void pageResult(int totalCount){
		//1. totalPage구하기
		int totalPage=0;
		int perBlock = 5;
		
		if(totalCount%this.getPerPage()==0){
			totalPage = totalCount/this.getPerPage();
		}else {
			totalPage = totalCount/this.getPerPage()+1;
		}
		//2.totalBlock
		if(totalPage%perBlock==0){
			totalBlock = totalPage/perBlock;
		}else {
			totalBlock = totalPage/perBlock+1;
		}
		//3.curBlock
		if(this.getCurPage()%perBlock==0){
			curBlock = this.getCurPage()/perBlock;
		}else {
			curBlock = this.getCurPage()/perBlock+1;
		}
		//4.startnum, lastnum
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		//
		if(curBlock==totalBlock){
			lastNum=totalPage;
		}
		
	}
}
