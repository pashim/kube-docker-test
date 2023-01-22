FROM gradle:jdk18 as build

ARG DEFAULT_PORT=8080

WORKDIR /build

COPY . ./

RUN gradle build -x test

FROM openjdk:18.0-jdk

WORKDIR /app

COPY --from=build /build/build/libs/*.jar app.jar

ENV PORT $DEFAULT_PORT

EXPOSE $PORT

CMD ["java", "-jar", "app.jar"]