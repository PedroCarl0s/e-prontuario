FROM openjdk:8-jdk-alpine
EXPOSE 7070
COPY target/prontuario.jar /usr/app/
WORKDIR /usr/app
CMD ["java", "-jar", "prontuario.jar"]