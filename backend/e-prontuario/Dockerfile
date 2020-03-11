FROM openjdk:8-jdk-alpine
EXPOSE 7070
LABEL maintainer "Pedro Carlos <pedro.carlos@dcx.ufpb.br>"
COPY target/prontuario.jar /usr/app/
WORKDIR /usr/app
CMD ["java", "-jar", "prontuario.jar"]