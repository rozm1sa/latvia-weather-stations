FROM amazoncorretto:17-al2023-jdk

RUN mkdir /opt/app

ENV JAR_FILENAME="target/latvia-weather-stations-1.0.0.jar"
ENV WORKDIR_PATH=/opt/app

WORKDIR $WORKDIR_PATH
COPY $JAR_FILENAME $WORKDIR_PATH

EXPOSE 8080

ENTRYPOINT ["java","-jar","/opt/app/latvia-weather-stations-1.0.0.jar"]