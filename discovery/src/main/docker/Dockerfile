FROM java:8
VOLUME /tmp
ADD eureka-1.0.0-SNAPSHOT.jar eureka.jar
RUN bash -c 'touch /eureka.jar'
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]
