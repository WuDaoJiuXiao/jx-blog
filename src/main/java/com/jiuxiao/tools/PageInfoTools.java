package com.jiuxiao.tools;

import java.util.List;

/**
 * 分页工具类
 * @Author: 悟道九霄
 * @Date: 2022年06月02日 18:18
 * @Version: 1.0.0
 */
public class PageInfoTools<T> {

    /** 要进行分页的数据列表 */
    private List<T> dataList;

    /** 数据总数 */
    private Integer totalNum;

    /** 总页数 */
    private Integer totalPage;

    /** 当前页数 */
    private Integer currentPage;

    /** 单页面数据数量 */
    private Integer pageSize;

    public PageInfoTools() {
    }

    public PageInfoTools(List<T> dataList, Integer totalNum, Integer totalPage, Integer currentPage, Integer pageSize) {
        this.dataList = dataList;
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}