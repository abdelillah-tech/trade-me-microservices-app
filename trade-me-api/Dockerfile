FROM maven:3-openjdk-11

WORKDIR /usr/src/app

COPY pom.xml .

CMD mvn help:evaluate -Dexpression=project.modules

CMD mvn clean package spring-boot:build-image

CMD mvn spring-boot:run