from openjdk:20-ea-17-jdk

workdir /app

copy /build/libs/*.jar ./app.jar

expose 8080

CMD ["java", "-jar", "app.jar"]