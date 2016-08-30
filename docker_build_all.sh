#!/usr/bin/env bash

# api-product
cd api-services/product
docker build -t jenshadlich/sc-api-product:latest .
cd ../..

# core-product
cd core-services/product
docker build -t jenshadlich/sc-core-product:latest .
cd ../..

# core-stock
cd core-services/stock
docker build -t jenshadlich/sc-core-stock:latest .
cd ../..

# discovery
cd infrastructure/discovery
docker build -t jenshadlich/sc-eureka-server:latest .
cd ../..

# edge
cd infrastructure/edge
docker build -t jenshadlich/sc-zuul-server:latest .
cd ../..

# monitoring
cd infrastructure/monitoring
docker build -t jenshadlich/sc-turbine-server:latest .
cd ../..

# security
cd infrastructure/security
docker build -t jenshadlich/sc-auth-server:latest .
cd ../..
