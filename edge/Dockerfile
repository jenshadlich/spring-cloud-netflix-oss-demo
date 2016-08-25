FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/edge.zuul-server-0.1-SNAPSHOT.jar /data/edge.zuul-server.jar

CMD java -jar edge.zuul-server.jar

EXPOSE 8765
