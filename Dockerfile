FROM openjdk:17
MAINTAINER matvey
COPY target/space-0.0.1-SNAPSHOT.jar space-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","space-0.0.1-SNAPSHOT.jar"]