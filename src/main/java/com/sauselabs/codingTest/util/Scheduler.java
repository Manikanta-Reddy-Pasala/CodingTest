package com.sauselabs.codingTest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
public class Scheduler {

    @Autowired
    private Environment environment;

    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    CircularQueue queue = new CircularQueue();
    SuccessFailureCount count = new SuccessFailureCount();

    RestTemplate restTemplate = new RestTemplate();


    @Scheduled(cron = "0 0/5 * * * ?", zone = "Asia/Calcutta")
    public void repoForEveryFiveMinutes() {

        LOGGER.info("Report: " + count.getReports().toString());
        count.clearCounts();
    }


    @Scheduled(fixedDelay = 500)
    public void checkHealth() {

        try {

            final String url = environment.getProperty("health_check_url");

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            HttpStatus responseCode = response.getStatusCode();

            LocalDateTime dateTime = LocalDateTime.now();

            if (responseCode.value() == 200) {
                if (queue.isFull()) {
                    queue.dequeue();
                }

                queue.enqueue(dateTime + " " + url + " " + "200 " + "Success");
                LOGGER.info(dateTime + " " + url + " " + "200 " + "Success");
                count.incrementSuccessCount();
            }


        } catch (HttpServerErrorException ex) {

            final String url = environment.getProperty("health_check_url");

            if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
                if (queue.isFull()) {
                    queue.dequeue();
                }

                LocalDateTime dateTime = LocalDateTime.now();
                queue.enqueue(dateTime + " " + url + " " + ex.getStatusCode() + " " + "Failed");
                LOGGER.error(dateTime + " " + url + " " + ex.getStatusCode() + " " + "Failed");
                count.incrementFailureCount();
            }

            if (ex.getStatusCode() != HttpStatus.INTERNAL_SERVER_ERROR) {
                if (queue.isFull()) {
                    queue.dequeue();
                }

                LocalDateTime dateTime = LocalDateTime.now();
                queue.enqueue(dateTime + " " + url + " " + ex.getStatusCode() + " " + "Un Available");
                LOGGER.error(dateTime + " " + url + " " + ex.getStatusCode() + " " + "Un Available");
                count.incrementNumber_of_times_un_available();
            }
        }

    }

    public CircularQueue getQueue() {
        return queue;
    }

    public SuccessFailureCount getReport() {
        return count;
    }
}