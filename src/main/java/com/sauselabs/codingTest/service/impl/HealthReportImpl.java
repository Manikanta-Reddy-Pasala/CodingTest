package com.sauselabs.codingTest.service.impl;

import com.sauselabs.codingTest.model.HealthReport;
import com.sauselabs.codingTest.service.HealthReportService;
import com.sauselabs.codingTest.util.Scheduler;
import com.sauselabs.codingTest.util.SuccessFailureCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthReportImpl implements HealthReportService {

    @Autowired
    Scheduler sch;

    @Override
    public HealthReport getHealthInLastFiveMinutes() {

        SuccessFailureCount report = sch.getReport();

        HealthReport response = report.getReports();
        response.setReport(sch.getQueue().toString());

        return response;
    }
}
