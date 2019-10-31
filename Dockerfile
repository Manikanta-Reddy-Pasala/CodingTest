FROM openjdk:8-jre-alpine
ADD /codingTest-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-Dspring.profiles.active=qa", "-jar", "/codingTest-0.0.1-SNAPSHOT.jar"]