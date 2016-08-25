#!/usr/bin/env bash

# compound-product
cd compound/product
docker build -t jenshadlich/sc-compound-product:latest .
cd ../..

# core-product
cd core/product
docker build -t jenshadlich/sc-core-product:latest .
cd ../..

# core-stock
cd core/stock
docker build -t jenshadlich/sc-core-stock:latest .
cd ../..

# discovery
cd discovery
docker build -t jenshadlich/sc-eureka-server:latest .
cd ..

# edge
cd edge
docker build -t jenshadlich/sc-zuul-server:latest .
cd ..

# monitoring
cd monitoring
docker build -t jenshadlich/sc-turbine-server:latest .
cd ..

# security
cd security
docker build -t jenshadlich/sc-auth-server:latest .
cd ..