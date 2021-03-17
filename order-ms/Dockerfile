FROM openjdk:8-jdk-alpine
ADD target/docker-managecurrencyconv.jar docker-managecurrencyconv.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","docker-managecurrencyconv.jar"]