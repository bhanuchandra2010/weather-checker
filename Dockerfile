FROM azul/zulu-openjdk-alpine:21
EXPOSE 8080
ADD target/weather-checker.jar weather-checker.jar
ENTRYPOINT ["java","-jar","/weather-checker.jar"]