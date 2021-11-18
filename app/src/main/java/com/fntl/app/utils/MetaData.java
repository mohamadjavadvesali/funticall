package com.fntl.app.utils;

public class MetaData {
    private final int pageIndex;
    private final int pageSize;
    private final int total;

    public MetaData(int pageIndex, int pageSize, int total) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
    }
}
