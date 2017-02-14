# Microservices workshop

## What we have?
1. Config server pointing to a git repository
2. Eureka server for services registry and discovering
3. ZuulServer as proxy layer-7. Main gateway
4. 2 dummy services: stockService and productosservice
5. 1 service using our two dummy services + async requests + circuit breaker
6. Hystrix Dashboard
7. Turbine server to collect hystrix.stream from our restFul services

## Set up environment

### For windows
SET JAVA_HOME=[route to java home e.g: C:/Program files/Java/jdk1.8.0_121]
SET PATH=%PATH%;[path_to_maven]\bin

### For linux
export JAVA_HOME=[route to java home e.g: /usr/bin/java]
export PATH=$PATH:[path_to_maven]\bin

## Start microservices in this order

```
cd 02-configserver
mvn spring-boot:run

cd 03-eurekaregistry
mvn spring-boot:run

cd 04-zuulserver
mvn spring-boot:run

cd 10-stockservice
mvn spring-boot:run

cd 11-CatalogoService
mvn spring-boot:run

20-productosservice
mvn spring-boot:run

cd hystrixDashboard
mvn spring-boot:run

cd turbine
mvn spring-boot:run
```

## Check microservices
### Main access to app
http://localhost:8000

### Eureka console
http://localhost:8761

### Hystrix dashboard
http://localhost:7979/
Put turbine url here

### Turbine url
http://localhost:8989/turbine.stream


