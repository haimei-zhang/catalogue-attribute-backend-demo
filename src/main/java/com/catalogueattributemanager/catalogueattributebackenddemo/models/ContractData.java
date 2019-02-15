package com.catalogueattributemanager.catalogueattributebackenddemo.models;

import java.util.List;

public class ContractData {

    private Long id;
    private String name;
    private String reference;
    private String type;
    private String assignType;
    private String description;
    private String startDate;
    private String endDate;
    private String supplier;
    private Integer supplierId;
    private Integer targetSpend;
    private String fileUrl;
    private Boolean expiryNotification;
    private String expiryNotificationFrom;
    private List<Attachment> attachments;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getTargetSpend() {
        return targetSpend;
    }

    public void setTargetSpend(Integer targetSpend) {
        this.targetSpend = targetSpend;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Boolean isExpiryNotification() {
        return expiryNotification;
    }

    public void setExpiryNotification(Boolean expiryNotification) {
        this.expiryNotification = expiryNotification;
    }

    public String getExpiryNotificationFrom() {
        return expiryNotificationFrom;
    }

    public void setExpiryNotificationFrom(String expiryNotificationFrom) {
        this.expiryNotificationFrom = expiryNotificationFrom;
    }

    public Boolean getExpiryNotification() {
        return expiryNotification;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachment) {
        this.attachments = attachment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
