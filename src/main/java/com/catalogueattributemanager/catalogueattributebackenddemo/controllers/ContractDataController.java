package com.catalogueattributemanager.catalogueattributebackenddemo.controllers;

import com.catalogueattributemanager.catalogueattributebackenddemo.models.Attachment;
import com.catalogueattributemanager.catalogueattributebackenddemo.models.ContractData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/contract-data")
public class ContractDataController {

    private List<ContractData> contractData = new ArrayList<>();

    ContractDataController() {
        this.contractData = buildContractDataList();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ContractData> getContractData() {
        return this.contractData;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ContractData saveContractData(@RequestBody ContractData contractDataItem) {
        Long nextId = 0L;
        if (this.contractData.size() != 0) {
            // ContractData lastContractData = this.contractData.stream().skip(this.contractData.size() - 1).findFirst().orElse(null);
            // nextId = lastContractData.getId() + 1;
            nextId = new Date().getTime();
            // nextId = Long.valueOf(this.contractData.size());
        }

        contractDataItem.setId(nextId);
        this.contractData.add(0, contractDataItem);
        return contractDataItem;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<ContractData> updateContractData(@RequestBody ContractData contractDataItem) {
        ContractData modifiedContractData = this.contractData.stream().filter(i -> i.getId().equals(contractDataItem.getId())).findFirst().orElse(null);
        modifiedContractData.setName(contractDataItem.getName());
        modifiedContractData.setReference(contractDataItem.getReference());
        modifiedContractData.setAssignType(contractDataItem.getAssignType());
        modifiedContractData.setDescription(contractDataItem.getDescription());
        modifiedContractData.setStartDate(contractDataItem.getStartDate());
        modifiedContractData.setEndDate(contractDataItem.getEndDate());
        modifiedContractData.setFileUrl(contractDataItem.getFileUrl());
        modifiedContractData.setTargetSpend(contractDataItem.getTargetSpend());
        modifiedContractData.setExpiryNotification(contractDataItem.isExpiryNotification());
        modifiedContractData.setExpiryNotificationFrom(contractDataItem.getExpiryNotificationFrom());
        modifiedContractData.setAttachment(contractDataItem.getAttachment());
        return this.contractData;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<ContractData> deleteContractData(@PathVariable Long id) {
        ContractData deleteContractData = this.contractData.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if (deleteContractData != null) {
            this.contractData.remove(deleteContractData);
        }
        return this.contractData;
    }

    List<ContractData> buildContractDataList() {
        List<ContractData> contractData = new ArrayList<>();

        List<Attachment> attachments = buildAttachments();

        ContractData contractData1 = buildContractData(1L, "CONTRACT", "DEF456", "Contract Data", "supplier", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Jan 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Oct 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "TEST Supplier 1", 123, 1000, "https://www.test.com/", true, "Fri Jan 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments);
        ContractData contractData2 = buildContractData(2L, "CONTRACT 2", "ABC123", "Contract Data", "items", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Feb 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Sep 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "TEST Supplier 2", 123, 1000, "https://www.test.com/", true, "Fri Jan 12 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments);
        ContractData contractData3 = buildContractData(3L, "CONTRACT 3", "GHI456", "Contract Data", "supplier", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Mar 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Nov 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "Supplier 3", 123, 2000, "https://www.test.com/", true, "Fri Feb 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments);
        ContractData contractData4 = buildContractData(4L, "CONTRACT 4", "JKL789", "Contract Data", "items", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Feb 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Feb 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "TEST Supplier 123", 123, 12000, "https://www.test.com/", true, "Fri Mar 13 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments);
        ContractData contractData5 = buildContractData(5L, "CONTRACT 5", "MNO838", "Contract Data", "items", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Oct 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Mar 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "Supplier 333", 123, 2500, "https://www.test.com/", true, "Fri Sep 11 2021 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments);
        
        contractData.add(contractData1);
        contractData.add(contractData2);
        contractData.add(contractData3);
        contractData.add(contractData4);
        contractData.add(contractData5);

        return contractData;
    }

    ContractData buildContractData(Long id, String name, String reference, String type, String assignType, String description, String startDate, String endDate, String supplier, Integer supplierId, Integer targetSpend, String fileUrl, Boolean expiryNotification, String expiryNotificationFrom, List<Attachment> attachments) {
        ContractData contractData = new ContractData();
        contractData.setId(id);
        contractData.setName(name);
        contractData.setReference(reference);
        contractData.setType(type);
        contractData.setAssignType(assignType);
        contractData.setDescription(description);
        contractData.setStartDate(startDate);
        contractData.setEndDate(endDate);
        contractData.setSupplier(supplier);
        contractData.setSupplierId(supplierId);
        contractData.setTargetSpend(targetSpend);
        contractData.setFileUrl(fileUrl);
        contractData.setExpiryNotification(expiryNotification);
        contractData.setExpiryNotificationFrom(expiryNotificationFrom);
        contractData.setAttachment(attachments);
        return contractData;
    }

    List<Attachment> buildAttachments() {
        List<Attachment> attachments = new ArrayList<>();
        Attachment attachment1 = buildAttachment("www.test.com", "test file 1", "comment 1", 1L);
        Attachment attachment2 = buildAttachment("www.test.com", "test file 2", "comment 2", 2L);
        Attachment attachment3 = buildAttachment("www.test.com", "test file 3", "comment 3", 3L);

        attachments.add(attachment1);
        attachments.add(attachment2);
        attachments.add(attachment3);

        return attachments;
    }

    Attachment buildAttachment(String fileUrl, String fileName, String comment, Long id) {
        Attachment attachment = new Attachment();
        attachment.setFileUrl(fileUrl);
        attachment.setComment(comment);
        attachment.setFileName(fileName);
        attachment.setId(id);
        return attachment;
    }
}
