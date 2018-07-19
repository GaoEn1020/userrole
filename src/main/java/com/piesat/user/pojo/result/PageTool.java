package com.piesat.user.pojo.result;

/**
 * Created by zgf on 2018/2/7.
 */
public class PageTool {
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

    private int pageNum;//第几页
    private  int pageSize;//每页显示多少条记录


}
