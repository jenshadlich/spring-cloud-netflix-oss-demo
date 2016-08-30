FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/security-auth-server-0.1-SNAPSHOT.jar /data/security-auth-server.jar

CMD java -jar security-auth-server.jar

EXPOSE 9999
