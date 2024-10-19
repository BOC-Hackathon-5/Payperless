FROM azul/zulu-openjdk:21.0.1
WORKDIR /usr/app
COPY target/kyb-api-1.0.0.jar  ./kyb-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kyb-api.jar"]
