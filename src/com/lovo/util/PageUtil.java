package com.lovo.util;

import java.util.List;

public class PageUtil<E> {
    private int code;
    private String msg;
    private List<E> data;
    private int pageNo;
    private int pageSize;
    private int count;
    private int totalPage;
    //实现模拟百度网页的分页
    //最重要的是确定总的分页页码的长度(一共要显示多少页码)
    //开始的页码和结束的页码
    private static final int PAGELENGTH = 6;
    private int start;
    private int end;

    public static int getPAGELENGTH() {
        return PAGELENGTH;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public PageUtil(List<E> data, int pageNo, int pageSize, int count) {
        this.code = 0;
        this.msg = "";
        this.data = data;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.totalPage = count % pageSize == 0 ? (count / pageSize):(count / pageSize + 1);
        if (totalPage<PAGELENGTH){
            start = 1;
            end = totalPage;
        }else{
            int temp = PAGELENGTH/2;
            start = pageNo - temp;
            end = pageNo + temp -1;
            if (start < 1){
                start = 1;
                end = PAGELENGTH;
            }
            if (end>totalPage){
                start = totalPage - PAGELENGTH + 1;
                end = totalPage;
            }
        }
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
