FROM gradle:jdk18 as build

WORKDIR /build

COPY . ./

RUN gradle build -x test

FROM openjdk:18.0-jdk

WORKDIR /app

COPY --from=build /build/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar", "--spring.profiles.active=dev"]