package org.soul.common;

import cn.hutool.core.util.PageUtil;
import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class PageResult<T> extends Pagination{
    private static final long serialVersionUID = 1L;
    private List<T> dataList = new ArrayList();
    private long total;
    private int pages;

    public PageResult() {
    }

    public static <T> PageResult<T> toPageResult(List<T> dataList) {
        PageResult<T> result = new PageResult();
        if (dataList instanceof Page) {
            Page<T> page = (Page)dataList;
            result.setPageNum(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        } else {
            result.setPageNum(1);
            result.setPageSize(dataList.size());
            result.setDataList(dataList);
            result.setTotal((long)dataList.size());
        }

        return result;
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getOffsetIndex() {
        int offset = (this.getPageNum() - 1) * this.getPageSize();
        if ((long)offset >= this.getTotal()) {
            offset = 0;
        }

        return offset;
    }

    public static <T> PageResult<T> toPageResult(PageResult<?> pageInfo, List<T> dataList) {
        PageResult<T> result = new PageResult();
        result.setDataList(dataList);
        result.setPages(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setSortField(pageInfo.getSortField());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setSortOrder(pageInfo.getSortOrder());
        return result;
    }

    public static <T> PageResult<T> paging(int pageNum, int pageSize, List<T> dataList) {
        int total = 0;
        int totalPage;
        if (CollectionUtils.isNotEmpty(dataList)) {
            total = dataList.size();
            totalPage = PageUtil.totalPage(total, pageSize);
            if (pageNum > totalPage) {
                pageNum = totalPage;
            }

            int[] startWithEnd = PageUtil.transToStartEnd(pageNum - 1, pageSize);
            int beginIndex = startWithEnd[0];
            int endIndex = startWithEnd[1];
            if (pageSize > total) {
                pageNum = 1;
                beginIndex = 0;
                endIndex = total;
            }

            if (endIndex > total) {
                endIndex = total;
            }

            dataList = dataList.subList(beginIndex, endIndex);
        }

        totalPage = PageUtil.totalPage(total, pageSize);
        PageResult<T> pageResult = new PageResult();
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setTotal((long)total);
        pageResult.setPages(totalPage);
        pageResult.setDataList(dataList);
        return pageResult;
    }
}
