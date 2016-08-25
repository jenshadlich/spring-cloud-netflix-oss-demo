FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/core.stock-0.1-SNAPSHOT.jar /data/core.stock.jar

CMD java -jar -Dspring.profiles.active=docker core.stock.jar
