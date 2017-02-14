package com.ljishopping.search.pojo;

import java.util.List;

public class SearchResult {
	// current page
	private long pageNo;
	// page numbers
	private long pageNum;
	// total records
	private long total;
	// return datas
	private List<ExtItem> datas;

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<ExtItem> getDatas() {
		return datas;
	}

	public void setDatas(List<ExtItem> datas) {
		this.datas = datas;
	}

}
