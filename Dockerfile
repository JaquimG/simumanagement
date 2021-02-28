FROM openjdk

WORKDIR /app

COPY /target/simuManagement-0.0.1-SNAPSHOT.jar /app/simuManagement.jar

ENTRYPOINT ["java", "-jar", "simuManagement.jar"]