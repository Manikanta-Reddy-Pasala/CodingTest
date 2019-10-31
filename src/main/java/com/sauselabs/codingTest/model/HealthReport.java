package com.sauselabs.codingTest.model;

public class HealthReport {

    private int failed_count;
    private int success_count;
    private int un_available_count;
    private String report;

    public HealthReport(int failed_count, int success_count, int un_available_count) {
        this.failed_count = failed_count;
        this.success_count = success_count;
        this.un_available_count = un_available_count;
    }

    public int getFailed_count() {
        return failed_count;
    }

    public void setFailed_count(int failed_count) {
        this.failed_count = failed_count;
    }

    public int getSuccess_count() {
        return success_count;
    }

    public void setSuccess_count(int success_count) {
        this.success_count = success_count;
    }

    public int getUn_available_count() {
        return un_available_count;
    }

    public void setUn_available_count(int un_available_count) {
        this.un_available_count = un_available_count;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "HealthReport{" +
                "failed_count=" + failed_count +
                ", success_count=" + success_count +
                ", un_available_count=" + un_available_count +
                '}';
    }
}
