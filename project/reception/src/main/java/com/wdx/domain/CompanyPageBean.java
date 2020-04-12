package com.wdx.domain;

import com.wdx.dao.CompanyDAO;

import java.util.ArrayList;



public class CompanyPageBean {
	// 每页显示记录数
		private Integer pageSize = 2;
		// 当前页码
		private Integer pageNo = 1;
		// 总页数
		private Integer totalPages;
		// 每页数据记录集合
		private ArrayList<Company> pageData = new ArrayList<Company>();
		// 是否有下一页
		private boolean hasNext;
		// 是否有上一页
		private boolean hasPrevious;
		
		public CompanyPageBean() {
			super();
		}
		
		public CompanyPageBean(Integer pageSize, Integer pageNo) {
			super();
			this.pageSize = pageSize;
			this.pageNo = pageNo;
		}
		
		public void setPageNo(Integer pageNo) {
			this.pageNo = pageNo;
		}
		
		public int getTotalPages() {
			// 获取总记录数
			CompanyDAO company = new CompanyDAO();
			int recordCount = company.getAllNum();
			// 获取并返回总页数
			return (recordCount + pageSize - 1) / pageSize;
		}
		
		public void setTotalPages(Integer totalPages) {
			this.totalPages = totalPages;
		}
		
		public ArrayList<Company> getPageData(){
			// 查询当页记录
			CompanyDAO company = new CompanyDAO();
			ArrayList<Company> list = company.getCompanyPageList(pageNo, pageSize);
			return list;
		}
		
		public void setPageData(ArrayList<Company> pageData) {
			this.pageData = pageData;
		}
		
		public Integer getPageNo() {
			return pageNo;
		}
		
		public boolean isHasNext() {
			return (this.getPageNo() < this.getTotalPages());				
		}

		public boolean isHasPrevious() {
			return (!this.getPageNo().equals(1));
		}
		
		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}

		public void setHasNext(boolean hasNext) {
			this.hasNext = hasNext;
		}

		public void setHasPrevious(boolean hasPrevious) {
			this.hasPrevious = hasPrevious;
		}
}
