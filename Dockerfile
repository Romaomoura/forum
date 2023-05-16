FROM amazoncorretto:17.0.5-alpine
WORKDIR /opt/app
EXPOSE 8080
COPY target/forum-0.0.1-SNAPSHOT.jar /opt/app
ADD target/forum-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java", "-Dserver.port=8080", "-Dspring.profiles.active=dev", "-jar", "forum.jar"]