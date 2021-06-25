FROM openjdk:15-alpine
LABEL maintainer="sergeykalenikov@gmail.ru"
ARG JAR_FILE=target/guitar-bot.jar
WORKDIR /usr/local/test/
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]