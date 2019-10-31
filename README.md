# CodingTest


enables swagger:
-------------------
url for swagger: http://localhost:8080/swagger-ui.html

by using endpoint you will get last five minutes health check
----------------------------------------------------------------
Get request: http://localhost:8080/v1/health/getHealthInLastFiveMinutes

created docker file:
----------------------

find contetnt in Dockerfile

created log files and history logs:
----------------------------------------

folder locations: {project-home}/logs, {project-home}/logs/history/



main points:
----------------

1) used spring boot to implement 
2) every half second this will check whether python server exists or not
3) it log all failure and success in log files, aotomatically applies rolling updated to log files
4) created docker file
5) it calculates number of success requests, failure request and un avaibale request and logs all to log file for every five minutes and resets its counts
6) we can get last 5 minutes report by using above mentioned endpoint
