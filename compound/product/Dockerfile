FROM anapsix/alpine-java:jre8

WORKDIR /data

CMD ["bash"]

ADD target/compound.product-0.1-SNAPSHOT.jar /data/compound.product.jar

CMD java -jar -Dspring.profiles.active=docker compound.product.jar

EXPOSE 8080
