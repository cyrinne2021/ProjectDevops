FROM openjdk:11
EXPOSE 9090
COPY target/tpAchatProject-1.0.jar tpAchatProject.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]