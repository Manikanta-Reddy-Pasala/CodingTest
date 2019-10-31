package com.sauselabs.codingTest.controller;

import com.sauselabs.codingTest.model.HealthReport;
import com.sauselabs.codingTest.service.HealthReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health")
public class HealthCheckMonitorController {

    @Autowired
    HealthReportService healthReportService;

    @GetMapping(value = "/getHealthInLastFiveMinutes")
    @ApiOperation(value = "get health check report from past five minutes", produces = MediaType.APPLICATION_JSON_VALUE)
    public HealthReport getHealthInLastFiveMinutes() {

        return healthReportService.getHealthInLastFiveMinutes();
    }

}
