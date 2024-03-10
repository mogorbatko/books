FROM gradle:8.6.0-jdk17-alpine
ENV APP_HOME=/root/dev/books
WORKDIR $APP_HOME
COPY src ./src
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle/ ./gradle/
COPY dataset ./dataset
COPY config.ini .
RUN gradle build
COPY build/libs/books-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "books-0.0.1-SNAPSHOT.jar"]
