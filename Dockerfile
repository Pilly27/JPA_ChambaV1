FROM openjdk:17.0.2-jdk-oracle

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} backend.jar

CMD apt-get update -y

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/backend.jar"]
