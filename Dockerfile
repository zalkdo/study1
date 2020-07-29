FROM openjdk:8-jdk-alpine
LABEL maintainer="jh_kim@emro.co.kr"
ADD ./target/demo-0.0.1-SNAPSHOT.jar study1.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/study1.jar"]