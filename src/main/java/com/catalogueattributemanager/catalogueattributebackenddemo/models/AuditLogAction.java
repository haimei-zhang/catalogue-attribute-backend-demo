package com.catalogueattributemanager.catalogueattributebackenddemo.models;

public class AuditLogAction {
    private String value;
    private String type;
    private String download_link;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }
}
