package com.chen.pojo;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 分页bean
 * @param <T>
 */
public class PageInfo<T> {

    //当前页
//    private int pageNum;
    //总页数
    private int pages;
    //总记录数
    private int total;
    //结果集
    private List<T> list;
    //是否有前一页
//    private boolean hasPreviousPage;
    //是否有下一页
//    private boolean hasNextPage;
    //所有导航页号
    private int[] navigatepageNums;

    public PageInfo() {
    }

    public PageInfo(int pages, int total, List<T> list, int[] navigatepageNums) {
//        this.pageNum = pageNum;
        this.pages = pages;
        this.total = total;
        this.list = list;
//        this.hasPreviousPage = hasPreviousPage;   , boolean hasPreviousPage, boolean hasNextPage
//        this.hasNextPage = hasNextPage;
        this.navigatepageNums = navigatepageNums;
    }

//    public int getPageNum() {
//        return pageNum;
//    }

//    public void setPageNum(int pageNum) {
//        this.pageNum = pageNum;
//    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

//    public boolean isHasPreviousPage() {
//        return hasPreviousPage;
//    }
//
//    public void setHasPreviousPage(boolean hasPreviousPage) {
//        this.hasPreviousPage = hasPreviousPage;
//    }
//
//    public boolean isHasNextPage() {
//        return hasNextPage;
//    }
//
//    public void setHasNextPage(boolean hasNextPage) {
//        this.hasNextPage = hasNextPage;
//    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pages=" + pages +
                ", total=" + total +
                ", list=" + list +
//                ", hasPreviousPage=" + hasPreviousPage +
//                ", hasNextPage=" + hasNextPage +
                ", navigatepageNums=" + Arrays.toString(navigatepageNums) +
                '}';
    }
}
