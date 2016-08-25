FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/edge.zuul-server-0.1-SNAPSHOT.jar /data/edge.zuul-server.jar

CMD java -jar -Dspring.profiles.active=docker edge.zuul-server.jar

EXPOSE 8765
