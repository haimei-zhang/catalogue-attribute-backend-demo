package com.catalogueattributemanager.catalogueattributebackenddemo.controllers;

import com.catalogueattributemanager.catalogueattributebackenddemo.models.AuditLog;
import com.catalogueattributemanager.catalogueattributebackenddemo.models.AuditLogAction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/contract-data/audit-log")
public class AuditLogController2 {
    private List<AuditLog> auditLogs = new ArrayList<>();

    AuditLogController2() {
        this.auditLogs = buildAuditLogs();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AuditLog> getAuditLogs() {
        return this.auditLogs;
    }

    List<AuditLog> buildAuditLogs() {
        List<AuditLog> auditLogs = new ArrayList<>();

        AuditLogAction auditLogAction = new AuditLogAction();
        auditLogAction.setValue("all");
        auditLogAction.setType("export");
        auditLogAction.setDownload_link("https://www.test.com");

        AuditLog auditLog1 = buildAuditLog("Fri Jan 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "CONTRACT",
                "Contract Data", "James", auditLogAction, "COMPLETED", "Applied to supplier catalogue");
        AuditLog auditLog2 = buildAuditLog("Thu Jan 10 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "CONTRACT 2",
                "Contract Data", "Bob", auditLogAction, "COMPLETED_WITH_ERRORS", "Uploaded items");
        AuditLog auditLog3 = buildAuditLog("Wed Jan 9 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "CONTRACT 3",
                "Contract Data", "Andy", auditLogAction, "REQUESTED", "Exported contracted items");
        AuditLog auditLog4 = buildAuditLog("Wed Dec 19 2018 13:29:02 GMT+0000 (Greenwich Mean Time)", "CONTRACT 2",
                "Contract Data", "Chris", auditLogAction, "FAILED", "Exported all items");
        AuditLog auditLog5 = buildAuditLog("Fri Jan 25 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "CONTRACT 4",
                "Contract Data", "Sally", auditLogAction, "PROCESSING", "Uploaded items");
        AuditLog auditLog6 = buildAuditLog("Fri Jan 11 2019 13:29:02 GMT+0000 (Greenwich Mean Time)", "CONTRACT 5",
                "Contract Data", "Tom", auditLogAction, "COMPLETED", "Updated contract data");

        auditLogs.add(auditLog1);
        auditLogs.add(auditLog2);
        auditLogs.add(auditLog3);
        auditLogs.add(auditLog4);
        auditLogs.add(auditLog5);
        auditLogs.add(auditLog6);

        return auditLogs;
    }

    AuditLog buildAuditLog(String datetime, String tag, String tag_type, String user, AuditLogAction action,
            String status, String description) {
        AuditLog auditLog = new AuditLog();
        auditLog.setDatetime(datetime);
        auditLog.setTag(tag);
        auditLog.setTag_type(tag_type);
        auditLog.setUser(user);
        auditLog.setAction(action);
        auditLog.setStatus(status);
        auditLog.setDescription(description);
        return auditLog;
    }
}
