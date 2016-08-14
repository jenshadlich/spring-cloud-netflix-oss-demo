# spring-cloud-netflix-oss-demo

![build](https://api.travis-ci.org/jenshadlich/spring-cloud-netflix-oss-demo.svg)

Uses: Zuul, Eureka, Ribbon, Hystrix

## Components

* discovery (Eureka server)
* `core-stock`
  * random port
* `core-product`
  * random port
* `compound-product`
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
  "service": "COMPOUND.PRODUCT",
  "instanceId": "compound.product:e9ab069f49abe8cffc215d80944fd06b",
  "ipAddr": "10.x.x.181",
  "port": 8080,
  "status": "UP"
}
{
  "service": "CORE.PRODUCT",
  "instanceId": "core.product:aac7415cf4e0fbaeeb8e35bbee00cb6e",
  "ipAddr": "10.x.x.181",
  "port": 63981,
  "status": "UP"
}
{
  "service": "CORE.STOCK",
  "instanceId": "core.stock:5e9bb499bf59c43eb8551f5196b6522f",
  "ipAddr": "10.x.x.181",
  "port": 61262,
  "status": "UP"
}
{
  "service": "CORE.STOCK",
  "instanceId": "core.stock:8f5c0330b939c1643645d83b91ad9795",
  "ipAddr": "10.x.x.181",
  "port": 61268,
  "status": "UP"
}
```
