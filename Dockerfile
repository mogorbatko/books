FROM gradle:8.6.0-jdk17-alpine AS BUILD_IMAGE
ENV APP_HOME=/root/dev/books/
WORKDIR $APP_HOME
COPY . $APP_HOME
RUN gradle clean build

FROM amazoncorretto:17
WORKDIR /root/
COPY --from=BUILD_IMAGE /root/dev/books/dataset ./dataset
COPY --from=BUILD_IMAGE /root/dev/books/config ./config
COPY --from=BUILD_IMAGE /root/dev/books/build/libs/books-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "books-0.0.1-SNAPSHOT.jar"]