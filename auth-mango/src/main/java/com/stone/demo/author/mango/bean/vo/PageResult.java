package com.stone.demo.author.mango.bean.vo;

import java.util.List;

/***
 *
 * 自定义分页结果
 *
 * @author stone
 * @date 2021 - 1 - 15
 */
public class PageResult {

    /**
     *  当前页码
     */
    private int pageNum;

    /**
     *  每页数量
     */
    private int pageSize;

    /**
     *  记录总数
     */
    private long totalSize;

    /**
     *  总页数
     */
    private int totalPages;

    /**
     *  分页数据
     */
    private List<?> content;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }
}
