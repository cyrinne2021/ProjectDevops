FROM maven:3.8.2-jdk-8
RUN apt-get install curl
RUN curl -u admin:adminadmin -o achat.jar "http://192.168.1.46:8081/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089
