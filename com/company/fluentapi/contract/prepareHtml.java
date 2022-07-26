package com.company.fluentapi.contract;

public interface prepareHtml {
    public prepareHtml param(String parameter, String value);
    public String genHtml(String template);
}
