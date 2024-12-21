package com.ks.ksfinal3.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class DatatableColumnData {

    private String data;
    private String name;
    private String searchable;
    private String orderable;
    private DatatableColumnSearch search;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearchable() {
        return searchable;
    }

    public void setSearchable(String searchable) {
        this.searchable = searchable;
    }

    public String getOrderable() {
        return orderable;
    }

    public void setOrderable(String orderable) {
        this.orderable = orderable;
    }

    public DatatableColumnSearch getSearch() {
        return search;
    }

    public void setSearch(DatatableColumnSearch search) {
        this.search = search;
    }
}
