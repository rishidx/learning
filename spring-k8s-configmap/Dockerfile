FROM eclipse-temurin:17.0.8.1_1-jre
VOLUME /tmp
ADD ./target/spring-k8s-configmap-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]