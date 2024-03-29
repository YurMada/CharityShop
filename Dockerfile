FROM maven:3.8.4-openjdk-17-slim as build
COPY ./ /src
RUN mvn -f /src/pom.xml clean package

FROM openjdk:17
COPY --from=build /src/target/Charity_Shop-0.0.1-SNAPSHOT.jar /src/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "src/Charity_Shop-0.0.1-SNAPSHOT.jar"]