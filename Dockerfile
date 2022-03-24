FROM openjdk:17
COPY ./target/Charity_Shop-0.0.1-SNAPSHOT.jar
/usr/src/charity/
WORKDIR /usr/src/charity/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Charity_Shop-0.0.1-SNAPSHOT.jar"]