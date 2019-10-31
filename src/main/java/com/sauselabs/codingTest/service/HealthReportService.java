package com.sauselabs.codingTest.service;

import com.sauselabs.codingTest.model.HealthReport;

public interface HealthReportService {

    HealthReport getHealthInLastFiveMinutes();
}
