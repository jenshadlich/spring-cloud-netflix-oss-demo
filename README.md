# spring-cloud-netflix-oss-demo

![build](https://api.travis-ci.org/jenshadlich/spring-cloud-netflix-oss-demo.svg)

Uses: Zuul, Eureka, Ribbon, Hystrix, Turbine

## Components

* discovery (Eureka server)
* `core-stock`
  * random port
* `core-product`
  * random port
* `api-product`
  * higher level service that uses `core-stock` and `core-product`
  * port 8080
  * [Hystrix dashboard](http://localhost:8080/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8080%2Fhystrix.stream) is enabled
  * Example: [http://localhost:8080/product/1](http://localhost:8080/product/1)

## Service discovery with Eureka

### Build:
```
cd discovery
mvn clean install
java -jar target/discovery.eureka-server-0.1-SNAPSHOT.jar
```

### Run:
```
java -jar target/discovery.eureka-server-0.1-SNAPSHOT.jar
```

Eureka web ui: [http://localhost:8761/](http://localhost:8761/)

### Retrieve application info:
```
curl -s -H "Accept: application/json" http://localhost:8761/eureka/apps | jsonpp
```

### Retrieve application info (with filters applied):
```
curl -s -H "Accept: application/json" http://localhost:8761/eureka/apps | jq '.applications.application[] | .name as $service | ( .instance[] | { service: $service, instanceId: .instanceId, ipAddr: .ipAddr, port: .port."$", status: .status} )'
```

Example output:

```
{
  "service": "CORE-STOCK",
  "instanceId": "core-stock:676c02cd118ff7d028727bcb744af206",
  "ipAddr": "172.18.0.6",
  "port": 44680,
  "status": "UP"
}
{
  "service": "CORE-STOCK",
  "instanceId": "core-stock:f05c02672a13bde4ae8827627908d4d6",
  "ipAddr": "172.18.0.8",
  "port": 38100,
  "status": "UP"
}
{
  "service": "TURBINE",
  "instanceId": "4dcf0c45e83a:turbine:8989",
  "ipAddr": "172.18.0.5",
  "port": 8989,
  "status": "UP"
}
{
  "service": "CORE-PRODUCT",
  "instanceId": "core-product:51e1c12bdc7ad6b58555c205249c61f6",
  "ipAddr": "172.18.0.4",
  "port": 36571,
  "status": "UP"
}
{
  "service": "API-PRODUCT",
  "instanceId": "api-product:fee174f2f33bd4ac23381923d537fae2",
  "ipAddr": "172.18.0.7",
  "port": 8080,
  "status": "UP"
}
{
  "service": "EDGE",
  "instanceId": "97f2fac83e61:edge:8765",
  "ipAddr": "172.18.0.3",
  "port": 8765,
  "status": "UP"
}
```
