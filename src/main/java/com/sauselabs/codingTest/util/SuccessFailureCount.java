package com.sauselabs.codingTest.util;

import com.sauselabs.codingTest.model.HealthReport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SuccessFailureCount {

    private static int success = 0;
    private static int failure = 0;
    private static int un_available = 0;

    public void incrementSuccessCount() {

        ++success;

    }

    public void incrementFailureCount() {

        ++failure;
    }

    public void incrementNumber_of_times_un_available() {

        ++un_available;
    }

    public void clearCounts() {
        success = 0;
        failure = 0;
        un_available = 0;

    }

    public HealthReport getReports() {

        return new HealthReport(failure, success, un_available);
    }


}
