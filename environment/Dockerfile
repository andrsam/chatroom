FROM openjdk:8-alpine
#
WORKDIR /opt
#
COPY target/chatroom-*.jar /opt/chatroom.jar
#
ENTRYPOINT java -jar chatroom.jar
