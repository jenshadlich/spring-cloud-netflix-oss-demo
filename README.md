# spring-cloud-netflix-oss-demo

## discovery (Eureka)

```
cd discovery
mvn clean install
java -jar target/discovery.eureka-server-0.1-SNAPSHOT.jar
```

Eureka web ui: http://localhost:8761/

Retrieve application info:
```
curl -s -H "Accept: application/json" http://localhost:8761/eureka/apps | jsonpp
```

Retrieve application info (with filters applied):
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