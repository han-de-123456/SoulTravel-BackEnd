package org.soul.common;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

public class Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String DESC = "descend";
    public static final String ASC = "ascend";
    protected int pageNum = 1;
    protected int pageSize = 10;
    protected String sortField = "createDate";
    protected String sortOrder = "descend";

    public Pagination(int pageNum, int pageSize) {
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum <= 0) {
            pageNum = 1;
        }

        this.pageNum = pageNum;
    }

    public boolean isNeedPagination() {
        return this.pageNum < 0;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 0) {
            pageSize = 0;
        } else if (pageSize == 0) {
            pageSize = 10;
        }

        this.pageSize = pageSize;
    }

    public String getSortField() {
        return this.sortField;
    }

    public void setSortField(String sortField) {
        if (StringUtils.isNotBlank(sortField)) {
            this.sortField = sortField;
        }

    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean needOrderBy() {
        return StringUtils.isNotBlank(this.sortField);
    }

    public boolean isAsc() {
        return Objects.equals(this.sortOrder, "ascend");
    }

    public boolean defaultSort() {
        return "createDate".equals(this.sortField) && Objects.equals(this.sortOrder, "descend");
    }

    public Pagination() {
    }
}
