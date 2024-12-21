package com.ks.ksfinal3.model;

import lombok.Getter;
import lombok.Setter;

public class DatatableColumnSearch {
    private String value;
    private String regex;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
