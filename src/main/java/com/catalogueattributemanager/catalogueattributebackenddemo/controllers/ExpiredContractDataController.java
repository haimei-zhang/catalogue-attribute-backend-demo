package com.catalogueattributemanager.catalogueattributebackenddemo.controllers;

import com.catalogueattributemanager.catalogueattributebackenddemo.models.Attachment;
import com.catalogueattributemanager.catalogueattributebackenddemo.models.ContractData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/expired-contract-data")
public class ExpiredContractDataController {

    private List<ContractData> expiredContractData = new ArrayList<>();

    ExpiredContractDataController() {
        this.expiredContractData = buildExpiredContractDataList();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ContractData> getExpiredContractData() {
        return this.expiredContractData;
    }

    List<ContractData> buildExpiredContractDataList() {
        List<ContractData> expiredContractData = new ArrayList<>();

        List<Attachment> attachments = buildAttachments();

        ContractData expiredContractData1 = buildExpiredContractData(6L, "EXPIRED CONTRACT", "DEF456123", "Contract Data", "supplier", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Jan 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Oct 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "TEST Supplier 1", 123, 1000, "https://www.test.com/", true, "Fri Jan 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments, "test comment 1", false);
        ContractData expiredContractData2 = buildExpiredContractData(7L, "EXPIRED CONTRACT 2", "ABC123123", "Contract Data", "items", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Feb 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Sep 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "TEST Supplier 2", 123, 1000, "https://www.test.com/", true, "Fri Jan 12 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments, "test comment 2", false);
        ContractData expiredContractData3 = buildExpiredContractData(8L, "EXPIRED CONTRACT 3", "GHI456123", "Contract Data", "supplier", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Mar 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Nov 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "Supplier 3", 123, 2000, "https://www.test.com/", true, "Fri Feb 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments, "test comment 3", true);
        ContractData expiredContractData4 = buildExpiredContractData(9L, "EXPIRED CONTRACT 4", "JKL789123", "Contract Data", "items", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Feb 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Feb 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "TEST Supplier 123", 123, 12000, "https://www.test.com/", true, "Fri Mar 13 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments, "test comment 4", true);
        ContractData expiredContractData5 = buildExpiredContractData(10L, "EXPIRED CONTRACT 5", "MNO838123", "Contract Data", "items", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "Fri Oct 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "Fri Mar 11 2020 13:29:02 GMT+0000 (Greenwich Mean Time)", "Supplier 333", 123, 2500, "https://www.test.com/", true, "Fri Sep 11 2021 13:29:02 GMT+0000 (Greenwich Mean Time)", attachments, "test comment 5", false);

        expiredContractData.add(expiredContractData1);
        expiredContractData.add(expiredContractData2);
        expiredContractData.add(expiredContractData3);
        expiredContractData.add(expiredContractData4);
        expiredContractData.add(expiredContractData5);

        return expiredContractData;
    }

    ContractData buildExpiredContractData(Long id, String name, String reference, String type, String assignType, String description, String startDate, String endDate, String supplier, Integer supplierId, Integer targetSpend, String fileUrl, Boolean expiryNotification, String expiryNotificationFrom, List<Attachment> attachments, String comment, Boolean archive) {
        ContractData expiredContractData = new ContractData();
        expiredContractData.setId(id);
        expiredContractData.setName(name);
        expiredContractData.setReference(reference);
        expiredContractData.setType(type);
        expiredContractData.setAssignType(assignType);
        expiredContractData.setDescription(description);
        expiredContractData.setStartDate(startDate);
        expiredContractData.setEndDate(endDate);
        expiredContractData.setSupplier(supplier);
        expiredContractData.setSupplierId(supplierId);
        expiredContractData.setTargetSpend(targetSpend);
        expiredContractData.setFileUrl(fileUrl);
        expiredContractData.setExpiryNotification(expiryNotification);
        expiredContractData.setExpiryNotificationFrom(expiryNotificationFrom);
        expiredContractData.setAttachments(attachments);
        expiredContractData.setComment(comment);
        expiredContractData.setArchive(archive);
        return expiredContractData;
    }

    List<Attachment> buildAttachments() {
        List<Attachment> attachments = new ArrayList<>();
        Attachment attachment1 = buildAttachment("www.test.com", "test file 1", 1L);
        Attachment attachment2 = buildAttachment("www.test.com", "test file 2", 2L);
        Attachment attachment3 = buildAttachment("www.test.com", "test file 3", 3L);

        attachments.add(attachment1);
        attachments.add(attachment2);
        attachments.add(attachment3);

        return attachments;
    }

    Attachment buildAttachment(String fileUrl, String fileName, Long id) {
        Attachment attachment = new Attachment();
        attachment.setFileUrl(fileUrl);
        attachment.setFileName(fileName);
        attachment.setId(id);
        return attachment;
    }


}
