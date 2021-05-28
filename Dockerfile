#
# Build stage
#
FROM maven:3.8.1-amazoncorretto-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM amazoncorretto:11.0.11
COPY --from=build /home/app/target/dynamo-0.0.1-SNAPSHOT.jar /usr/local/lib/application.jar
EXPOSE 8080
ENTRYPOINT exec java -jar /usr/local/lib/application.jar
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar webfluxbasicapi.jar
