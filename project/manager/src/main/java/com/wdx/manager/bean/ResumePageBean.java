package com.wdx.manager.bean;

import com.wdx.manager.dao.ResumeDAO;

import java.util.ArrayList;

/*
 *  Resume这个分页方法用JSP+JSTL+EL表达式实现
 *  这种方式不用设置Bean里所有的值
 *  需要设置pageNo,totalPages,pageData
 */
public class ResumePageBean {
    // 	每页显示记录数
    private Integer pageSize = 4;
    // 当前页码
    private Integer pageNo = 1;
    // 总页数
    private Integer totalPages;
    // 每页数据记录集合
    private ArrayList<Resume> pageData = new ArrayList<Resume>();
    // 是否有下一页
    private boolean hasNext;
    // 是否有上一页
    private boolean hasPrevious;

    public ResumePageBean() {
        super();
    }

    public ResumePageBean(Integer pageSize, Integer pageNo) {
        super();
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        // 获取总记录数
        ResumeDAO resumeDao = new ResumeDAO();
        int recordCount = resumeDao.getAllNum();
        // 获取并返回总页数
        return (recordCount + pageSize - 1) / pageSize;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<Resume> getPageData(){
        // 查询当页记录
        ResumeDAO resumeDao = new ResumeDAO();
        ArrayList<Resume> list = resumeDao.getPageList(pageNo, pageSize);
        return list;
    }

    public void setPageData(ArrayList<Resume> pageData) {
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

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

}
