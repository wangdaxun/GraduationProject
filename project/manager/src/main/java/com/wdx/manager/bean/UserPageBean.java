package com.wdx.manager.bean;

import com.wdx.manager.dao.UserDAO;

import java.util.ArrayList;

public class UserPageBean {
	// 每页显示记录数
	private Integer pageSize = 2;
	// 当前页码
	private Integer pageNo = 1;
	// 总页数
	private Integer totalPages;
	// 每页数据记录集合
	private ArrayList<User> pageData = new ArrayList<User>();
	// 是否有下一页
	private boolean hasNext;
	// 是否有上一页
	private boolean hasPreviousPage;
	
	public UserPageBean() {
		super();
	}

	public UserPageBean(Integer pageSize, Integer pageNo) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}
	
	public int getTotalPages() {
		// 获取总记录数
		UserDAO userDao = new UserDAO();
		int recordCount = userDao.getAllNum();
		// 获取并返回总页数
		return (recordCount + pageSize - 1) / pageSize;
	}
	
	public ArrayList<User> getPageData(){
		// 查询当页记录
		UserDAO userDao = new UserDAO();
		ArrayList<User> list = userDao.getPageList(pageNo, pageSize);
		return list;
	}
	
	public boolean isHasNextPage() {
		return (this.getPageNo() < this.getTotalPages());
	}
	
	public boolean isHasPreviousPage() {
		return (!this.getPageNo().equals(1));
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public void setPageData(ArrayList<User> pageData) {
		this.pageData = pageData;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	
}
