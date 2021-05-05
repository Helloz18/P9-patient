FROM java:8-jdk-alpine
COPY target/patient-1.jar patient-1.jar
ENTRYPOINT ["java", "-jar", "/patient-1.jar"]
EXPOSE 8081