FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/tracing.zipkin-server-0.1-SNAPSHOT.jar /data/tracing.zipkin-server.jar

CMD java -jar -Dspring.profiles.active=docker tracing.zipkin-server.jar

EXPOSE 8765
