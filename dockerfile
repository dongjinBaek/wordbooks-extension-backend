FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY run.sh .
COPY credentials.json .
ENTRYPOINT ["/run.sh"]