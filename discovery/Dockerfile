FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/discovery.eureka-server-0.1-SNAPSHOT.jar /data/discovery.eureka-server.jar

CMD java -jar -Dspring.profiles.active=docker discovery.eureka-server.jar

EXPOSE 8761
