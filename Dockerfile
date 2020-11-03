FROM openjdk:14
ADD target/CheckInService.jar CheckInService.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "CheckInService.jar"]