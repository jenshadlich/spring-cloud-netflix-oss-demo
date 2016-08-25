FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/monitoring.turbine-server-0.1-SNAPSHOT.jar /data/monitoring.turbine-server.jar

CMD java -jar -Dspring.profiles.active=docker monitoring.turbine-server.jar

EXPOSE 8765
