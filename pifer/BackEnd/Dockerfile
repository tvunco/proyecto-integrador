FROM amazoncorretto:11-alpine-jdk
MAINTAINER FER
COPY target/fer-0.0.1-SNAPSHOT.jar fer-app.jar ///copia el empaquetado
ENTRYPOINT ["java","-jar","/fer-app.jar"]   ///lo primero que va ejecutar primero
